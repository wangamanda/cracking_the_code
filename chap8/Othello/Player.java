package Othello;

public class Player{
	private Color color;
	public Player(Color c){
		color = c;
	}

	public int getScore(){
		
	}

	public Color getColor(){
		return color;
	}

	public boolean playPiece(int r, int c){
		Game.getInstance().getBoard().placeColor(r, c, color);
	}
}
