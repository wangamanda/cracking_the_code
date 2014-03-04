package ChatServer;

import java.util.HashMap;

public class UserManager{
	private static UserManager instance;
	private HashMap<Integer, User> usersById;
	private HashMap<String, User> usersByAccountName;
	private HashMap<Integer, User> onlineUsers;

	public static UserManager getInstance(){
		if(instance == null){
			instance = new UserManager();
		}
		return instance;
	}

	public void addUser(User from, String toAccount){
		User to = usersByAccountName.get(toAccount);
		Request r = new Request(from, to, new Time());
		to.receiveRequest(r);
		from.sentRequest(r);
	}

	public void approveRequest(Request r){
		r.setStatus(RequestStatus.Accepted);
		User from = r.getFromUser();
		User to = r.getToUser();
		from.addFriend(to);
		to.addFriend(from);
	}

	public void rejectRequest(Request r){
		r.setStatus(RequestStatus.Rejected);
		User from = r.getFromUser();
		from.removeRequest(r);
		User to = r.getToUser();
		to.removeRequest(r);
	}

	public void userSignedOn(String account){
		User u = usersByAccountName.get(account);
		if(u != null){
			u.setStatus(UserStatusType.Available);
			onlineUsers.put(u.getID(), u);
		}
	}

	public void userSignedOff(String account){
		User u = usersByAccountName.get(account);
		if(u != null){
			u.setStatus(UserStatusType.Offline);
			onlineUsers.remove(u.getID());
		}
	}
}
