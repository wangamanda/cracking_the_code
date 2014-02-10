package chap2;

public class PartitionByX{

	public static void main(String args[]){
	
		LinkedList l = new LinkedList();

		for (int i = 10 ; i > 1 ; i -- ){
			Node a = new Node(i);
			l.appendToTail(a);
		}

		int k = 6;

		System.out.println("original: ");
		l.print();
		System.out.println("partition by "+k+": ");
		l = Partition(l,k);
		l.print();
	}

	public static LinkedList Partition(LinkedList l,int k){
		Node h = l.getHead();
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		while (h != null){
			if (h.data >= k){
				l2.appendToTail(h.data);
			}else{
				l1.appendToTail(h.data);
			}
			h = h.next;
		}
		System.out.println("l1");
		l1.print();
		System.out.println("l2");
		l2.print();
		l = Combine(l1,l2);
		return l;
	}

	public static LinkedList Combine(LinkedList l1, LinkedList l2){
		Node h = l2.getHead();
		l1.appendToTail(h);
		System.out.println("final:");
		l1.print();
		return l1;
	}
}
