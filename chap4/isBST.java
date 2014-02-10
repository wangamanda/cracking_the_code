package chap4;

import java.util.Random;

public class isBST{

	public static void main(String args[]){
		Tree tr = new Tree();
		
		for (int i = 0 ; i < 10 ; i ++ ){
		
			Random r= new Random();
			int rr = r.nextInt(99);
			tr.insertOrder(rr);
		}
		
		tr.insert(7);
/*		
		tr.insert(6);
		tr.insertOrder(9);
		TreeNode n = new TreeNode(8);
		tr.root.left.setRight(n);
*/		

		tr.print();
		
		if(tr.isBinarySearchTree(tr.root)){
			System.out.println("Is BST");
		}else{
			System.out.println("Is not BST");
		}

		IntWrapper min = new IntWrapper(0);
		IntWrapper max = new IntWrapper(0);
		if(tr.checkBST(tr.root,max,min)){
			System.out.println("checkBST: true");
		}else{
			System.out.println("checkBST: false");
		}
	}
}
