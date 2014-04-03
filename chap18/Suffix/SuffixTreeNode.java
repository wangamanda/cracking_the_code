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
		String sub = String.substring(1);
		SuffixTreeNode child = null;
		if(children.containsKey(first)){
			child = children.get(first);
		}else{
			child = new SuffixTreeNode();
			children.put(first, child);
		}
		
		child.insert(sub, index);
	}
}
