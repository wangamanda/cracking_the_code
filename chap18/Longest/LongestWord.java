package Longest;

import java.util.Arrays;
import java.util.HashMap;

public class LongestWord{
	public static String arr[] = {"test", "tester","testertest", "testing", "apple", "seattle", "banana", "batting", "ngcat", "batti", "bat", "testingtester", "testbattingcatt"};

	public static void main(String[] args){
		Arrays.sort(arr, new LengthComparator());
		String res = getLongest(arr);
		System.out.println(res);
	}

	public static String getLongest(String[] arr){
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		for(String str : arr){
			map.put(str, true);
		}

		for(String str : arr){
			if(map.get(str) == true && isBuildWord(str, false, map)){
				return str;
			}
		}

		return "";
	}

	public static boolean isBuildWord(String str, boolean isBuild, HashMap<String, Boolean> map){
		if(map.containsKey(str)&& map.get(str) == true && isBuild){
			return true;
		}

		for(int i = 1 ; i < str.length() ; i ++ ){
			String left = str.substring(0, i);
			String right = str.substring(i);
			if(map.containsKey(left) && map.get(left) == true && isBuildWord(right, true, map)){
				return true;
			}

			if(!map.containsKey(left)){
				map.put(left, false);
			}
		}
		return false;
	}
}
