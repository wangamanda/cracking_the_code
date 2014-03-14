public class Maximum{
	public static void main(String[] args){
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = a-b;
		int sign_a = sign(a);
		int sign_b = sign(b);
		int sign_c = sign(c);
		int sign_ab = sign_a ^ sign_b;
		int sign_vab = flip(sign_ab);

		int k = sign_ab * sign_a + sign_vab * sign_c;
		int p = flip(k);
		int res = a*k + b*p;
		System.out.println(res+"");
	}

	public static int sign(int a){
		return flip((a >> 31) & 0x01); // return 1 if a is positive return 0 if a is negative
	}

	public static int flip(int a){
		return a ^ 0x01;
	}
}
