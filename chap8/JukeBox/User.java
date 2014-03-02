package JukeBox;

public class User{
	private String name;
	private int id;
	
	public User(int i, String s){
		id = i;
		name = s;
	}

	public String getName(){
		return name;
	}

	public void setName(String s){
		name = s;
	}

	public int getID(){
		return id;
	}

	public void setID(int i){
		id = i;
	}

	public User getUser(){
		return this;
	}

}
