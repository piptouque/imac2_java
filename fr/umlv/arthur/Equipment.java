
package fr.umlv.arthur;

import java.util.Objects;

public abstract class Equipment {
	private final String _name;

	public abstract int use();
	public String name() { return name(); };

	public Equipment(String name) {
		_name = Objects.requireNonNull(name);
		if(name.length() < 1) {
			throw new IllegalArgumentException("Strange women lying in ponds giving away swords is no good basis for a system of government!");
		}
	}

	@Override
	public String toString() {
		return name();
	}

	@Override
	public int hashCode() {
		return _name.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Equipment)) {
			return false;
		}
		Equipment e = (Equipment)o;
		return _name  == e._name;
	}
}
