package chap2;

public class kth{
	
	public static void main(String args[]){
		Node a = new Node(1);
		LinkedList l = new LinkedList(a);

		for (int i = 2; i < 10; i ++ ){
			Node b = new Node(i);
			l.appendToTail(b);
		}
		l.print();
		int k =  11;
		int c = lastkth(l,k);
		System.out.println("last "+k+"th element is "+c);
	}

	public static int lastkth(LinkedList l, int k){
		Node cur = l.getHead();
		for (int i = 1; i < k ; i++ ){
			if(cur == null){
				return -1;
			}
			cur = cur.next;
		}
		Node run = l.getHead();
		while(cur.next != null){
			cur = cur.next;
			run = run.next;
		}
		return run.data;
	}
}
