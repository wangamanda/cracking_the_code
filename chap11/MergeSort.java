import java.util.Arrays;

public class MergeSort{
	public static void main(String args[]){
		int[] arr = new int[10];
		for (int i = 0 ; i < 10 ; i ++ ){
			arr[i] = 50 - i*2;
		}
		System.out.println(Arrays.toString(arr));
		Sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void Sort(int[] arr){
		int len = arr.length;
		int[] helper = new int[len];
		Sort(arr, helper, 0, len-1);
	}

	public static void Sort(int[] arr, int[] helper, int start, int end){
		if(start >= end){
			return;
		}
		int mid = (start+end)/2;
		Sort(arr, helper, start, mid);
		Sort(arr, helper, mid+1, end);
		Merge(arr, helper, start, mid, end);
	}

	public static void Merge(int[] arr, int[] helper, int start, int mid, int end){
		for(int m = start ; m <= end ; m ++ ){
			helper[m] = arr[m];
		}
		int i = start;
		int j = mid+1;
		int k = start;
		while(i <= mid && j <= end){
			if(helper[i] < helper[j]){
				arr[k] = helper[i];
				i++;
			}else{
				arr[k] = helper[j];
				j++;
			}
			k++;
		}
		while(i <= mid){
			arr[k] = helper[i];
			i++;
			k++;
		}
		while(j <= end){
			arr[k] = helper[j];
			j++;
			k++;
		}
	}
}
