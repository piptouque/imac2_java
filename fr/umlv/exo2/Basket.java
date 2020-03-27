
package fr.umlv.exo2;

import fr.umlv.exo2.Fruit;

import java.util.ArrayList;

public class Basket {
	private final ArrayList<Fruit> _content;

	public
	Basket() {
		_content = new ArrayList<Fruit>();
	}

	public
	void
	add(final Fruit fruit) {
		_content.add(0, fruit);
	}

	public
	double getPrice() {
		return _content.stream()
			       .mapToDouble(Fruit::getPrice)
			       .sum()
			  ;
	}

	@Override
	public String toString() {
		var str = new StringBuilder();
		for(var fruit: _content) {
			str.append(fruit.toString() + " x 1\n");
		}
		str.append("price: " + Double.toString(getPrice()));
		return str.toString();
	}
}
