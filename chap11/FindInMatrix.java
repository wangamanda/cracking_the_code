public class FindInMatrix{
	public static void main(String args[]){
		int M = 4;
		int N = 4;
		int[][] mat = new int[M][N];
		for(int i = 0 ; i < M ; i ++ ){
			for(int j = 0 ; j < N ; j ++ ){
				mat[i][j] = i * 2 + j * 3;
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		int n = Integer.parseInt(args[0]);
		int[] ij = Find(mat, n);
		if(ij != null){
			System.out.println(n+": "+ij[0]+" "+ij[1]+" ");
		}
	}

	public static int[] Find(int[][] mat, int n){
		int M = mat.length;
		int N = mat[0].length;
		int[] res = Find(mat, n, 0, M-1, 0, N-1);
		return res;
	}

	public static int[] Find(int[][] mat, int n, int rstart, int rend, int cstart, int cend){
		if(rstart > rend && cstart > cend){
			return null;
		}

		int rmid = rstart + (rend-rstart)/2;
		int cmid = cstart + (cend-cstart)/2;
		if(mat[rmid][cmid] > n){
			return Find(mat, n, rstart, rmid, cstart, cmid);
		}else if(mat[rmid][cmid] < n){
			int[] ij1 = null;
			int[] ij2 = null;
			int[] ij3 = null;

			if(rmid+1 <= rend){
				ij1 = Find(mat, n, rmid+1, rend, cstart, cmid);
			}

			if(ij1 != null){
				return ij1;
			}

			if(cmid+1 <= cend){
				ij2 = Find(mat, n, rstart, rmid, cmid+1, cend);
			}

			if(ij2 != null){
				return ij2;
			}

			if(rmid+1 <= rend && cmid+1 <= cend && mat[rmid+1][cmid+1] <= n){
				ij3 = Find(mat, n, rmid+1, rend, cmid+1, cend);
			}
			return ij3;
		}else{
			int[] ij = new int[2];
			ij[0] = rmid;
			ij[1] = cmid;
			return ij;
		}
	}
}
