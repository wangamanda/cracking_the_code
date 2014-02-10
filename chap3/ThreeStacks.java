package chap3;

public class ThreeStacks{

	public static int stackSize = 10;
	public static int[] a = new int[stackSize*3];
	public static int[] head = {-1,-1,-1};
	
	public static void main(String args[]) throws Exception{
		
		for (int i = 0 ; i < 3 ; i ++ ){
			push(i,i*3);
			push(i,i*2+6);
			int v = peek(i);
			System.out.println("push: " + v);
		}

		for (int i = 0 ; i < 3 ; i ++ ){
			int v = pop(i);
			System.out.println("pop: "+v);
		}

	}

	public static void push(int num, int v) throws Exception {

		if (head[num]+1 > stackSize) {
			throw new Exception("Out of bound!");
		}
		int h = ++head[num];
		a[num*stackSize + h] = v;
	}

	public static int pop(int num) throws Exception{

		if (head[num] == -1){
			throw new Exception("Try to pop from empty stack!");
		}
		int h = head[num];
		head[num] = 0;
		int v = a[num*stackSize + h];
		head[num]--;
		return v;
	}

	public static int peek(int num){
		int h = head[num];
		int v = a[num*stackSize + h];
		return v;
	}
}
