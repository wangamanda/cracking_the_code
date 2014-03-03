package BookReader;

import java.util.Hashtable;

public class UserManager{
	private Hashtable<Integer, User> users;

	public User addUser(int id, String name){
		if(users.contains(id)){
			return null;
		}
		User user = new User(id, name);
		users.put(id, user);
		return user;
	}

	public boolean remove(User u){
		return users.remove(u.getID());
	}

	public boolean remove(ind id){
		if(users.containsKey(id)){
			users.remove(id);
			return true;
		}
		return false;
	}

	public User find(int id){
		return users.get(id);
	}
}
