package RectangleWords;

import java.util.ArrayList;

public class Trie{
	TrieNode root;

	public Trie(ArrayList<String> words){
		root = new TrieNode();
		for(String s : words){
			root.addWord(s);
		}
	}

	public Trie(String[] words){
		root = new TrieNode();
		for(String s : words){
			root.addWord(s);
		}
	}

	public boolean contains(String prefix){
		TrieNode cur = root;
		for(int i = 0 ; i < prefix.length() ; i ++ ){
			cur = cur.getChild(prefix.charAt(i));
			if(cur == null){
				return false;
			}
		}
		return cur.terminate();
	}
}
