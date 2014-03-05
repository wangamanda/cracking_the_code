package Othello;

public class Piece{
	private Color color;
	
	public Piece(Color c){
		color = c;
	}

	public void Flip(){
		if(color == Color.White){
			color = Color.Black;
		}else if(color == Color.Black){
			color = Color.White;
		}
	}

	public Color getColor(){
		return color;
	}
}
