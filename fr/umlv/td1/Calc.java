package fr.umlv.td1;

import java.util.Scanner; 

public class Calc { 
	public static void main(String args[]) {
		Scanner scanner;
		scanner = new Scanner(System.in);
		int a, b;
		System.out.println("Paye tes entiers.");
		a = scanner.nextInt();
		b = scanner.nextInt();
		//
		System.out.println("La somme : " + String.valueOf(a + b));
		System.out.println("La produit : " + String.valueOf(a *	b));
		System.out.println("La quotient : " + String.valueOf(a /  b));
		System.out.println("La reste : " + String.valueOf(a % b));
	}
}
