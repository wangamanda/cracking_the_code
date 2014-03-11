import java.util.Arrays;

public class FindIndex{
	public static void main(String args[]){
		int[] arr = new int[10];
		int n = Integer.parseInt(args[0]);
		for(int i = 0 ; i < 10 ; i ++ ){
			arr[i] = 10*(i+5)%100;
		}
		System.out.println(Arrays.toString(arr));
		int res = Index(arr, n);
		System.out.println(res+" "+n);
	}

	public static int Index(int[] arr, int n){
		int len = arr.length;
		int i = Search(arr, 0, len-1, n);
		return i;
	}

	public static int Search(int[] arr, int start, int end, int n){
		while(start <= end){
			int mid = start+(end-start)/2;
			if(arr[mid] < n){
				if(arr[end] > arr[mid]){
					if(n < arr[end]){
						start = mid+1;
						continue;
					}else if(n > arr[end]){
						end = mid-1;
						continue;
					}else{
						return end;
					}
				}else{
					start = mid+1;
					continue;
				}
			}else if(arr[mid] > n){
				if(arr[start] < arr[mid]){
					if(n > arr[start]){
						end = mid-1;
						continue;
					}else if(n < arr[start]){
						start = mid+1;
						continue;
					}else{
						return start;
					}
				}else{
					end = mid-1;
					continue;
				}
			}else{
				return mid;
			}
		}
		return -1;
	}
}
