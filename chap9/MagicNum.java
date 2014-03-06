import java.util.Arrays;
import java.util.Random;

public class MagicNum{
	public static void main(String args[]){
		int[] A = new int[10];
		for (int i = 0 ; i < 10 ; i ++ ){
			Random r = new Random();
			int rr = r.nextInt(30)-5;
			A[i] = rr;
		}
		Arrays.sort(A);
		System.out.println(Arrays.toString(A));
		int[] indexes = new int[2];
		indexes[0] = -1;
		indexes[1] = -1;
		indexes = getMagic(A, 0, A.length-1, indexes[0], indexes[1]);
		System.out.println(""+indexes[0] + " " +indexes[1]);
	}

	public static int[] getMagic(int[] A, int low, int high, int l, int h){
		if (low > high){
			int[] index = {l, h};
			return index;
		}
		int mid = (low+high)/2;
		if(A[mid] != mid){
			int y = Math.min(A[mid], mid-1);
			int[] res = new int[2];
			if(y < 0){
				res[0] = -1;
				res[1] = -1;
			}
			res = getMagic(A, low, y, l, h);
			if(res[0] == -1 && res[1] == -1){
				int x = Math.max(A[mid], mid+1);
				res = getMagic(A, x, high, l, h);
			}
			return res;
		}else{
			for (int i = mid ; i <= A.length-1 ; i ++ ){
				if(A[i] != i){
					h = i-1;
					break;
				}else{
					h = i;
				}
			}
			for (int i = mid ; i >= 0 ; i -- ){
				if(A[i] != i){
					l = i+1 ;
					break;
				}else{
					l = i;
				}
			}
			int[] res = {l, h};
			return res;
		}
	}
}
