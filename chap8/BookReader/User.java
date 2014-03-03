package BookReader;

import java.util.Set;
import java.util.HashSet;

public class User{
	private int uid;
	private String uname;
	private Set<Book> books;

	public User(int i, String n){
		uid = i;
		uname = n;
		books = new HashSet<Book>();
	}

	public int getID(){
		return uid;
	}

	public void setID(int i){
		uid = i;
	}

	public String getReaderName(){
		return uname;
	}

	public void setReaderName(String n){
		uname = n;
	}

	public boolean borrowBook(Book b){
		if(b.isAvailable()){
			books.add(b);
			b.setReader(this);
			return true;
		}
		return false;
	}

	public void renewMembership(){
	
	}

	public boolean returnBook(Book b){
		if(books.contains(b)){
			b.setReader(null);
			return books.remove(b);
		}
		return false;
	}
}
