class Point{

	double x;
	double y;
	Point(double a, double b){
		x = a;
		y = b;
	}
}

class Square{

	Point left_up;
	Point left_bottom;
	Point right_up;
	Point right_bottom;
	Square(Point a1, Point a2, Point a3, Point a4){
		left_bottom = a1;
		right_bottom = a2;
		left_up = a3;
		right_up = a4;
	}
}

class LineSeg{

	Point start;
	Point end;
	LineSeg(Point s, Point e){
		start = s;
		end = e;
	}
	void PrintLineSeg(){
		System.out.println("start: "+start.x+" "+start.y+" ");
		System.out.println("end: "+end.x+" "+end.y+" ");
	}
}

class Line{

	double k;
	double b;
	boolean ParX = false;
	boolean ParY = false;
	double epsilon = 0.00000000001;

	Line(double A1, double B1, double A2, double B2){
		if (Math.abs(A1 - A2) < epsilon){
			k = Integer.MAX_VALUE;
			b = Integer.MAX_VALUE;
			ParY = true;
		}else if (Math.abs(B1 - B2) < epsilon){
			k = 0;
			b = B1;
			ParX = true;
		}else{
			k = (B2 - B1)/(A2 - A1);
			b = (A2*B1 - B2*A1)/(A2 - A1);
		}
			System.out.print(k+"");
	}

	Line(double K, double B){
		k = K;
		b = B;
	}

	double getY(double x){
		if (ParY){
			throw new IllegalArgumentException("The line is parallel to Y axis.");
		}else{
			if (ParX){
				return b;
			}
			double r = k*x + b;
			return r;
		}
	}

	double getX(double y){
		if (ParX){
			throw new IllegalArgumentException("The line is parallel to X axis.");
		}else{
			if (ParY){
				double r = -b/k;
				return r;
			}
			double r = (y - b)/k;
			return r;
		}
	}
}

public class LineCutSquare{

	public static void main(String args[]){
		Point p1 = new Point(1, 1);
		Point p2 = new Point(3, 1);
		Point p3 = new Point(1, 3);
		Point p4 = new Point(3, 3);
		Square s1 = new Square(p1, p2, p3, p4);
		Point p5 = new Point(3, 1);
		Point p6 = new Point(5, 1);
		Point p7 = new Point(3, 3);
		Point p8 = new Point(5, 3);
		Square s2 = new Square(p5, p6, p7, p8);
		double a1 = (s1.left_bottom.x + s1.right_bottom.x)/2;
		double b1 = (s1.left_bottom.y + s1.left_up.y)/2;
		double a2 = (s2.left_bottom.x + s2.right_bottom.x)/2;
		double b2 = (s2.left_bottom.y + s2.left_up.y)/2;
		Point np1 = new Point(a1, b1);
		Point np2 = new Point(a2, b2);
		Line l = new Line(a1, b1, a2, b2);
		double length = s1.right_bottom.x - s1.left_bottom.x;
		LineSeg ls1 = new LineSeg(np1, np2);
		LineSeg ls2 = new LineSeg(np2, np2);

		if (l.ParY){
			Point n1 = new Point(a1, b1+length/2);
			Point n2 = new Point(a1, b1-length/2);
			Point n3 = new Point(a2, b2+length/2);
			Point n4 = new Point(a2, b2-length/2);
			ls1 = new LineSeg(n1, n4);
			ls2 = new LineSeg(n2, n3);
		}else if (l.ParX){
			Point n1 = new Point(a1+length/2, b1);
			Point n2 = new Point(a1-length/2, b1);
			Point n3 = new Point(a2+length/2, b2);
			Point n4 = new Point(a2-length/2, b2);
			ls1 = new LineSeg(n1, n4);
			ls2 = new LineSeg(n2, n3);
		}else{
			if(l.k >= 1 || l.k <= -1){
				System.out.print(l.k+"");
				double d1 = l.getY(s1.left_bottom.x);
				double d2 = l.getY(s1.right_bottom.x);
				double d3 = l.getY(s2.left_bottom.x);
				double d4 = l.getY(s2.right_bottom.x);
				Point n1 = new Point(s1.left_bottom.x, d1);
				Point n2 = new Point(s1.right_bottom.x, d2);
				Point n3 = new Point(s2.left_bottom.x, d3);
				Point n4 = new Point(s2.right_bottom.x, d4);
				ls1 = new LineSeg(n1, n4);
				ls2 = new LineSeg(n2, n3);
			}else if(l.k < 1 && l.k > -1){
				double c1 = l.getX(s1.left_up.y);
				double c2 = l.getX(s1.left_bottom.y);
				double c3 = l.getX(s2.left_up.y);
				double c4 = l.getX(s2.left_bottom.y);
				Point n1 = new Point(c1, s1.left_up.y);
				Point n2 = new Point(c2, s1.left_bottom.y);
				Point n3 = new Point(c3, s2.left_up.y);
				Point n4 = new Point(c4, s2.left_bottom.y);
				ls1 = new LineSeg(n1, n4);
				ls2 = new LineSeg(n2, n3);
			}
		}
		ls1.PrintLineSeg();
		ls2.PrintLineSeg();
	}
}
