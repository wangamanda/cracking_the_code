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

	public Link delete(Link n){
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

public class remove2{
	public static void main(String args[]) throws IOException{
		Linklist list = new Linklist();
		list.insert('a');
		list.insert('b');
		list.insert('a');
		list.insert('c');
		list.insert('d');
		list.insert('c');

		list.printLinklist();
		int k;

		Link beginner = list.first;
		for(;beginner != null ; beginner = beginner.nextLink){
			Link runner = beginner;
			while (runner.nextLink != null){ 
				if (runner.nextLink.data == beginner.data){
					runner.nextLink = runner.nextLink.nextLink;
				}
				else
					runner = runner.nextLink;
			}
		}
		for (beginner = list.first ; beginner != null ; beginner = beginner.nextLink){
			System.out.print(beginner.data);
		}
		System.out.println();
	}
}
