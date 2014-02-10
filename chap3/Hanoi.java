package chap3;

public class Hanoi{

	public static void main(String args[]){
	
		MyStack from = new MyStack("FROM");
		MyStack mid = new MyStack("MID");
		MyStack to = new MyStack("TO");
		int n = 20;

		for (int i = n ; i >= 1 ; i -- ){
		
			Node a = new Node(i);
			from.push(a);
		}

		System.out.println("Before moving: ");
		System.out.println("MyStack FROM: ");
		from.print();
		System.out.println("MyStack MID: ");
		mid.print();
		System.out.println("MyStack TO: ");
		to.print();
		Hanoi(from, mid, to, n);
		System.out.println("After moving:");
		System.out.println("MyStack FROM: ");
		from.print();
		System.out.println("MyStack MID: ");
		mid.print();
		System.out.println("MyStack TO: ");
		to.print();
	}

	public static void Hanoi(MyStack a, MyStack b, MyStack c, int n){
		
		if (n == 0){
			return;
		}

		if (n == 1){
			Node t = a.pop();
			c.push(t);
			return;
		}
		
		Hanoi(a,c,b,n-1);
		Hanoi(a,b,c,1);
		Hanoi(b,a,c,n-1);
		return;
	}
}
