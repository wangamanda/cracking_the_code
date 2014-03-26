import java.util.Arrays;

public class FindMax{
	public static void main(String[] args){
		int[] arr = new int[6];
		arr[0] = 2;
		arr[1] = -8;
		arr[2] = 3;
		arr[3] = -2;
		arr[4] = 4;
		arr[5] = -10;

		int res = Find(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(res+"");
		int res1 = FindM(arr);
		System.out.println(res1+"");
	}

	public static int Find(int[] arr){
		int max = Integer.MIN_VALUE;
		int sum = 0;
		int tmp = 0;
		for(int i = 0 ; i < arr.length - 1 ; i ++ ){
			sum += arr[i];
			sum = Math.max(arr[i], sum);
			if(sum > max){
				max = sum;
			}
		}

		return max;
	}

	public static int FindM(int[] arr){
		int max = 0;
		int sum = 0;
		for(int i = 0 ; i < arr.length - 1 ; i ++ ){
			sum += arr[i];
			if(max < sum){
				max = sum;
			}else if(sum < 0){
				sum = 0;
			}
		}
		return max;
	}
}
