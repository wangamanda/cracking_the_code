public class Sum{
	public static void main(String[] args){
		int a = 0b101;
		int b = 0b101;
		int c = add(a,b);
		System.out.println("sum of "+a+" and "+b+" is "+c+"");
	}

	public static int add(int a, int b){
		if(b == 0){
			return a;
		}
		
		int carry = (a & b) << 1;
		int sum = a ^ b;
		return add(sum, carry);
	}
}
