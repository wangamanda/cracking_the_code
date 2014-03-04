package ChatServer;

public class Time{
	private int hour;
	private int minute;
	private int second;
	private int day;

	public Time(){
	
	}

	public Time(int h, int m, int s, int d){
		hour = h;
		minute = m;
		second = s;
		day = d;
	}

	public int getHour(){
		return hour;
	}

	public int getMinute(){
		return minute;
	}

	public int getSecond(){
		return second;
	}

	public int getDay(){
		return day;
	}
}
