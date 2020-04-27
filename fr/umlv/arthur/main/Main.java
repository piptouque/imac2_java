
package fr.umlv.arthur.main;

import fr.umlv.arthur.Sword;
import fr.umlv.arthur.Bow;
import fr.umlv.arthur.Shield;
import fr.umlv.arthur.Heroicity;
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
		var thorn = new Sword("Thorn", 11);
		var someShield = new Shield("Some shield lying around", 1);
		var camaris = new Knight("Camaris Sà-Vinitta", thorn, someShield);	
		System.out.println(camaris);
		System.out.println("He protec: " + camaris.protection());
		System.out.println("He attac: " + camaris.damage());
		System.out.println("But more importantly,");
		System.out.println("He dunks on John when he is bac: " + camaris.isBetterThan(john));

		/* Shiva's a dude, by the by */
		var jingizu = new Sword("Jingizu", 20);	
		var sorrow = new Bow("Sorrow (bow edition)", 10, 7);
		var kvalnir = new Bow("Kvalnir (bow edition)", 10, 7);
		var naidel = new Shield("Naidel (shield edition)",  12);
		var ineluki = new Knight("Ineluki Storm King", jingizu, sorrow, kvalnir, naidel);
		System.out.println(ineluki);


		System.out.println(simon);
		System.out.println("Simon Mooncalf: " +  simon.isHeroic());
		simon.setHeroicity(new Heroicity(2));
		System.out.println(simon.isHeroic());
		System.out.println(simon.damage());
		System.out.println(simon.protection());
		System.out.println(simon);

		System.out.println(camaris);
		camaris.setHeroicity(new Heroicity(2, 3));
		System.out.println(camaris.isHeroic());
		System.out.println(camaris.damage());
		System.out.println(camaris.protection());
		System.out.println(camaris);
	}

	
}
		
