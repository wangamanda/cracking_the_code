package ChatServer;

public class Request{
	private User from;
	private User to;
	private Time time;
	private RequestStatus status;

	public Request(User f, User t, Time tm, RequestStatus s){
		from = f;
		to = t;
		time = tm;
		status = s;
	}

	public User getFromUser(){
		return from;
	}

	public User getToUser(){
		return to;
	}

	public Time getTime(){
		return time;
	}

	public RequestStatus getStatus(){
		return status;
	}
}
