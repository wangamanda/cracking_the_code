package chap2;

public class FindHead{

	public static void main(String args[]){
		Node h = new Node();
		LinkedList l = new LinkedList();
		for (char a = 'a'; a <= 'g' ; a ++ ){
			Node t = new Node(a);
			if (a == 'c'){
				h = t;
			}
			l.appendToTail(t);
		}
		l.appendToTail(h);
		char c = ReturnHead(l);
		System.out.println(c);
	}

	public static char ReturnHead(LinkedList l){
	
		Node h = l.getHead();
		Node r = l.getHead();

		if (h == null){
			return '\0';
		}

		while(h.next != null && r.next != null){
			h = h.next;
			r = r.next.next;
			if (r == null){
				return '\0';
			}
			if (h.data == r.data){
				r = l.getHead();
				break;
			}
		}

		while (h.next != null && r.next != null){
			h = h.next;
			r = r.next;
			if (h.data == r.data){
				break;
			}
		}

		return Character.toChars(h.data)[0];
	}
}

