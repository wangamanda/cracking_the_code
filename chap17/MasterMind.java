import java.util.Arrays;

public class MasterMind{

	public static void main(String[] args){
		String solution = args[0];
		String guess = args[1];

		int res[] = Count(solution, guess);
		System.out.println(Arrays.toString(res));
	}

	public static int[] Count(String a, String b){
		int[] arr = new int[4];
		int hit = 0;
		int psedo_hit = 0;

		if(a.length() != b.length()){
			return null;
		}

		for(int i = 0 ; i < a.length() ; i ++ ){
			if(a.charAt(i) == 'R'){
				arr[0] += 1;
			}

			if(a.charAt(i) == 'Y'){
				arr[1] += 1;
			}

			if(a.charAt(i) == 'G'){
				arr[2] += 1;
			}

			if(a.charAt(i) == 'B'){
				arr[3] += 1;
			}

			if(a.charAt(i) == b.charAt(i)){
				hit += 1;
			}
		}

		for(int i = 0 ; i < b.length() ; i ++ ){
			if(b.charAt(i) == 'R' && arr[0] > 0){
				arr[0] -= 1;
				psedo_hit ++ ;
			}

			if(b.charAt(i) == 'Y' && arr[1] > 0){
				arr[1] -= 1;
				psedo_hit ++ ;
			}

			if(b.charAt(i) == 'G' && arr[2] > 0){
				arr[2] -= 1;
				psedo_hit ++ ;
			}

			if(b.charAt(i) == 'B' && arr[3] > 0){
				arr[3] -= 1;
				psedo_hit ++ ;
			}
		}
		
		psedo_hit -= hit;
		int[] res = new int[2];
		res[0] = hit;
		res[1] = psedo_hit;
		return res;
	}
}

