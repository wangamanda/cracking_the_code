package JukeBox;

import java.util.ArrayList;

public class CD{
	private int id;
	private String artist;
	private ArrayList<Song> songs = new ArrayList<Song>();

	public CD(int i, String a, ArrayList<Song> s){
		id = i;
		artist = a;
		songs = s;
	}
}
