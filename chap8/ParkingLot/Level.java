package ParkingLot;

public class Level{
	private int floor;
	private int availableSpots;
	private ParkingSpot[] spots;
	private static final int SPOTS_PER_ROW = 10;

	public Level(int f, int a){
		floor = f;
		availableSpots = a;
		spots = new ParkingSpot[a];
		int compactStart = a/3;
		int largeStart = a*2/3;
		for (int i = 0 ; i < a ; i ++ ){
			VehicleSize vs;
			if (i < compactStart){
				vs = VehicleSize.Motorcycle;
			}else if(i < largeStart){
				vs = VehicleSize.Compact;
			}else{
				vs = VehicleSize.Large;
			}

			int row = i/SPOTS_PER_ROW;
			spots[i] = new ParkingSpot(this, row, i, vs);
		}
	}

	public int availableSpots(){
		return availableSpots;
	}

	public boolean parkVehicle(Vehicle vehicle){
		int start = findAvailableSpots(vehicle);
		if(start < 0 || availableSpots() < vehicle.getSpotsNeeded()){
			return false;
		}
		return parkStartingAtSpot(start, vehicle);
	}

	public boolean parkStartingAtSpot(int num, Vehicle v){
		boolean success = true;
		for (int i = num ; i < num+v.getSpotsNeeded() ; i ++ ){
			success &= spots[i].canFitVehicle(v);
			if(i >= SPOTS_PER_ROW){
				return false;
			}
		}
		availableSpots -= v.getSpotsNeeded();
		return success;
	}

	public int findAvailableSpots(Vehicle vehicle){
		int lastRow = 0;
		int spotsFound = 0;
		for (int i = 0 ; i < spots.length ; i ++ ){
			if (lastRow != spots[i].getRow()){
				lastRow = spots[i].getRow();
				spotsFound = 0;
			}
			if(spots[i].canFitVehicle(vehicle)){
				spotsFound ++ ;
			}else{
				spotsFound = 0;
			}
			if(spotsFound == vehicle.getSpotsNeeded()){
				return i - vehicle.getSpotsNeeded() + 1;
			}
		}
		return -1;
	}

	public void spotFreed(Vehicle v){
		v.clearSpots();
		int n = v.getSpotsNeeded();
		for(int i = 0 ; i < n ; i ++ ){
			availableSpots ++ ;
		}
	}
}
