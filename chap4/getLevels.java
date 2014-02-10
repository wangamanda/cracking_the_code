package chap4;

import java.util.Random;
import java.util.LinkedList;

public class getLevels{

	public static void main(String args[]){
	
		Tree tr = new Tree();
		for(int i = 1 ; i < 20 ; i ++){
		
			Random r = new Random();
			int rr = r.nextInt(999);
			tr.insertOrder(rr);
		}
		tr.print();
		LinkedList<LinkedList<TreeNode>> l = tr.getAllLevels();
		for (int i = 0 ; i < l.size() ; i ++ ){
		
			LinkedList<TreeNode> ll = l.get(i);
			for (int j = 0 ; j < ll.size() ; j ++ ){
				System.out.print(" "+ll.get(j).data);
			}
			System.out.println();
		}
	}
}
