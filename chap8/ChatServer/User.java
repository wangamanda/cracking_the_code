package ChatServer;

import java.util.HashMap;

public class User{
	private int id;
	private String accountName;
	private String fullName;
	private UserStatusType status;

	private HashMap<Integer, PrivateChat> privatechats;
	private HashMap<Integer, GroupChat> groupchats;
	private HashMap<Integer, User> friends;
	private HashMap<Integer, Request> sentrequests;
	private HashMap<Integer, Request> receivedrequests;

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

	public void setStatus(UserStatusType type){
		status = type;
	}

	public UserStatusType getStatus(){
		return status;
	}

	public boolean addFriend(User u){
		if(friends.containsValue(u)){
			return false;
		}
		friends.put(u.getID(), u);
		return true;
	}

	public void receiveRequest(Request r){
		int receiveID = r.getFromUser().getID();
		if(!receivedrequests.containsKey(receiveID)){
			receivedrequests.put(receiveID, r);
		}
	}

	public void sentRequest(Request r){
		int sentID = r.getToUser().getID();
		if(!sentrequests.containsKey(sentID)){
			sentrequests.put(sentID, r);
		}
	}

	public void removeRequest(Request r){
		if(r.getToUser() == this){
			receivedrequests.remove(r);
		}
		if(r.getFromUser() == this){
			sentrequests.remove(r);
		}
	}

}
