
package fr.upem.restos;

import java.util.Objects;

public abstract class Establishment {
	private static final int _DEFAULT_STARS = 0;
	private final String _name;
	private final int _stars;

	public Establishment(String name, int stars) {
		if(stars < 0) {
			throw new IllegalArgumentException("Stars must be positive integers.");
		}
		_name = Objects.requireNonNull(name);
		_stars = stars;
}
	public Establishment(String name) {
		this(name, _DEFAULT_STARS);
	}

	public int stars() { return _stars; } 

  @Override
  public String toString() {
    var str = new StringBuilder(_name);
    for(int i=0; i<_stars; ++i) {
      str.append('*');
    }
    return str.toString();
   }

  @Override
  public int hashCode() {
    /* bad, as always. */
    return Objects.hash(_name, _stars);
  }

  @Override
  public boolean equals(Object o) {
    if(!(o instanceof Establishment )) {
      return false;
    }
    var e = (Establishment) o;
    return e._name == _name && e._stars == _stars;
  }

}
