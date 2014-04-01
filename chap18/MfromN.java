import java.util.Random;
import java.util.Arrays;

public class MfromN{
	public static int N = 1000000;
	public static void main(String[] args){
		int M = 100;
		int[] arr = new int[N];
		Random r = new Random();
		for(int i = 0 ; i < N ; i ++ ){
			int n = r.nextInt(N);
			arr[i] = n;
		}

		int[] res = new int[M];
		sort(res, arr, M, 0, N-1);
		System.out.print(Arrays.toString(res));
		System.out.println();
		System.out.println(arr[M]+"");
	}

	public static void sort(int[] res, int[] arr, int M, int s, int e){
		Random r = new Random();
		int start = s;
		int end = e;
		if(s >= e || e > N || s < 0){
			return;
		}

		int pivot = arr[start + r.nextInt(end-start)];
		while(start < end){
			if(arr[start] <= pivot){
				start ++ ;
				if(start >= end){
					break;
				}
			}

			if(arr[end] >= pivot){
				end -- ;
				if(start >= end){
					break;
				}
			}

			if(arr[start] > pivot && arr[end] < pivot){
				int tmp = arr[start];
				arr[start] = arr[end];
				arr[end] = tmp;
				start ++ ;
				end -- ;
			}
		}


		if(start == M-1){
			for(int i = s ; i < start ; i ++ ){
				res[i] = arr[i];
			}
			return;
		}else if(start < M-1){
			for(int i = s ; i < start ; i ++ ){
				res[i] = arr[i];
			}
			sort(res, arr, M, start, e);
		}else{
			sort(res, arr, M, s, start);
		}
	}
}
