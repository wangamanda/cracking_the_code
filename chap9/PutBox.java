import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

class Box{
	int width;
	int depth;
	int height;

	public Box(int a, int b, int c){
		width = a;
		depth = b;
		height = c;
	}

	public int getWidth(){
		return width;
	}

	public int getDepth(){
		return depth;
	}

	public int getHeight(){
		return height;
	}

	public boolean canPutUnder(Box b){
		if (width > b.getWidth() && depth > b.getDepth() && height > b.getHeight()){
			return true;
		}
		return false;
	}

	public boolean canPutAbove(Box b){
		return width < b.getWidth() && depth < b.getDepth() && height < b.getHeight();
	}
}

public class PutBox{
	public static void main(String args[]){
		ArrayList<Box> boxes = new ArrayList<Box>();
		Box a = new Box(7,8,9);
		Box b = new Box(8,7,10);
		Box c = new Box(6,7,8);
		Box d = new Box(5,6,7);
		Box e = new Box(7,6,8);
		boxes.add(b);
		boxes.add(c);
		boxes.add(d);
		boxes.add(e);
		boxes.add(a);
		ArrayList<Box> res = new ArrayList<Box>();
		HashMap<Box, ArrayList<Box>> map = new HashMap<Box, ArrayList<Box>>();
		res = getHighest(boxes, null, map);
		int H = getH(res);
		System.out.println("Height: "+H);
	}

	public static ArrayList<Box> getHighest(ArrayList<Box> boxes, Box bottom, HashMap<Box, ArrayList<Box>> map){
		if(bottom != null && map.containsKey(bottom)){//the longest stack based on box bottom has been found
			return map.get(bottom);
		}

		ArrayList<Box> max_stack = null;
		
		for (Box b : boxes) {
			if(bottom == null || b.canPutAbove(bottom)){
				ArrayList<Box> tmp = getHighest(boxes, b, map);
				if(getH(tmp) > getH(max_stack)){
					max_stack = tmp;
				}
			}
		}

		if(max_stack == null){//no box can lay on top of box bottom
			max_stack = new ArrayList<Box>();
		}
		if(bottom != null){
			max_stack.add(bottom);
			map.put(bottom, max_stack);//put box bottom and the current longest stack based on it(itself)
		}
		return (ArrayList<Box>)max_stack.clone();
		//return type of clone() is Object, need to cast
	}
	
	public static int getH(ArrayList<Box> boxes){
		int n = 0;
		if(boxes == null || boxes.size() == 0){
			return 0;
		}else{
			for(int i = 0 ; i < boxes.size() ; i ++ ){
				Box b = boxes.get(i);
				n += b.getHeight();
			}
		}
		return n;
	}
}
