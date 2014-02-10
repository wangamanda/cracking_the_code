package chap3;

public class LinkedList{

	private Node head;
	private Node tail;

	public LinkedList(){
		head = null;
		tail = null;
	}

	public LinkedList(Node a){
		this.head = a;
		head.next = null;
		tail = head;
	}

	public LinkedList(int d){
		Node a = new Node(d);
		this.head = a;
		head.next = null;
		tail = head;
	}

	public Node getHead(){
		return head;
	}

	public Node getTail(){
		return tail;
	}
	
	public void setHead(Node h){
		head = h;
	}

	public void setTail(Node t){
		tail = t;
	}

	public void appendToTail(Node n){
		if(tail == null){
			head = n;
			tail = n;
			return;
		}

		tail.next = n;
		tail = tail.next;
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
			tail = n;
			return;
		}
		n.next = head;
		head = n;
	}
	
	public boolean delete(Node n){
		Node h = head;
		if (h == null){
			return false;
		}
		
		if (h == n){
			head = head.next;
			return true;
		}

		while(h.next.next != null){
			if (h.next == n){
				h.next = h.next.next;
				return true;
			}
			h = h.next;
		}

		if (h.next == n){
			h.next = null;
			tail = h;
			return true;
		}
		
		return false;
	}
	
	public boolean delete(int d){
		Node h = head;
		if (h == null){
			return false;
		}

		if (h.data == d){
			head = head.next;
		}

		while (h.next != null){
			if (h.next.data == d){
				h.next = h.next.next;
				return true;
			}
			h = h.next;
		}

		if (h.data == d){
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
