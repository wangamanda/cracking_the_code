package RectangleWords;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;

public class WordGroup{
	HashMap<String, Boolean> map = new HashMap<String, Boolean>();
	ArrayList<String> arr =new ArrayList<String>();

	public WordGroup(){
	}

	public boolean containsWord(String s){
		return map.containsKey(s);
	}

	public int length(){
		return arr.size();
	}

	public void addWord(String s){
		map.put(s, true);
		arr.add(s);
	}

	public String getWord(int i){
		return arr.get(i);
	}

	public ArrayList<String> getWords(){
		return arr;
	}

	public static WordGroup[] createWordGroups(String[] list){
		WordGroup[] res;
		int maxLength = 0;
		for(int i = 0 ; i < list.length ; i ++ ){
			if(list[i].length() > maxLength){
				maxLength = list[i].length();
			}
		}

		res = new WordGroup[maxLength];

		for(String s : list){
			int len = s.length()-1;
			if(res[len] == null){
				res[len] = new WordGroup();
			}

			res[len].addWord(s);
		}
		return res;
	}
}
