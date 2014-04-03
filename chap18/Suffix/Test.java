package Suffix;

import java.util.ArrayList;

public class Test{
	public static void main(String[] args){
		String testString = "mississippi";
		String[] stringArr = {"is","sip","hi","sis"};
		SuffixTree tree = new SuffixTree(testString);
		for(String s : stringArr){
			ArrayList<Integer> indexes = tree.search(s);
			if(indexes != null){
				System.out.println(s+" "+indexes.toString());
			}
		}
	}
}
