package simpleExample;

import java.util.ArrayList;


/**
 * This class allows us to weight balls and cubes of different sizes
 * Unfortunately, there is a lot of duplicated code
 * Can we develop a common interface to make this class a lot shorter?
 * 
 * @author Jason Yoder
 *
 */
public class ScaleSimulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// create a list of balls and compare them
		ArrayList<Weighable> weighableObjects = new ArrayList<Weighable>();
		for (int i=1; i<= 3; i++) {
			weighableObjects.add( new Ball(i) );
			weighableObjects.add( new Cube(i) );
			weighableObjects.add( new Cylinder(i, i) );

		}
		System.out.println("---------------------------------------");
		reportweighableObjectsComparison(weighableObjects);
		
		
		//How could I compare all of these?
		

	}
	



	private static void reportweighableObjectsComparison(ArrayList<Weighable> weighableObjects) {
		if ( weighableObjects.isEmpty() ) {
			return;
		}
		Weighable heaviest = weighableObjects.get(0);
		for(Weighable b: weighableObjects) {
			if (b.getWeightInLbs() > heaviest.getWeightInLbs() ) {
				System.out.println( b + " is heavier than " + heaviest );
				heaviest = b;
			} else if (b.getWeightInLbs() < heaviest.getWeightInLbs()) {
				System.out.println( b + " is lighter than " + heaviest );
			} else {
				System.out.println( b + " is the same as " + heaviest );
			}
		}
	}
}
