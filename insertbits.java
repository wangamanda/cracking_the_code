public class insertbits{

	public static void main(String args[]){
		
		int a = 13579;
		int b = 24;

		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));

		int i = 2;
		int j = 6;
		
		int c = insert(a,b,i,j);
		System.out.println(Integer.toBinaryString(c));

	}

	public static int insert(int m, int n, int i, int j){
	
		int allones = -1;
		int high = (allones << (j+1));
		int low = ((1 << i) - 1);
		int mask = high | low;
		int prep = m & mask;
		int move_n = (n << i);
		return move_n | prep;

	}

}
