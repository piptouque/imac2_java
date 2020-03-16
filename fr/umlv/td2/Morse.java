package fr.umlv.td2;

import java.lang.StringBuilder;

public class Morse {
	public static void main(String[] args) {
		StringBuilder out = new StringBuilder();
		String stop = "Stop.";
		for(var arg: args)
		{
			String tail = arg + ' ' + stop + ' ';
			out.append(tail);
		}
		// Moins d'usage de mémoire
		// un seul appel d'affichage
		System.out.println(out);
		// On doit utiliser append() quand on construit une chaîne de caractères mutable
		// C'est pas bien parce qu'on mélange append() l'opérateur + qui est une autre méthode de concaténation (?)
	}
}
