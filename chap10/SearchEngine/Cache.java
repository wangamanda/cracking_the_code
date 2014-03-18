package SearchEngine;

import java.util.HashMap;

public class Cache{
	Node head;
	Node tail;
	int Max_size = 100;
	HashMap<String, Node> hmap;
	int size = 0;
	
	public Cache(){
		hmap = new HashMap<String, Node>();
	}

	public void RemoveNode(Node n){
		if(n == null){
			return;
		}

		Node prev = n.prev;
		Node next = n.next;

		if(n == head){
			head = next;
		}

		if(n == tail){
			tail = prev;
		}

		if(prev != null){
			next.prev = prev;
		}

		if(next != null){
			prev.next = next;
		}

		n.next = null;
		n.prev = null;
	}

	public void MoveFront(String q){
		Node n = hmap.get(q);
		MoveFront(n);
	}

	public String[] getResults(String q){
		if(hmap.containsKey(q)){
			Node n = hmap.get(q);
			MoveFront(n);
			return n.results;
		}
		return null;
	}

	public void insertResults(String q, String[] res){
		if(hmap.containsKey(q)){
			Node n = hmap.get(q);
			MoveFront(n);
			n.results = res;
		}
		Node n = new Node(res, q);
		hmap.put(q, n);
		
		if(size > Max_size){
			hmap.remove(tail.query);
			RemoveNode(tail);
		}
	}

	public void MoveFront(Node n){
		if(n == null || n == head){
			return;
		}

		RemoveNode(n);
		n.next = head;
		if(head != null){
			head.prev = n;
		}
		head = n;
		size ++ ;
		if(tail == null){
			tail = n;
		}
	}
}
