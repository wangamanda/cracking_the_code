class BitSet{
	int[] number;
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

}
