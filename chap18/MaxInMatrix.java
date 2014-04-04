import java.util.Arrays;

public class MaxInMatrix{
	public static void main(String[] args){
		int[][] matrix = {{1,2,3,4,7}, {-1,6,9,3,-3},{-2,4,-11,6,3},{1,-7,6,8,-2},{4,5,9,-10,6}};
		for(int i = 0 ; i < matrix.length ; i ++ ){
			System.out.println(Arrays.toString(matrix[i]));
		}

		int res = FindMax(matrix);
		System.out.println(res+"");
	}

	public static void clear(int[] arr){
		for(int i = 0 ; i < arr.length ; i ++ ){
			arr[i] = 0;
		}
	}

	public static int FindMax(int[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		int[] partial = new int[col];
		int max = Integer.MIN_VALUE;

		for(int start = 0 ; start < row ; start ++ ){
			clear(partial);
			for(int end = start ; end < row ; end ++ ){
				for(int i = 0 ; i < col ; i ++ ){
					partial[i] += matrix[end][i];
				}
				int tmp = FindPartialMax(partial);
				max = Math.max(max, tmp);
			}
		}

		return max;
	}

	public static int FindPartialMax(int[] arr){
		int len = arr.length;
		int sum = 0;
		int max = Integer.MIN_VALUE;

		for(int i = 0 ; i < len ; i ++ ){
			sum = Math.max(arr[i], sum+arr[i]);
			max = Math.max(max, sum);
			if(sum < 0){
				sum = 0;
			}
		}

		return max;
	}
}
