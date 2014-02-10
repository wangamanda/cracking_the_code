package chap3;

public class MyStack{

	private LinkedList l;
	private String name;
	
	public MyStack(){
		l = new LinkedList();
	}

	public MyStack(String s){
		this();
		name = s;
	}

	public MyStack(Node h){
		this();
		l.appendToHead(h);
	}

	public MyStack(int n){
		this();
		Node a = new Node(n);
		l.appendToHead(a);
	}

	public MyStack(char c){
		this();
		Node a = new Node(c);
		l.appendToHead(a);
	}

	public String getName(){
		return name;
	}

	public void push(Node a){
		l.appendToHead(a);
	}

	public void push(int n){
		Node a = new Node(n);
		push(a);
	}

	public void push(char c){
		Node a = new Node(c);
		push(a);
	}

	public int Size(){
		Node h = l.getHead();
		int cnt = 0;

		if (h == null){
			return cnt;
		}

		while(h != null){
			cnt ++ ;
			h = h.next;
		}

		return cnt;
	}

	public Node peek(){
		return Head();
	}

	public Node pop(){
		if (l.getHead() == null){
			return null;
		}else{
			Node h = l.getHead();
			l.setHead(h.next);
			h.next = null;
			return h;
		}
	}

	public Node getElem(int i){
		if (i >= Size()){
			return null;
		}else{
			Node h = Head();
			for (int j = 0 ; j < i ; j ++ ){
				h = h.next;
			}
			return h;
		}
	}

	public Node Head(){
		return l.getHead();
	}

	public Node Tail(){
		return l.getTail();
	}
	
	public Node popBottom(){
		if (l.getTail() == null){
			return null;
		}else{
		/*
			Node n = l.getTail();
			Node h = l.getHead();
			if(h.next == null){
				Node t = h;
				h = null;
				return t;
			}
			while(h.next.next != null){
				h = h.next;
			}
			Node t = h.next;
			h.next = null;
			return t;
			*/
			Node t = l.getTail();
			Node tmp = t;
			if(l.delete(t)){
				System.out.println("SUCCESS!!!");
				return tmp;
			}else{
				System.out.println("FAILURE+++");
				return null;
			}
		}
	}

	public boolean isEmpty(){
	
		return Head()==null;
	}

	public void print(){
		Node h = l.getHead();
		if (h == null){
			System.out.println("Empty stack!");
			return;
		}
		while (h != null){
			System.out.print(" "+h.data+" ");
			h = h.next;
		}
		System.out.println();
	}

}
