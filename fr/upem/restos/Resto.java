
package fr.upem.restos;

import fr.upem.restos.Establishment;

import java.util.Objects;

public final class Resto extends Establishment {
	private final int _covers;

	private static void checkCovers(int covers) {

		if(covers < 0) {
			throw new IllegalArgumentException("Covers must be positive.");

		}
	}
	public Resto(String name, int covers, int stars) {
		super(name, stars);
		checkCovers(covers);
		_covers = covers;
}
	public Resto(String name, int covers) {
		super(name);
		checkCovers(covers);
		_covers = covers;
	}
  
  @Override
  public String toString() {
    var str = new StringBuilder(super.toString());
    str.append(" ("+ _covers + ')');
    return str.toString();
   }

  @Override
  public int hashCode() {
    /* bad, as always. */
    return Objects.hash(super.hashCode(), _covers);
  }

  @Override
  public boolean equals(Object o) {
    if(!(o instanceof Resto)) {
      return false;
    }
    var r = (Resto) o;
    return super.equals(r) && r._covers == _covers;
  }
}
