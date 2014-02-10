package chap4;

public class TreeNode{

	int data;
	int hgt;//height of the node
	TreeNode left;
	TreeNode right;
	TreeNode parent;

	public TreeNode(){
	}

	public TreeNode(int d){
		this();
		hgt = 0;
		data = d;
		left = null;
		right = null;
		parent = null;
	}

	public int getData(){
		return data;
	}

	public TreeNode getLeft(){
		return left;
	}

	public TreeNode getRight(){
		return right;
	}

	public TreeNode getParent(){
		return parent;
	}

	public void setLeft(TreeNode l){
		left = l;
	}

	public void setRight(TreeNode r){
		right = r;
	}

	public void setParent(TreeNode p){
		parent = p;
	}

	public int getHeight(){
		/*
		if (left == null){
			if (right == null){
				hgt = 1;
			}else{
				hgt = right.getHeight()+1;
			}
		}else{
			if(right == null){
				hgt = left.getHeight()+1;
			}else{
				hgt = Math.max(left.getHeight(),right.getHeight())+1;
			}
		}
		*/
		if (left == null && right == null){
			hgt = 1;
			return hgt;
		}
		if (left == null && right != null){
			hgt = right.getHeight()+1;
			return hgt;
		}
		if (right == null && left != null){
			hgt = left.getHeight()+1;
			return hgt;
		}
		hgt = Math.max(left.getHeight(),right.getHeight())+1;
		
		return hgt;
	}

	@Override
	public String toString(){
		return data+" ";
	}
}
