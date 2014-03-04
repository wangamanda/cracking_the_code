package ChatServer;

public class Message{
	private String content;
	private Time time;
	public Message(String s, Time t){
		content = s;
		time = t;
	}

	public String getContent(){
		return content;
	}

	public void sendMessage(){
		System.out.println(time.getDay()+" "+time.getHour()+" "+time.getMinute()+" "+time.getSecond());
		System.out.println(content);
	}

	public Time getTime(){
		return time;
	}
}
