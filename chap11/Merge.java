import java.util.Arrays;

public class Merge{
	public static void main(String args[]){
		int[] A = new int[20];
		int[] B = new int[10];
		for(int i = 0 ; i < 10 ; i ++ ){
			A[i] = 2*i;
			B[i] = 3*i - 5;
		}
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(B));
		Combine(A, 10, B);
		System.out.println(Arrays.toString(A));
	}

	public static void Combine(int[] a, int n, int[] b){
		int len1 = n;
		int len2 = b.length;
		int len = a.length;
		int i = len1-1;
		int j = len2-1;
		int k = len-1;
		while(i >= 0 && j >= 0){
			if(a[i] >= b[j]){
				a[k] = a[i];
				i--;
			}else{
				a[k] = b[j];
				j--;
			}
			k--;
		}

		while(i < 0 && j >= 0){
			a[k] = b[j];
			j--;
			k--;
		}
		while(j < 0 && i >= 0){
			a[k] = a[i];
			i--;
			k--;
		}
	}

}
