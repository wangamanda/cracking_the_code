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
	}
}
