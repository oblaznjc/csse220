package MapProblems;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import MapProblemsTest.RunAllTestsSetUp;
import MapProblemsTest.RunAllTestsTearDown;
import MapProblemsTest.TestFindCities;
import MapProblemsTest.TestUpdateGPA;


@RunWith(Suite.class)
@SuiteClasses({RunAllTestsSetUp.class, TestFindCities.class, TestUpdateGPA.class, RunAllTestsTearDown.class})
public class RunAllTests {
	static public int allTestsPassedCount = 0;
	static public int allTestsExecutedCount = 0;
	
	public static void outputResults(int testsPassed, int numberOfTests, String testClassName) {
		double percentagePassed = (double) testsPassed / (double) numberOfTests * 100.0;

		System.out.printf("%5d   %8d   %10.1f%%   %-15s\n", numberOfTests, testsPassed, percentagePassed, testClassName);

		// Add to grand total
		RunAllTests.allTestsPassedCount += testsPassed;
		RunAllTests.allTestsExecutedCount += numberOfTests;
	} // outputResults
}
