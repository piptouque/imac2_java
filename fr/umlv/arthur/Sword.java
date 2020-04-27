

package fr.umlv.arthur;

import fr.umlv.arthur.Equipment;

import java.util.Objects;

public class Sword extends Equipment {
	private final int _damage;

	public Sword(String name, int damage) {
		super(name);
		if(damage <= 0) {
			throw new IllegalArgumentException("This sword is very obviously cursed, get an exorcist.");
		}
		_damage = damage;
	}
	public Sword(Sword other) {
		this(other.name(), other.damage());
	}
	public int damage() {
		return _damage;
	}
	@Override
	public int use() { return damage(); }
	@Override
	public int hashCode() {
		// bad.
		return super.hashCode() + _damage;
	}
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Sword)) {
			return false;
		}
		Sword s = (Sword)o;
		return super.equals(s) && (s._damage == _damage);
	}
	@Override
	public String toString() {
		var str = new StringBuilder(super.toString());
		str.append(", ye mighty sworde");
		str.append(", of power unmatched of " + _damage);
		return str.toString();
	}
}
