public class LackInN{
	public static void main(String args[]){
		int n = 50;
		int[] arr = new int[50];
		String N = Integer.toBinaryString(n);
		int[] m = new int[N.length()+2];

		for (int i = 0 ; i < 20 ; i ++ ){
			arr[i] = i;
		}

		for (int i = 20 ; i <= 49 ; i ++ ){
			arr[i] = i+1;
		}
		FindLack(m, n, arr, 0);
		for (int i = m.length-1 ; i >= 0 ; i -- ){
			System.out.print(m[i]+"");
		}
		System.out.println();
		System.out.println(N);
	}

	public static void FindLack(int[] m, int n, int[] arr, int j){
		if (n == 1){
			m[j] = 1^arr[0];
			return;
		}

		int[] zeros = new int[2*n];
		int[] ones = new int[2*n];
		int z = 0;
		int o = 0;

		for (int i = 0 ; i < n ; i ++ ){
			int t = getDigit(arr[i], 0);
			if (t == 1){
		//		ones[o] = arr[i] >> 1;
				o ++ ;
			}else{
		//		zeros[z] = arr[i] >> 1;
				z ++ ;
			}
		}

		if(z > o){
			m[j] = 1;
			FindLack(m, o, ones, ++j);
		} else{
			m[j] = 0;
			FindLack(m, z, zeros, ++j);
		}
	}

	public static int getDigit(int a, int j){
		j = a >> j;
		return j&1;
	}
}
