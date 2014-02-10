package chap3;

import java.util.LinkedList;

class SetOfStacks{

	public LinkedList<MyStack> ll;
	int size = 10;

	SetOfStacks(){
		ll = new LinkedList<MyStack>();
		MyStack ms = new MyStack();
		ll.push(ms);
	}

	SetOfStacks(Node n){
		ll = new LinkedList<MyStack>();
		MyStack ms = new MyStack(n);
		ll.push(ms);
	}
	
	SetOfStacks(int n){
		ll = new LinkedList<MyStack>();
		Node a = new Node(n);
		MyStack ms = new MyStack(a);
		ll.push(ms);
	}

	public void push(Node n){
		MyStack last = ll.peek();
		if (last.Size() < 10){
			last.push(n);
		}else if(last.Size() == 10){
			MyStack ms = new MyStack(n);
			ll.push(ms);
		}
	}

	public Node pop(){
		MyStack last = ll.peek();
		if (last.Size() == 0){
			System.out.println("try to pop from an empty stack!");
			return null;
		}
		Node n = last.pop();
		if(last.Size() == 0){
			ll.pop();
		}
		return n;
	}

	public Node popAt(int i){
		if(i == 0){
			return pop();
		}else{
			MyStack ith = ll.get(i);
			Node n = ith.pop();
			for (int t = i-1; t >= 0 ; t --){
				MyStack tth = ll.get(t);
				Node m = tth.popBottom();
				ith.push(m);
				ith = tth;
			}
			if(ith.Size() == 0){
				ll.pop();
			}
			return n;
		}
	}

	public void print(){
		for (int i = 0 ; i < ll.size() ; i ++ ){
			MyStack m = ll.get(i);
			System.out.println("The "+i+" th stack: ");
			m.print();
			System.out.println();
		}
	}
}

public class SetofStacks{
	
	public static void main(String args[]){
		
		SetOfStacks ss = new SetOfStacks();

		for (int i = 0 ; i < 100; i ++ ){
			Node a = new Node(i);
			ss.push(a);
		}
		ss.print();
		for (int i = 0 ; i < 25 ; i ++ ){
			Node a = ss.pop();
		}
		ss.print();
		for (int i = 0 ; i < 7 ; i ++ ){
			ss.popAt(i);
		}
		ss.print();
		
	}

}
