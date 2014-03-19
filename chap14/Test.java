package chap14;
public class Test{
	public static void main(String[] args){
		CircularArray<String> carr = new CircularArray<String>(10);
		for(int i = 0 ; i < 10 ; i ++ ){
			carr.set(i, String.valueOf(i));
		}

		carr.rotate(3);
		for(String i : carr){
			System.out.println(i);
		}
	}
}
