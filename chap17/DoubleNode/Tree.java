package DoubleNode;

public class Tree{
	BiNode root;

	public Tree(BiNode n){
		root = n;
	}

	public void insert(BiNode n){
		BiNode cur = root;
		BiNode former = null;
		while(cur != null){
			int val = cur.getValue();
			if(n.getValue() >= val){
				former = cur;
				cur = cur.getNode2();
			}else{
				former = cur;
				cur = cur.getNode1();
			}
		}

		if(n.getValue() >= former.getValue()){
			former.setNode2(n);
		}else{
			former.setNode1(n);
		}
	}

	public static void main(String[] args){
		BiNode root = new BiNode(20);
		Tree tr = new Tree(root);
		tr.insert(new BiNode(10));
		tr.insert(new BiNode(30));
		tr.insert(new BiNode(5));
		tr.insert(new BiNode(15));
		tr.insert(new BiNode(25));
		tr.insert(new BiNode(35));
		tr.insert(new BiNode(3));
		tr.insert(new BiNode(7));
		tr.insert(new BiNode(13));
		tr.insert(new BiNode(17));
		tr.insert(new BiNode(23));

		BiNode cur2 = root;

		while(cur2.getNode1() != null){
			System.out.print(cur2.getValue()+" ");
			cur2 = cur2.getNode1();
		}
		System.out.print(cur2.getValue()+" ");
		System.out.println();
		
		Change(tr);
		BiNode cur = root;
		while(cur.getNode1() != null){
			cur = cur.getNode1();
		}

		BiNode cur1 = new BiNode(10);
		while(cur != null){
			System.out.print(cur.getValue()+" ");
			cur1 = cur;
			cur = cur.getNode2();
		}
		System.out.println();

		cur = cur1;
		while(cur != null){
			System.out.print(cur.getValue()+" ");
			cur = cur.getNode1();
		}
		System.out.println();
	}

	public static void Change(Tree tr){
		if(tr.root == null){
			return;
		}

		BiNode cur = tr.root;
		BiNode n1 = setLeftChild(cur.getNode1());
		BiNode n2 = setRightChild(cur.getNode2());
		cur.setNode1(n1);
		if(n1 != null){
			n1.setNode2(cur);
		}
		cur.setNode2(n2);
		if(n2 != null){
			n2.setNode1(cur);
		}
	}

	public static BiNode setLeftChild(BiNode n){
		if(n == null){
			return null;
		}

		if(n.getNode1() == null && n.getNode2() == null){
			return n;
		}

		if(n.getNode1() != null){
			if(n.getNode1().getNode1() == null && n.getNode1().getNode2() == null){
				n.setNode1(n.getNode1());
				n.getNode1().setNode2(n);
			}else{
				BiNode left = setLeftChild(n.getNode1());
				n.setNode1(left);
				if(left != null){
					left.setNode2(n);
				}
			}
		}

		if(n.getNode2() != null){
			if(n.getNode2().getNode1() == null && n.getNode2().getNode2() == null){
				n.setNode2(n.getNode2());
				n.getNode2().setNode1(n);
				return n.getNode2();
			}else{
				BiNode right = setRightChild(n.getNode2());
				n.setNode2(right);
				if(right != null){
					right.setNode1(n);
					while(right.getNode2() != null){
						right = right.getNode2();
					}
					return right;
				}else{
					return n;
				}
			}
		}
		return n;
	}

	public static BiNode setRightChild(BiNode n){
		if(n == null){
			return null;
		}

		if(n.getNode1() == null && n.getNode2() == null){
			return n;
		}

		if(n.getNode2() != null){
			if(n.getNode2().getNode1() == null && n.getNode2().getNode2() == null){
				n.setNode2(n.getNode2());
				n.getNode2().setNode1(n);
			}else{
				BiNode right = setRightChild(n.getNode2());
				n.setNode2(right);
				if(right != null){
					right.setNode1(n);
				}
			}
		}

		if(n.getNode1() != null){
			if(n.getNode1().getNode1() == null && n.getNode1().getNode2() == null){
				n.setNode1(n.getNode1());
				n.getNode1().setNode2(n);
				return n.getNode1();
			}else{
				BiNode left = setLeftChild(n.getNode1());
				n.setNode1(left);
				if(left != null){
					left.setNode2(n);
					while(left.getNode1() != null){
						left = left.getNode1();
					}
					return left;
				}else{
					return n;
				}
			}
		}
		return n;
	}
}
