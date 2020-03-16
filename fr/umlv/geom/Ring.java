
package fr.umlv.geom;

import fr.umlv.geom.Circle;

public class Ring extends Circle {
	private final int _inRadius;

	public
	Ring(Point centre, int outRadius, int inRadius) {
		super(centre, outRadius);
		if(outRadius < inRadius) {
			throw new IllegalArgumentException("YOU HAVE NO POWER HERE.");
		}
		_inRadius = inRadius;	
	}

	@Override
	public
	double
	surface() {
		return super.surface() - new Circle(getCentre(), _inRadius).surface();
	}

	@Override
	public
	boolean
	contains(Point p) {
		return super.contains(p) && !(new Circle(getCentre(), _inRadius)).contains(p);
	}

	public
	static
	boolean
	contains(Point p, Ring... rings) {
		return Circle.contains(p, rings);
	}

	@Override
	public
	String
	toString() {
		return super.toString() + " __ " + Integer.toString(_inRadius);
	}


}
