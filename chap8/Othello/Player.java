package Othello;

public class Player{
	private Color color;
	public Player(Color c){
		color = c;
	}

	public int getScore(){
		return Game.getInstance().getBoard().getScoreForColor(color);
	}

	public Color getColor(){
		return color;
	}

	public boolean playPiece(int r, int c){
		return Game.getInstance().getBoard().placeColor(r, c, color);
	}
}
