package ChatServer;

import java.util.ArrayList;

public abstract class Conversation{
	protected ArrayList<User> participants;
	protected int id;
	protected ArrayList<Message> messages;

	public ArrayList<User> getUsers(){
		return participants;
	}

	public boolean addUser(User u){
		if(participants.contains(u)){
			return false;
		}
		return participants.add(u);
	}

	public boolean removeUser(User u){
		if(!participants.contains(u)){
			return false;
		}
		return participants.remove(u);
	}

	public ArrayList<Message> getMessages(){
		return messages;
	}

	public boolean addMessage(Message m){
		if(messages.contains(m)){
			return false;
		}
		return messages.add(m);
	}

	public int getID(){
		return id;
	}
}
