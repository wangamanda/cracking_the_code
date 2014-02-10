package chap3;

public class TestStackToQueue{

	public static void main(String args[]){
		
		StackToQueue que = new StackToQueue();
		for (int i = 0 ; i < 10 ; i ++ ){
			Node a = new Node(i);
			que.Enqueue(a);
		}
		que.print();
		for (int i = 4 ; i > 0 ; i -- ){
			que.Dequeue();
		}
		que.print();
		for (int i = 10 ; i < 20 ; i ++ ){
			Node a = new Node(i);
			que.Enqueue(a);
		}
		que.print();
		for (int i = 10 ; i > 1 ; i -- ){
			que.Dequeue();
		}
		que.print();
		for (int i = 5 ; i < 15 ; i ++ ){
			Node a = new Node(i);
			que.Enqueue(a);
		}
		que.print();
		for (int i = 5 ; i < 13 ; i ++ ){
			que.Dequeue();
		}
		que.print();
	}
}
