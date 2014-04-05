package RectangleWords;

import java.util.LinkedList;

public class TrieNode{
	LinkedList<TrieNode> children = null;
	char value;
	boolean terminate = false;

	public TrieNode(){
		children = new LinkedList<TrieNode>();
	}

	public TrieNode(char c){
		this();
		value = c;
	}

	public char getChar(){
		return value;
	}

	public TrieNode getChild(char c){
		for(TrieNode t : children){
			if(t != null && t.getChar() == c){
				return t;
			}
		}
		return null;
	}

	public boolean terminate(){
		return terminate;
	}

	public void setTerminate(boolean t){
		terminate = t;
	}

	public void addWord(String s){
		if(s == null || s.isEmpty()){
			return;
		}

		char first = s.charAt(0);
		TrieNode t = getChild(first);
		if(t == null){
			t = new TrieNode(first);
			children.add(t);
		}

		if(s.length() > 1){
			t.addWord(s.substring(1));
		}else{
			t.setTerminate(true);
		}
	}
}
