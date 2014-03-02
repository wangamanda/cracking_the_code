package JukeBox;

import java.util.Queue;

public class PlayList{
	private Song song;
	private Queue<Song> songs;

	public PlayList(Song s, Queue<Song> queue){
		song = s;
		songs = queue;
	}

	public Song getNextToPlay(){
		return songs.peek();
	}

	public void queueUpSong(Song s){
		songs.add(s);
	}

	public Song removeSong(){
		return songs.remove();
	}
}
