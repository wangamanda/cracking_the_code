package PhoneCall;

public enum Title{
	Respondent(0),
	Manager(1),
	Director(2);
	int value;

	private Title(int v){
		value = v;
	}

	public int getValue(){
		return value;
	}

}
