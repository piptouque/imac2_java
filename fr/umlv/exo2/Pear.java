
package fr.umlv.exo2;

import fr.umlv.exo2.Fruit;

public class Pear extends Fruit {
	private final int _juciness;
	
	private static final int  MAX_NB_PEARS = 1000;

	public
	Pear(int weight, int juciness) {
		super(weight);
		if(juciness < 0) {
			throw new IllegalArgumentException("Whatever.");
		}
		_juciness = juciness;
	}	
	@Override
	public
	double getPrice() {
		return _juciness * 3.;	
	}
	
	@Override
	public
	boolean equals(Object o) {
		if(!(o instanceof Pear)) {
			return false;
		}
		var other = (Pear) o;
		return super.equals(other) && _juciness == other._weight;
	}

	@Override
	public
	int hashCode() {
		return super.hashCode() % MAX_NB_PEARS + MAX_NB_PEARS * _juciness;
	}

	@Override
	public
	String toString() {
		var str = new String("Pear " + Integer.toString(_juciness) + ' ' + super.toString());
		return str;
	}
}
