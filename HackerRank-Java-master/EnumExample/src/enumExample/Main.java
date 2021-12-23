package enumExample;

public class Main {

	public static void main(String[] args) {
		System.out.println("Enum Example");
		
		/* Create a new person with Black hair */
		Person peterParker = new Person(HairColors.BLACK);
		System.out.println("Creating Peter Parker with " + peterParker.getHairColor() + " hair");

		/* Creating an alias Spiderman for Peter Parker */
		System.out.println("Creating an alias for Peter Parker, called Spiderman");
		Person spiderMan = peterParker;
		System.out.println("Spiderman has " + spiderMan.getHairColor() + " hair, just like Peter Parker");
		
		/* Change Peter Parkers hair, and see if spidermans hair changes color */
		peterParker.setHairColor(HairColors.BLONDE);
		System.out.println("Setting Peter Parkers hair to " + peterParker.getHairColor());
		System.out.println("Spidermans hair is now " + spiderMan.getHairColor());
		
		/* Changing Spidermans hair */
		spiderMan.setHairColor(HairColors.PINK);
		System.out.println("We changed Spiderman's hair to " + spiderMan.getHairColor());
		System.out.println("Peter Parkers hair is now " + peterParker.getHairColor());

	}

}
