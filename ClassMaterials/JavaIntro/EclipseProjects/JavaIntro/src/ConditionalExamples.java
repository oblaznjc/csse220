/**
 * A class filled with interesting functions for learning.
 * 
 * @author Michael Hewner
 *
 */
public class ConditionalExamples {


	/**
	 * 
	 * Computes the average of the three input numbers
	 * 
	 * I've provided the solution for this one.
	 * 
	 */
	public static double computeAverage(double a, double b, double c) {
		return (a + b + c)/3;
	}
	
	/**
	 * 
	 * Computes a number cubed.
	 * 
	 * Once you get this function working, modify main (below) to 
	 * test this function
	 * 
	 * NOTE: in java, there is no exponent operator (e.g. ^)
	 * There is a function called pow the in math library, but
	 * if we're talking about integers often the easier way is to
	 * just multiply several times
	 */
	public static double computedCubed(double numberToCube) {
		return (numberToCube * numberToCube * numberToCube);
	}

	/**
	 * 
	 * If the input number is divisible by 3, prints "divisible by 3!"
	 * Otherwise prints "NOT divisible by 3"
	 * 
	 * I've provided the solution for this one
	 */
	public static void printDivisibleBy3(int number) {
		if(number % 3 == 0) {
			System.out.println(number + " is divisible by 3");
		} else {
			System.out.println(number + " is NOT divisible by 3");
		}
	}
	
	/**
	 * Takes a number and a guess for what it's cube root ought to be.
	 * If the guess is too high, print "Lower"
	 * if the guess is too low, print "Higher"
	 * If the guess is just right, print "Perfect"
	 * 
	 * So guessCubeRoot(27,2.5) would print "Higher"
	 *    guessCubeRoot(27,3.3) would print "Lower"
	 *    guessCubeRoot(27,3) would print "Perfect"
	 * 
	 * You'll solve this one yourself.  Use > < and ==
	 * 
	 * As in the previous one, modify main to test your code once you've
	 * got a plausible solution.
	 * 
	 * HINT: you could use functions in Math to compute the cube root directly, 
	 * but this is not needed!  Instead, compute the cube of the guess and then
	 * see how that compares to the real value.
	 */
	public static void guessCubeRoot(double number, double guess) {
		if (guess * guess * guess > number) {
			System.out.println("Lower");
		} else if (guess * guess * guess < number) {
			System.out.println("Higher");
		} else {
			System.out.println("Perfect");
		}
	}
	
	/**
	 * We won't go over this one in class at all, just for fun if you get
	 * done with the others (do the problems in the other files before coming 
	 * here).
	 * 
	 * Returns true if the first number is much larger (at least 100x larger)
	 * than the second.  You can assume the first number is larger than the 
	 * second.
	 */
	public static boolean isWayBigger (int bigger, int smaller) {
		if ( bigger >= 100 * smaller) {
			return true;
		}
		return false;
	}
	
	/**
	 * We won't go over this one in class at all, just for fun if you get
	 * done with the others.
	 * 
	 * Returns true if at least 1 one of the 3 input values is greater than 3
	 * 
	 * hint: you can do a logical OR with the || operator
	 * 
	 * Solve this one yourself
	 */
	public static boolean isGreaterThan3 (int one, int two, int three) {
		if (one > 3 || two > 3 || three > 3) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Average of 3 4 5 is " + computeAverage(3, 4, 5));
		System.out.println("Average of 3 4 6 is " + computeAverage(3, 4, 6));
		
		System.out.println("Cube of 3 is " + computedCubed(3));
		System.out.println("Cube of 3.1 is " + computedCubed(3.1));
		
		printDivisibleBy3(12); // note in this case we print within the function
		printDivisibleBy3(13);
		
		guessCubeRoot(27,2.5);
		guessCubeRoot(27,3);
		guessCubeRoot(27,3.5);
		
		System.out.println("999 is way bigger than 1: " + isWayBigger(999,1));
		System.out.println("100 is way bigger than 1: " + isWayBigger(100,1));
		System.out.println("99 is way bigger than 1: " + isWayBigger(99,1));
		
		System.out.println("1, 2, or 3 is larger than 3: " + isGreaterThan3(1,2,3));
		System.out.println("1, 2, or 4 is larger than 3: " + isGreaterThan3(1,2,4));
		System.out.println("55, 2, or 4 is larger than 3: " + isGreaterThan3(55,2,4));


	}
}
