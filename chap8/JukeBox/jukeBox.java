package JukeBox;

import java.util.Set;

public class jukeBox{
	private CDPlayer cdPlayer;
	private User user;
	private Set<CD> cdCollection;
	
	public jukeBox(){
		
	}

	public jukeBox(CDPlayer cdPlayer, User user, Set<CD> cdCollection){
		this.cdPlayer = cdPlayer;
		this.user = user;
		this.cdCollection = cdCollection;
	}

	public void setUser(User u){
		this.user = u;
	}
}
