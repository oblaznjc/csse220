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

public class TestFindCities {

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
		String className = TestFindCities.class.getSimpleName();
		RunAllTests.outputResults(testsPassed, numberOfTests, className);
	} // oneTimeTearDown

	// --------------------------------------------
	// Helper operations
	// --------------------------------------------

	private static HashMap<String, Integer> initMap() {
//		String cityNames[] = { "Beijing", "Buenos Aires", "Chicago", "Los Angeles", "Mumbai", "Nairobi", "Riyadh" };
//		Integer cityPopulation[] = { 20463, 15057, 8865, 12447, 20411, 4735, 7231 };

		@SuppressWarnings("serial")
		HashMap<String, Integer> m = new HashMap<String, Integer>() {
			{
				put("Beijing", 20463);
				put("Buenos Aires", 15057);
				put("Chicago", 8865);
				put("Los Angeles", 12447);
				put("Mumbai", 20411);
				put("Nairobi", 4735);
				put("Riyadh", 7231);
			}
		};
		return m;
	}

	private static boolean checkResult(ArrayList<String> answer, ArrayList<String> answerToCheck) {
		boolean soFarSoGood = true;
		while (soFarSoGood && (answerToCheck.size() > 0)) {
			soFarSoGood = answer.remove(answerToCheck.remove(0));
		} // end while
		return soFarSoGood && (answer.size() == 0) && (answerToCheck.size() == 0);
	} // checkResult

	// --------------------------------------------
	// JUnit Tests
	// --------------------------------------------

	@Test
	public void testFindCitiesN01() {
		HashMap<String, Integer> myMap = initMap();
		// ----------------------------------------
		// Find 3 cities
		// ----------------------------------------
		ArrayList<String> correctAnswer = new ArrayList<String>(Arrays.asList("Beijing", "Buenos Aires", "Mumbai"));


		numberOfTests++;
		ArrayList<String> result = MapProblems.findCities(myMap, 15000);
		String errorMsgWhenIncorrectResult = "\n" + "expected:" + correctAnswer.toString() + " but was: " + result;
		assertTrue(errorMsgWhenIncorrectResult, checkResult(correctAnswer, result));
		assertTrue("expected: map to not be changed", myMap.equals(initMap()));
		testsPassed++;
	} // testFindCitiesN01

	@Test
	public void testFindCitiesN02() {
		HashMap<String, Integer> myMap = initMap();
		// ----------------------------------------
		// Find 0 cities
		// ----------------------------------------
		ArrayList<String> correctAnswer = new ArrayList<String>();

		numberOfTests++;
		ArrayList<String> result = MapProblems.findCities(myMap, 25000);
		String incorrectAnsMsg = "\n" + "expected:" + correctAnswer.toString() + " but was: " + result;
		assertTrue(incorrectAnsMsg, checkResult(correctAnswer, result));
		assertTrue("expected: map to not be changed", myMap.equals(initMap()));
		testsPassed++;
	} // testFindCitiesN02

	@Test
	public void testFindCitiesN03() {
		HashMap<String, Integer> myMap = initMap();
		// ----------------------------------------
		// Find all cities
		// ----------------------------------------
		ArrayList<String> correctAnswer = new ArrayList<String>(
				Arrays.asList("Beijing", "Buenos Aires", "Chicago", "Los Angeles", "Mumbai", "Nairobi", "Riyadh"));

		numberOfTests++;
		ArrayList<String> result = MapProblems.findCities(myMap, 1000);
		String incorrectAnsMsg = "\n" + "expected:" + correctAnswer.toString() + " but was: " + result;
		assertTrue(incorrectAnsMsg, checkResult(correctAnswer, result));
		assertTrue("expected: map to not be changed", myMap.equals(initMap()));
		testsPassed++;
	} // testFindCitiesN03

	@Test
	public void testFindCitiesN04() {
		HashMap<String, Integer> myMap = initMap();
		// ----------------------------------------
		// Find city with largest population (Beijing) by using exact population of that city
		// ----------------------------------------
		ArrayList<String> correctAnswer = new ArrayList<String>(Arrays.asList("Beijing"));

		numberOfTests++;
		ArrayList<String> result = MapProblems.findCities(myMap, 20463);
		String incorrectAnsMsg = "\n" + "expected:" + correctAnswer.toString() + " but was: " + result;
		assertTrue(incorrectAnsMsg, checkResult(correctAnswer, result));
		assertTrue("expected: map to not be changed", myMap.equals(initMap()));
		testsPassed++;
	} // testFindCitiesN04

}
