package PhoneCall;

public abstract class Employee{
	protected Title rank;
	protected Call currentCall;

	public Employee(){
	
	}

	public Employee(Title r){
		rank = r;
	}

	public boolean isFree(){
		if(currentCall == null){
			return true;
		}
		return false;
	}

	public void receiveCall(Call call){
		if (currentCall == null){
			currentCall = call;
		}
	}

	public void completeCall(){
		if (!isFree()){
			currentCall.disconnect();
			currentCall = null;
		}
		assignNewCall();
	}

	public boolean assignNewCall(){
		if (currentCall != null){
			return false;
		}
		return CallHandler.getInstance().assignCall(this);
	}

	public Title getRank(){
		return rank;
	}

	public void ReassignCall(){
	//when the current level of employee cannot solve the problem, the phone goes to upper level
		if (currentCall != null){
			currentCall.incrementRank();
			CallHandler.getInstance().dispatchCall(currentCall);
			currentCall = null;
		}
		assignNewCall();
	}
}
