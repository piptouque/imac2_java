
package fr.umlv.geom;

import fr.umlv.geom.Point;


public class Circle {
	private final Point _centre;
	private final int   _radius;

	public
	Circle(Point p, int radius) {
		_centre = p;
		_radius = radius;
	}

	public
	Point
	getCentre() {
		/* defensive copy */
		return new Point(_centre);
	}

	public
	double
	surface() {
		return Math.PI * _radius * _radius;
	}

	public
	boolean
	contains(Point p) {
		return Math.abs(_centre.distanceTo(p)) <= _radius;	
	}

	public
	static
	boolean
	contains(Point p, Circle... circles) {
		/* variadic argument circles... */
		for(var c: circles)
		{
			if(c.contains(p)) return true;
		}
		return false;
	}

	@Override
	public
	String
	toString() {
		return _centre.toString() + " | " + Integer.toString(_radius) + ": " + Double.toString(surface());
	}

	public
	void
	translate(int dx, int dy) {
		_centre.translate(dx, dy);
	}
}
