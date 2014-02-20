
public class SieveEratosthenes{

	public static void main(String args[]){
		int n = 100;
		boolean[] arr = new boolean[n];
		SieveOfEratosthenes(arr, n);
		for (int i = 0 ; i < n ; i ++ ){
			if (arr[i] == true){
				System.out.print(i+", ");
			}
		}
		System.out.println();
	}

	public static void SieveOfEratosthenes(boolean[] arr, int n){
		arr[0] = false;
		arr[1] = false;
		for (int i = 2 ; i < n ; i ++ ){
			arr[i] = true;
		}

		int prime = 2;
		while(prime < Math.sqrt(n)){
			for (int i = prime*prime ; i < arr.length ; i += prime){
				arr[i] = false;
			}
			prime ++ ;
			while(arr[prime] == false){
				prime ++ ;
			}
		}
		
	}
}
