class Line{

	public double A;
	public double B;
	public double C;

	Line(double a, double b, double c){
		A = a;
		B = b;
		C = c;
	}

	public boolean intersects(Line l){
		double epsilon = 0.0000000000001;
		if(Math.abs(A) < epsilon && Math.abs(l.A) < epsilon){
			if(Math.abs(B*l.C - C*l.B) < epsilon){
				return true;
			}
			return false;
		}
		
		if(Math.abs(B) < epsilon && Math.abs(l.B) < epsilon){
			if(Math.abs(A*l.C - C*l.A) < epsilon){
				return true;
			}
			return false;
		}

		if(Math.abs(A*l.B - B*l.A) > epsilon){
			return true;
		}else{
			if(Math.abs(A*l.C - C*l.A) < epsilon){
				return true;
			}
			return false;
		}
	}
}

public class IntersectLine{

	public static void main(String args[]){
		Line line1 = new Line(3.5, 4.0, 5);
		Line line2 = new Line(2.8, 3.2, 4.3);
		Line line3 = new Line(1.2, 2.2, 3.8);
		Line line4 = new Line(3, 6, 0);
		Line line5 = new Line(6, 12, 0);
		if (line1.intersects(line2)){
			System.out.println("line1 intersects with line2");
		}else{
			System.out.println("line1 does NOT intersects with line2");
		}
		if (line1.intersects(line3)){
			System.out.println("line1 intersects with line3");
		}else{
			System.out.println("line1 does NOT intersects with line3");
		}
		if (line4.intersects(line5)){
			System.out.println("line4 intersects with line5");
		}else{
			System.out.println("line4 does NOT intersects with line5");
		}
	}
}
