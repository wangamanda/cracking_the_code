package JukeBox;

public class Song{
	private int id;
	private CD cd;
	private String title;
	private double length;
	private boolean isComplete;

	public Song(int i, CD c, String t, double l){
		id = i;
		cd = c;
		title = t;
		length = l;
		isComplete = false;
	}

	public void play(){
		while(length > 0){
			System.out.println("Song name: "+ name + ". Singer: "+singer+".");
			length -= 0.01;
		}
		complete();
	}

	public double getLength(){
		return length;
	}

	public void complete(){
		System.out.println("Song "+ name+" ends.");
		isComplete = true;
	}

	public boolean iscomplete(){
		return isComplete;
	}
}
