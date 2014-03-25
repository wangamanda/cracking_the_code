package NumToString;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class PrintNum{

	public String[] ones = {"one","two","three","four","five","six","seven","eight","nine"};
	public String[] teens = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	public String[] tens = {"ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninty"};
	public String[] bigs = {"","thousand","million"};
	public String getStringFromInt(int N){
		String res = "";
		int count = 0;
		if(N == 0){
			return "zero";
		}

		if(N < 0){
			return "Negative "+getStringFromInt(-1*N);
		}

		while(N != 0){
			res = getStringFrom100(N % 1000) + " " + bigs[count] + " " + res;
			N /= 1000;
			count ++ ;
		}

		return res;
	}

	public String getStringFrom100(int N){
		String res = "";
		int n = N/100;
		if(n >= 1){
			res += ones[n-1]+" "+"hundred ";
		}

		int m = 0;
		N %= 100;
		if(N % 100 != 0){
			m = N / 10;

			int k = 0;
			k = N % 10;
			if(m > 1){
				res += tens[m-1]+" ";
				if(N % 10 != 0){
					res += ones[k-1]+" ";
				}
			}

			else if(m == 1){
				res += teens[k]+" ";
			}
			
			else{
				res += ones[k-1]+" ";
			}
		}
		return res;
	}
}
