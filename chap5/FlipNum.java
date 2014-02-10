public class FlipNum{

	public static void main(String args[]){
		int a = 78;
		int b = 40;

		int c = Flip1(a,b);
		int d = Flip2(a,b);
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		System.out.println(Integer.toString(c));
		System.out.println(Integer.toString(d));
	}

	public static int Flip1(int a, int b){
		int c = a ^ b;
		int count = 0;
		for (int i = c ; i != 0 ; i = i >> 1){
			count += i & 1 ;
		}
		return count;
	}

	public static int Flip2(int a, int b){
		int c = a^b;
		int count = 0;
		for(int i = c ; i != 0 ; i = i & (i-1)){
			count ++ ;
		}
		return count;
	}
}
