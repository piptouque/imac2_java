package fr.umlv.fight;

import java.util.Objects;

abstract class Fighter {
	
	public Fighter(String name) {
		_name = Objects.requireNonNull(name);
		_health = _MAX_HEALTH;
	}

	@Override
	public String toString() {
		String str = _name + " | (" + _health + '/' + _MAX_HEALTH + ')';
		return str;
	}

	abstract public void fire(Fighter other);

	public boolean isDead() {
		return _health <= _MIN_HEALTH;
	}

	public static void fight(Fighter conan, Fighter heman) {
		Fighter victor=null, loser=null;
		while(!conan.isDead() && !heman.isDead()) {
			conan.fire(heman);
			if(heman.isDead()) {
				victor = conan;
				loser = heman;
			}
			heman.fire(conan);
			if(conan.isDead()) {
				victor = heman;
				loser = conan;
			}
		}
		victor.celebrate();
		loser.cryALot();
	}	
	public void celebrate() {
		System.out.println(_name + " has stepped up to the challenge of their rival!"); 
	}
	public void cryALot() {
		System.out.println(_name + " brought dishonour upon their family.");
	}

	public  static final int _MAX_HEALTH = 10;
	public  static final int _MIN_HEALTH = 0;
	
	protected static final int _LOSS_HEALTH = 2;

	protected int _health;
	protected final String _name;	
}
