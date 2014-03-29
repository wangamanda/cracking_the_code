import java.util.HashMap;
import java.util.HashSet;

public class Parse{

	public static String str = "iamasecondyearmasterstudentfromlehighuniversity";
	public static HashSet<String> dictionary = new HashSet<String>();

	public Parse(){
		dictionary.add("i");
		dictionary.add("am");
		dictionary.add("a");
		dictionary.add("second");
		dictionary.add("year");
		dictionary.add("master");
		dictionary.add("student");
		dictionary.add("from");
		dictionary.add("university");
		dictionary.add("high");
		dictionary.add("dye");
		dictionary.add("arm");
		dictionary.add("ear");
	}

	public static void main(String[] args){
		Parse parse = new Parse();
		System.out.println(str);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int res = parseStr(map, 0, 0);
		System.out.println(res+"");
	}

	public static int parseStr(HashMap<Integer, Integer> map, int start, int end){
		if(end >= str.length()){
			return end-start;
		}

		if(map.containsKey(start)){
			return map.get(start);
		}

		int cutHere = parseStr(map, end+1, end+1);
		String word = str.substring(start,end+1);
		if(!dictionary.contains(word)){
			cutHere += word.length();
		}

		int cutBehind = parseStr(map, start, end+1);
		int min = Math.min(cutHere, cutBehind);
		map.put(start, min);
		return min;
	}
}
