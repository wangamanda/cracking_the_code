package chap4;

import java.util.Random;

public class inOrderSuccessor{
	
	public static void main(String args[]){
		Tree tr = new Tree();
		Random r = new Random();
		for(int i = 0 ; i < 10 ; i ++ ){
			int rr = r.nextInt(99);
			tr.insertOrder(rr);
		}
		tr.print();
		TreeNode s = tr.FindinOrderSuccessor(tr.root.left.left);
		String output = (s == null ? "NL":""+s.data);
		System.out.println(output);
	}
}
