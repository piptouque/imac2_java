package fr.umlv.td4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class StaticShoppingCart implements ShoppingCart {
	private Book _listBooks[];
	private int _numberBooks;
	private static final int _MAX_NUMBER_BOOKS = 50;

	public static void main(String args[]) {
		var cart = new StaticShoppingCart();
		for(int i=0; i<10; ++i) cart.add(new Book());
		cart.add(new Book("Whatever it is, it's bad."));
		Book longest = cart.bookWithLongestTitle();
		System.out.println("Longest: " + longest);
	}	
	public StaticShoppingCart() {
		_listBooks = new Book[_MAX_NUMBER_BOOKS];
		_numberBooks = 0;
	}
	
	public void add(Book book) {
		Objects.requireNonNull(book);
		if( _listBooks.length <= _numberBooks + 1) {
			throw new IllegalStateException("Not this book, you won't.");
		}
		_listBooks[_numberBooks++] = new Book(book);
	}
	
	@Override
	public String showContent() {
		// header
		StringBuilder content = new StringBuilder(new String().format("%d / %d | ",_numberBooks, _MAX_NUMBER_BOOKS));
		for(var book: _listBooks) content.append(book);
		return content.toString();
	}
	
	@Override
	public String toString() {return showContent();}

	public Book bookWithLongestTitle() {
		if(_numberBooks == 0)
		{
			return null;
		}
		// asList should not copy _listBooks
		// the List should only point to the used elements
		var temp = Arrays.asList(_listBooks).subList(0, _numberBooks);
		/* using Stream and a lambda function as shown
		 * here: https://www.techiedelight.com/find-maximum-minimum-custom-objects-java/
		 */
		Book longest = temp.stream()
		    .reduce(
			(book1, book2) -> 
				book1.getTitleLength() > book2.getTitleLength() ? book1 : book2
			)
		    .get();
		return longest;
	}
}
