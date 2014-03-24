import java.util.Random;
import java.util.Arrays;

public class MinArray{
	public static void main(String[] args){
		int arr[] = new int[10];
		Random rr = new Random();
		for (int i = 0 ; i < arr.length ; i ++ ){
			int r = rr.nextInt(20);
			arr[i] = r;
		}
		System.out.println(Arrays.toString(arr));
		FindMinArr(arr);
	}

	public static void FindMinArr(int[] arr){
		int m = 0;
		int n = 0;
		int start = 0;
		int end = arr.length-1;
		for(int i = 0 ; i < end-1 ; i ++ ){
			if(arr[i] > arr[i+1]){
				m = i;
				break;
			}
		}

		for(int i = end-1 ; i > start ; i -- ){
			if(arr[i] < arr[i-1]){
				n = i;
				break;
			}
		}
		
		if(m == 0 && n == arr.length-1){
			start = 0;
			end = 0;
			return;
		}

		int min = 100;
		int max = -1;
		for(int i = m+1 ; i <= n-1 ; i ++ ){
			if(arr[i] > max){
				max = arr[i];
			}

			if(arr[i] < min){
				min = arr[i];
			}
		}
		System.out.println(max+" "+min);

		for(int i = 0 ; i <= m ; i ++ ){
			if(arr[i] > min){
				start = i;
				break;
			}
		}

		for(int i = arr.length-1 ; i >= n ; i --){
			if(arr[i] < max){
				end = i;
				break;
			}
		}
		System.out.println(start+" "+end);
	}
}
