package Homework4;

import java.io.Serializable;

public class Book implements Serializable {
	public String name;
	public String author;
	
	public Book(String name, String author) {
		this.name = name;
		this.author = author;
	}
	
	@Override
	public String toString() {
		return this.author + "\t" + this.name + "\n";
	}
	
}
