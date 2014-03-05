public class RobotMove{
	public static void main(String args[]){
		int X = 10;
		int Y = 10;
		int x = 5;
		int y = 4;
		int[][] nodes = new int[X][Y];
		for (int i = 0 ; i < X ; i ++ ){
			for (int j = 0 ; j < Y ; j ++ ){
				nodes[i][j] = -1;
			}
		}
		nodes[x][y] = 0;
		int n = FromStartToEnd(nodes, X-1, Y-1);
		System.out.println("Number of ways: "+n);
	}

	public static int FromStartToEnd(int[][] nodes, int x, int y){
		 if(x == 0 && y == 0){
		 	return 1;
		 }else if(x == 0){
		 	if(nodes[x][y] == -1){
				nodes[x][y] = FromStartToEnd(nodes, x, y-1);
			}
		 	return nodes[x][y];
		 }else if(y == 0){
		 	if(nodes[x][y] == -1){
				nodes[x][y] = FromStartToEnd(nodes, x-1, y);
			}
		 	return nodes[x][y];
		 }else{
		 	if(nodes[x][y] == -1){
		 		nodes[x][y] = FromStartToEnd(nodes, x-1, y) + FromStartToEnd(nodes, x, y-1);
			}
			return nodes[x][y];
		 }
	}
}
