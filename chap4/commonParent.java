package chap4;

import java.util.Random;

public class commonParent{

	public static void main(String args[]){
		Tree tr = new Tree();
		for(int i = 0 ; i < 50 ; i ++ ){
			Random r = new Random();
			int rr = r.nextInt(99);
			tr.insertOrder(rr);
		}
		tr.print();
		TreeNode n = tr.root.left.right;
		TreeNode m = tr.root.left.left.left;
		TreeNode t = tr.FindCommonParent(n,m);
		System.out.println("The common parent of node "+n.data+" and node "+m.data+" is node: "+t.data);
	}
}
