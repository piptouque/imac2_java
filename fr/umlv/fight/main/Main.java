
package fr.umlv.fight.main;

import fr.umlv.fight.Robot;
import fr.umlv.fight.Hooman;
import fr.umlv.fight.Arena;

public class Main {
	public static void main(String args[]) {
		var megaman = new Robot("Mega man");
		var robotmaster = new Robot("Robot master");
		Arena.fight(megaman, robotmaster);
	}
}
