
package fr.upem.restos.main;

import fr.upem.restos.Ranker;
import fr.upem.restos.Restaurant;

import fr.upem.restos.Establishment;
import fr.upem.restos.Resto;
import fr.upem.restos.Bar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Main {

  private static void printEstablishmentsWithGivenStarNumber(List<Establishment> list, int stars) {
		String str = list.stream()
			  .filter(e -> e.stars() == stars)
				.map(Establishment::toString)
				.reduce(
						"",
						(acc, eStr) -> acc + (acc == "" ? "" : '\n') + eStr);
		System.out.println(str);
	}

  public static void main(String[] args) {
/* -- RESTAURANT -- */ 
System.out.println("/* -- RESTAURANT -- */");
    var r1 = new Restaurant("Le p'tit creux", 25);
    var r2 = new Restaurant("Le p'tit creux", 25, 0);
    System.out.println(r2);
    var r3 = new Restaurant("Le Pré Catlan", 50, 3);
    System.out.println(r3);
    System.out.println(r1.equals(r2));
    System.out.println(r1.equals(r3));

    /* -- ESTABLISHMENT -- */
System.out.println("/* -- ESTABLISHMENT -- */");
    Establishment r4 = new Resto("Le p'tit creux", 25);
    Establishment r5 = new Resto("Le p'tit creux", 25, 0);
    System.out.println(r5);
    Establishment r6 = new Resto("Le Pré Catlan", 50, 3);
    System.out.println(r6);
    System.out.println(r4.equals(r5));
    System.out.println(r4.equals(r6));

    Establishment b1 = new Bar("L'Écume des Jours", false);
    Establishment b2 = new Bar("Mary's Place", true, 2);

    System.out.println(b1);
    System.out.println(b2);

    System.out.println(r6.stars() - b2.stars());

    /* -- LIST -- */
System.out.println("/* -- LIST -- */");
    List<Establishment> list = new ArrayList<Establishment>();

    list.add(r4);
    list.add(r6);
    list.add(b1);
    list.add(b2);

    System.out.println(list.contains(new Bar("L'Écume des Jours", false, 0)));
    System.out.println(list.contains(new Bar("L'Écume des Jours", true, 0)));
    System.out.println(list.contains(new Resto("L'Écume des Jours", 10)));

		System.out.println("This: ");
    printEstablishmentsWithGivenStarNumber(list, 2);
		System.out.println("That: ");
    printEstablishmentsWithGivenStarNumber(list, 0);

		System.out.println(list);
		/* */
		list.sort((e1, e2) -> e2.stars() - e1.stars());
		/**
		 * HOWTO: add lexicographic sortinhg **
		 * 
		 * 1) write a sotring method without taking lexicographic order into account
		 * -> Undecided cases will be set to 0
		 * 2) call the first sotring method, filter null results, and sort THEM using names. 
		 * that's it
		 */
		/* */
		System.out.println(list);

    /* -- RANKER -- */
    System.out.println("/* -- RANKER -- */");
    Ranker<Establishment> ritaSkeeters = new Ranker<>();

    ritaSkeeters.addEvaluation(r6, 5, "AmAAAzing");
    ritaSkeeters.addEvaluation(r6, 1, "Not worth a single knut");
    ritaSkeeters.addEvaluation(r6, 2);
    ritaSkeeters.addEvaluation(r6, 3, "Meh.");

    ritaSkeeters.addEvaluation(b1, 4, "Nice.");
    ritaSkeeters.addEvaluation(b1, 0, "Noope");

    ritaSkeeters.addEvaluation(b2, 1, "Expensive.");
    ritaSkeeters.addEvaluation(b2, 4, "Fashionable");

    var average = ritaSkeeters.averageScoreFor(new Resto("Le Pré Catlan", 50, 3));
    System.out.println(average);
    System.out.println("/* -- Items with score -- */");

    ritaSkeeters.printCommentsForItemsWithScoreBetterOrEqual(3);
    System.out.println("/* -- items with predicate -- */");
    ritaSkeeters.printCommentsForItemsVerifying(e -> e.stars() >= 2);

  }
}
