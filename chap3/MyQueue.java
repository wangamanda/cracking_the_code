package chap3;

public class MyQueue{

	LinkedList l;
	Node head;
	Node bottom;
	
	public MyQueue(){
		l = new LinkedList();
	}

	public MyQueue(Node h){
		l = new LinkedList();
		l.appendToTail(h);
		head = h;
		bottom = h;
	}

	public MyQueue(int n){
		l = new LinkedList();
		Node a = new Node(n);
		l.appendToTail(a);
		head = a;
		bottom = a;
	}

	public MyQueue(char c){
		l = new LinkedList();
		Node a = new Node(c);
		l.appendToTail(a);
		head = a;
		bottom = a;
	}

	public void Enqueue(Node a){
		if (l.getHead() == null){
			l.appendToTail(a);
			head = a;
			bottom = a;
		}else{
			l.appendToTail(a);
			bottom = a;
		}
	}

	public void Enqueue(int n){
		Node a = new Node(n);
		Enqueue(a);
	}

	public void Enqueue(char c){
		Node a = new Node(c);
		Enqueue(a);
	}

	public Node peek(){
		if (l.getHead() == null){
			return null;
		}else{
			Node h = l.getHead();
			while(h.next != null){
				h = h.next;
			}
			return h;
		}
	}

	public Node Dequeue(){
		if (l.getHead() == null){
			return null;
		}else{
			Node h = l.getHead();
			while(h.next != null){
				h = h.next;
			}
			Node t = h;
			h = null;
			return t;
		}
	}

}
