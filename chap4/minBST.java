package chap4;

public class minBST{

	public static TreeNode insert(int[] arr, int start, int end){
		if(start > end){
			return null;
		}
		int mid = (start + end)/2;
		TreeNode n = new TreeNode(arr[mid]);
		n.left = insert(arr,start,mid-1);
		n.right = insert(arr,mid+1,end);
		return n;
	}

	public static void main(String args[]){
		int[] arr = new int[10];
		for (int i = 0 ; i < 10 ; i++){
			arr[i] = i*2;
		}
		TreeNode root = new TreeNode();
		root = insert(arr,0,arr.length-1);
		Tree tr = new Tree(root);	
		tr.print();
		if(tr.isBalanced(root)){
			System.out.println("it is a balanced tree");
		}else{
			System.out.println("it is not a balanced tree");
		}
	}
}
