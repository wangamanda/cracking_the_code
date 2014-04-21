import java.util.ArrayList;
import java.util.Arrays;

public class SetOfIntegers{
	public static void main(String[] args){
		int M = 10;
		int N = 20;
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i ++ ){
			arr[i] = i;
		}
		System.out.println(Arrays.toString(arr));
		Shuffle(arr);
		int[] res = new int[M];
		for(int i = 0 ; i < M ; i ++ ){
			res[i] = arr[i];
		}
		System.out.println(Arrays.toString(res));
	}

	public static void Shuffle(int[] arr){
		for(int i = 0 ; i < arr.length ; i ++ ){
			int t = rand(0, i);
			int tmp = arr[i];
			arr[i] = arr[t];
			arr[t] = tmp;
		}
	}

	public static int rand(int low, int high){
		return low+(int)(Math.random()*(high-low+1));
	}
}
