package fr.umlv.geom;

public class Point {
	private int _x;
	private int _y;

	public 
	Point(int x, int y) {
		_x = x;
		_y = y;
	}

	public
	Point(Point other) {
		this(other._x, other._y);
	}
	public
	int 
	getX() {
		return _x;
	}

	public
	int 
	getY() {
		return _y;
	}


	public
	double
	norm() {
		return Math.sqrt(_x * _x + _y * _y);
	}

	public
	double
	distanceTo(Point other)
	{
		return other.norm() - norm();
	}

	@Override
	public
	String 
	toString() {
		return "(" + _x + ',' + _y + ')';
	}
	
	public
	void
	translate(int dx, int dy) {
	  /* x et y non modifiables,
	   * erreur !
	   * On réecrira la fonction
	   * en effectuant une « copie défensive ».
	   */
	   _x += dx;
	   _y += dy;
	}
}
