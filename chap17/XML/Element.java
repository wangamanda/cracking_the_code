package XML;

import java.util.ArrayList;

public class Element{
	String tag;
	ArrayList<Attribute> attributes;
	ArrayList<Element> children;

	public Element(String t){
		tag = t;
		attibutes = new ArrayList<Attribute>();
		children = new ArrayList<Element>();
	}
}
