package NoDeadLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Hashtable;
import java.util.ArrayList;

public class LockNode{
	int ID;
	int count;
	ArrayList<LockNode> children = new ArrayList<LockNode>();
	State state = State.Fresh;
	Lock lock;

	public LockNode(int i, int c){
		ID = i;
		count = c;
	}

	public void join(LockNode n){
		children.add(n);
	}

	public void remove(LockNode n){
		children.remove(n);
	}

	public Lock getLock(){
		if(lock == null){
			lock = new ReentrantLock();
		}
		return lock;
	}

	public boolean hasCycle(Hashtable<Integer, Boolean> touchedNodes){
		State[] states = new State[count];
		for(int i = 0 ; i < count ; i ++ ){
			states[i] = State.Fresh;
		}

		return hasCycle(touchedNodes, states);
	}

	public boolean hasCycle(Hashtable<Integer, Boolean> touchedNodes, State[] states){
		if(touchedNodes.contains(ID)){
			touchedNodes.put(ID, true);
		}

		if(states[ID] == State.Visiting){
			return true;
		}else{
			states[ID] = State.Visiting;
			for(LockNode n : children){
				if(n.hasCycle(touchedNodes, states)){
					return true;
				}
			}
			states[ID] = State.Visited;
		}

		return false;
	}

	public int getID(){
		return ID;
	}
}
