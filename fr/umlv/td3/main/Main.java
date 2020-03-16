package fr.umlv.td3.main;

import fr.umlv.td3.Book;
import fr.umlv.td3.Exo4;

import java.util.ArrayList;

public class Main {
		
	public static void main(String[] args) {
		var book = new Book();
		System.out.println(book);

		/* Error: private attributes cannot be accessed from Main.
		 * Let's define getter and setters in Book.
		 */

		/* Always declare attributes as private
		 * so as not get morted.
		 */
		
		var b1 = new Book("Da Java Code", "Duke Brown");
		var b2 = b1;
		var b3 = new Book("Da Java Code", "Duke Brown");
	
		System.out.println(b1 == b2); // true: same reference
		System.out.println(b1 == b3); // false: different references
		System.out.println(b1.equals(b3));
	
		var list = new ArrayList<Book>();
		list.add(b1);
		System.out.println(list.indexOf(b2)); // 0; all clear
		System.out.println(list.indexOf(b3)); // -1; not found, means it uses shallow equality

	}
};
