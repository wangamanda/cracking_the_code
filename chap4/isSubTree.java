package chap4;

import java.util.Random;

public class isSubTree{
	
	public static void main(String args[]){
		Tree tr1 = new Tree();
		Tree tr2 = new Tree();
		Random r = new Random();
		for (int i = 0 ; i < 6 ; i ++ ){
			int rr = r.nextInt(20);
			tr1.insertOrder(rr);
			if(i <= 5 && i > 2){
				tr2.insertOrder(rr);
			}
		}
		tr1.print();
		System.out.println("*****");
		tr2.print();
		if(tr1.hasSubTree(tr1.root,tr2.root)){
			System.out.println("tree 2 is subtree of tree 1");
		}else{
			System.out.println("tree 2 is NOT subtree of tree 1");
		}

	}
}
