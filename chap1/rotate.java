public class rotate{
	
	public static void main(String args[]){
	
		int mat[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int n = 4;
		rotatemat(mat, n);
	}

	public static void rotatemat(int[][] mat, int n){
	
		for (int i = 0 ; i < n ; i ++ ){
			for (int j = 0 ; j < n ; j ++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}

		for (int j = 0 ; j < n-1 ; j ++ ){ //transpose
			for (int i = j+1 ; i < n ; i ++ ){
				int tmp = mat[j][i];
				mat[j][i] = mat[i][j];
				mat[i][j] = tmp;
			}
		}

		for (int j = 0 ; j < n/2 ; j ++ ){//change j and n-1-j row
			for (int i = 0 ; i < n ; i ++ ){
				int tmp = mat[j][i];
				mat[j][i] = mat[n-1-j][i];
				mat[n-1-j][i] = tmp;
			}
		}

		for (int j = 0 ; j < n ; j ++ ){
			for (int i = 0 ; i < n ; i ++ ){
				System.out.print(mat[j][i]+" ");
			}
			System.out.println();
		}
	}
}
