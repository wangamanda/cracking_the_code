public class NextSameOnesNum{

	public static void main(String args[]){
	
		int a = 0b1001100;
		int b = 0b1100101;
		int c = 0b1110000;

		int a1 = NextSameOnes(a);
		int b1 = NextSameOnes(b);
		int c1 = NextSameOnes(c);
		int a2 = LastSameOnes(a);
		int b2 = LastSameOnes(b);
		int c2 = LastSameOnes(c);

		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(a1));
		System.out.println(Integer.toBinaryString(a2));
		System.out.println();
		System.out.println(Integer.toBinaryString(b));
		System.out.println(Integer.toBinaryString(b1));
		System.out.println(Integer.toBinaryString(b2));
		System.out.println();
		System.out.println(Integer.toBinaryString(c));
		System.out.println(Integer.toBinaryString(c1));
		System.out.println(Integer.toBinaryString(c2));
}

	public static int NextSameOnes(int n){
	
		boolean st = false;
		int i = 0;
		int start = 0;
		int end = 0;
		if((1 & n) == 0){
			int tmp = 1;
			while(i <= Integer.toBinaryString(n).length()+1){
				i ++ ;
				tmp = tmp << 1;
				if((tmp & n) != 0){
					if(!st){
						start = i;
						st = true;
					}
				}else{
					if(st){
						end = i;
						break;
					}
				}
			}

			int low_ones = (1 << (end - start - 1)) - 1;
			low_ones = low_ones + (1 << (end));
			int high_ones = -1 - ((1 << (end)) - 1);
			n = low_ones + (high_ones & n);

		}else{
			int tmp = 1;
			while(tmp != (1 << 31)){
				if((tmp & n) == 0){
					tmp = tmp << 1;
				}else{
					int t = ~tmp;
					n = n & t;
					break;
				}
			}

			tmp = tmp << 1;
			while(tmp != 0){
				int t = ((tmp<<1) - 1) & n;
				if(tmp - t <= 0){
					tmp = tmp << 1;
				}else{
					n = n | tmp;
					break;
				}
			}
		}
		return n;
	}

	public static int LastSameOnes(int n){
	
		if((1 & n) == 0){
			int tmp = 1;
			int i = 0;
			while (i <= Integer.toBinaryString(n).length() + 1){
				i ++ ;
				tmp = tmp << 1;
				if((tmp & n) != 0){
					break;
				}
			}

			n = (~(1 << i)) & ((1 << (i-1)) | n);
		}else{
			int i = 0;
			int tmp = 1;
			int cnt = 0;
			boolean b = false;
			int top = 0;
			while(i <= Integer.toBinaryString(n).length() + 1){
				i ++ ;
				tmp = tmp << 1;
				if((tmp & n) == 0){
					if(!b){
						cnt = i;
						b = true;
					}
				}else{
					if(b){
						top = i;
						break;
					}
				}
			}

			int low = ((1 << top) - 1) - ((1 << (top - cnt - 1)) - 1);
			int high = -1 - ((1 << (top+1)) - 1);
			n = (n & high) | low;
		}
		return n;
	}
}
