package TwoDArrayProblemsTest;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import TwoDArrayProblems.RunAllTests;
import TwoDArrayProblems.TwoDArrayProblems;

public class TestFindMaxValues {
	
	private static int testsPassed;
	private static int numberOfTests;

	@BeforeClass
	public static void oneTimeSetUp() {
		testsPassed = 0;
		numberOfTests = 0;
	} // oneTimeSetUp

	// --------------------------------------------
	
	@AfterClass
	public static void oneTimeTearDown() {
		String className = TestFindMaxValues.class.getSimpleName();
		RunAllTests.outputResults(testsPassed, numberOfTests, className);
	} // oneTimeTearDown

	// --------------------------------------------
	// JUnit Tests
	// --------------------------------------------

	@Test
	public void testFindMaxValuesN01() {
		int[][] inputA = {{47,-1,10,71},{9,4,7,0},{-20,92,5,19}};
		int[][] inputB = {{74,-5,10,17},{19,3,0,7},{-2,29,5,11}};
		int[][] expectedOutput = {{74,-1,10,71},{19,4,7,7},{-2,92,5,19}};
				
		numberOfTests++;
		int[][] result = TwoDArrayProblems.findMaxValues(inputA, inputB);
		String incorrectAnsMsg = "\n" + "expected: " + Arrays.deepToString(expectedOutput) + "\n  but was: "
				+ Arrays.deepToString(result);
		assertTrue(incorrectAnsMsg, Arrays.deepEquals(result, expectedOutput));
		testsPassed++;
	} // testFindMaxValuesN01

	@Test
	public void testFindMaxValuesN02() {
		int[][] inputA = {{47,-1,10},{71,9,4},{7,0,-20},{92,5,19}};
		int[][] inputB = {{74,-5,10},{17,19,3},{0,7,-2},{29,5,11}};
		int[][] expectedOutput = {{74,-1,10},{71,19,4},{7,7,-2},{92,5,19}};
		
		numberOfTests++;
		int[][] result = TwoDArrayProblems.findMaxValues(inputA, inputB);
		String incorrectAnsMsg = "\n" + "expected: " + Arrays.deepToString(expectedOutput) + "\n  but was: "
				+ Arrays.deepToString(result);
		assertTrue(incorrectAnsMsg, Arrays.deepEquals(result, expectedOutput));
		testsPassed++;
	} // testFindMaxValuesN02
	
	@Test
	public void testFindMaxValuesN03() {
		int[][] inputA = {{47,-11,101}};
		int[][] inputB = {{74,-51,101}};
		int[][] expectedOutput = {{74,-11,101}};
				
		numberOfTests++;
		int[][] result = TwoDArrayProblems.findMaxValues(inputA, inputB);
		String incorrectAnsMsg = "\n" + "expected: " + Arrays.deepToString(expectedOutput) + "\n  but was: "
				+ Arrays.deepToString(result);
		assertTrue(incorrectAnsMsg, Arrays.deepEquals(result, expectedOutput));
		testsPassed++;
	} // testFindMaxValuesN03
	
	@Test
	public void testFindMaxValuesN04() {
		int[][] inputA = {{}};
		int[][] inputB = {{}};
		int[][] expectedOutput = {{}};
				
		numberOfTests++;
		int[][] result = TwoDArrayProblems.findMaxValues(inputA, inputB);
		String incorrectAnsMsg = "\n" + "expected: " + Arrays.deepToString(expectedOutput) + "\n  but was: "
				+ Arrays.deepToString(result);
		assertTrue(incorrectAnsMsg, Arrays.deepEquals(result, expectedOutput));
		testsPassed++;
	} // testFindMaxValuesN04

}
