package SocialNetwork;

import java.util.HashMap;

public class Machine{
	HashMap<Integer, Person> map = new HashMap<Integer, Person>();
	int id;

	public Machine(int i){
		id = i;
	}

	public Person getPerson(int i){
		return map.get(i);
	}
}
