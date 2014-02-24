import java.util.ArrayList;
import java.util.HashMap;

class Point{
	double x;
	double y;
	Point(double a, double b){
		x = a;
		y = b;
	}
}

class Line(Point p1, Point p2){
	double k;
	double b;
	double epsilon = 0.00000001;
	boolean ParX = false;
	boolean ParY = false;
	if ((p1.x - p2.x) < epsilon){
		k = double.MAX_VALUE;
		ParY = true;
	}else if ((p1.y - p2.y) < epsilon){
		k = 0;
		b = p1.y;
		ParX = true;
	}else{
		k = (p2.y - p1.y)/(p2.x - p1.x);
		b = p2.y - k*p2.x;
	}
}

public class LineCoverDots{
	public static void main(String args[]){
		ArrayList<Line> lines = new ArrayList<Line>();
		HashMap<double, ArrayList<Line>> hmap = new HashMap<double, ArrayList<Line>>();

		Point[] points = new Point[20];
		for (int i = 0 ; i <= 5 ; i ++ ){
			points[i] = new Point(i, i + 3);
		}
		for (int i = 6 ; i <= 12 ; i ++ ){
			points[i] = new Point(2 * i, i - 3);
		}
		for (int i = 13 ; i < 20 ; i ++ ){
			points[i] = new Point(3 * i , i + 4);
		}

		for (int i = 0 ; i < points.length - 1 ; i ++ ){
			for (int j = i + 1 ; j < points.length ; j ++ ){
				Line l = new Line(points[i], points[j]);
				insert(hmap, l);
			}
		}
	}

	public static void insert(HashMap<double, ArrayList<Line>> hmap, Line l){
		double key = l.k;
		ArrayList<Line> lines;
		if(!hmap.containsKey(key)){
			lines = new ArrayList<Line>();
		}else{
			lines = hmap.get(key);
		}
		
	}
}
