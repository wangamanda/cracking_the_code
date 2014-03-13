class NUM{
	int val;
	public NUM(int v){
		val = v;
	}

	public int getValue(){
		return val;
	}

	public void setValue(int v){
		val = v;
	}
}

public class Swap{
	public static void main(String[] args){
		int a = 3;
		int b = 5;
		NUM A = new NUM(a);
		NUM B = new NUM(b);
		swap(A, B);
		System.out.println(a+";"+b);
		System.out.println(A.getValue()+";"+B.getValue());
	}

	public static void swap(NUM a, NUM b){
		a.setValue(a.getValue()+b.getValue());
		b.setValue(a.getValue()-b.getValue());
		a.setValue(a.getValue()-b.getValue());
	}
}
