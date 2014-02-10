import java.io.*;

class Link{
	int data;
	Link nextLink;

	public Link(int d){
		data = d;
		nextLink = null;
	}

	void insert(int num){
		Link last = new Link(num);
		Link current = this;
		while(current.nextLink != null){
//			System.out.println(current.data);
			current = current.nextLink;
		}
		current.nextLink = last;
//		System.out.println(current.data);
	}
}

public class kth{
	public static void main(String args[]) throws IOException{
		Link a = new Link(3);
		a.insert(2);
		a.insert(5);
		int i = 0;
		int n;
		int[] arr = new int[256];
	//	System.out.println(a.data);
		while(a.nextLink != null){
		arr[i] = a.data;
		i++;
		a = a.nextLink;
		}
		arr[i] = a.data;
		n = i+1;

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		int k = Integer.parseInt(s);
		System.out.println(arr[n-k]);
	}
}
