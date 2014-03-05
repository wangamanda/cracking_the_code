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
		int up = row;
		int down = row;
		int left = col;
		int right = col;
		if(board[row][col] != null){
			return false;
		}else{
			board[row][col] = new Piece(c);
			for(int i = 0 ; i < row ; i ++ ){
				if(board[i][col] == null || board[i][col].getColor() == c){
					continue;
				}else{
					up = i;
				}
			}
			for (int i = ROW ; i > row ; i -- ){
				if(board[i][col] == null || board[i][col].getColor() == c){
					continue;
				}else{
					down = i;
				}
			}
			for (int j = 0 ; j < col ; j ++ ){
				if(board[row][j] == null || board[row][j].getColor() == c){
					continue;
				}else{
					left = j;
				}
			}
			for (int j = COL ; j > col ; j -- ){
				if(board[row][j] == null || board[row][j].getColor() == c){
					continue;
				}else{
					right = j;
				}
			}
			
			int cnt = 0;
			for (int i = up ; i <= down ; i ++ ){
				board[i][col].Flip();
				cnt ++ ;
			}
			for (int j = left ; j <= right ; j ++ ){
				board[row][j].Flip();
				cnt ++ ;
			}
			
			for (int i = cnt ; i >= 0 ; i -- ){
				if(c == Color.Black){
					BlackCount ++ ;
				}else{
					WhiteCount ++ ;
				}
			}
			
		}
		return true;
	}

	public int getScoreForColor(Color c){
		if(c == Color.Black){
			return BlackCount;
		}else{
			return WhiteCount;
		}
	}
}
