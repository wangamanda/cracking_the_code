package chap3;

class StackWithMin{
	
	MyStack s;
	MyStack m;

	public StackWithMin(){
		s = new MyStack();
		m = new MyStack();
	}

	public void push(Node n){
		if (s.isEmpty()){
			s.push(n);
			Node nn = new Node(n.data);
			m.push(nn);
			return;
		}

		s.push(n);		
		Node k = m.peek();
		if(k.data >= n.data){
			Node nn = new Node(n.data);
			m.push(nn);
		}
	}

	public Node pop() throws Exception{
		if (s == null){
			throw new Exception("Try to pop from an empty stack!");
		}
		Node n = s.pop();
		if (n.data == m.peek().data){
			m.pop();
		}

		return n;
	}

	public Node min(){
		Node n = m.peek();
		return n;
	}

	public void print(){
		System.out.println("Stack from head to tail:");
		s.print();
		
		System.out.println("min value:");
		m.print();	
	}
}

public class PushPopMin{

	public static void main(String args[]) throws Exception{
		
		StackWithMin sw = new StackWithMin();

		for (int i = 10 ; i > 1 ; i -- ){
			Node a = new Node(i*2);
			Node b = new Node(i*3);
			sw.push(a);
			sw.print();
			sw.push(b);
			sw.print();
		}
		
		for (int i = 10 ; i > 0 ; i -- ){
			sw.pop();
			sw.print();
		}
	
	}
}
