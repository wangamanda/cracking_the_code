public class sameonebits{

	public static void main(String args[]){
	
		int n = 56;
		System.out.println(n);
		System.out.println(Integer.toBinaryString(n));
		int output_small = findprev(n);
		int output_big = findnext(n);
		System.out.println(output_small+": "+Integer.toBinaryString(output_small));
		System.out.println(output_big+": "+Integer.toBinaryString(output_big));
	}

	public static int findnext(int n){
	
		int c = n;
		int c0 = 0;
		int c1 = 0;
		while (c != 0){
			if ((c & 1) == 0 && c1 == 0){
				c >>= 1;
				c0 ++ ;
			}else if((c & 1) == 1){
				c >>= 1;
				c1 ++ ;
			}else if((c & 1) == 0 && c1 != 0){
				break;
			}
		}

		if (c0 + c1 == 31 || c0 + c1 == 0){
			return -1;
		}

		n = (1 << (c0+c1)) | n ;
		int high = (~((1 << (c0+c1))-1));
		n = high & n;
		int low = (1 << (c1-1)) - 1;
		n = n | low;
		return n;
	}

	public static int findprev(int n){
	
		int c = n;
		int c0 = 0;
		int c1 = 0;

		while(c != 0){
			if ((c & 1) == 1 && c0 == 0){
				c1 ++ ;
				c >>= 1;
			}else if ((c & 1) == 0){
				c0 ++ ;
				c >>= 1;
			}else if ((c & 1) == 1 && c0 != 0){
				break;
			}
		}

		if (c0 + c1 == 31 || c0 == 0){
			return -1;
		}
		System.out.println("c1: "+c1+" c0: "+c0);
		int high = ~((1 << (c0 + c1 + 1))-1);
		System.out.println("high: "+Integer.toBinaryString(high));
		n = high & n;
		System.out.println("high of n: "+Integer.toBinaryString(n));
		int low = ((1 << (c0 + c1))-1)-((1 << (c0-1))-1);
		System.out.println("low: "+Integer.toBinaryString(low));
		n = low | n;

		return n;
	}
}
