package JigsawPuzzle;

public enum PixelType{
	Corner(0),
	Side(1),
	Inside(2);
	
	private int value;
	private PixelType(int v){
		value = v;
	}
	
	public static PixelType getPixelType(int v){
		switch(v){
			case 0:
				return PixelType.Corner;
			case 1:
				return PixelType.Side;
			case 2:
				return PixelType.Inside;
			default:
				return null;
		}
	}
}
