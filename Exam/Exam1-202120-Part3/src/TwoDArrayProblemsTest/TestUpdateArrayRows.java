package TwoDArrayProblemsTest;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import TwoDArrayProblems.RunAllTests;
import TwoDArrayProblems.TwoDArrayProblems;

public class TestUpdateArrayRows {
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
		String className = TestUpdateArrayRows.class.getSimpleName();
		RunAllTests.outputResults(testsPassed, numberOfTests, className);
	} // oneTimeTearDown

	// --------------------------------------------
	// JUnit Tests
	// --------------------------------------------
	
	@Test
	public void testUpdateArrayRowsN01() {
		char[][] inputA =  {{'a','b','c'},{'a','b','c'},{'x','y','z'},{'q','r','s'}};
		char[][] expectedOutput = {{'-','-','-'},{'a','b','c'},{'-','-','-'},{'q','r','s'}};
		char newC = '-';
		
		numberOfTests++;
		TwoDArrayProblems.updateArrayRows(inputA, newC);		
		String incorrectAnsMsg = "\n" + "expected: " + Arrays.deepToString(expectedOutput) + "\n  but was: " + Arrays.deepToString(inputA);
		assertTrue(incorrectAnsMsg, Arrays.deepEquals(inputA, expectedOutput));
		testsPassed++;
	} // testUpdateArrayRowsN01

	@Test
	public void testUpdateArrayRowsN02() {
		char[][] inputA = {{'a','b','c'}};
		char[][] expectedOutput = {{'-','-','-'}};
		char newC = '-';
		
		numberOfTests++;
		TwoDArrayProblems.updateArrayRows(inputA, newC);		
		String incorrectAnsMsg = "\n" + "expected: " + Arrays.deepToString(expectedOutput) + "\n  but was: " + Arrays.deepToString(inputA);
		assertTrue(incorrectAnsMsg, Arrays.deepEquals(inputA, expectedOutput));
		testsPassed++;
	} // testUpdateArrayRowsN02
	
	@Test
	public void testUpdateArrayRowsN03() {
		char[][] inputA =  {{'a','b','c','a'},{'b','c','x','y'},{'z','q','r','s'}};
		char[][] expectedOutput = {{'X','X','X','X'},{'b','c','x','y'},{'X','X','X','X'}};
		char newC = 'X';
		
		numberOfTests++;
		TwoDArrayProblems.updateArrayRows(inputA, newC);				
		String incorrectAnsMsg = "\n" + "expected: " + Arrays.deepToString(expectedOutput) + "\n  but was: " + Arrays.deepToString(inputA);
		assertTrue(incorrectAnsMsg, Arrays.deepEquals(inputA, expectedOutput));
		testsPassed++;
	} // testUpdateArrayRowsN03
	
	
	@Test
	public void testUpdateArrayRowsN04() {
		char[][] inputA =  {{}};
		char[][] expectedOutput = {{}};
		char newC = 'X';
		
		numberOfTests++;
		TwoDArrayProblems.updateArrayRows(inputA, newC);		
		String incorrectAnsMsg = "\n" + "expected: " + Arrays.deepToString(expectedOutput) + "\n  but was: " + Arrays.deepToString(inputA);
		assertTrue(incorrectAnsMsg, Arrays.deepEquals(inputA, expectedOutput));
		testsPassed++;
	} // testUpdateArrayRowsN04

}
