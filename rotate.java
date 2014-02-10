import java.io.*;
import java.lang.Integer;

public class rotate{
	public static void main(String args[]) throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int[][] a = new int[256][256];
		int line = 0;

		String str = null;
		while((str=br.readLine()) != null){
			String[] original = str.split(" ");
			for (int i = 0; i < original.length; i ++){
				a[line][i] = Integer.parseInt(original[i]);
//				System.out.print(a[line][i]);
			}
			line ++;
		}
		int N = line;
		System.out.print(N);
		System.out.print("\n");
		int m,n;
		int [][] b = new int[N][N];
		for (m = 0 ; m < N ; m ++){
			for (n = 0 ; n < N ; n ++){
				b[m][n] = a[N-1-n][m];
				System.out.print(b[m][n]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
		
	}
}
