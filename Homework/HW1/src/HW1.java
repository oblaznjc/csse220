/*
 * This is a very small assignment.  It's mostly to show that you can
 * check out and check in code successfully.
 */
public class HW1 {

	/**
	 * This method takes in 4 separate integers. The first two comprise the first fraction
	 * as the numerator and denominator, respectively.  The third and fourth integers 
	 * comprise the second fraction.
	 * 
	 * This method returns the decimal result of adding the two fractions
	 * 
	 * Example
	 * 
	 * addFraction(1,2,1,4) returns 0.75
	 */
	public static double addFraction(double num1, double den1, double num2, double den2) {
		double decimal_result = (num1 / den1) + (num2 / den2);
		return decimal_result;
	}
	
	/**
	 * Takes a string that is all Ts or Fs.
	 * 
	 * T stands for touchdown and is worth 7 points.
	 * F stands for fieldgoal and is worth 3 points.
	 * 
	 * Returns the total score.
	 * 
	 * For example:
	 * "TT" returns 14
	 * "FTF" returns 13
	 * "FFFF" returns 12
	 * "" returns 0;
	 *  
	 * 
	 * @param a string only Ts and Fs
	 * @return a score
	 */
	public static int footballScore(String input) {
		int score = 0;
		for(int index = 0; index < input.length(); index++) {
			if(input.charAt(index) == 'T') {
				score = score + 7;
			}
			else {
				score = score + 3;
			}
		}
		return score;
	}
	
}//end class HW1
