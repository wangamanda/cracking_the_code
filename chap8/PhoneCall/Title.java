package PhoneCall;

public enum Title{
	Respondent(0),
	Manager(1),
	Director(2);

	public static Title getTitle(int n){
		switch (n){
			case 0: 
				return Title.Respondent;
			case 1:
				return Title.Manager;
			case 2:
				return Title.Director;
		}
	}
}
