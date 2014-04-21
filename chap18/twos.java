import java.util.ArrayList;

public class twos{
	public static void main(String[] args){
		int N = Integer.parseInt(args[0]);
		int res = Count(N);
		System.out.println(res+"");
	}

	public static int Count(int number){
		int res = 0;
		int len = String.valueOf(number).length();
		for(int i = 0 ; i < len ; i ++ ){
			res += Count(number, i);
		}
		return res;
	}

	public static int Count(int number, int n){
		int powerofTen = (int)Math.pow(10, n);
		int nextpowerofTen = (int)Math.pow(10, n+1);
		int lower = number - number % nextpowerofTen;
		int upper = lower + nextpowerofTen;
		int digit = (number / powerofTen) % 10;
		int right = number % powerofTen;

		if(digit < 2){
			return lower/10;
		}else if(digit == 2){
			return lower/10 + right + 1;
		}else{
			return upper/10;
		}
	}
}
