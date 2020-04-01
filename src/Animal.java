import java.util.Random; 

public abstract class Animal {
	protected int simID;
	protected Location location;
	protected boolean full;
	protected boolean rested;
	
	public Animal() {
		simID = 0;
		location = new Location(0,0);
		full = false;
		rested = false;
	}//end empty-argument constructor
	
	public Animal(int simID, Location location, boolean full, boolean rested) {
		this.simID = simID;
		this.location = location;
		full = false;
		rested = true;
	}//end preferred constructor
	
	//check for invalid simID
	public void validateID(int ID) {
		InvalidSimIDException ISIDE;
		try {
			if(ID < 0) {
				ISIDE = new InvalidSimIDException("\nInvalid simID.");
				throw ISIDE;
			}
			else {
				simID = ID;
			}
		}
			catch(InvalidSimIDException e) {
				System.out.print(e.getMessage());
		}
	}

	//checks if animal is full or not
	public boolean eat() {
		// create instance of Random class
		Random r = new Random();
		double hunger = r.nextDouble();
		//hunger = less than .5, then animal is not full. hunger = .5 or more, animal is full
		if(hunger<.5) 
			full = false;
		else
			full = true;	
		return full;
		}
	
	//checks if animal is rested or not
	public boolean sleep() {
		Random r = new Random();
		double rest = r.nextDouble();
		if(rest<.5) 
			rested = false;
		else
			rested = true;	
		return rested;
		}
	
	public String animalInfo() {
		validateID(simID);
		StringBuilder sb = new StringBuilder("\n===============");
		sb.append("\nSimID:"+ simID);
		sb.append("\nLocation: " + location);
		sb.append("\nFull: " + full);
		sb.append("\nRested: " + rested);
		sb.append("\n===============");
		return sb.toString();
	}
	
	//Getters & Setters
	public int getSimID() {
		return simID;
	}

	public void setSimID(int simID) {
		this.simID = simID;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public boolean isFull() {
		return full;
	}

	public void setFull(boolean full) {
		this.full = full;
	}

	public boolean isRested() {
		return rested;
	}

	public void setRested(boolean rested) {
		this.rested = rested;
	}
	
}
