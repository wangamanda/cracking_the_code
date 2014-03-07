import java.util.ArrayList;
import java.util.Iterator;

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
		res = getHighest(res, boxes);
		int H = getH(res);
		System.out.println("Height: "+H);
	}

	public static ArrayList<Box> getHighest(ArrayList<Box> res, ArrayList<Box> boxes){
		if(boxes.size() == 0){
			return res;
		}
		
		ArrayList<ArrayList<Box>> arr = new ArrayList<ArrayList<Box>>();
		for(Box b : boxes){
			if(res.size() == 0){
				res.add(b);
			}
			if(b.canPutAbove(res.get(res.size()-1))){
				res.add(b);
			}
			ArrayList<Box> tmp = new ArrayList<Box>();
			for(Box x : boxes){
				if(!b.equals(x))
					tmp.add(x);
			}
			if(tmp.size() != 0){
				ArrayList<Box> ar = getHighest(res, tmp);
				arr.add(ar);
			}else{
				ArrayList<Box> ar = new ArrayList<Box>();
				ar.add(b);
				return ar;
			}
		}

		if(arr.size() > 0){
			int m = 0;
			ArrayList<Box> a = new ArrayList<Box>();
			ArrayList<Box> aa = new ArrayList<Box>();
			for (int i = 0 ; i < arr.size() ; i ++ ){
				a = arr.get(i);
				if(getH(a) > m){
					aa = new ArrayList<Box>();
					for(Box b:a){
						aa.add(b);
					}
					m = getH(a);
				}
			}
			return aa;
		}
		return res;
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
