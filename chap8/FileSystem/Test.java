package FileSystem;

public class Test{
	public static void main(String args[]){
		Right r = Right.Write;
		Right[] rights = new Right[2];
		rights[0] = r;
		Right rr = Right.Read;
		rights[1] = rr;
		File f = new File("File", null, rights);
		Directory d = new Directory("Direct", null, rights);
		d.addFile(f);
	}
}
