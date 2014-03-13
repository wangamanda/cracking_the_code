public class TrailingZero{
	public static void main(String[] args){
		int n = Integer.parseInt(args[0]);
		int res = Zeros(n);
		System.out.println(res+"");
	}

	public static int Zeros(int n){
		int k = 1;
		for (int i = 5 ; i <= n ; i += 5){
			k ++ ;
			int t = i/5;
			while(t % 5 == 0){
				t /= 5;
				k ++ ;
			}
		}
		return k;
	}
}
