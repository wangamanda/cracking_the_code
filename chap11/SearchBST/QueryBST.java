package SearchBST;

import java.util.Random;

public class QueryBST{
	public static void main(String[] args){
	Node n = new Node(5);
	BST tree = new BST(n);
	for (int i = 0 ; i < 5 ; i ++ ){
		Random r = new Random();
		int rr = i+3;
		tree.track(rr);
	}
	System.out.println(BST.getRoot().getValue()+"");
	System.out.println(BST.getRoot().getLeft());
	int k = Integer.parseInt(args[0]);
	int t = tree.getRankOfNumber(k);
	System.out.println(t+"");
	}
}
