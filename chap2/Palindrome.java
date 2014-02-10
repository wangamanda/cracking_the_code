package chap2;

import java.util.Stack;

public class Palindrome{

	public static void main(String args[]){

		LinkedList l = new LinkedList();
		for (char a = 'a'; a <= 'd'; a ++){
			Node t = new Node(a);
			l.appendToTail(t);
		}

		for (char a = 'e' ; a >= 'a' ; a --){
			Node t = new Node(a);
			l.appendToTail(t);
		}

		l.printChar();
		
		boolean ip = isPalindrome(l);
		if (ip){
			System.out.println("The list is palindrome.");
		}else{
			System.out.println("The list is not palindrome.");
		}
	}

	public static boolean isPalindrome(LinkedList l){
	
		Stack<Node> st= new Stack<Node>();
		Node fast = l.getHead();
		Node slow = l.getHead();
		boolean odd = true;

		if (fast == null || fast.next == null){
			return true;
		}

		while (fast.next.next != null){
			st.push(slow);
			slow = slow.next;
			fast = fast.next.next;
			if (fast.next == null){
				odd = true;
				break;
			}
		}

		if (fast.next != null && fast.next.next == null){
			odd = false;
		}

		Node a = new Node();

		if (odd) {
			while(slow.next != null){
				slow = slow.next;
				a = st.pop();
				if (slow.data != a.data){
					System.out.println("slow"+slow.data);
					System.out.println("a"+a.data);
					return false;
				}
			}
			return true;
		}else{
			st.push(slow);
			while(slow.next != null){
				slow = slow.next;
				a = st.pop();
				if (slow.data != a.data){
					return false;
				}
			}
			return true;
		}
	}
}
