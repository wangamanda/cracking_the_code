import java.util.Random;

public class MfromN{
	public static int N = 1000000000;
	public static void main(String[] args){
		int M = 1000000;
		int[] arr = new int[N];
		Random r = new Random();
		for(int i = 0 ; i < N ; i ++ ){
			int n = r.nextInt(N);
			arr[i] = n;
		}

		int[] res = sort(arr, M);
	}

	public static int[] sort(int[] arr, int M){
		Random r = new Random();
		int pivot = r.nextInt(N);
		
	}
}
