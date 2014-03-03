package JigsawPuzzle;

public class Pixel{
	private Edge[] edges;
	private PixelType pixelType;

	public Pixel(){
		
	}

	public boolean isCorner(){
		int cnt = 0;
		for (int i = 0 ; i < edges.length ; i ++ ){
			if(edges[i].getEdgeType() == EdgeType.Flat){
				cnt ++ ;
			}
			if(cnt == 2){
				return true;
			}
		}
		return false;
	}

	public Edge[] getEdges(){
		return edges;
	}
}
