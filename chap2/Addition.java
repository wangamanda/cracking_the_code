package chap2;

class CarryandList{
	int carry = 0;
	LinkedList l = new LinkedList();

	public CarryandList(){
	
	}

	public CarryandList(int c, LinkedList ll){
		carry = c;
		l = ll;
	}
}

public class Addition{

	public static void main(String args[]){
	
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		for (int i = 4 ; i > 1 ; i -- ){
			Node a = new Node(i);
			Node b = new Node(5+i);
			l1.appendToTail(a);
			l2.appendToTail(b);
		}

		System.out.println("l1: ");
		l1.print();
		System.out.println("l2: ");
		l2.print();
		LinkedList l = add(l1,l2);
		System.out.println("l: ");
		l.print();
	}

	public static LinkedList add(LinkedList l1, LinkedList l2){
	
		int len1 = len(l1);
		int len2 = len(l2);

		LinkedList l = new LinkedList();

		if (len1 < len2){
			addzero(l1,len2-len1);
		}else if(len1 > len2){
			addzero(l2,len1-len2);
		}
		System.out.println("after append zero:");
		l1.print();
		l2.print();
		
		CarryandList c = Sum(l1.getHead(),l2.getHead());
		l = c.l;
		if (c.carry == 1){
			l.appendToHead(new Node(c.carry));
		}
		return c.l;
	}

	public static CarryandList Sum(Node ln1, Node ln2){
		
		if (ln1 == null && ln2 == null){
			CarryandList p = new CarryandList(0, null);
			return p;
		}
		if (ln1.next == null && ln2.next == null){
			int n1 = ln1.data;
			int n2 = ln2.data;
			int s = (n1+n2)%10;
			int cc = (n1+n2)/10;
			LinkedList l = new LinkedList();
			l.appendToHead(new Node(s));
			CarryandList p = new CarryandList(cc,l);
			return p;
		}
		int n1 = ln1.data;
		int n2 = ln2.data;
		CarryandList p = Sum(ln1.next,ln2.next);
		LinkedList l = p.l;
		int c1 = (n1+n2+p.carry)/10;
		int s1 = (n1+n2+p.carry)%10;
		l.appendToHead(new Node(s1));
		p.l = l;
		p.carry = c1;
		return p;
	}

	public static void addzero(LinkedList l, int n){
	
		for (int i = 1 ; i <= n ; i ++ ){
			l.appendToHead(new Node(0));
		}
	}

	public static int len(LinkedList l){
		
		Node h = l.getHead();
		if (h == null){
			return 0;
		}
		int cnt = 0;
		while (h != null){
			h = h.next;
			cnt ++ ;
		}
		return cnt;
	}
}
