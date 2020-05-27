
package fr.upem.restos;

import java.util.Objects;

public class Restaurant {
	private static final int _DEFAULT_STARS = 0;
	private final String _name;
	private final int _covers;
	private final int _stars;

	public Restaurant(String name, int covers, int stars) {
		if(covers < 0 || stars < 0) {
			throw new IllegalArgumentException("Covers and stars must be positive integers.");
		}
		_name = Objects.requireNonNull(name);
		_covers = covers;
		_stars = stars;
}
	public Restaurant(String name, int covers) {
		this(name, covers, _DEFAULT_STARS);
	}
  
  @Override
  public String toString() {
    var str = new StringBuilder(_name);
    for(int i=0; i<_stars; ++i) {
      str.append('*');
    }
    str.append(" ("+ _covers + ')');
    return str.toString();
   }

  @Override
  public int hashCode() {
    return Objects.hash(_name, _covers, _stars);
  }

  @Override
  public boolean equals(Object o) {
    if(!(o instanceof Restaurant)) {
      return false;
    }
    var r = (Restaurant) o;
    return r._name == _name && r._covers == _covers && r._stars == _stars;
  }
}
