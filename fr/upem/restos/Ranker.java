
package fr.upem.restos;

import fr.upem.restos.Evaluation;

import java.util.function.Predicate;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Ranker<E> {
  private Map<E, List<Evaluation>> _rankings;

  public Ranker() {
	_rankings = new HashMap<>();
  }

  private List<Evaluation> getEvaluationListOrElse(E item) {
	if(!_rankings.containsKey(item)) {
		throw new IllegalArgumentException("Item not yet reviewed.");
	}
	return _rankings.get(item);
  }

  private void addEvaluation(E item, Evaluation eval)
  {
	_rankings.putIfAbsent(item, new ArrayList<Evaluation>());
	var list = _rankings.get(item);
	list.add(Objects.requireNonNull(eval));	
  }

  public void addEvaluation(E item, int score, String comment) {
	  addEvaluation(item, new Evaluation(score, comment));
  }
  public void addEvaluation(E item, int score) {
	  addEvaluation(item, new Evaluation(score));
  }

  public double averageScoreFor(E item) {
	var list = getEvaluationListOrElse(item);  
	return list.stream()
		   .mapToInt(Evaluation::getScore)
		   .average()
		   .getAsDouble();
  }

  public void printCommentsForItemsWithScoreBetterOrEqual(int score) {
	var str = _rankings.entrySet()
		     .stream()
		     .reduce(
			"",
			(acc, entry) -> {
				E item = entry.getKey();
				var list = entry.getValue();
				var listAbove = list.stream()
				    .filter(eval -> eval.getScore() >= score)
				    .collect(Collectors.toList()); 
				if(listAbove.isEmpty()) { return acc; }
				return acc + (acc == "" ? "" : '\n') + item + " : " + listAbove;
				},
			(a, b) -> a + b
		     ); 
	System.out.println(str.toString());
  }

  public void printCommentsForItemsVerifying(Predicate<E> predicate) {
	var str = _rankings.entrySet()
		     .stream()
		     .reduce(
			"",
			(acc, entry) -> {
				E item = entry.getKey();
				if(!predicate.test(item)) { return acc; }
				var list = entry.getValue();
				return acc + (acc == "" ? "" : '\n') + item + " : " + list;
				},
			(a, b) -> a + b
		     ); 
	System.out.println(str.toString());
  }

}
