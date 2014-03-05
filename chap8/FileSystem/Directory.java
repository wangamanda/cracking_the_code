package FileSystem;

import java.util.ArrayList;

public class Directory extends Document{
	private int size;
	private ArrayList<File>	files;
	private ArrayList<Directory> directories;

	public Directory(String n, Directory p, Right[] r){
		super(n, p, r);
		size = 1000;
		files = new ArrayList<File>();
		directories = new ArrayList<Directory>();
	}

	public int getSize(){
		return size;
	}

	public ArrayList<File> getFiles(){
		return files;
	}

	public ArrayList<Directory> getDirectories(){
		return directories;
	}

	public void addFile(File f){
		files.add(f);
		f.setLocation(this);
		size += f.getSize();
	}

	public boolean removeFile(File f){
		if(files.contains(f)){
			size -= f.getSize();
			return files.remove(f);
		}
		return false;
	}

	public void addDirectory(Directory d){
		directories.add(d);
		d.setLocation(this);
		size += d.getSize();
	}

	public boolean removeDirectory(Directory d){
		if(directories.contains(d)){
			size -= d.getSize();
			return directories.remove(d);
		}
		return false;
	}
}
