
package fr.umlv.exo2.main;

import fr.umlv.exo2.Apple;
import fr.umlv.exo2.AppleKind;
import fr.umlv.exo2.Pear;
import fr.umlv.exo2.Basket;
import fr.umlv.exo2.HashBasket;

import java.util.HashSet;

public class Main {
	public static void main(String args[]) {
		var apple1 = new Apple(20, AppleKind.Golden);
		var apple2 = new Apple(40, AppleKind.PinkLady);
		var pear1 = new Pear(40, 4);

		var basket = new Basket();
		basket.add(apple1);
		basket.add(apple2);
		basket.add(pear1);
		System.out.println(basket);

		/* */
		var set = new HashSet<Apple>();
		set.add(new Apple(20, AppleKind.Golden));
		System.out.println(set.contains(new Apple(20, AppleKind.Golden)));

		/* */
		var hash = new HashBasket();
		hash.add(apple1, 3);
		hash.add(pear1, 2);
		hash.add(apple1, 2);
		System.out.println(hash);
	}
}

