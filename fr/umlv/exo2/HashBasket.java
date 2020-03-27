
package fr.umlv.exo2;

import fr.umlv.exo2.Fruit;

import java.util.HashMap;

public class HashBasket {
	private final HashMap<Fruit, Integer> _content;

	public
	HashBasket() {
		_content = new HashMap<Fruit, Integer>();
	}

	public
	void
	add(final Fruit fruit, final int number) {
		if(number <= 0) {
			throw new IllegalArgumentException("Tutti frutti, no diggety ");
		}
		_content.put(fruit, getNumber(fruit) + number);
	}

	public
	int getNumber(final Fruit fruit) {
		return  _content.containsKey(fruit) ? _content.get(fruit) : 0;
	}

	public
	double getPrice() {
		return _content.entrySet()
			       .stream()
			       .reduce(0., (acc, entry) -> acc + entry.getValue() * entry.getKey().getPrice(), Double::sum);
	}

	@Override
	public String toString() {
		var str = new StringBuilder();
		for(var fruitEntry: _content.entrySet()) {
			str.append(fruitEntry.getKey().toString() + " x " + fruitEntry.getValue() + '\n');
		}
		str.append("price: " + Double.toString(getPrice()));
		return str.toString();
	}
}
