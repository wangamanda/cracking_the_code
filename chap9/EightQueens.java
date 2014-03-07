import java.util.ArrayList;

public class EightQueens{
	public static void main(String args[]){
		ArrayList<int[]> res = new ArrayList<int[]>();
		int[] column = new int[8];
		FindPosition(0, column, res);
		int n = res.size();
		System.out.println(n+"");
	}

	public static void FindPosition(int row, int[] col, ArrayList<int[]> res){
		if(row == 8){
			res.add(col.clone()); // clone() deep copy, a new array with a new reference is generated
		}else{
			for(int i = 0 ; i < 8 ; i ++ ){
				if(isValid(row, i, col)){
					col[row] = i;
					FindPosition(row+1, col, res);
				}
			}
		}
	}

	public static boolean isValid(int r, int c, int[] col){
		for (int i = 0 ; i < r ; i ++ ){
			if(col[i] == c){ // check column
				return false;
			}
			if(Math.abs(r-i) == Math.abs(c-col[i])){//check diagnol
				return false;
			}
		}
		return true;
	}
}
