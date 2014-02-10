package chap4;

import java.util.LinkedList;

public class Tree{

	TreeNode root;
	
	public Tree(){
		root = null;
	}

	public Tree(int d){
		root = new TreeNode(d);
	}

	public Tree(TreeNode n){
		root = n;
	}

	public int getHeight(){
		return root.getHeight();
	}

	public TreeNode getRoot(){
		return root;
	}

	public static int max(int a, int b){
		return (a>b)?a:b;
	}

	public static int abs(int a){
		if(a >= 0){
			return a;
		}
		a = 0-a;
		return a;
	}
	
	public LinkedList<LinkedList<TreeNode>> getAllLevels(){
		LinkedList<TreeNode> up = new LinkedList<TreeNode>();
		TreeNode cur = root;
		if(cur != null){
			up.addLast(cur);
		}
		LinkedList<LinkedList<TreeNode>> res = new LinkedList<LinkedList<TreeNode>>();
		res.addLast(up);

		while(true){
			LinkedList<TreeNode> down = new LinkedList<TreeNode>();
			for(int i = 0 ; i < up.size() ; i ++ ){
				TreeNode n = up.get(i);
				if(n.left != null){
					down.addLast(n.left);
				}
				if(n.right != null){
					down.addLast(n.right);
				}
			}
			if(down.size() == 0){
				break;
			}
			res.addLast(down);
			up = down;
		}
		return res;
	}

	public boolean isBinarySearchTree(TreeNode root){
		
		if(root == null){
			return true;
		}
		
		if(root.left == null&&root.right == null){
			return true;
		}
		
		if(root.left != null&&root.right == null){
			int max_num = FindMax(root.left);
			if(root.data < max_num){
				return false;
			}else{
				return isBinarySearchTree(root.left);
			}
		}
		
		if(root.right != null&&root.left == null){
			int min_num = FindMin(root.right);
			if(root.data > min_num){
				return false;
			}else{
				return isBinarySearchTree(root.right);
			}
		}

		int max_num = FindMax(root.left);
		int min_num = FindMin(root.right);
		if(root.data < max_num || root.data > min_num){
			System.out.println("left max:"+max_num);
			System.out.println("root.data:"+root.data);
			return false;
		}else{
			return isBinarySearchTree(root.right)&&isBinarySearchTree(root.left);
		}
	}

	public int FindMin(TreeNode n){
		int m = Integer.MAX_VALUE;
		m = Math.min(n.data,m);
		
		if(n.left != null){
			m = Math.min(m,FindMin(n.left));
		}
		if(n.right != null){
			m = Math.min(m,FindMin(n.right));
		}

		return m;
	}

	public int FindMax(TreeNode n){
		int m = Integer.MIN_VALUE;
		m = Math.max(n.data,m);
		
		if(n.left != null){
			m = Math.max(m,FindMax(n.left));
		}
		if(n.right != null){
			m = Math.max(m,FindMax(n.right));
		}

		return m;
	}

	public void print(){
		LinkedList<TreeNode> up = new LinkedList<TreeNode>();
		LinkedList<TreeNode> down = new LinkedList<TreeNode>();

		TreeNode cur = root;
		if(cur != null){
			up.addLast(cur);
		}
		while(up.size() != 0){
			while(up.size() != 0){
				TreeNode n = up.poll();
				String le = (n.left == null ? "NL":""+n.left.data);
				String ri = (n.right == null ? "NL":""+n.right.data);
				for (int i = 0 ; i < n.getHeight() ; i ++ ){
					System.out.print("   ");
				}
				System.out.print(" *"+le+"  "+n.data+" "+ri+"* ");
				if(n.left != null){
					down.addLast(n.left);
				}
				if(n.right != null){
					down.addLast(n.right);
				}
			}
			up = down;
			down = new LinkedList<TreeNode>();
			System.out.println();
		}
	}

	public void UpdateHgt(TreeNode n){
		if(n == null){
			n.hgt = 0;
		}else{
			n.hgt = n.getHeight();
		}
		UpdateHgt(n.left);
		UpdateHgt(n.right);
		
	}

