package FileSystem;

public abstract class Document{
	protected String name;
	protected Directory parent;
	protected long created;
	protected long lastUpdated;
	protected long lastAccessed;
	protected Right[] right;
	
	public Document(String n, Directory p, Right[] r){
		name = n;
		parent = p;
		right = r;
		created = System.currentTimeMillis();
		lastUpdated = System.currentTimeMillis();
		lastAccessed = System.currentTimeMillis();
	}


	public boolean changeName(String s){
		if(name != s){
			name = s;
			return true;
		}
		return false;
	}

	public void changeRight(Right[] r){
		right = r;
		lastUpdated = System.currentTimeMillis();
	}

	public void setLocation(Directory p){
		parent = p;
	}

	public String getFullPath(){
		if (parent == null){
			return name;
		}else{
			return getFullPath()+"/"+name;
		}
	}
	public String getName(){
		return name;
	}

	public long getCreated(){
		return created;
	}

	public long getLastAccessed(){
		return lastAccessed;
	}

	public long getLastUpdated(){
		return lastUpdated;
	}

}
