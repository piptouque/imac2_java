package fr.umlv.fight;

import java.util.Objects;

public class Robot extends Fighter {
	
	public Robot(String name) {
		super(name);	
	}

	@Override
	public void fire(Fighter other) {
		other._health -= _LOSS_HEALTH;	
		System.out.println(other.getClass().getSimpleName() + _name + " was hit by Robot " + other._name + '.');
	}
}
