package fr.umlv.td2;

public class Test {
	public static void main(String[] args) {
		var first = args[0];
		var second = args[1];
		var last = args[2];
		System.out.println(first + ' ' + second + ' ' + last);
		// on peut utiliser ' ' car le caractère sera transtypé en String 
		// Effectivement, dans le bytecode, il est interprété comme un Ljava/lang/String dans makeConcatWithConstants()
	}
}
