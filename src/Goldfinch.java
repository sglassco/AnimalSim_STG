
public class Goldfinch extends Animal implements Flyable, Walkable{

	private double wingSpan;
	private int maxWD = 1;
	
	public Goldfinch() {
		super();
		wingSpan = 9.0;
	}//end empty-argument constructor
	
	public Goldfinch(int simID, Location location, double wingSpan) {
		this.simID = simID;
		this.location = location;
		this.wingSpan = wingSpan;
		full = false;
		rested = true;
	}//end preferred constructor

	//check for invalid wingspan
	public void validateWingSpan(double ws) {
		InvalidWingspanException IWSE;
		try {
			if(ws < 5.0 || ws > 11.0) {
				IWSE = new InvalidWingspanException("\nInvalid Wingspan.");
				throw IWSE;
			}
			else {
				wingSpan = ws;
			}
		}
			catch(InvalidWingspanException e) {
				System.out.print(e.getMessage());
		}
	}
	
	public String animalInfo() {
		validateID(simID);
		System.out.println();
		validateWingSpan(wingSpan);
		StringBuilder sb = new StringBuilder("\n===============");
		sb.append("\nSimID:"+ simID);
		sb.append("\nLocation: " + location.displayCoordinates());
		sb.append("\nWingspan: " + wingSpan);
		sb.append("\nFull: " + full);
		sb.append("\nRested: " + rested);
		sb.append("\n===============");
		return sb.toString();
	}

	//Getters & Setters
	public double getWingSpan() {
		return wingSpan;
	}

	public void setWingSpan(double wingSpan) {
		this.wingSpan = wingSpan;
	}

	//interfaces
	@Override
	public void walk(int direction) {
		Location l;
		int d = direction;
		if(d>maxWD) 
			d = maxWD;
		l = new Location(d,d);
		System.out.print("\nThe Goldfinch walked from " + location.displayCoordinates() + "to ");
		location.update(l.getxCoord()+location.getxCoord(), l.getyCoord()+location.getyCoord());
		System.out.print(location.displayCoordinates());
	}

	@Override
	public void fly(Location l) {
		System.out.print("\nThe Goldfinch flew from " + location.displayCoordinates() + "to ");
		location.update(l.getxCoord(), l.getyCoord());
		System.out.print(location.displayCoordinates());
	}

	
}
