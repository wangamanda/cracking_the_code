package ChatServer;

import java.util.ArrayList;

public class GroupChat extends Conversation{
	public GroupChat(){
		participants = new ArrayList<User>();
	}
	
	public GroupChat(User u){
		participants = new ArrayList<User>();
		participants.add(u);
	}

}
