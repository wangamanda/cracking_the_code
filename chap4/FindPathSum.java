package chap4;

import java.util.Random;
import java.util.LinkedList;

public class FindPathSum{
	public static void main(String args[]){
		Tree tr = new Tree();
		Random r = new Random();
		for (int i = 0 ; i < 50 ; i ++ ){
			int rr = r.nextInt(99);
			tr.insertOrder(rr);
		}
		tr.print();
		int n = 200;
		LinkedList<LinkedList<TreeNode>> l = tr.FindPathToSum(tr.root, n);
		System.out.println("The sum of "+n+" has the following paths on the tree: ");
		for (int i = 0 ; i < l.size() ; i ++ ){
			LinkedList<TreeNode> ll = l.get(i);
			for(int j = 0 ; j < ll.size() ; j ++ ){
				System.out.print(" "+ll.get(j).data);
			}
			System.out.println();
		}
	}
}
