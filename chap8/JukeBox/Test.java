package JukeBox;

import java.util.ArrayList;

public class Test{
	public static void main(String args[]){
		Song song = new Song(1, "You raise me up", 95.24);
		PlayList playList = new PlayList(song, null);
		ArrayList<Song> songs = new ArrayList<Song>();
		songs.add(song);
		CD cd = new CD(1, "WestLife", songs);
	}
}
