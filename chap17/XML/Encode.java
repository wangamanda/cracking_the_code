package XML;

import java.lang.StringBuffer;

public class Encode{
	public static String encodeToString(Element root){
		StringBuffer str = new StringBuffer();
		encode(root, str);
		return str.toString();
	}

	public static void encode(Element root, StringBuffer str){
		encode(root.getNameCode(), str);
		for(Attribute a : root.attributes){
			encode(a, str);
		}
		encode("0", str);

		if(root.value != null && root.value != ""){
			encode(root.value, str);
		}

		for(Element e : root.children){
			encode(e, str);
		}
		encode("0", str);

	}

	public static void encode(Attribute a, StringBuffer str){
		encode(a.getTagCode(), str);
		encode(a.value, str);
	}

	public static void encode(String a, StringBuffer str){
		str.append(a);
		str.append(" ");
	}
	
	public static void main(String[] args){
		Element root = new Element("family");
		Attribute a1 = new Attribute("lastName","McDowell");
		Attribute a2 = new Attribute("state","CA");
		root.insert(a1);
		root.insert(a2);
		Element child = new Element("person", "some Message");
		Attribute ca = new Attribute("firstName","Gayle");
		child.insert(ca);
		root.insert(child);
		String res = encodeToString(root);
		System.out.println(res);
	}
}