	public TreeNode FindSuccessor(TreeNode n){
		int cnt = 0;
		boolean k = false;
		if(n == null){
			return null;
		}
		TreeNode cur = n;
		while(cur != null & cur != root){
			if (cur == cur.parent.right){
				cur = cur.parent;
				System.out.println("from right to parent: "+cur.data);
				cnt ++ ;
			}else if(cur == cur.parent.left){
				if(cur.parent.right == null || cur.parent.right.getHeight() < cnt){
					cur = cur.parent;
					System.out.println("from left to parent: "+cur.data);
					cnt ++ ;
				}else{
					cur = cur.parent.right;
					System.out.println("from left child to right child: "+cur.data);
					k = true;
					break;
				}
			}
		}
		if(n == root){
			return null;
		}
		for (int i = cnt ; i > 0 ; i -- ){
			if(cur.left != null && cur.left.getHeight() >= cnt-1){
				cur = cur.left;
			}else{
				cur = cur.right;
			}
		}
		if(!k){
			return null;
		}
		return cur;
	}

	public TreeNode FindinOrderSuccessor(TreeNode n){
		if(n == null){
			return null;
		}

		TreeNode cur = n;
		if(cur.right != null){
			cur = cur.right;
			while(cur.left != null){
				cur = cur.left;
			}
			return cur;
		}

		if(cur.parent == null){
			return null;
		}

		if(cur == cur.parent.left){
			return cur.parent;
		}

		while(cur.parent != null && cur == cur.parent.right){
			cur = cur.parent;
		}
		if(cur.parent == null){
			return null;
		}
		if(cur == cur.parent.left){
			return cur.parent;
		}
		return null;
	}

	public void insertOrder(int d){
		TreeNode t = new TreeNode(d);
		if(root == null){
			root = new TreeNode(d);
			return;
		}
		TreeNode cur = root;
		while(cur != null){
			if(cur.getData() > d){
				if(cur.left == null){
					cur.setLeft(t);
					t.setParent(cur);
					break;
				}else{
					cur = cur.left;
					continue;
				}
			}else{
				if(cur.right == null){
					cur.setRight(t);
					t.setParent(cur);
					break;
				}else{
					cur = cur.right;
					continue;
				}
			}
		}
		if(cur == null){
			cur = new TreeNode(d);
			return;
		}
	}

	public void insert(int d){
		if (root == null){
			root = new TreeNode(d);
			return;
		}
		TreeNode cur = root;	
		TreeNode t = new TreeNode(d);
		while(cur.getLeft() != null){
			cur = cur.getLeft();
		}
		if (cur.getLeft() == null){
			System.out.println(" "+cur.getData());
			cur.setLeft(t);
			return;
		}
	}
	
	public boolean checkBST(TreeNode root, IntWrapper max, IntWrapper min){
		
		if(root == null){
			return true;
		}

		if(root.left == null){
			min.data = root.data;
		}else{
			IntWrapper new_max = new IntWrapper(0);
			IntWrapper new_min = new IntWrapper(0);
			if(!checkBST(root.left, new_max, new_min)){
				return false;
			}
			if(root.data < new_max.data){
				return false;
			}
			min.data = new_min.data;
		}
		
		if(root.right == null){
			max.data = root.data;
		}else{
			IntWrapper new_max = new IntWrapper(0);
			IntWrapper new_min = new IntWrapper(0);
			if(!checkBST(root.right, new_max, new_min)){
				return false;
			}
			if(root.data > new_min.data){
				return false;
			}
			max.data = new_max.data;
		}
		return true;
	}

