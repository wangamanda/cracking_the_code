package SearchBST;

class Node{
	int val = 0;
	Node left = null;
	Node right = null;
	
	public Node(int value){
		val = value;
		left = null;
		right = null;
	}

	public int getValue(){
		return val;
	}

	public void setLeft(Node l){
		left = l;
	}

	public Node getLeft(){
		return left;
	}

	public void setRight(Node r){
		right = r;
	}

	public Node getRight(){
		return right;
	}

}

public class BST{
	private static Node root = null;
	
	public BST(Node r){
		root = r;
	}

	public BST(int x){
		Node n = new Node(x);
		root = n;
	}

	public static Node getRoot(){
		return root;
	}

	public void track(int x){
		Node n = new Node(x);
		if(root == null){
			root = n;
		}else{
			Node cur = root;
			while(cur != null){
				if(cur.getValue() >= x){
					if(cur.getLeft() == null){
						cur.setLeft(new Node(x));
						break;
					}else{
						cur = cur.getLeft();
					}
				}else{
					if(cur.getRight() == null){
						cur.setRight(new Node(x));
						break;
					}else{
						cur = cur.getRight();
					}
				}
			}
		}
	}

	public int getRankOfNumber(int x){
		if(root == null){
			return -1;
		}else{
			if(root.getValue() > x){
				return getRankOfNumber(root.getLeft(), x, 0);
			}else if(root.getValue() == x){
				return getRankOfNumber(root.getLeft(), x, 1);
			}else{
				int n1 = getRankOfNumber(root.getLeft(), x, 1);
				int n2 = getRankOfNumber(root.getRight(), x, 0);
				if(n1 != -1 && n2 != -1){
					return n1+n2;
				}else if(n1 != -1){
					return n1;
				}else if(n2 != -1){
					return n2;
				}
			}
			return -1;
		}
	}

	public int getRankOfNumber(Node n, int x, int res){
		if(n == null){
			return res;
		}
		if(n.getValue() == x){
			return res;
		}else{
			if(n.getValue() > x){
				return getRankOfNumber(n.getLeft(),x,res);
			}else if(root.getValue() == x){
				return getRankOfNumber(n.getLeft(),x,res+1);
			}else{
				int n1 = getRankOfNumber(n.getLeft(), x, res+1);
				int n2 = getRankOfNumber(n.getRight(), x, 0);
				if(n1 != -1 && n2 != -1){
					return n1+n2;
				}else if(n1 != -1){
					return n1;
				}else if(n2 != -1){
					return n2;
				}
				
			}
			return -1;
		}
	}
}
