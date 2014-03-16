class BitSet{
	public int[] number;
	public BitSet(int n){
		number = new int[n/32];
	}

	public void Set(int n){
		int IntNum = number[n/32];
		int BitNum = 1 << (n%32);
		IntNum |=  BitNum;
	}

	public boolean Get(int n){
		int IntNum = number[n/32];
		int BitNum = 1 << (n%32);
		int res = IntNum & BitNum;
		return res != 0;
	}
}

public class FindDuplicate{
	public static void main(String[] args){
		int N = 32000;
		int[] arr = new int[30000];
		for(int i = 0 ; i < arr.length ; i ++ ){
			arr[i] = i+200;
		}
		BitSet b = new BitSet(N);
		for (int i = 0 ; i < arr.length ; i ++ ){
			int n = arr[i];
			int num = n - 1;
			if(b.Get(num)){
				System.out.println(num);
			}else{
				b.Set(num);
			}
		}
	}
}
