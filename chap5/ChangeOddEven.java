public class ChangeOddEven{

	public static void main(String args[]){
		int a = 98;
		int b = 69;
		
		int a1 = OddEvenExchange(a);
		int b1 = OddEvenExchange(b);

		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(a1));
		System.out.println();
		System.out.println(Integer.toBinaryString(b));
		System.out.println(Integer.toBinaryString(b1));
	}

	public static int OddEvenExchange(int a){
		int odd = 0x55555555;
		int even = 0xaaaaaaaa;

		int res = ((a & odd) << 1) | ((a & even) >> 1);
		return res;
	}
}
