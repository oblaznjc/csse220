package TwoDArrayProblems;

import java.util.Arrays;

public class TwoDArrayProblems {

	/**
	 * 
	 * updateArrayRows
	 * 
	 * ensures: modifies incomingA by assigning incomingC to each cell in all even
	 * numbered rows and does not change any of the cells in all odd numbered rows
	 * 
	 * @param incomingA - the array to be modified
	 * @param incomingC - the character to be assigned
	 * 
	 *                  Hint: even numbered rows are 0, 2, 4, ..., etc. odd numbered
	 *                  rows are 1, 3, 5, ..., etc.
	 * 
	 *                  Assume r is declared as an 'int' ((r % 2) == 0) is true if r
	 *                  is even ((r % 2) == 0) is false if r is odd
	 * 
	 *                  Example: incoming values: char[][] myA =
	 *                  {{'a','b','c'},{'a','b','c'},{'x','y','z'},{'q','r','s'}};
	 *                  char myC = '-';
	 * 
	 *                  updateArrayRows(myA, myC); // Example call
	 * 
	 *                  outgoing values: myA =
	 *                  {{'-','-','-'},{'a','b','c'},{'-','-','-'},{'q','r','s'}}
	 *                  myC = '-'
	 */
	public static void updateArrayRows(char[][] incomingA, char incomingC) {
		// TODO: finish me
		// System.out.println("A: " + Arrays.deepToString(incomingA));
		// System.out.println("C: " + incomingC);
		for (int r = 0; r < incomingA.length; r = r + 2) {
			for (int c = 0; c < incomingA[r].length; c++) {
				incomingA[r][c] = incomingC;
			}
		}
		// System.out.println("A Final : " + Arrays.deepToString(incomingA));
	} // updateArrayRows

	// *********************************************************************************************

	/**
	 * 
	 * findMaxValues
	 * 
	 * ensures: a new 2D array is created and returned, the cells of the new array
	 * must be assigned a value either from the corresponding cell of incomingA or
	 * incomingB. The value assigned to the new array's cell must the largest
	 * between incomingA's corresponding cell and incomingB's corresponding cell.
	 * incomingA and incomingB must not be changed
	 * 
	 * @param incomingA - an array of int values
	 * @param incomingB - an array of int values requires: the dimensions of two
	 *                  incoming 2D arrays are exactly the same
	 * @return a new 2D array with the exact same dimensions as incomingA and
	 *         incomingB
	 * 
	 * 
	 *         Example: incoming values: int[][] myA =
	 *         {{47,-1,10,71},{9,4,7,0},{-20,92,5,19}}; int[][] myB =
	 *         {{74,-5,10,17},{19,3,0,7},{-2,29,5,11}};
	 * 
	 *         int[][] result = findMaxValues(myA, myB); // Example call
	 * 
	 *         outgoing values: myA = {{47,-1,10,71},{9,4,7,0},{-20,92,5,19}} myB =
	 *         {{74,-5,10,17},{19,3,0,7},{-2,29,5,11}} result =
	 *         {{74,-1,10,71},{19,4,7,7},{-2,92,5,19}}
	 */
	public static int[][] findMaxValues(int[][] incomingA, int[][] incomingB) {
		// TODO: finish me
		int numRow = incomingA.length;
		int numCol = incomingA[0].length;

		int[][] result = new int[numRow][numCol];

		for (int r = 0; r < numRow; r++) {
			for (int c = 0; c < numCol; c++) {
				if (incomingA[r][c] > incomingB[r][c]) {
					result[r][c] = incomingA[r][c];
				} else {
					result[r][c] = incomingB[r][c];
				}
			}
		}
		// System.out.println(Arrays.deepToString(result));
		return result;
	} // findMaxValues

}
