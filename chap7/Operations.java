public class Operations{

	public static void main(String args[]){
		
		int a = -20;
		int b = -4;
		int sub = 0;
		sub = subtract(a, b);
		int mul = 0;
		mul = multiple(a, b);
		int div = 0;
		div = division(a, b);
		System.out.println("subtract "+a+" - "+b+" = "+sub);
		System.out.println("multiply "+a+" * "+b+" = "+mul);
		System.out.println("divide "+a+" / "+b+" = "+div); 
	}

	public static int division(int a, int b){
		if (a < 0){
			return division(negate(a), negate(b));
		}
		if (b < 0){
			if (abs(b) > a){
				return 0;
			}
			int c = b;
			int n = 0;
			while(abs(c) <= a){
				c += b;
				n += -1;
			}
			return n;
		}
		if (b > a){
			return 0;
		}
		int c = b;
		int n = 0;
		while(c <= a){
			c += b;
			n += 1;
		}
		return n;
	}

	public static int multiple(int a, int b){
		if(a < 0){
			return multiple(negate(a), negate(b));
		}

		int r = 0;
		if(b < 0){
			while (b != 0){
				r += negate(a);
				b += 1;
			}
			return r;
		}

		while (b != 0){
			r += a;
			b += -1;
		}
		return r;
	}

	public static int subtract(int a, int b){

		if (b < 0){
			b = abs(b);
			return a+b;
		}
		while(b != 0){
			a += -1;
			b += -1;
		}	
		return a;	
	}

	public static int abs(int a){
		int n = 0;
		if (a > 0){
			return a;
		}
		while(a != 0){
			n += 1;
			a += 1;
		}
		return n;
	}
	
	public static int negate(int a){
		int b = 0;
		if (a > 0){
			while(a != 0){
				a += -1;
				b += -1;
			}
			return b;
		}
		if (a < 0){
			while(a != 0){
				a += 1;
				b += 1;
			}
			return b;
		}
		return b;
	}
}
