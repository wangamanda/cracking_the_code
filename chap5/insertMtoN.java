public class insertMtoN{

	public static void main(String args[]){
		int N = 0b10000000000;
		int M = 0b10011;

		int i = 2;
		int j = 6;

		int result = insertMintoN(N,M,i,j);
		System.out.println(Integer.toBinaryString(result));
	}

	public static int insertMintoN(int N, int M, int i, int j){
		int high = (1 << (i+j))-1;
		int ones = ~0;
		high = ones - high;
		int low = (1 << i) - 1;
		high = high | low;

		int result = (N & high) | (M << i);
		return result;
	}
}
