import java.io.*;

class Link{
	public char data;
	public Link nextLink;

	public Link(char d){
		data = d;
		nextLink = null;
	}

	public void printLink(){
		System.out.print(" " + data + " ");
	}
}

class Linklist{
	public Link first;
	
	public Linklist(){
		first = null;
	}

	public void insert(char d){
		Link link = new Link(d);
		link.nextLink = first;
		first = link;
	}

	public Link delete(){
		Link temp = first;
		first = first.nextLink;
		return temp;
	}

	public boolean isEmpty(){
		return first == null;
	}

	public void printLinklist(){
		for(Link i = first; i != null; i = i.nextLink)
			i.printLink();
	}

	public char readLinklist(){
		
		return first.data;
	}
}

public class remove{
	public static void main(String args[]) throws IOException{
		Linklist list = new Linklist();
		list.insert('a');
		list.insert('b');
		list.insert('a');
		list.insert('c');
		list.insert('d');
		list.insert('c');

		list.printLinklist();
		System.out.println();
		int k;
		boolean [] arr = new boolean[256];
		while (!list.isEmpty()){
			int temp = (int)list.readLinklist();
			if (!arr[temp]){
				arr[temp] = true;
				System.out.println((char)temp);
			}
			list.delete();
		}
	}
}
