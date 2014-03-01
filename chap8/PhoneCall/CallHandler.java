package PhoneCall;

import java.util.ArrayList;

public class CallHandler{
	private final int LEVELS = 3;
	private final int NUM_RESPONDENTS = 10;
	private final int NUM_MANAGERS = 4;
	private final int NUM_DIRECTORS = 2;

	protected ArrayList<ArrayList<Employee>> employeeLevels;
	protected ArrayList<ArrayList<Call>> callQueues;
	
	protected CallHandler(){
		employeeLevels = new ArrayList<ArrayList<Employee>>(LEVELS);
		ArrayList<Employee> respondents = new ArrayList<Employee>(NUM_RESPONDETS);
		for (int i = 0 ; i < NUM_RESPONDENTS ; i ++ ){
			respondents.add(new Respondent());
		}
		employeeLevels.add(respondents);

		ArrayList<Employee> managers = new ArrayList<Employee>(NUM_MANAGERS);
		for (int i = 0 ; i < NUM_MANAGERS ; i ++ ){
			managers.add(new Manager());
		}
		employeeLevels.add(managers);

		ArrayList<Employee> directors = new ArrayList<Employee>(NUM_DIRECTORS);
		for (int i = 0 ; i < NUM_DIRECTORS ; i ++ ){
			directors.add(new Director());
		}
		employeeLevels.add(directors);

		callQueues = new ArrayList<ArrayList<Call>>(LEVELS);
	}

	public Employee getHandlerForCall(Call call){
		int rank = call.getRank().getValue();
		for (int i = rank ; i < LEVELS ; i ++ ){
			ArrayList<Employee> employees = employeeLevels.get(i);
			for (int j = 0 ; j < employees.size() ; j ++ ){
				employee = employees.get(j);
				if (employee.isFree()){
					return employee;
				}
			}
		}
		return null;
	}

	public void dispatchCall(Caller caller){
		Call call = new Call(caller);
		Employee employee = getHandlerForCall(call);
		if(employee != null){
			call.setHandler(employee);
			employee.receiveCall(call);
		}else{
			call.reply("Please wait a second.");
			callQueues.get(call.getRank().getValue()).add(call);
		}
	}

	public void assignCall(Employee employee){
		int rank = callQueues.getRank().getValue();
		for (int i = rank ; i >= 0 ; i --){
			ArrayList<call> callQue = callQueues.get(i);
			if (callQue.size() > 0){
				Call call = callQue.remove(0);
				call.setHandler(employee);
				return;
			}
		}
		employee.setFree();
	}
}
