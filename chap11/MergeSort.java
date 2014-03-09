import java.util.Arrays;

public class MergeSort{
	public static void main(String args[]){
		int[] arr = new int[10];
		for (int i = 0 ; i < 10 ; i ++ ){
			arr[i] = 50 - i*2;
		}
		System.out.println(Arrays.toString(arr));
		int[] res = new int[10];
		res = Sort(arr);
		System.out.println(Arrays.toString(res));
	}

	public static int[] Sort(int[] arr){
		int len = arr.length();
		int[] helper = new int[len];
		Sort(arr, helper, 0, len-1);
		return res;
	}

	public static int[] Sort(int[] arr, int[] helper, int start, int end){
		if(start == end){
			return arr;
		}
		int mid = (start+end)/2;
		arr = Sort(arr, helper, start, mid);
		helper = Sort(arr, helper, mid+1, end);
		arr = Merge(arr, helper, start, mid, end);
		return arr;
	}

	public static int[] Merge(int[] arr, int[] helper, int start, int mid, int end){
		helper = arr;
		i = start;
		j = mid+1;
		k = start;
		while(i != mid && j != end){
			if(helper[i] < helper[j]){
				arr[k] = helper[i];
				i++;
			}else{
				arr[k] = helper[j];
				j++;
			}
			k++;
			continue;
		}
	}
}
