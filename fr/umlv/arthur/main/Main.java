
package fr.umlv.arthur.main;

import fr.umlv.arthur.Sword;
import fr.umlv.arthur.Shield;
import fr.umlv.arthur.Knight;

public class Main {
	public static void main(String args[]) {
	var stick = new Sword("Stick", 2);
	var simon = new Knight("Simon Mooncalf", stick);
	var excalibur = new Sword("Excalibur", 10);
	var yeOtherExcalibur = new Sword("Excalibur", 10);
	var yeFalseExcalibur = new Sword("excalifragilisticaliwhatever", 10);
	System.out.println("Ye other Excalibur: " + excalibur.equals(yeOtherExcalibur));
	System.out.println("Ye false Excalibur: " + excalibur.equals(yeFalseExcalibur));

	var memory  = new Sword("Thorn", 7);
	var brightnail = new Sword("Bright-Nail", 4);
	var john = new Knight("King John Presbyter", memory, brightnail);
	System.out.println("John strikes! "+ john.damage());
	System.out.println("Simon Mooncalf against King John: " + simon.isBetterThan(john));
	var sorrow = new Sword("Sorrow", 11);
	var someShield = new Shield("Some Shield lying around", 1);
        var ineluki = new Knight("Ineluki Storm-King", sorrow, someShield);	
	System.out.println("John dies: " + ineluki.isBetterThan(john));
	}

	
}
		
