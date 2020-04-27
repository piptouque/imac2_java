
package fr.umlv.arthur;

import fr.umlv.arthur.Equipment;

import java.util.Objects;

public class Shield extends Equipment {
	private final int _protection;	

	public Shield(String name, int protection) {
		super(name);
		if(protection <= 0) {
			throw new IllegalArgumentException("This shield is cursed, don't touch it!");
		}
		_protection = protection;
	}

	public int protection() {
		return _protection;
	}
	@Override
	public int use() { return protection(); }
	@Override
	public int hashCode() {
		// still bad
		return super.hashCode() +  _protection;
	}
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Shield)) {
			return false;
		}
		Shield s = (Shield)o;
			return super.equals(s) && (s._protection == _protection);
	}
	@Override
	public String toString() {
		var str = new StringBuilder(super.toString());
		str.append(", ye bulkwark shielde");
		str.append(", of sturdiness unmatched of " + _protection);
	       	return str.toString();
	}
}

