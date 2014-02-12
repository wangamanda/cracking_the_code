public class monoscreen{

	public static void main(String args[]){
		int width = 40;
		int height = 10;
		byte[] screen = new byte[40*10/8];
		int x1 = 5;
		int x2 = 32;
		int y = 4;

		drawLine(screen, width, x1, x2, y);
		printScreen(width, height, screen);
	}

	public static void drawLine(byte[] screen, int width, int x1, int x2, int y){
		int start_full_bytes = x1 / 8;
		int start_offset = x1 % 8;
		int end_full_bytes = x2 / 8;
		int end_offset = x2 % 8;

		if(start_offset != 0){
			start_full_bytes += 1;
		}
		if(end_offset != 7){
			end_full_bytes -= 1;
		}
		
		byte start = (byte) (0xFF >> start_offset);
		byte end = (byte) (~(0xFF >> (end_offset + 1)));
		screen[width*y / 8 + start_full_bytes - 1] = start;
		screen[width*y / 8 + end_full_bytes + 1] = end;
		if(start_full_bytes <= end_full_bytes){
			for (int i = start_full_bytes ; i <= end_full_bytes ; i ++ ){
				screen[width*y / 8 + i] = (byte) 0xFF;
			}
		}
	}

	public static void printScreen(int width, int height, byte[] screen){
		for (int h = 0 ; h < height ; h ++ ){
			for(int w = 0 ; w < width/8 ; w ++ ){
				print(screen[h*width/8 + w]);
			}
			System.out.println();
		}
	}
	
	public static void print(byte a){
		for (int i = 7 ; i >= 0 ; i -- ){
			System.out.print((a >> i) & 1);
		}
	}
}