	public boolean isBalanced(TreeNode root){
		if (root == null){
			return true;
		}
		TreeNode cur = root;
		if(cur.left == null){
			if (cur.right != null){
				if(cur.right.getHeight() <= 1){
					return true;
				}else{
					return false;
				}
			}else{
				return true;
			}
		}
		
		if(cur.right == null){
			if (cur.left != null){
				if(cur.left.getHeight() <= 1){
					return true;
				}else{
					return false;
				}
			}
		}
		
		if(Math.abs(cur.left.getHeight()-cur.right.getHeight())>1){
			return false;
		}
		
		return isBalanced(cur.left)&isBalanced(cur.right);
	}

	public TreeNode FindCommonParent(TreeNode p, TreeNode q){
		
		Result res = FindCommonParentHelper(p,q,root);
		if(res.isAncestor){
			return res.Ancestor;
		}else{
			System.out.println("null");
			return null;
		}
	}
	
	public Result FindCommonParentHelper(TreeNode p, TreeNode q, TreeNode root){
		
		if(root == null){
			Result res = new Result(null,false);
			return res;
		}

		if(root == p && root == q){
			Result res = new Result(root, true);
			return res;
		}

		Result lef = FindCommonParentHelper(p,q,root.left);
		if(lef.isAncestor){
			return new Result(lef.Ancestor,true);
		}

		Result rig = FindCommonParentHelper(p,q,root.right);
		if(rig.isAncestor){
			return new Result(rig.Ancestor,true);
		}

		if(lef.Ancestor != null && rig.Ancestor == null){
			if(root == p || root == q){
				return new Result(root,true);
			}
			return new Result(lef.Ancestor,false);
		}

		if(rig.Ancestor != null && lef.Ancestor == null){
			if(root == p || root == q){
				return new Result(root,true);
			}
			return new Result(rig.Ancestor,false);
		}

		if(rig.Ancestor != null && lef.Ancestor != null){
			return new Result(root, true);
		}

		if(rig.Ancestor == null && lef.Ancestor == null){
			if(root == p || root == q){
				return new Result(root,false);
			}
		}
		
		return new Result(null,false);
	}

	public boolean hasSubTree(TreeNode tr1, TreeNode tr2){

		if(tr2 == null){
			return true;
		}

		if(tr1 == null && tr2 != null){
			return false;
		}
		
		if(tr1.data == tr2.data){
		
			if(matchTree(tr1,tr2)){
				return true;
			}
		}

		return hasSubTree(tr1.left, tr2) || hasSubTree(tr1.right, tr2);
		
	}

	public boolean matchTree(TreeNode tr1, TreeNode tr2){
		if(tr1 == null && tr2 == null){
			return true;
		}

		if(tr1 == null || tr2 == null){
			return false;
		}

		if(tr1.data == tr2.data){
			return matchTree(tr1.left,tr2.left) && matchTree(tr1.right, tr2.right);
		}

		return false;
	}

	public LinkedList<LinkedList<TreeNode>> FindPathToSum(TreeNode root, int sum){
		
		if(root == null){
			return null;
		}
		
		LinkedList<LinkedList<TreeNode>> res = new LinkedList<LinkedList<TreeNode>>();
		int depth = root.getHeight();
		int[] path = new int[depth];
		FindPath(root, sum, path, 0, res);
		
		return res;
	}

	public void FindPath(TreeNode root, int sum, int[] path, int level, LinkedList<LinkedList<TreeNode>> res){
		
		if(root == null){
			return;
		}
		
		int s = 0;
		path[level] = root.data;

		for(int i = level ; i >= 0 ; i -- ){
			s += path[i];
			if(s == sum){
				LinkedList<TreeNode> l = new LinkedList<TreeNode>();
				for(int j = level ; j >= i ; j -- ){
					TreeNode n = new TreeNode(path[j]);
					l.addFirst(n);
				}
				res.addLast(l);
			}
		}

		FindPath(root.left, sum, path, level+1, res);
		FindPath(root.right, sum, path, level+1, res);
	}

}

class Result{
	boolean isAncestor;
	TreeNode Ancestor;

	Result(){
		isAncestor = false;
		Ancestor = null;
	}

	Result(TreeNode n, boolean b){
		Ancestor = n;
		isAncestor = b;
	}
}

