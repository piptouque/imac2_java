package fr.umlv.geom.main;

import fr.umlv.geom.Point;
import fr.umlv.geom.Circle;
import fr.umlv.geom.Ring;

public class Main {
	public static void main(String args[]) {
		var point   = new Point(1, 2);
		var circle  = new Circle(point, 1);
		var circle2 = new Circle(point, 2);
		var ring    = new Ring(point, 2, 1);
		var ring2   = new Ring(point, 4, 3);

		circle2.translate(1, 1);
		/* 
		 * We need to explicitly call toString
		 * on the Circles
		 */
		System.out.println(circle.toString() + ' ' + circle2.toString());
		System.out.println(ring);
		System.out.println("Where boyz fear to tread: " + Circle.contains(point, circle, circle2));
		System.out.println("Through the eyes of Java: " + Ring.contains(point, ring, ring2));
	}
}
