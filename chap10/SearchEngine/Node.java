package SearchEngine;

public class Node{
	Node prev;
	Node next;
	String[] results;
	String query;

	public Node(String[] res, String q){
		query = q;
		results = res;
	}
}
