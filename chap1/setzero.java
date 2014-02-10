public class setzero{

	public static void main(String args[]){
	
		int mat[][] = {{1,2,3,0,5},{2,0,1,3,5},{4,5,6,7,8},{9,8,7,6,0},{3,5,7,3,6}};
		int n = mat.length;
		zero(mat, n);
	}

	public static void zero(int[][] mat, int n){
	
		for (int i = 0 ; i < n ; i ++ ){
		
			for (int j = 0 ; j < n ; j ++ ){
			
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}

		boolean col[] = new boolean[5];
		boolean row[] = new boolean[5];

		for (int i = 0 ; i < n ; i ++ ){
			
			for (int j = 0 ; j < n ; j ++ ){
			
				if (mat[i][j] == 0){
					row[i] = true;
					col[j] = true;
				}
			}
		}

		for (int i = 0 ; i < n ; i ++ ){
			if (row[i] == true){
				for (int j = 0 ; j < n ; j ++ ){
					mat[i][j] = 0;
				}
			}
		}

		for (int j = 0 ; j < n ; j ++ ){
			if (col[j] == true){
				for (int i = 0 ; i < n ; i ++ ){
					mat[i][j] = 0;
				}
			}
		}

		for (int i = 0 ; i < n ; i ++ ){
			
			for (int j = 0 ; j < n ; j ++ ){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
}
