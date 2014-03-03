package JigsawPuzzle;

public class Edge{
	private EdgeType edgeType;
	private int edgeInt;
	private Edge attached;
	private int index;
	private Pixel parent;

	public EdgeType getEdgeType(){
		return edgeType;
	}
	
	public void setEdgeType(int i){
		edgeInt = i;
		edgeType = EdgeType.getEdgeType(edgeInt);
	}
	
	public boolean fitsWith(Edge edge){
		if(this.getEdgeType() == EdgeType.Inner && edge.getEdgeType() == EdgeType.Outer
		|| this.getEdgeType() == EdgeType.Outer && edge.getEdgeType() == EdgeType.Inner){
			return true;
		}
		return false;
	}
}