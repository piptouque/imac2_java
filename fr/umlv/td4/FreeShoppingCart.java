package fr.umlv.td4;

//import fr.umlv.td4.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Comparator;


public class FreeShoppingCart implements ShoppingCart {
	private ArrayList<Book> _listBooks;

	public static void main(String args[]) {
		var cart = new FreeShoppingCart();
		var book1 = new Book("Du Svardenvyrd", "Nisse");
		var book2 = new Book("Science and the Beyond", "Albert Marconi");
		cart.add(book1);
		for(int i=0; i<3; ++i) cart.add(new Book("Beren and Lúthien","J.R.R Tolkien"));
		cart.add(book2);
		cart.add(book1);
		cart.add(book2);
		cart.removeFirstOccurrence(book1);
		cart.removeFirstOccurrenceIterator(book2);
		Book longest = cart.bookWithLongestTitle();
		System.out.println("Longest: " + longest);
		System.out.println(cart);
	}	
	public FreeShoppingCart() {
		_listBooks = new ArrayList<Book>();
	}
	
	@Override
	public String showContent() {
		// header
		StringBuilder content = new StringBuilder(new String().format("%d | ", _listBooks.size()));
		for(var book: _listBooks) content.append(book);
		return content.toString();
	}
	
	@Override
	public String toString() {
		return showContent();
	}	
	public void add(Book book) {
		Objects.requireNonNull(book);
		_listBooks.add(new Book(book));
	}
	
	public Book bookWithLongestTitle() {
		if(_listBooks.size() == 0)
		{
			return null;
		}
		var longest =  _listBooks.stream()
				 .reduce(
				 (book1, book2) ->
					book1.getTitleLength() > book2.getTitleLength() ? book1 : book2
				 )
			   	 .get();
		return longest;
	}

	public void removeFirstOccurrence(Book book) {
		/* Complexity in the worst case of O(n)*/
		_listBooks.remove(book);
	}

	public void removeFirstOccurrenceIterator(Book book) {
		/* same thing, O(n) */
		var it = _listBooks.iterator();
		while(it.hasNext())
		{
			Book next = it.next();
			if(next.equals(book))
			{
				it.remove();
				break;
			}
		}
	}
	
}
