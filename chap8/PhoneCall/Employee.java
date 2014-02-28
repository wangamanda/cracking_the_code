package PhoneCall;

public abstract class Employee{
	protected String name;
	protected int age;
	protected Title title;
	protected int level;
	protected boolean isAvailable;

	public Employee(String s, int a, int l){
		name = s;
		age = a;
		level = l
		title = Title.getTitle(l);
		isAvailable = true;
	}

	public boolean isAvailable(){
		return isAvailable();
	}

	public void setAvailable(){
		isAvailable = true;
	}

	public void setUnAvailable(){
		isAvailable = false;
	}

}
