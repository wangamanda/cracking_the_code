import java.util.HashMap;
import java.util.Arrays;

public class WordFrequency{

	public static HashMap<String, Integer> map = new HashMap<String, Integer>();
	public static String[] book = {"This", "is", "a", "good", "book", "That", "is", "not", "a", "cat"};

	public static void main(String[] args){
		String s = args[0];
		int res = FindFrequency(s);
		System.out.println(Arrays.toString(book));
		System.out.println(res+"");
	}

	public static int FindFrequency(String str){
		for(int i = 0 ; i < book.length ; i ++ ){
			String s = book[i].toLowerCase();
			int f = 0;
			if(map.containsKey(s)){
				f = map.get(s);
			}
			f += 1;
			map.put(s, f);
		}
		
		if(str == null || map == null){
			return -1;
		}

		if(map.containsKey(str)){
			int res = map.get(str);
			return res;
		}

		return 0;
	}
}
