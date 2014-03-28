package DoubleNode;

public class BiNode{
	public BiNode node1, node2;
	public int data;

	public BiNode(int n){
		data = n;
		node1 = null;
		node2 = null;
	}

	public BiNode(int n, BiNode b1, BiNode b2){
		data = n;
		node1 = b1;
		node2 = b2;
	}

	public void setNode1(BiNode n){
		node1 = n;
	}

	public void setNode2(BiNode n){
		node2 = n;
	}

	public BiNode getNode1(){
		return node1;
	}

	public BiNode getNode2(){
		return node2;
	}

	public int getValue(){
		return data;
	}
}
