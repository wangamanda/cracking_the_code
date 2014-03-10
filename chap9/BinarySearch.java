import java.util.Arrays;

public class BinarySearch{
	public static void main(String args[]){
		int[] arr = new int[10];
		int n = Integer.parseInt(args[0]);
		for (int i = 0 ; i < 10 ; i ++ ){
			arr[i] = 3 * i;
		}

		System.out.println(Arrays.toString(arr));
		int index = Search(arr, n);
		int i = BSearch(arr, n);
		System.out.println(n + " " + index + " " + i);
	}

	public static int BSearch(int[] arr, int n){
		int len = arr.length;
		int start = 0;
		int end = len-1;
		while(start <= end){
			int mid = (start+end)/2;
			if(arr[mid] < n){
				start = mid+1;
				continue;
			}else if(arr[mid] > n){
				end = mid-1;
				continue;
			}else{
				return mid;
			}
		}
		return -1;
	}

	public static int Search(int[] arr, int n){
		int len = arr.length;
		int index = Search(arr, 0, len-1, n);
		return index;
	}

	public static int Search(int[] arr, int start, int end, int n){
		int mid = (start + end)/2;
		if(start > end){
			return -1;
		}
		if(arr[mid] == n){
			return mid;
		}else if (arr[mid] < n){
			return Search(arr, mid+1, end, n);
		}else{
			return Search(arr, start, mid-1, n);
		}
	}
}
