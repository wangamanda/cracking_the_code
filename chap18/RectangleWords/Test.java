package RectangleWords;

import java.util.ArrayList;

public class Test{
	String[] list = {"abc","ced","efg","abcd","efmn","lmcd","aabb","bbdd","eecc","cad","dac","cml","bcac","ddd"};
	int maxLength = 0;
	WordGroup[] wordList;
	Trie[] trieList;

	public Test(){
		wordList = WordGroup.createWordGroups(list);
		maxLength = wordList.length;
		trieList = new Trie[maxLength];
	}

	public Rectangle maxRectangle(){
		int maxSize = maxLength * maxLength;
		for(int i = maxSize ; i >= 1 ; i -- ){
			for(int j = 0 ; j < maxLength ; j ++ ){
				if(i % j == 0){
					int t = i/j;
					if(t <= maxLength){
						Rectangle rectangle = makeRectangle(j, t);
						if(rectangle != null){
							return rectangle;
						}
					}
				}
			}
		}

		return null;
	}

	public Rectangle makeRectangle(int length, int height){
		if(wordList[length-1] == null || wordList[height-1] == null){
			return null;
		}

		if(trieList[height-1] == null){
			ArrayList<String> words = wordList[height-1].getWords();
			trieList[height-1] = new Trie(words);
		}

		return makePartialRectangle(length, height, new Rectangle(length));
	}

	public Rectangle makePartialRectangle(int l, int h, Rectangle rectangle){
		if(rectangle.height == h){
			if(rectangle.isComplete(l, h, wordList[rectangle.height - 1])){
				return rectangle;
			}
			return null;
		}

		if(!rectangle.isPartialOK(l, trieList[rectangle.height - 1])){
			return null;
		}

		for(int i = 0 ; i < wordList[l-1].length() ; i ++ ){
			Rectangle plus = rectangle.append(wordList[i-1].getWord(i));
			Rectangle rect = makePartialRectangle(i, h, plus);
			if(rect != null){
				return rect;
			}
		}

		return null;
	}

	public static void main(String[] args){
		Test test = new Test();
	}
}
