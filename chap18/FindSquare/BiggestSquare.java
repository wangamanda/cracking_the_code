package FindSquare;

public class BiggestSquare{
	public static void main(String[] args){
		int Size = 10;
		int[][] square = new int[Size][Size];
		for(int i = 0 ; i < 2 ; i ++ ){
			square[i][i] = 1;
		}
		Square sq = Find(square);
		if(sq != null){
			System.out.println(sq.row+" "+sq.col+" "+sq.size);
		}
	}

	public static Square Find(int[][] matrix){
		int N = matrix.length;
		for(int i = 0 ; i < N ; i ++ ){
			assert(matrix[i].length == matrix.length);
		}

		for(int i = N ; i >= 1 ; i -- ){
			int[] sizes = FindSize(matrix, i);
			if(sizes != null){
				return new Square(sizes[0], sizes[1], sizes[2]);
			}else{
				return null;
			}
		}
		return null;
	}

	public static int[] FindSize(int[][] matrix, int size){
		int count = matrix.length + 1 - size;
		for(int i = 0 ; i < count ; i ++ ){
			for(int j = 0 ; j < count ; j ++ ){
				if(isSquare(matrix, i, j, size)){
					int[] res = {i, j, size};
					System.out.println(i+" "+j+" "+size);
					return res;
				}
			}
		}
		return null;
	}

	public static boolean isSquare(int[][] matrix, int row, int col, int size){
		for(int i = 0 ; i < size ; i ++ ){
			if(matrix[row][col+i] == 1){
				return false;
			}
			if(matrix[row+size-1][col+i] == 1){
				return false;
			}
		}

		for(int i = 1 ; i < size-1 ; i ++ ){
			if(matrix[row+i][col] == 1){
				return false;
			}
			if(matrix[row+i][col+size-1] == 1){
				return false;
			}
		}

		return true;
	}
}
