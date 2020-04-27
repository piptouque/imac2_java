
package fr.umlv.arthur;

import fr.umlv.arthur.Equipment;
import fr.umlv.arthur.Shield;
import fr.umlv.arthur.Sword;

import java.util.Objects;
import java.util.ArrayList; 
import java.util.Arrays;

public class Knight {
	/* a Knight without his sword is no Knight at all. */
	/* also, a Knight who can't change swords is an idiot. We don't do idiots. */
	private ArrayList<Equipment> _equipment;
	/* ever tried wielding a sword with your left foot? I have. */
	/* i guess a knight can't change their name, though */
	private final String _name;
	public Knight(String name, Equipment... equipment) {
		_name = Objects.requireNonNull(name);
		if(name.length() < 1) {
			throw new IllegalArgumentException("That's not much of a name now is it?");
		}
		if(equipment.length < 1) {
			throw new IllegalArgumentException("That's not much of a knight, innit?");
		}
		_equipment = new ArrayList<Equipment>(Arrays.asList(Objects.requireNonNull(equipment)));
	}
	public String name() {
		return _name;
	}
	private <C extends Equipment> int use(Class<C> c) {
		return _equipment.stream()
			.filter(e -> c.isInstance(e))
			.mapToInt(Equipment::use)
			.sum();
	}

	public int damage() {
		return use(Sword.class);
	}
	public int protection() {
		return use(Shield.class);
	}
	public boolean isBetterThan(Knight other) {
		int gallantConfrontation = damage() - other.damage();
		if(gallantConfrontation == 0) {
			return protection() > other.protection();
		}
		return gallantConfrontation > 0;
	}
	@Override
	public String toString() {
		var str = new StringBuilder();
		str.append("All hail " + _name);
		str.append(", gallant knight with ");
	        str.append(
			_equipment.stream()
				.map(e -> e.toString())
				.reduce("", (acc, strEquipment) -> acc + ", and " + strEquipment)
		);
		str.append(" bestowed.");
		return str.toString();
	}
}

