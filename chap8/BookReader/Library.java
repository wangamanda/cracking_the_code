package BookReader;

import java.util.Hashtable;

public class Library{
	private Hashtable<Integer, Book> books;

	public Book addBook(int id, String name, String author){
		if(books.containsKey(id)){
			return null;
		}
		Book b = new Book(name, author, id);
		books.put(id, b);
		return b;
	}

	public boolean remove(Book b){
		if(books.containsKey(b.getID())){
			books.remove(b.getID());
			return true;
		}
		return false;
	}

	public boolean remove(int id){
		if(!books.containsKey(id)){
			return false;
		}
		books.remove(id);
		return true;
	}

	public Book find(int id){
		return books.get(id);
	}
}
