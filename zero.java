import java.io.*;

public class zero{
	public static void main(String args[]) throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		int[][] a = new int[256][256];
		int line = 0;
		int i,j;
		int m,n;
		int M = 0;
		int N = 0;
		int[] row = new int[256];
		int[] col = new int[256];

		while ((str = br.readLine()) != null){
			String[] line_matrix = str.split(" ");
			N = line_matrix.length;
			for (i = 0 ; i < N ; i ++){
				a[line][i] = Integer.parseInt(line_matrix[i]);
			}
			line ++ ;
		}
		
		M = line;
		i = 0;
		for (m = 0 ; m < M ; m ++){
			for (n = 0 ; n < N ; n ++){
				if (a[m][n] == 0){
					row[i] = m;
					col[i] = n;
					i ++ ;
		/*			for (i = 0 ; i < M ; i ++)
						a[i][n] = 0;
					for (j = 0 ; j < N ; j ++)
						a[m][j]=0;
		*/
			}
			}
		}
		int sum = i;
		int k;
		for (i = 0 ; i < sum ; i ++){
		for (j = 0 ; j < M ; j ++){
			if (j == row[i]){
				for(k = 0 ; k < N ; k ++)
					a[row[i]][k]=0;
			}
		}
		}
		for (i = 0 ; i < sum ; i ++){
			for (j = 0 ; j < N ; j ++){
				if (j == col[i]){
					for (k = 0 ; k < M ; k ++)
						a[k][col[i]]=0;
				}
			}
		}
		for (m = 0 ; m < M ; m ++){
			for (n = 0 ; n < N ; n ++){
				System.out.print(a[m][n]+" ");
			}
			System.out.print("\n");
		}
		

	}
}
