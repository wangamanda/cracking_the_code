package Suffix;

import java.util.ArrayList;

public class SuffixTree{
	SuffixTreeNode root = new SuffixTreeNode();

	public SuffixTree(String s){
		for(int i = 0 ; i < s.length() ; i ++ ){
			String sub = s.substring(i);
			root.insert(sub, i);
		}
	}

	public ArrayList<Integer> search(String s){
		return root.getIndexes(s);
	}
}
