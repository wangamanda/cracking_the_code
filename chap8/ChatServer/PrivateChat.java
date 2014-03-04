package ChatServer;

import java.util.ArrayList;

public class PrivateChat extends Conversation{
	public PrivateChat(User u1, User u2){
		participants = new ArrayList<User>();
		participants.add(u1);
		participants.add(u2);
	}
	
	public User get(User u){
		if(participants.contains(u)){
			return u;
		}
		return null;
	}
}
