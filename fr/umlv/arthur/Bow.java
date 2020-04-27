
package fr.umlv.arthur;

import fr.umlv.arthur.Weapon;
import fr.umlv.arthur.Protection;
import fr.umlv.arthur.Equipment;

public class Bow extends Equipment implements Weapon, Protection {
	private final int _damage, _protection;

	public Bow(final String name, final int damage, final int protection) {
		super(name);
		if(damage <= 0 || protection <= 0) {
			throw new IllegalArgumentException("Apparently bows can defend now, sorry.");
		}
		_damage = damage;
		_protection = protection;
	}
	@Override
	public int damage() {
		return _damage;
	}
	@Override
	public int protection() {
		return _protection;
	}

	@Override
	public int hashCode() {
		return super.hashCode() + _damage + _protection;
	}
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Bow)) {
			return false;
		}
		Bow b = (Bow)o;
		return super.equals(b) && (b._damage == _damage) && (b._protection == _protection);
	}
	@Override
	public String toString() {
		var str = new StringBuilder(super.toString());
		str.append(", ye tremendous bowe");
		str.append(", of power unmatched of " + _damage);
		str.append(" and sturdiness of " + _protection);
		return str.toString();
	}
}
