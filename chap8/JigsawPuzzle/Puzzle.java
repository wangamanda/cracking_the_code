package JigsawPuzzle;

public class Puzzle{
	private Pixel[] pixels;
	private Pixel[][] solution;
	
	private Edge[] inners, outers, flats;
	private Pixel[] corners;
	
	public void sort(){
		int i = 0;
		int j = 0;
		int k = 0;
		for (Pixel pixel : pixels){
			if(pixel.isCorner()){
				corners[i++] = pixel;
			}
			for (Edge edge : pixel.getEdges()){
				if(edge.getEdgeType() == EdgeType.Inner){
					inners[j++] = edge;
				}else if(edge.getEdgeType() == EdgeType.Outer){
					outers[k++] = edge;
				}
			}
		}
	}

	public void solve(){
		Edge currentEdge = getExposedEdge(corners[0]);
		while(currentEdge != null){
			Edge[] opposites = new Edge[inners.length];
			if(currentEdge.getEdgeType() == EdgeType.Inner){
				opposites = new Edge[inners.length];
				opposites = inners;
			}else if(currentEdge.getEdgeType() == EdgeType.Outer){
				opposites = new Edge[outers.length];
				opposites = outers;
			}
			
			for (Edge edge : opposites){
				if(currentEdge.fitsWith(edge)){
					attachEdges(edge, currentEdge);
				}
				removeFromList(currentEdge);
				removeFromList(edge);
				currentEdge = nextExposedEdge(edge);
				break;
			}
		}
	}
	
	public void removeFromList(Edge edge){
		if(edge.getEdgeType() == EdgeType.Flat){
			return;
		}
		Edge[] edges;
		if(edge.getEdgeType() == EdgeType.Inner){
			edges = inners;
		}else{
			edges = outers;
		}
		Edge[] newedges = new Edge[edges.length-1];
		int j = 0;
		for (int i = 0 ; i < edges.length ; i ++ ){
			if(edges[i] == edge){
				;
			}else{
				newedges[j++] = edges[i];
			}
		}
	}
	
	public void attachEdges(Edge e1, Edge e2){
		e1.attached_to = e2;
		e2.attached_to = e1;
	}
	
	public Edge getExposedEdge(Pixel p){
		for (Edge edge : p.getEdges()){
			if(isExposed(edge)){
				return edge;
			}
		}
		return null;
	}
	
	public boolean isExposed(Edge e){
		return e.getEdgeType() != EdgeType.Flat && e.attached_to == null;
	}
	
	public Edge nextExposedEdge(Edge e){
		int next_index = (e.index + 2)%4;
		Edge next_edge = e.parent.getEdges()[next_index];
		if(isExposed(next_edge)){
			return next_edge;
		}
		return getExposedEdge(e.parent);
	}
}
