package MapProblemsTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import MapProblems.MapProblems;
import MapProblems.RunAllTests;

public class TestUpdateGPA {

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
		String className = TestUpdateGPA.class.getSimpleName();
		RunAllTests.outputResults(testsPassed, numberOfTests, className);
	} // oneTimeTearDown

	// --------------------------------------------
	// Helper operations
	// --------------------------------------------

	private static HashMap<Integer, Double> initMap(Integer IDs[], Double GPAs[]) {

		@SuppressWarnings("serial")
		HashMap<Integer, Double> m = new HashMap<Integer, Double>() {
			{
				for (int k = 0, z = IDs.length; k < z; k++) {
					put(IDs[k], GPAs[k]);
				} // end for
			}
		};
		return m;
	} // initMap

	// --------------------------------------------
	// JUnit Tests
	// --------------------------------------------

	@Test
	public void testUpdateGPAN01() {
		// allStudentIDs of students to have GPA modified - 2 students
		ArrayList<Integer> studentIDs = new ArrayList<Integer>(Arrays.asList(6658, 1230));
		
		Integer allStudentIDs[] = { 5242, 1287, 6658, 8046, 6584, 2476, 1230 };
		Double incomingGPAs[] = { 2.3, 1.0, 4.0, 3.8, 2.1, 1.1, 0.75 };
		Double outgoingGPAs[] = { 2.3, 1.0, 4.5, 3.8, 2.1, 1.1, 1.25 };
		HashMap<Integer, Double> myMap = initMap(allStudentIDs, incomingGPAs);
		HashMap<Integer, Double> correctAnswer = initMap(allStudentIDs, outgoingGPAs);

		numberOfTests++;
		MapProblems.updateGPA(myMap, studentIDs);		
		String incorrectAnsMsg = "\n" + "expected: " + correctAnswer.toString() + "\n  but was: " + myMap;
		assertTrue(incorrectAnsMsg, correctAnswer.equals(myMap));
		testsPassed++;
	} // testUpdateGPAN01
	
	@Test
	public void testUpdateGPAN02() {
		// allStudentIDs of students to have GPA modified - zero students
		ArrayList<Integer> studentIDs = new ArrayList<Integer>(Arrays.asList());

		Integer allStudentIDs[] = { 5242, 1287, 6658, 8046, 6584, 2476, 1230 };
		Double incomingGPAs[] = { 2.3, 1.0, 4.0, 3.8, 2.1, 1.1, 0.75 };
		HashMap<Integer, Double> myMap = initMap(allStudentIDs, incomingGPAs);
		HashMap<Integer, Double> correctAnswer = initMap(allStudentIDs, incomingGPAs);

		numberOfTests++;
		MapProblems.updateGPA(myMap, studentIDs);
		String incorrectAnsMsg = "\n" + "expected:" + correctAnswer.toString() + " but was: " + myMap;
		assertTrue(incorrectAnsMsg, correctAnswer.equals(myMap));
		testsPassed++;
	} // testUpdateGPAN02
	
	@Test
	public void testUpdateGPAN03() {
		// allStudentIDs of students to have GPA modified - all students
		ArrayList<Integer> studentIDs = new ArrayList<Integer>(Arrays.asList(5242, 1287, 6658, 8046, 6584, 2476, 1230));

		Integer allStudentIDs[] = { 5242, 1287, 6658, 8046, 6584, 2476, 1230 };
		Double incomingGPAs[] = { 2.3, 1.0, 4.0, 3.8, 2.1, 1.1, 0.75 };
		Double outgoingGPAs[] = { 2.8, 1.5, 4.5, 4.3, 2.6, 1.6, 1.25 };
		HashMap<Integer, Double> myMap = initMap(allStudentIDs, incomingGPAs);
		HashMap<Integer, Double> correctAnswer = initMap(allStudentIDs, outgoingGPAs);

		numberOfTests++;
		MapProblems.updateGPA(myMap, studentIDs);		
		String incorrectAnsMsg = "\n" + "expected: " + correctAnswer.toString() + "\n  but was: " + myMap;
		assertTrue(incorrectAnsMsg, correctAnswer.equals(myMap));
		testsPassed++;
	} // testUpdateGPAN03
	
	@Test
	public void testUpdateGPAN04() {
		// allStudentIDs of students to have GPA modified - no students, no GPAs, no updates
		ArrayList<Integer> studentIDs = new ArrayList<Integer>(Arrays.asList());

		Integer allStudentIDs[] = { };
		Double incomingGPAs[] = { };
		Double outgoingGPAs[] = { };
		HashMap<Integer, Double> myMap = initMap(allStudentIDs, incomingGPAs);
		HashMap<Integer, Double> correctAnswer = initMap(allStudentIDs, outgoingGPAs);

		numberOfTests++;
		MapProblems.updateGPA(myMap, studentIDs);		
		String incorrectAnsMsg = "\n" + "expected: " + correctAnswer.toString() + "\n  but was: " + myMap;
		assertTrue(incorrectAnsMsg, correctAnswer.equals(myMap));
		testsPassed++;
	} // testUpdateGPAN04

}
