package fr.umlv.td2;

public class Exo1 {
	public static void main(String[] args) {
		var s = "toto"; // Inférence du type String de s
		System.out.println(s.length()); // length() de String

		var s1 = "toto"; // valeur
		var s2 = s1; // copie valeur
		var s3 = new String(s1); // copie valeur dans référence
		System.out.println(s1 == s2); // égalité de références, même référence -> vrai
		System.out.println(s1 == s3); // Égalité de références, réf diff -> faux

		var s4 = "toto";
		var s5 = new String(s4);

		System.out.println(s4.equals(s5));

		var s6 = "toto";
		var s7 = new String(s6); // réf diff de s4

		System.out.println(s6 == s7); // Pas le même objet, références différentes -> faux

		/* On justifie le caractère non mutable des Strings en Java
		* dans le cas où plusieurs références pointent vers le même objet
		* On ne veut pas qu'une opération sur l'un affecte les autres
		* donc on interdit la modification et on copie.
		*/

		var s8  = "hello";
		s8.toUpperCase(); // Non mutable, pas de changement.
		System.out.println(s8);
	}
}
