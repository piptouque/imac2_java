
package fr.umlv.exo2;

import fr.umlv.exo2.Fruit;
import fr.umlv.exo2.AppleKind;

import java.util.Objects;


public class Apple extends Fruit {
	private final AppleKind _type;

	private static final AppleKind UNKNOWN_TYPE = AppleKind.Whatever;
	private static final int MAX_NB_APPLES = 1000;

	public
	Apple(final int weight, final AppleKind type) {
		super(weight);
		_type = Objects.requireNonNull(type);
	}

	public 
	Apple(final int weight) {
		this(weight, UNKNOWN_TYPE);
	}

	public
	Apple(final Apple other) {
		super(other);
		_type = other._type;
	}

	/*
	 * We need to override equals in order to compare apples
	 */	
	@Override
	public
	boolean equals(final Object o) {
		if(!(o instanceof Apple)) {
			return false;
		}
		var other = (Apple) o;
		return super.equals(other) && _type == other._type;
	}
	
	/*
	 * And redifine hashCode because we overrode equals
	 */
	@Override
	public
	int hashCode() {
		/* whatever */
		return super.hashCode() % MAX_NB_APPLES + MAX_NB_APPLES * _type.hashCode();
	}

	@Override
	public double getPrice() { return _weight / 2.; }
	@Override
	public String toString() {
		var str = new String(_type.toString() + ' ' + super.toString());
		return str;
	}

}
