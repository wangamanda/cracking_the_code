package RectangleWords;

public class Rectangle{
	char[][] matrix;
	int length;
	int height;

	public Rectangle(int l){
		length = l;
	}

	public Rectangle(int l, int h, char[][] c){
		length = l;
		height = h;
		matrix = c;
	}

	public char getLetter(int i, int j){
		return matrix[i][j];
	}

	public String getColumn(int j){
		char[] res = new char[height];
		for(int i = 0 ; i < height ; i ++ ){
			res[i] = matrix[i][j];
		}
		return new String(res);

	}

	public boolean isComplete(int l, int h, WordGroup wg){
		if(height == h){
			for(int j = 0 ; j < l ; j ++ ){
				String str = getColumn(j);
				if(!wg.containsWord(str)){
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public boolean isPartialOK(int l, Trie trie){
		if(height == 0){
			return true;
		}

		for(int i = 0 ; i < l ; i ++ ){
			String str = getColumn(i);
			if(!trie.contains(str)){
				return false;
			}
		}
		return true;
	}

	public Rectangle append(String s){
		if(s.length() == length){
			char[][] temp = new char[height+1][length];
			for(int i = 0 ; i < height ; i ++ ){
				for(int j = 0 ; j < length ; j ++ ){
					temp[i][j] = matrix[i][j];
				}
			}

			s.getChars(0, length, temp[height], 0);
			return new Rectangle(length, height+1, temp);
		}
		return null;
	}

	public void print(){
		for(int i = 0 ; i < height ; i ++ ){
			for(int j = 0 ; j < length ; j ++ ){
				System.out.print(matrix[i][j]+"");
			}
			System.out.println();
		}
	}
}
