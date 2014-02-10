package chap3;

public class StackToQueue{

	private MyStack in;
	private MyStack out;
	private Node head;
	private Node tail;

	public StackToQueue(){
		in = new MyStack();
		out = new MyStack();
		head = out.Head();
		tail = in.Tail();
	}

	public Node Head(){
		return out.Head();
	}

	public Node Tail(){
		return in.Tail();
	}

	public void Enqueue(Node a){
		in.push(a);
	}

	public Node Dequeue(){
		if(out.Size() == 0){
			if(in.Size() == 0){
				System.out.println("Try to dequeue from empty queue!");
				return null;
			}else{
				while(in.Size() != 0){
					Node t = in.pop();
					out.push(t);
				}
			}
		}
		return out.pop();
	}
	
	public Node peek(){
		if(out.Size() == 0){
			while(in.Size() != 0){
				Node t = in.pop();
				out.push(t);
			}	
		}
		return out.peek();
	}

	public void print(){
		out.print();
		in.print();
	}
}
