import java.util.ArrayList;
import java.lang.Object;
import java.util.regex.Pattern;

public class XMLparsing{
	public static void main(String[] args){
		ArrayList<String> xmlfile = new ArrayList<String>();
		String str = "<family lastname="McDowell" state="CA">";
		xmlfile.add(str);
		str = "<person firstName="Gayle">Some Message</person>";
		xmlfile.add(str);
		str = "</family>";
		xmlfile.add(str);

		String res = parse(xmlfile);
		System.out.println(res);
	}

	public static String parse(ArrayList<String> file){
		for(int i = 0 ; i < file.size()-1 ; i ++ ){
			String str = file.get(i);
			
		}
	}
}
