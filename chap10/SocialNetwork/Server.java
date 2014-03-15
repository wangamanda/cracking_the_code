package SocialNetwork;

import java.util.HashMap;

public class Server{
	HashMap<Integer, Machine> machines = new HashMap<Integer, Machine>();
	HashMap<Integer, Integer> PersonMachineMap = new HashMap<Integer, Integer>();

	public Machine getMachine(int i){
		return machines.get(i);
	}

	public int getMachineFromPerson(int person){
		Integer machine = PersonMachineMap.get(person);
		if(machine == null){
			return -1;
		}else{
			return machine;
		}
	}

	public Person getPerson(int i){
		int ma = getMachineFromPerson(i);
		if(i == -1){
			return null;
		}
		Machine machine = getMachine(ma);
		if(machine == null){
			return null;
		}
		return machine.getPerson(i);
	}
}
