import java.util.Queue;
import java.util.LinkedList;
import java.io.*;

public class KthPrimeMultiple{
	public static void main(String args[]) throws Exception{
		int k = 10;
		int r = KthMultiple(k);
		System.out.println(r + "");
	}

	public static int KthMultiple(int k) throws Exception{
		Queue<Integer> q3 = new LinkedList<Integer>();//Queue is an interface, that cannot be instantiated
		Queue<Integer> q5 = new LinkedList<Integer>();
		Queue<Integer> q7 = new LinkedList<Integer>();
		int val = 0;
		if (k < 1){
			throw new Exception("Element k " + k + " is illegal!");
		}
		
		if(k >= 1){
			val = 3;
			q3.add(val);
			if(k > 1){
				q3.add(val*3);
				q3.remove();
				q5.add(val*5);
				q7.add(val*7);
			}
		}
		
		if(k >= 2){
			val = 5;
			q5.add(val);
			if(k > 2){
				q5.add(val*5);
				q5.remove();
				q7.add(val*7);
			}
		}
		
		if(k >= 3){
			val = 7;
			q7.add(val);
			if(k > 3){
				q7.add(val*7);
				q7.remove();
			}
		}

		for (int i = 4 ; i <= k ; i ++ ){
			val = Math.min(q3.peek(), Math.min(q5.peek(), q7.peek()));
			if(val == q3.peek()){
				q3.add(val*3);
				q3.remove();
				q5.add(val*5);
				q7.add(val*7);
			}else if(val == q5.peek()){
				q5.add(val*5);
				q5.remove();
				q7.add(val*7);
			}else if(val == q7.peek()){
				q7.add(val*7);
				q7.remove();
			}
		}
		return val;
	}
}
