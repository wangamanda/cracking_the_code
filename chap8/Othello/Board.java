package Othello;

public class Board{
	private int BlackCount = 0;
	private int WhiteCount = 0;
	private int COL;
	private int ROW;
	private Piece[][] board;

	public Board(int r, int c){
		ROW = r;
		COL = c;
		board = new Piece[ROW][COL];
	}

	public void Initialize(){
		int col = COL/2;
		int row = ROW/2;
		board[row][col] = new Piece(Color.Black);
		board[row+1][col+1] = new Piece(Color.Black);
		board[row+1][col] = new Piece(Color.White);
		board[row][col+1] = new Piece(Color.White);
		BlackCount = 2;
		WhiteCount = 2;
	}

	public boolean placeColor(int row, int col, Color c){
		if(board[row][col] != null){
			return false;
		}else{
			board[row][col] = new Piece(c);
			if(c == Color.Black){
				BlackCount ++ ;
			}else{
				WhiteCount ++ ;
			}
			
			for(int i = 0 ; i < row ; i ++ ){
				
			}
			return true;
		}
	}

}
