package BookReader;

public class Book{
	private String name;
	private String author;
	private int id;
	private User reader;

	public Book(String n, String a, int i){
		name = n;
		author = a;
		id = i;
	}

	public int getID(){
		return id;
	}

	public String getName(){
		return name;
	}

	public String getAuthor(){
		return author;
	}

	public void setID(int i){
		id = i;
	}

	public User getReader(){
		return reader;
	}

	public void setReader(User r){
		reader = r;
	}

	public boolean isAvailable(){
		return reader == null;
	}
}
