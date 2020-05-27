
package fr.upem.restos;

import java.util.Objects;

class Evaluation {
  private static final int _MINSCORE = 0;
  private static final int _MAXSCORE = 5;
  private static final String _DEFAULTCOMMENT = "";

  private final int _score;	
  private final String _comment;

  public Evaluation(int score, String comment) {
	if(score < _MINSCORE || score > _MAXSCORE) {
		throw new IllegalArgumentException("Score must be between " + _MINSCORE + " and " + _MAXSCORE);
	}
	_score = score;
	_comment = Objects.requireNonNull(comment);
  }

  public Evaluation(int score) {
	  this(score, _DEFAULTCOMMENT);
  }

  public int getScore() { return _score; }
  public String getComment() { return _comment; }
	
  @Override
  public int hashCode() {
	  return Objects.hash(_comment, _score);
  }

  @Override
  public boolean equals(Object o) {
	if(!(o instanceof Evaluation)) {
		  return false;
	}
	var e = (Evaluation) o;
	return e._score == _score && e._comment == _comment;
  }

  @Override
  public String toString() {
	  return "<" + _score + ">" + _comment;
  }
}


