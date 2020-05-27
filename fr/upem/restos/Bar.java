
package fr.upem.restos;

import fr.upem.restos.Establishment;

import java.util.Objects;

public final class Bar extends Establishment  {
	private final boolean _afterEight;

	public Bar(String name, boolean afterEight, int stars) {
		super(name, stars);
		_afterEight = afterEight;
}
	public Bar(String name, boolean afterEight) {
		super(name);
		_afterEight = afterEight;
	}
  
  @Override
  public String toString() {
    var str = new StringBuilder(super.toString());
    String open = _afterEight ? "(open" : "(not open";
    str.append(' ' + open + " after eight)");
    return str.toString();
   }

  @Override
  public int hashCode() {
    /* bad, as always. */
    int after = _afterEight ? 1 : -1;
    return Objects.hash(super.hashCode(), _afterEight);
  }

  @Override
  public boolean equals(Object o) {
    if(!(o instanceof Bar)) {
      return false;
    }
    var b = (Bar) o;
    return super.equals(b) && b._afterEight == _afterEight;
  }
}
