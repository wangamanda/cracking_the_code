package chap4;

import java.util.Random;

public class isBalanced{

	Tree tr;

	public static void main(String args[]){
	
		Tree tr = new Tree();
		Random r = new Random();
		for (int i = 0 ; i < 4 ; i ++ ){
			int rr = r.nextInt(999);
			System.out.println(rr+"");
			tr.insertOrder(rr);
			if (tr.getRoot() == null){
				System.out.println("insert fail");
			}
		}

		if (tr.isBalanced(tr.getRoot())){
			System.out.println("Is a balanced tree.");
		}else{
			System.out.println("Is not a balanced tree.");
		}
	}
}
