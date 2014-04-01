import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class WordDistance{
	public static HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
	public static String[] book = {"This", "is", "a", "book", "It", "is", "helpful", "to", "improve", "your", "programming","skills", "You", "can", "buy", "this", "book", "from", "the", "book", "store", "or", "online"};
	
	public static void main(String[] args){
		String word = new String();
		for(int i = 0 ; i < book.length ; i ++ ){
			word = book[i].toLowerCase();
			if(map.containsKey(word)){
				ArrayList<Integer> arr = map.get(word);
				arr.add(i);
			}else{
				ArrayList<Integer> arr = new ArrayList<Integer>();
				arr.add(i);
				map.put(word, arr);
			}
		}

		String word1 = args[0].toLowerCase();
		String word2 = args[1].toLowerCase();
		System.out.println(Arrays.toString(book));
		System.out.println(word1 + " " + word2);
		int res = getDistance(word1, word2);
		System.out.println(res + "");
	}

	public static int getDistance(String str1, String str2){
		if(!map.containsKey(str1) || !map.containsKey(str2)){
			return Integer.MAX_VALUE;
		}

		ArrayList<Integer> arr1 = map.get(str1);
		ArrayList<Integer> arr2 = map.get(str2);
		int[] array1 = new int[arr1.size()+arr2.size()];
		int[] array2 = new int[arr1.size()+arr2.size()];
		int i = 0 ;
		int j = 0 ;
		int k = 0 ;
		while(i < arr1.size() || j < arr2.size()){
			if(i == arr1.size() || arr1.get(i) > arr2.get(j)){
				array1[k] = arr2.get(j);
				array2[k] = 2;
				k ++ ;
				j ++ ;
			}else{
				array1[k] = arr1.get(i);
				array2[k] = 1;
				k ++ ;
				i ++ ;
			}
		}

		int min = Integer.MAX_VALUE;
		for(i = 0 ; i < array1.length-1 ; i ++ ){
			if(Math.abs(array1[i]-array1[i+1]) < min && Math.abs(array2[i]-array2[i+1])==1){
				min = Math.abs(array1[i] - array1[i+1]);
			}
		}
		return min;
	}
}
