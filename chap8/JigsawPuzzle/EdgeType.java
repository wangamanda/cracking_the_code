package JigsawPuzzle;

public enum EdgeType{
	Flat(0),
	Inner(1),
	Outer(2);
	
	private int value;
	private EdgeType(int v){
		value = v;
	}
	
	public int getValue(){
		return value;
	}
	
	public static EdgeType getEdgeType(int v){
		switch(v){
			case 0:
				return EdgeType.Flat;
			case 1:
				return EdgeType.Inner;
			case 2:
				return EdgeType.Outer;
			default:
				return null;
		}
	}
}
