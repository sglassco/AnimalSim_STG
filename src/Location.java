
public class Location {
	private int xCoord;
	private int yCoord;
	
	//initializing instance variables
		public Location() {
			xCoord= 0;  	
			yCoord = 0; 	   	  
		}//end empty-argument constructor
	
		public Location(int x, int y) {
			validateCoords(x,y);	
		}//end preferred constructor
		
		//updates coords and rechecks for exception
		public void update(int x, int y) {
			validateCoords(x,y);	
		}
		
		public  int[] getCoordinates(int x, int y) {			
			int[] coords = new int[] {xCoord,yCoord};
			return coords;
		}
		
		//checking for invalid coords
		public void validateCoords(int x, int y) {
			InvalidCoordinateException ICE;
			try {
				if(x<0) {
					ICE = new InvalidCoordinateException("\nInvalid X Coord");
					throw ICE;
				}
				else if(y<0) {
					ICE = new InvalidCoordinateException("\nInvalid Y Coord");
					throw ICE;
				}else {
					xCoord = x;
					yCoord = y;
				}
			}
				catch(InvalidCoordinateException e) {
					System.out.print(e.getMessage());
			}
		}
		
		public String displayCoordinates() {
			StringBuilder sb = new StringBuilder("");
			sb.append("\n(" + xCoord + "," + yCoord +")");
			return sb.toString();
		}
		
		//Getters & Setters
		public int getxCoord() {
			return xCoord;
		}

		public void setxCoord(int xCoord) {
			this.xCoord = xCoord;
		}

		public int getyCoord() {
			return yCoord;
		}

		public void setyCoord(int yCoord) {
			this.yCoord = yCoord;
		}

}
