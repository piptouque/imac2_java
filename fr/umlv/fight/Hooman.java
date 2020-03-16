package fr.umlv.fight;

import java.util.Random;

public class Hooman extends Fighter {
	
	public Hooman(String name, int seed) {
		super(name);
		_rng = new Random(seed);
	}
	
	@Override
	public void fire(Fighter other) {
		if( _rng.nextFloat() <= _FIRE_ACCURACY) {
			other._health -= _LOSS_HEALTH;	
			System.out.println( other.getClass().getSimpleName() +  _name + " was hit by Hooman " + other._name + '.');
		}
		else
		{
			System.out.println( other.getClass().getSimpleName() +  _name + "missed! What a dunce!");
		}

	}

	private long _randomSeed;
	private final Random _rng;
	private final static float _FIRE_ACCURACY = 0.7f;
}
