package SocialNetwork;

import java.util.ArrayList;

public class Person{
	int id;
	ArrayList<Integer> friends;
	public Person(int i){
		id = i;
		friends = new ArrayList<Integer>();
	}

	public int getID(){
		return id;
	}

	public void addFrind(int i){
		friends.add(i);
	}

	public ArrayList<Integer> getFriends(){
		return friends;
	}
}
