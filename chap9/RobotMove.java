import java.util.ArrayList;

public class RobotMove{
	public static final int X = 10;
	public static final int Y = 10;
	public static void main(String args[]){
		int x = 5;
		int y = 4;
		int[][] nodes = new int[X][Y];
		ArrayList<Integer> path = new ArrayList<Integer>();
		for (int i = 0 ; i < X ; i ++ ){
			for (int j = 0 ; j < Y ; j ++ ){
				nodes[i][j] = -1;
			}
		}
		for (int i = 0 ; i < X-1 ; i ++ ){
			nodes[i][2] = 0;
		}
		int n = FromStartToEnd(nodes, X-1, Y-1);
		System.out.println("Number of ways: "+n);
		getPath(path, nodes, X-1, Y-1);
		if(path.size() == 0){
			System.out.println("Path not found.");
		}else{
			System.out.println("Path found.");
		}
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

	public static void getPath(ArrayList<Integer> path, int[][] nodes, int x, int y){
	
		if(x == X-1 && y == Y-1 && nodes[x][y] == 0){
			return;
		}	

		if(x == 0 && y == 0){
			path.add(nodes[x][y]);
			return;
		}else if(x == 0){
			if(nodes[x][y-1] != 0){
				path.add(nodes[x][y]);
				getPath(path, nodes, x, y-1);
			}else{
				nodes[x][y] = 0;
				path.clear();
				getPath(path, nodes, X-1, Y-1);
			}
		}else if(y == 0){
			if(nodes[x-1][y] != 0){
				path.add(nodes[x][y]);
				getPath(path, nodes, x-1, y);
			}else{
				nodes[x][y] = 0;
				path.clear();
				getPath(path, nodes, X-1, Y-1);
			}
		}else{
			if(nodes[x-1][y] == 0 && nodes[x][y-1] == 0){
				nodes[x][y] = 0;
				path.clear();
				getPath(path, nodes, X-1, Y-1);
			}else if(nodes[x-1][y] != 0){
				path.add(nodes[x][y]);
				getPath(path, nodes, x-1, y);
			}else if(nodes[x][y-1] != 0){
				path.add(nodes[x][y]);
				getPath(path, nodes, x, y-1);
			}
		}
		return;
	}
}
