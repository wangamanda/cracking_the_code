package chap5;

public class LackInN{
	public static void main(String args[]){
		int n = 50;
		int[] arr = new int[50];

		for (int i = 1 ; i < 20 ; i ++ ){
			arr[i] = i;
		}

		for (int i = 20 ; i < 49 ; i ++ ){
			arr[i] = i+1;
		}
		int res = FindLack(n,arr);
		System.out.println(Integer.toBinaryString(res));
	}

	public static int FindLack(int n, int[] arr){
		for (int i = 0 ; i < arr.size ; i ++ ){
			
		}
	}
}
