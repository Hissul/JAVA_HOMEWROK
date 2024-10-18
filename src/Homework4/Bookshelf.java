package Homework4;

import java.io.Serializable;
import java.util.Arrays;

public class Bookshelf implements Serializable {
	public int row;
	public Book[] books;
	
	public Bookshelf(int row, Book[] books) {
		this.row = row;
		this.books = books;
	}
	
	@Override 
	public String toString() {
		return Integer.toString(row) + " :\n" + Arrays.toString(books);
	}
}
