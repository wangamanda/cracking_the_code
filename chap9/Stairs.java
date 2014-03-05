public class Stairs{
	public static void main(String args[]){
		int n = 40;
		int[] tmp = new int[n];
		for (int i = 0 ; i < n ; i ++ ){
			tmp[i] = -1;
		}
		int num = CalcMethods(n-1, tmp);
		System.out.println("Number of methods: "+num);
	}

	public static int CalcMethods(int n, int[] t){
		if (n < 0){
			return 0;
		}else if(n == 0){
			return 1;
		}else if(n > 0){
			if(t[n] == -1){
				t[n] = CalcMethods(n-1, t)+CalcMethods(n-2, t)+CalcMethods(n-3, t);
			}
		}
		return t[n];
	}
}
