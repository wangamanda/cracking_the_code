package PhoneCall;

public class Call{
	private Title rank;
	private Caller caller;
	private Employee employee;

	public Call(Caller c){
		caller = c;
		rank = Title.Respondent;
	}

	public void setRank(Title r){
		rank = r;
	}

	public Title getRank(){
		return rank;
	}

	public void reply(String s){
		System.out.println(s);
	}

	public void disconnect(){
		System.out.println("Thank you for calling.");
	}

	public void setHandler(Employee emp){
		employee = emp;
	}

	public Title incrementRank(){
		if (rank == Title.Respondent){
			setRank(Title.Manager);
		}else if (rank == Title.Manager){
			setRank(Title.Director);
		}
		return rank;
	}
}
