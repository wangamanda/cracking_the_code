package chap3;

public class Node{

	int data;
	Node next;

	public Node(){
		this.next = null;
	}

	public Node(int v){
		this.data = v;
		this.next = null;
	}

	public Node(char c){
		this.data = c; 
		this.next = null;
	}
	
	public int getData(){
		return this.data;
	}

	public void setNext(Node nxt){
		this.next = nxt;
	}

	public Node getNext(){
		return this.next;
	}

	@Override
	public String toString(){
		return data+" ";
	}
}


