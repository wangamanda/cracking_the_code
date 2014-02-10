package chap4;

import java.util.Random;

public class Successor{
	public static void main(String args[]){
		Tree tr = new Tree();
		Random r = new Random();
		for (int i = 0 ; i < 20 ; i ++){
			int rr = r.nextInt(99);
			tr.insertOrder(rr);
		}
		tr.print();
		TreeNode t = tr.FindSuccessor(tr.getRoot().left.right);
		String output = (t == null ? "NL":""+t.getData());
		System.out.println(output);
	}
}
