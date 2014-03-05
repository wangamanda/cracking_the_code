package Hashtab;

public class Test{

	public static void main(String args[]){
		Hash<Integer, Character> h = new Hash<Integer, Character>();
		Element<Integer, Character> e = new Element<Integer, Character>(2, 'a');
		h.put(e);
	}
}
