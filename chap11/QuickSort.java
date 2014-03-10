import java.util.Arrays;

public class QuickSort{
	public static void main(String args[]){
		int[] arr = new int[10];
		for (int i = 0 ; i < 10 ; i ++ ){
			arr[i] = 50 - i * 2;
		}
		System.out.println(Arrays.toString(arr));
		Sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void Sort(int[] arr){
		int len = arr.length;
		Sort(arr, 0, len-1);
	}

	public static void Sort(int[] arr, int start, int end){
		int mid = partition(arr, start, end);//find the pivot from middle and keep the smaller ones left, keep the right ones right, avoid find the first element as pivot(hard to insert smaller ones to the left, when the left one is the biggest number, it is hard to deal with)
		if(mid-1 > start){
			Sort(arr, start, mid-1);
		}
		if(mid < end){
			Sort(arr, mid, end);
		}
		return;
	}

	public static int partition(int[] arr, int start, int end){
		int mid = (start+end)/2;
		int pivot = arr[mid];
		int i = start;
		int j = end;
		while(i <= j){// <= not < because when there are only two elements, < will avoid us from entering the loop, mid-1 becomes an invalid index of array
			while(i <= j && arr[i] < pivot){
				i ++ ;
			}
			while(i <= j && arr[j] > pivot){
				j -- ;
			}
			if(i <= j){
				swap(arr, i, j);
				i ++ ;
				j -- ;
			}
		}
		return i;
	}

	public static void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
