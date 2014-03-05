package FileSystem;

import java.util.ArrayList;

public class File extends Document{
	private int size;
	private ArrayList<String> content;

	public File(String n, Directory p, Right[] r){
		super(n, p, r);
		content = new ArrayList<String>();
		size = 1000;
	}

	public void Write(String s){
		content.add(s);
		size += 100;
	}

	public void Read(){
		for (int i = 0 ; i < content.size() ; i ++ ){
			System.out.print(content.get(i));
		}
	}

	public boolean DeleteContent(String s){
		for (int i = 0 ; i < content.size() ; i ++ ){
			String st = content.get(i);
			if(st.equals(s)){
				size -= 100;
				return content.remove(st);
			}
		}
		return false;
	}

	public void Close(){
		lastUpdated = System.currentTimeMillis();
		lastAccessed = System.currentTimeMillis();
	}

	public ArrayList<String> getContent(){
		return content;
	}

	public int getSize(){
		return size;
	}
}
