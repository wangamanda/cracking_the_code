package GraphProb2;

import java.util.LinkedList;

enum State{
Unvisited,Visiting,Visited;
}

public class Node{

	String vertex;
	LinkedList<Node> adjacent;
	int adjacent_cnt;
	State state;
	
	public Node(){
		adjacent_cnt = 0;
		adjacent = new LinkedList<Node>();
	}

	public Node(String a){
		adjacent_cnt = 0;
		adjacent = new LinkedList<Node>();
		vertex = a;
	}

	public void addAdjacent(Node n){
		adjacent.addLast(n);
		adjacent_cnt ++ ;
	}

	public Node[] getAdjacent(){
		Node[] all = new Node[adjacent.size()];
		for (int i = 0 ; i < adjacent.size() ; i ++ ){
			all[i] = adjacent.get(i);
		}
		return all;
	}

	public boolean containAdjacent(Node a){
		if(adjacent.contains(a)){
			return true;
		}
		return false;
	}

	public State getState(){
		return state;
	}

	public String getName(){
		return vertex;
	}
}
