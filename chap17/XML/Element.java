package XML;

import java.util.ArrayList;

public class Element{
	public String tag;
	public String value;
	public ArrayList<Attribute> attributes;
	public ArrayList<Element> children;

	public Element(String t){
		tag = t;
		attributes = new ArrayList<Attribute>();
		children = new ArrayList<Element>();
	}

	public Element(String t, String v){
		tag = t;
		value = v;
		attributes = new ArrayList<Attribute>();
		children = new ArrayList<Element>();
	}

	public String getNameCode(){
		switch(tag){
			case "family":
				return "1";
			case "person":
				return "2";
			case "firstName":
				return "3";
			case "lastName":
				return "4";
			case "state":
				return "5";
			default:
				return "";
		}
	}

	public void insert(Element e){
		children.add(e);
	}

	public void insert(Attribute a){
		attributes.add(a);
	}
}
