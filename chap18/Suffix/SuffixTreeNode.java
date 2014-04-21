package Suffix;

import java.util.HashMap;
import java.util.ArrayList;

public class SuffixTreeNode{
	char value;
	HashMap<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();
	ArrayList<Integer> arr = new ArrayList<Integer>();

	public SuffixTreeNode(){
	
	}

	public void insert(String str, int index){
		arr.add(index);
		char first = str.charAt(0);
		value = first;
		String sub = str.substring(1);
		SuffixTreeNode child = null;
		if(children.containsKey(first)){
			child = children.get(first);
		}else{
			child = new SuffixTreeNode();
			children.put(first, child);
		}
		
		child.insert(sub, index);
	}

	public ArrayList<Integer> getIndexes(String str){
		if(str == null || str.length() == 0){
			return arr;
		}else{
			char first = str.charAt(0);
			if(children.containsKey(first)){
				String sub = str.substring(1);
				return children.get(first).getIndexes(sub);
			}
		}
		return null;
	}
}
