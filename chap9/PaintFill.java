import java.util.Random;
import java.util.ArrayList;

class Node{
	private int x;
	private int y;
	private int color;
	public Node(int i, int j, int c){
		x = i;
		y = j;
		color = c;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public int getColor(){
		return color;
	}

	public void setColor(int c){
		color = c;
	}
}

public class PaintFill{
	public static final int X = 5;
	public static final int Y = 16;

	public static void main(String args[]){
		ArrayList<ArrayList<Node>> Board = new ArrayList<ArrayList<Node>>();
		Random r = new Random();
		int r1 = r.nextInt(X);
		int r2 = r.nextInt(Y);
		for (int i = 0 ; i < X ; i ++ ){
			ArrayList<Node> line = new ArrayList<Node>();
			Board.add(line);
			for (int j = 0 ; j < Y ; j ++ ){
				if(i == X-1 || i == 0 || j == Y-1 || j == 0){
					Node n = new Node(i, j, 1);
					line.add(n);
				}else if(i == r1 && j == r2){
					Node n = new Node(i, j, 1);
					line.add(n);
				}else{
					Node n = new Node(i, j, -1);
					line.add(n);
				}
			}
		}
		Print(Board);
		System.out.println(r1+" "+r2);
		FillPaint(Board, r1, r2);
		Print(Board);
	}

	public static void FillPaint(ArrayList<ArrayList<Node>> board, int r1, int r2){
		ArrayList<Node> openList = new ArrayList<Node>();
		ArrayList<Node> closeList = new ArrayList<Node>();
		openList.add(board.get(r1).get(r2));
		while(openList.size() != 0){
			Node nn = openList.get(0);
			if (nn.getColor() == -1){
				nn.setColor(1);
			}
			openList.remove(nn);
			closeList.add(nn);
			int x = nn.getX();
			int y = nn.getY();
			if(x+1 < X){
				Node n = board.get(x+1).get(y);
				if(!closeList.contains(n) && !openList.contains(n)){
					openList.add(n);
				}
			}
			if(x-1 >= 0){
				Node n = board.get(x-1).get(y);
				if(!closeList.contains(n) && !openList.contains(n)){
					openList.add(n);
				}
			}
			if(y+1 < Y){
				Node n = board.get(x).get(y+1);
				if(!closeList.contains(n) && !openList.contains(n)){
					openList.add(n);
				}
			}
			if(y-1 >= 0){
				Node n = board.get(x).get(y-1);
				if(!closeList.contains(n) && !openList.contains(n)){
					openList.add(n);
				}
			}
		}
	}

	public static void Print(ArrayList<ArrayList<Node>> board){
		for (int i = 0 ; i < board.size() ; i ++ ){
			ArrayList<Node> tmp = board.get(i);
			for (int j = 0 ; j < tmp.size() ; j ++ ){
				System.out.print(tmp.get(j).getColor()+"");
			}
			System.out.println();
		}
	}
}
