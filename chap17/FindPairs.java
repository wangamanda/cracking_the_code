import java.util.HashMap;
import java.util.HashSet;

public class FindPairs{
	public static void main(String[] args){
		int[] arr = new int[30];
		int N = 50;
		for(int i = 0 ; i < arr.length ; i ++ ){
			arr[i] = i*2+3;
		}
		HashSet<Integer> map = new HashSet<Integer>();
		Find(arr, map, N);
		for(Integer i : map){
			if(map.contains(i) || map.contains(N-i)){
				System.out.println(i+" , "+(N-i));
			}
		}
	}

	public static void Find(int[] arr, HashSet<Integer> map, int N){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0 ; i < arr.length ; i ++ ){
			set.add(arr[i]);
		}

		for(int i = 0 ; i < arr.length ; i ++ ){
			if(set.contains(N-arr[i]) && !map.contains(N-arr[i])){
				map.add(arr[i]);
			}
		}
	}
}
