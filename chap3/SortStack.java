package chap3;

import java.util.Stack;
import java.util.Random;

public class SortStack{

	public static Stack<Integer> s1 = new Stack<Integer>();
	public static Stack<Integer> s2 = new Stack<Integer>();
	
	public static void sort(){
		while (s1.size() != 0){
			Integer top = s1.pop();
			if (s2.size() == 0 || (s2.peek().intValue() >= top.intValue())){
				s2.push(top);
			}else{
				while(s2.size() != 0){
					Integer top2 = s2.peek();
					if(top2.intValue() < top.intValue()){
						top2 = s2.pop();
						s1.push(top2);
					}else{
						break;
					}
				}
				s2.push(top);
			}
		}

		while (s2.size() != 0){
			Integer t = s2.pop();
			s1.push(t);
		}
	}

	public static void main(String args[]){
		for (int i = 20 ; i > 0 ; i -- ){
			Random r = new Random();
			int k = r.nextInt(50);
			Integer a = Integer.valueOf(k);
			s1.push(a);
		}
		System.out.println(s1.toString());
		sort();
		System.out.println(s1.toString());

	}

}
