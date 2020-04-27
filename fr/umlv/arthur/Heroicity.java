
package fr.umlv.arthur;

import fr.umlv.arthur.Equipment; 
import fr.umlv.arthur.Weapon; 
import fr.umlv.arthur.Protection; 

public class Heroicity {
	private final int _damageLevel, _protectionLevel;

	public Heroicity(final int damageLevel, final int protectionLevel) {
		if(damageLevel < 1 || damageLevel > 3 || protectionLevel < 1 || protectionLevel > 3) {
			throw new IllegalArgumentException("She turned me into a newt!");
		}
		_damageLevel = damageLevel;
		_protectionLevel = protectionLevel;
	}
	public Heroicity(final int level) {
		this(level, level);
	}
	public Heroicity(final Heroicity other) {
		this(other._damageLevel, other._protectionLevel);
	}
	public Heroicity() { this(1); }


	public boolean isHeroic() {
		return _damageLevel >= 2 && _protectionLevel >= 2;
	}	
	
	public int damage(Weapon w) {
		switch(_damageLevel) {
			case 2:	return w.damage() + 3;
			case 3:	return w.damage() * 3;
			default: return w.damage();
		}
	}
	public int protection(Protection p) {
		switch(_protectionLevel) {
			case 2:	return p.protection() + 3;
			case 3: return p.protection() * 3;
			default: return p.protection();
		}
	}
}
