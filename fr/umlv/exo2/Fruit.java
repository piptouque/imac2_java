

package fr.umlv.exo2;

public abstract class Fruit {
	protected final int _weight;

	public
	Fruit(final int weight) {
		if(weight < 0) {
			throw new IllegalArgumentException("Infinite sadness.");
		}
		_weight = weight;
	}
	
	public
	Fruit(final Fruit other) {
		this(other._weight);
	}
	

	public
	int getWeight() { return _weight; }

	abstract
	double getPrice();

	@Override
	public
	String toString() {
		return new String(Integer.toString(_weight) + " g");
	}

	@Override
	public
	boolean equals(Object o) {
		if(!(o instanceof Fruit)) {
			return false;
		}
		var other = (Fruit) o;
		return _weight == other._weight;
	}

	@Override
	public
	int hashCode() {
		return _weight;
	}
}
