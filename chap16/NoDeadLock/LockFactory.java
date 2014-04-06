package NoDeadLock;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class LockFactory{
	int count;
	LockNode[] locks;
	public static LockFactory instance = null;
	private Hashtable<Integer, LinkedList<LockNode>> lockOrder;

	private LockFactory(int c){
		count = c;
		locks = new LockNode[count];
		lockOrder = new Hashtable<Integer, LinkedList<LockNode>>();
		for(int i = 0 ; i < count ; i ++ ){
			locks[i] = new LockNode(i, count);
		}
	}

	public static LockFactory getInstance(){
		return instance;
	}

	public static LockFactory Initialize(int c){
		if(instance == null){
			instance = new LockFactory(c);
		}
		return instance;
	}

	public boolean hasCycle(Hashtable<Integer, Boolean> table, int[] resources){
		for(int resource : resources){
			if(table.get(resource) == false){
				LockNode n = locks[resource];
				if(n.hasCycle(table)){
					return true;
				}
			}
		}
		return false;
	}

	public boolean declare(int id, int[] resources){
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		table.put(resources[0], false);
		for(int i = 1 ; i < resources.length ; i ++ ){
			LockNode p = locks[resources[i-1]];
			LockNode a = locks[resources[i]];
			p.join(a);
			table.put(resources[i], false);
		}

		if(hasCycle(table, resources)){
			for(int i = 1 ; i < resources.length ; i ++ ){
				LockNode p = locks[resources[i-1]];
				LockNode a = locks[resources[i]];
				p.remove(a);
			}
			return false;
		}

		LinkedList<LockNode> nodes = new LinkedList<LockNode>();
		for(int i = 0 ; i < resources.length ; i ++ ){
			LockNode p = locks[resources[i]];
			nodes.add(p);
		}
		lockOrder.put(id, nodes);
		return true;
	}

	public Lock getLock(int id, int resource){
		LinkedList<LockNode> list = lockOrder.get(id);
		if(list == null){
			return null;
		}

		LockNode head = list.getFirst();
		if(head.getID() == resource){
			list.removeFirst();
			return head.getLock();
		}
		return null;
	}
}
