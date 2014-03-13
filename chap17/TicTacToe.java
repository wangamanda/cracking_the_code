public class TicTacToe{
	public static void main(String[] args){
		int N = 10;
		int[][] board = new int[N][N];
		for(int i = 0 ; i < N ; i ++ ){
			for(int j = 0 ; j < N ; j ++ ){
				char c = ' ';
				board[i][j] = (int)c;
				if(i == 1){
					c = 'x';
					board[i][j] = (int)c;
				}
				if(i != j && j == 2){
					c = 'o';
					board[i][j] = (int)c;
				}
			}
		}

		if(isWon(board, N)){
			System.out.println("Is won!");
		}else{
			System.out.println("No winner.");
		}
	}

	public static boolean isWon(int[][] board, int N){

		boolean res = true;
		//check row
		for(int i = 0 ; i < N ; i ++ ){
			for(int j = 1 ; j < N ; j ++ ){
				if(board[i][j] != board[i][j-1] || board[i][j] == ' '){
					res &= false;
				}
			}
			if(res != false){
				return true;
			}
			res = true;
		}

		//check column
		for(int j = 0 ; j < N ; j ++ ){
			for(int i = 1 ; i < N ; i ++ ){
				if(board[i][j] != board[i-1][j] || board[i][j] == ' '){
					res &= false;
				}
			}
			if(res != false){
				return true;
			}
			res = true;
		}

		//ckeck diagnol
		for(int i = 1 ; i < N ; i ++ ){
			if(board[i][i] != board[i-1][i-1] || board[i][i] == ' '){
				res &= false;
			}
		}
		if(res != false){
			return true;
		}
		res = true;

		for(int i = 1 ; i < N ; i ++ ){
			if(board[i][N-1-i] != board[i-1][N-i] || board[i][N-1-i] == ' '){
				res &= false;
			}
		}
		if(res != false){
			return true;
		}
		return res;
	}
}
