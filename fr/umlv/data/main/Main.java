
package fr.umlv.data.main;

import fr.umlv.data.LinkedList;

public class Main {
	public static void main(String args[]) {
		var l = new LinkedList<Integer>(13, 144, 22, 10);
		System.out.println(l);
		System.out.println(l.contains(Integer.valueOf(21)));
		System.out.println(l.contains(Integer.valueOf(144)));
	}
}
