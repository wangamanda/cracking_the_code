package chap2;

public class DeleteCur{

	public static void main(String args[]){
		
		Node a = new Node(1);
		Node b = new Node();
		LinkedList l = new LinkedList(a);
		for (int i = 2 ; i < 6 ; i ++ ){
			a = new Node(i);
			if (i == 3){
				b = a;
				System.out.println("b: "+b.data );
			}
			l.appendToTail(a);
		}
		System.out.println("original:");
		l.print();
		int t = b.data;
		DeleteNode(l,b);
		System.out.println("after removal: "+t+" the list is: ");
		l.print();
	}

	public static LinkedList DeleteNode(LinkedList l, Node b){
		
		Node h = l.getHead();
		while(h.next != null){
			if(h.data == b.data){
				break;
			}
			h = h.next;
		}
		if (h.next == null){
			return null;
		}
		h.data = h.next.data;
		h.next = h.next.next;
		return l;
	}		
}
