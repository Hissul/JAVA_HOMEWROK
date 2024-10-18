package Homework4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {
		
		Book[] books = {new Book("book_1", "author_1"), new Book("book_2", "author_2"), new Book("book_3", "author_3")};
		Bookshelf bookshelf = new Bookshelf(1, books);
		
		String fileName = "books.txt";
		
		srializeObject(bookshelf, fileName);
		Bookshelf deserializedBookshelf = deserializeObject(fileName);
		
		if(deserializedBookshelf != null) {
			System.out.println(deserializedBookshelf);
		}
	}
	
	// serialize
	public static void srializeObject(Bookshelf bookshelf, String fileName) {
		
		try {
			
			FileOutputStream outputStream = new FileOutputStream(fileName);
			try (ObjectOutputStream outputObjectStream = new ObjectOutputStream(outputStream)) {
				outputObjectStream.writeObject(bookshelf);
			}			
			
		}
		catch(IOException ex) {
			System.out.println(ex);
		}
	}
	
	// deserialize
	public static Bookshelf deserializeObject(String fileName) {
		
		try {
			
			FileInputStream inputStream = new FileInputStream(fileName);
			try (ObjectInputStream inputObjectStream = new ObjectInputStream(inputStream)) {
				Bookshelf shelf = (Bookshelf)inputObjectStream.readObject();
				
				return shelf;
			}			
		}
		catch(ClassNotFoundException ex) {
			System.out.println(ex);
		}
		catch(IOException ex) {
			System.out.println(ex);
		}
		return null;
	}
	

	

	

	


}
