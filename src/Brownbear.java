
public class Brownbear extends Animal implements Walkable, Swimmable{

	private String subSpecies;
	private int maxWD = 3;
	private int maxSD = 2;

	public Brownbear() {
		super();
		subSpecies = "Alaskan";
	}//end empty-argument contructor
	
	public Brownbear(int simID, Location location, String subSpecies) {
		this.simID = simID;
		this.location = location;
		this.subSpecies = subSpecies;
		full = false;
		rested = true;
	}//end preferred constructor

	//checks for invalid subspecies
	public void validateSubSpecies(String ss) {
		InvalidSubspeciesException ISE;
		try {
			if(ss != "Alaskan" && ss != "Asiatic" && ss != "European" && ss != "Grizzly" && ss != "Kodiak" && ss != "Siberian") {
				ISE= new InvalidSubspeciesException("\nInvalid Subspecies.");
				throw ISE;
			}
			else {
				subSpecies = ss;
			}
		}
			catch(InvalidSubspeciesException e) {
				System.out.print(e.getMessage());
		}
	}
	
	public String animalInfo() {
		validateID(simID);
		System.out.println();
		validateSubSpecies(subSpecies);
		StringBuilder sb = new StringBuilder("\n===============");
		sb.append("\nSimID:"+ simID);
		sb.append("\nLocation: " + location.displayCoordinates());
		sb.append("\nSubspecies: " + subSpecies);
		sb.append("\nFull: " + full);
		sb.append("\nRested: " + rested);
		sb.append("\n===============");
		return sb.toString();
	}
	
	//Getters & Setters
	public String getSubSpecies() {
		return subSpecies;
	}

	public void setSubSpecies(String subSpecies) {
		this.subSpecies = subSpecies;
	}

	//interfaces
	@Override
	public void swim(int direction) {
		Location l;
		int d = direction;
		if(d>maxWD) 
			d = maxWD;
		l = new Location(d,d);
		System.out.print("\nThe Bear swam from " + location.displayCoordinates() + "to ");
		location.update(l.getxCoord()+location.getxCoord(), l.getyCoord()+location.getyCoord());
		System.out.print(location.displayCoordinates());
	}

	@Override
	public void walk(int direction) {
		Location l;
		int d = direction;
		if(d>maxWD) 
			d = maxWD;
		l = new Location(d,d);
		System.out.print("\nThe Bear walked from " + location.displayCoordinates() + "to ");
		location.update(l.getxCoord()+location.getxCoord(), l.getyCoord()+location.getyCoord());
		System.out.print(location.displayCoordinates());
	}


	

}
