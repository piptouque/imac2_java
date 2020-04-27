
package fr.umlv.arthur;

import fr.umlv.arthur.Equipment;
import fr.umlv.arthur.Protection;
import fr.umlv.arthur.Weapon;
import fr.umlv.arthur.Heroicity;

import java.util.Objects;
import java.util.ArrayList; 
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Knight {
	/* a Knight without his sword is no Knight at all. */
	/* also, a Knight who can't change swords is an idiot. We don't do idiots. */
	private ArrayList<Equipment> _equipment;
	/* ever tried wielding a sword with your left foot? I have. */
	/* i guess a knight can't change their name, though */
	private final String _name;
	private Heroicity _heroicity;

	public Knight(String name, Equipment... equipment) {
		_name = Objects.requireNonNull(name);
		if(name.length() < 1) {
			throw new IllegalArgumentException("That's not much of a name now is it?");
		}
		_equipment = new ArrayList<Equipment>(Arrays.asList(Objects.requireNonNull(equipment)));
		if(weaponCount() == 0) {
			throw new IllegalArgumentException("It's dangerous out there! Take this exception!");
		}
		_heroicity = new Heroicity();
	}
	public String name() {
		return _name;
	}
	/* can't request C extends Equipment since we use the Weapon and Protection interfaces */
	private <C> Stream<C> streamEquipment(Class<C> c) {
		return _equipment.stream()
			.filter(c::isInstance)
			.map(c::cast);
	}
	private <C> ArrayList<C> filterEquipment(Class<C> c) {
		return streamEquipment(c)
			.collect(Collectors.toCollection(ArrayList::new));
	}
	public ArrayList<Weapon> weapons() {
		return filterEquipment(Weapon.class);
	}
	public ArrayList<Protection> protections() {
		return filterEquipment(Protection.class);
	}
	public int weaponCount() {
		return weapons().size();
	}
	public int protectionCount() {
		return protections().size();
	}

	public int damage() {
		return streamEquipment(Weapon.class)
			.mapToInt(w -> _heroicity.damage(w))
			.sum();
	}
	public int protection() {
		return streamEquipment(Protection.class)
			.mapToInt(p -> _heroicity.protection(p))
			.sum();
	}

	public void setHeroicity(final Heroicity h) {
		_heroicity = new Heroicity(h);	
	}
	public boolean isHeroic() { return _heroicity.isHeroic(); }

	public boolean isBetterThan(Knight other) {
		int gallantConfrontation = damage() - other.damage();
		if(gallantConfrontation == 0) {
			return protection() > other.protection();
		}
		return gallantConfrontation > 0;
	}
	public String coolInfo() {
		var str = new StringBuilder();
		str.append("All hail " + _name);
		str.append(", gallant knight with ");
	        str.append(
			_equipment.stream()
				.map(Equipment::toString)
				.reduce(
					"", 
					(acc, strEquipment) ->
					  acc + (acc.length() == 0 ? strEquipment : ", and " + strEquipment)
				)
		);
		str.append(" bestowed.");
		return str.toString();
	}
	public String mehInfo() {
		var str = new StringBuilder(name());
		str.append(" damage: " + damage());
		str.append(" protection: " + protection());
		str.append("\n  ");
		str.append(
				_equipment.stream()
				  .map(Equipment::name)
				  .collect(Collectors.toCollection(ArrayList::new))
				  .toString()
		);
		return str.toString();
	}

	@Override
	public String toString() {
		return mehInfo();
	}
}

