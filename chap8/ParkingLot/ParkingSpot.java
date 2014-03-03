package ParkingLot;

public class ParkingSpot{

	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int row;
	private int spotNum;
	private Level level;

	public ParkingSpot(Level l, int r, int n, VehicleSize vs){
		level = l;
		row = r;
		spotNum = n;
		spotSize = vs;
	}

	public VehicleSize getSize(){
		return spotSize;
	}

	public boolean isAvailable(){
		return vehicle == null;
	}

	public boolean canFitVehicle(Vehicle vehicle){
		if(isAvailable()){
			return vehicle.canFitInSpot(this);
		}
		return false;
	}

	public boolean park(Vehicle v){
		if(canFitVehicle(v)){
			vehicle = v;
			v.parkInSpot(this);
			return true;
		}
		return false;
	}

	public void removeVehicle(){
		vehicle = null;
		level.spotFreed(vehicle);
	}

	public int getRow(){
		return row;
	}

	public int getSpotNumber(){
		return spotNum;
	}
}
