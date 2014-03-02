package JukeBox;

public class Song{
	private int id;
	private CD cd;
	private String title;
	private double length;
	private boolean isComplete;

	public Song(int i, String t, double l){
		id = i;
		title = t;
		length = l;
		isComplete = false;
	}

	public void play(){
		while(length > 0){
			System.out.println("Song name: "+ title + ". Length: "+length+".");
			length -= 0.01;
		}
		complete();
	}

	public double getLength(){
		return length;
	}

	public void complete(){
		System.out.println("Song "+ title+" ends.");
		isComplete = true;
	}

	public boolean iscomplete(){
		return isComplete;
	}
}
