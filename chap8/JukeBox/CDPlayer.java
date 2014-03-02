package JukeBox;

import java.util.Queue;

public class CDPlayer{
	private CD cd;
	private PlayList playList;

	public CDPlayer(CD c){
		cd = c;
		playList = null;
	}

	public CDPlayer(CD c, PlayList p){
		cd = c;
		playList = p;
	}

	public Song getCurrentSong(){
		Song s = playList.peek();
		return s;
	}

	public void playSong(Song s){
		if (s == null){
			playList.remove(s);
			playSong(getCurrentSong());
		}else{
			s.play();
		}
	}

	public PlayList getPlayList(){
		return playList;
	}

	public void setPlayList(PlayList p){
		playList = p;
	}

	public CD getCD(){
		return cd;
	}

	public void setCD(CD c){
		cd = c;
	}
}
