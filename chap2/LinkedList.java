package chap2;

public class LinkedList{

	private Node head;

	public LinkedList(){
		head = null;
	}

	public LinkedList(Node a){
		this.head = a;
		head.next = null;
	}

	public LinkedList(int d){
		Node a = new Node(d);
		this.head = a;
		head.next = null;
	}

	public Node getHead(){
		return head;
	}
	
	public void appendToTail(Node n){
		if(head == null){
			head = n;
			return;
		}
		Node h = head;
		while (h.next != null){
			h = h.next;
		}
		h.next = n;
	}

	public void appendToTail(int d){
		Node n = new Node(d);
		appendToTail(n);
	}

	public void appendToTail(char c){
		Node n = new Node(c);
		appendToTail(n);
	}

	public void appendToHead(Node n){
		if (head == null){
			head = n;
			return;
		}
		n.next = head;
		head = n;
	}

	public boolean delete(int d){
		Node h = head;
		while (h.next != null){
			if (h.data == d){
				h.next.next = h.next;
				return true;
			}
		}

		if (h.next == null && h.data == d){
			h = null;
			return true;
		}

		return false;
	}

	public void print(){
		Node h = head;
		while(h != null){
			System.out.print(h.data+" ");
			h = h.next;
		}
		System.out.println();
	}

	public void printChar(){
		Node h = head;
		while(h != null){
			System.out.print(Character.toChars(h.data));
			System.out.print(" ");
			h = h.next;
		}
		System.out.println();
	}
}
