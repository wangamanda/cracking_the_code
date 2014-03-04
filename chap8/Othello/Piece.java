package Othello;

public class Piece{
	private Color color;
	
	public Piece(Color c){
		color = c;
	}

	public Color Flip(){
		if(color == Color.White){
			return Color.Black;
		}else if(color == Color.Black){
			return Color.White;
		}
	}

	public Color getColor(){
		return color;
	}
}
