package GraphProb2;

import java.util.LinkedList;
public class FindRoute{

	public static void main(String args[]){
	
		Graph G = new Graph();
		Node a = new Node("A");
		G.addNode(a);
		Node b = new Node("B");
		G.addNode(b);
		Node c = new Node("C");
		G.addNode(c);
		Node d = new Node("D");
		G.addNode(d);
		Node e = new Node("E");
		G.addNode(e);
		Node f = new Node("F");
		G.addNode(f);
		a.addAdjacent(b);
		a.addAdjacent(d);
		b.addAdjacent(e);
		c.addAdjacent(a);
		d.addAdjacent(c);
		d.addAdjacent(f);
		f.addAdjacent(e);
		if(ExistRoute(G,"A","D")){
			System.out.println("route exists from vertex A to vertex D");
		}else{
			System.out.println("route does not exist from vertex A to vertex D");
		}

		if(ExistRoute(G,"B","D")){
			System.out.println("route exists from vertex B to vertex D");
		}else{
			System.out.println("route does not exist from vertex B to vertex D");
		}
		
		if(ExistRoute(G,"C","D")){
			System.out.println("route exists from vertex C to vertex D");
		}else{
			System.out.println("route does not exist from vertex C to vertex D");
		}
		
		if(ExistRoute(G,"A","F")){
			System.out.println("route exists from vertex A to vertex F");
		}else{
			System.out.println("route does not exist from vertex A to vertex F");
		}

		if(ExistRoute(G,"B","F")){
			System.out.println("route exists from vertex B to vertex F");
		}else{
			System.out.println("route does not exist from vertex B to vertex F");
		}
		
	}

	public static boolean ExistRoute(Graph g, String a, String b){
		Node[] nodes = g.getNodes();
		Node start = new Node();
		for(Node node : nodes){
			if(node.getName()==a){
				start = node;
			}
		}
		LinkedList<Node> tmp = new LinkedList<Node>();
		LinkedList<Node> out = new LinkedList<Node>();
		tmp.addLast(start);
		while(tmp.size() != 0){
			Node t = tmp.pollFirst();
			out.addLast(t);
			Node[] ta = t.getAdjacent();
			for (Node node : ta){
				if (node.getName() == b){
					return true;
				}
				if(!out.contains(node)){
					tmp.addLast(node);
				}
			}
		}
		return false;
	}
}
