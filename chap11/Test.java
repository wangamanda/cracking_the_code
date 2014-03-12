public class Test{
	public static void main(String args[]){
		int a = 3;
		int b = 5;
		swap(a,b);
		System.out.println(a+";"+b);
	}
	public static void swap(int a, int b){
		int c = a;
		a = b;
		b = c;
	}
}
