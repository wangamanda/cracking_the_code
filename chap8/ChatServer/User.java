package ChatServer;

import java.util.HashMap;

public class User{
	private int id;
	private String accountName;
	private String fullName;
	private UserStatusType status;

	private HashMap<Integer, privateChat> privatechats;
	private HashMap<Integer, groupChat> groupchats;
	private HashMap<Integer, User> friends;
	private HashMap<Integer, Request> sentrequests;
	private HashMap<Integer, Request> receivedquests;

	public User(int i, String a, String f){
		id = i;
		accountName = a;
		fullName = f;
	}

	public String getAccountName(){
		return accountName;
	}

	public String getFullName(){
		return fullName;
	}

	public int getID(){
		return id;
	}

	public boolean sendMessageToUser(User to, String content){
		PrivateChat conversation = privatechats.get(to.getID());
		if(conversation == null){
			conversation = new PrivateChat(this, to);
			privatechats.put(to.getID(), conversation);
		}
		Message m = new Message(content, new Time());
		return conversation.addMessage(m);
	}

	public boolean sendMessageToGroup(int id, String content){
		GroupChat group = groupchats.get(id);
		if(group == null){
			group = new GroupChat();
			groupchats.put(id, group);
		}
		Message m = new Message(content, new Time());
		return group.addMessage(m);
	}


}
