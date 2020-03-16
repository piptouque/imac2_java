package fr.umlv.td4;

import java.util.Objects;

public class Book {
	private final String _title;
	private final String _author;
	private final boolean _isAuthored;
	
	public Book() {
		this("Red and Black", "Long John Silver");
	}

	public Book(Book book) {
		/* Strings are immutable
		* they will be copied.
		*/  
		_title  = book._title;
		_author = book._author;
		_isAuthored = book._isAuthored;
	}

	public Book(String title, String author) {
		_title  = Objects.requireNonNull(title);
		_author = Objects.requireNonNull(author);
		_isAuthored = true;
	}

	public Book(String title) {
		_title  = Objects.requireNonNull(title);
		_author = new String("<no author>");
		_isAuthored = false;
	}

	@Override
	public boolean equals(Object other) {
		if( (other == null) || !(other instanceof Book) ) {
			return false;
		}
		Book b = (Book)other;
		return  _author.equals(b._author) && _title.equals(b._title);
	}

	@Override
	public String toString() {
		String s = _isAuthored ? _title + ", by " + _author : _title;
		return s;
	}

	public static void main(String[] args) {
		var book = new Book();
		System.out.println(book._title + ", by " + book._author);
		
		/* Error: book initialised in default constructor.
		 * Java 13 does not allow implicit default initialisation of class attributes.
		 */

	}
	
	public String getTitle() {
		return new String(_title);
	}
	public int getTitleLength() {
		return  _title.length();
	}

	public String getAuthor() {
		return new String(_author);
	}
	
	public boolean isAuthored() {
		return _isAuthored;
	}
};
