/**
 * Application class to test all methods, constructors, exceptions, 
 * getters&setters of the classes within the AnimalSim Project
 * @author Sam Glassco
 * @version 1.0
 * AnimalSim Project
 * 2/11/2020
 */


	public class Application {

		public static void main(String[] args) {
			
			System.out.print("**********Location**********\n");
			//Empty Location
			System.out.print("Empty Location:");
			Location emptyA = new Location();
			System.out.print(emptyA.displayCoordinates());
			
			//Filled Location
			System.out.print("\n\nFilled Location:");
			Location filledA = new Location(2,6);
			System.out.print(filledA.displayCoordinates());
			
			//update method
			System.out.print("\n\nUpdate Coords from (2,6) to (3,5)");
			filledA.update(3,5);
			System.out.println(filledA.displayCoordinates());
			
			//xCoord exception test
			System.out.print("\nFilled Location W/ Invalid X");
			Location errorXA = new Location(-2,6);

			//yCoord exception test
			System.out.print("\n\nFilled Location W/ Invalid Y");
			Location errorYA = new Location(2,-6);
			
			//update method w/ exception
			System.out.print("\n\nUpdate Coords from (3,5) to (-3,5)");
			filledA.update(-3,5);			
			System.out.print("\n****************************");
			
			
			System.out.print("\n\n**********Animal**********");
			//Empty Animal
			System.out.print("\n\nCannot instantiate the type animal:");
			//Animal emptyB = new Animal();
			
			//testing empty Animal-Goldfinch and Filled Animal-Brownbear
			Animal GFA = new Goldfinch();
			Animal BBA = new Brownbear(3,filledA,"Siberian");
			//filled GFA
			GFA.setSimID(4);
			System.out.print("\nGoldfinch Animal SimID: " + GFA.getSimID());
			GFA.setLocation(filledA);
			System.out.print("\nGoldfinch Animal Location: " + GFA.getLocation().displayCoordinates());
			//testing eat/sleep & rested/full
			GFA.setFull(false);
			GFA.setRested(false);
			System.out.println("\nGFA Full: " + GFA.isFull());
			System.out.println("GFA Rested: " + GFA.isRested());
			System.out.println("GFA Full After Eating: " + GFA.eat());
			System.out.println("GFA Rested After Sleeping: " + GFA.sleep());
			System.out.print("\n****************************");
			
			
			System.out.print("\n\n**********Goldfinch**********");
			//empty Goldfinch
			System.out.print("\nEmpty Goldfinch:");
			Goldfinch emptyG = new Goldfinch();
			System.out.print(emptyG.animalInfo());
			
			//Filled Goldfinch
			System.out.print("\nFilled Goldfinch:");
			Goldfinch G = new Goldfinch(4,filledA,8.0);
			G.eat();
			G.sleep();
			System.out.print(G.animalInfo());
			
			//test simID exception & wingSpan exception
			System.out.print("\n\nTesting simID exception and Wingspan Exception");
			//ID exception
			Goldfinch errorIDG = new Goldfinch(-2,filledA,8.0);
			System.out.print(errorIDG.animalInfo());
			//Wingspan Exception
			Goldfinch errorWSG = new Goldfinch(3,filledA, 4.5);
			System.out.print("\n"+errorWSG.animalInfo());
			
			//testing walk & fly interfaces for Goldfinch
			System.out.print("\nTesting Walk & Fly Interfaces for Goldfinch");
			G.walk(1);
			G.fly(emptyA);



			

			System.out.print("\n\n**********Brownbear**********");
			//empty Brownbear
			System.out.print("\nEmpty Brownbear: ");
			Brownbear emptyB = new Brownbear();
			System.out.print(emptyB.animalInfo());
			
			//filled Brownbear
			System.out.print("\nFilled Brownbear: ");
			//setting simID,location, and subspecies
			Brownbear B = new Brownbear(13,filledA,"Grizzly");
			//eats/sleeps and checks if full/rested
			B.eat();
			B.sleep();
			System.out.print(B.animalInfo());
			
			//test simID exception & subSppecies exception
			System.out.print("\n\nTesting simID exception and subSpecies Exception");
			//ID exception
			Brownbear errorIDB = new Brownbear(-5,filledA,"Kodiak");
			System.out.print(errorIDB.animalInfo());
			//SubSpecies Exception
			Brownbear errorSSB = new Brownbear(3,filledA, "Carrot");
			System.out.print("\n"+errorSSB.animalInfo());
			
			//testing walk & swim interfaces for Brownbear
			System.out.print("\nTesting Walk & Swim Interfaces for Brownbear");
			B.walk(3);
			B.swim(2);
			System.out.print("\n****************************");

		}
}
