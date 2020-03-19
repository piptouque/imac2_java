package fr.umlv.td1;

import java.lang.Integer;
import java.util.Arrays;

public class Convertisseur {
	public static void main(String args[]) {
		int tab[] = Convertisseur.parseInts(args);
		System.out.println("Un tableau ! " +  Arrays.toString(tab));
		int acc = Convertisseur.sum(tab);
		System.out.println("Une somme ! " +  Integer.toString(acc));
	}

	public static int[]  parseInts(String args[]) {
		int tab[] = new int[args.length];
		int index=0;
		for(String arg: args) tab[index++] = Integer.parseInt(arg);
		return tab;
	}

	public static int sum(int tab[]) {
		int acc=0;
		for(int i: tab) acc += i;
		return acc;
	}
};
