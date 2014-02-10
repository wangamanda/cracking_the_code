package chap2;

public class removeduplicate{

	public static void main(String args[]){
	
		Node a1 = new Node(1);
		Node a2 = new Node(1);
		LinkedList l = new LinkedList(a1);
		LinkedList ll = new LinkedList(a2);
		for (int i=2;i<=5;i++){

			Node b = new Node(i);
			Node c = new Node(i+1);
			l.appendToTail(b);
			l.appendToTail(c);
		}
		Node e = new Node(1);
		Node f = new Node(1);
		ll.appendToTail(e);
		ll.appendToTail(f);
		System.out.println("original:");
		l.print();
		removeDuplicate(l);
		System.out.println("after removal:");
		l.print();
		System.out.println("original ll:");
		ll.print();
		removeDuplicate(ll);
		System.out.println("ll after removal:");
		ll.print();
	}

	public static void removeDuplicate(LinkedList l){
	
		Node i = l.getHead();
		if(i == null || i.next == null){
			return;
		}
		
		for(; i.next.next != null; i = i.next) {
			Node j = i;
			while(j.next.next != null){
				if (j.next.data == i.data){
					j.next = j.next.next;
				}else{
					j = j.next;
				}
			}
			
			if(i.next.next == null){
				break;
			}
			
			if(j.next != null && j.next.data == i.data){
				j.next = null;
				continue;
			}
		}

		if(i.next.data == i.data){
			i.next = null;
		}
	}
}
