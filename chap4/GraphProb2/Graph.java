package GraphProb2;

import java.util.LinkedList;

public class Graph{

	LinkedList<Node> nodes;
	int nodes_cnt;

	public Graph(){
		nodes_cnt = 0;
		nodes = new LinkedList<Node>();
	}

	public void addNode(Node n){
		nodes.addLast(n);
		nodes_cnt++;
	}

	public Node[] getNodes(){
		Node[] all = new Node[nodes.size()];
		for (int i = 0 ; i < nodes.size() ; i ++ ){
			all[i] = nodes.get(i);
		}
		return all;
	}
}
