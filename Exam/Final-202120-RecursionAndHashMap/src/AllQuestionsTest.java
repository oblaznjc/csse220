import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;


public class AllQuestionsTest {
	
	@Test
	public void testUpdatePhoneBook() {
		HashMap<String, ArrayList<String>> phonebook = new HashMap<String, ArrayList<String>>();
		String[] namesToStart = {"John Smith", "Anne Jones", "Stacy Jones"};
		String[][] numbersToStart = {{"111-1111", "222-2222"},
									 {"333-3333"},
									 {"444-4444", "555-5555", "777-7777"}};
		for(int i = 0; i < namesToStart.length; i++) {
			phonebook.put(namesToStart[i], new ArrayList<String>(Arrays.asList(numbersToStart[i])));
		}
		
		String[] names = {"John Smith", "Alex Davies", "Anne Jones", "Anne Jones", "John Smith", 
							"Taylor Swift", "Taylor Swift", "Stacy Jones", "Stacy Jones", "Stacy Jones"};
		String[] newNumbers = {"888-8888", "999-9999", "000-0000", "123-1234", "987-9876", "121-2121", 
								"787-8787",	"444-4444", "555-5555", "030-3030"};
		
		HashMap<String, ArrayList<String>> expectedPhonebook = new HashMap<String, ArrayList<String>>();
		String[] expectedNames = {"John Smith", "Anne Jones", "Stacy Jones", "Alex Davies", "Taylor Swift"};
		String[][] expectedNumbers = {{"111-1111", "222-2222", "888-8888", "987-9876"},
				                      {"333-3333", "000-0000", "123-1234"},
				                      {"444-4444", "555-5555", "777-7777", "030-3030"},
				                      {"999-9999"},
				                      {"121-2121", "787-8787"}};
		
		for(int i = 0; i < expectedNames.length; i++) {
			expectedPhonebook.put(expectedNames[i], new ArrayList<String>(Arrays.asList(expectedNumbers[i])));
		}
		
		AllQuestions.updatePhoneBook(phonebook, names, newNumbers);
		
		assertEquals(expectedPhonebook, phonebook);
		
		
		
		
		phonebook = new HashMap<String, ArrayList<String>>();
		namesToStart = new String[]{"A", "B", "C", "D", "E"};
		numbersToStart = new String[][]{{"1", "2"},
				 				        {"3"},
				 				        {"4"},
				 				        {"5", "6", "7"},
				 				        {"8", "9"}};
				 				        
		for(int i = 0; i < namesToStart.length; i++) {
			phonebook.put(namesToStart[i], new ArrayList<String>(Arrays.asList(numbersToStart[i])));
		}
		
		names = new String[] {"A", "A", "A", "B", "B", "C", "F", "F", "F", "G", "G", "H", "H", "H", "I"};
		newNumbers = new String[] {"1", "11", "111", "3", "33", "44", "0", "00", "000", "123", "321", "999", "999", "999", "1234567890"};
		
		expectedPhonebook = new HashMap<String, ArrayList<String>>();
		expectedNames = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
		expectedNumbers = new String[][] {{"1", "2", "11", "111"},
		        						  {"3", "33"},
		        						  {"4", "44"},
		        						  {"5", "6", "7"},
		        						  {"8", "9"},
		        						  {"0", "00", "000"},
		        						  {"123", "321"},
		        						  {"999"},
		        						  {"1234567890"}};
		for(int i = 0; i < expectedNames.length; i++) {
			expectedPhonebook.put(expectedNames[i], new ArrayList<String>(Arrays.asList(expectedNumbers[i])));
		}	
		
		AllQuestions.updatePhoneBook(phonebook, names, newNumbers);
		
		assertEquals(expectedPhonebook, phonebook);
	}
	
	@Test
	public void testMostCommonDigit() {
		HashMap<String, String> input = new HashMap<String, String>();
		String[] keys = {"A", "B", "1"};
		String[] values = {"11111111111", "123", "12"};
		for(int i = 0; i < keys.length; i++) {
			input.put(keys[i],  values[i]);
		}
		
		assertEquals(1, AllQuestions.mostCommonDigit(input));
		
		
		
		input = new HashMap<String, String>();
		keys = new String[]{"A", "B", "1"};
		values = new String[] {"012", "01", "0"};
		for(int i = 0; i < keys.length; i++) {
			input.put(keys[i],  values[i]);
		}
		
		assertEquals(0, AllQuestions.mostCommonDigit(input));
		
		
		input = new HashMap<String, String>();
		keys = new String[]{"A", "B", "C", "D"};
		values = new String[] {"11111", "22222", "33333", "444444"};
		for(int i = 0; i < keys.length; i++) {
			input.put(keys[i],  values[i]);
		}
		
		assertEquals(4, AllQuestions.mostCommonDigit(input));
		
		
		//Testing that it does not count non-digits with 2 digits
		input = new HashMap<String, String>();
		keys = new String[]{"A", "B", "C", "D"};
		values = new String[] {"aaaaaa", "aaaaaa", "aaaaaaa", "aaaaaa11"};
		for(int i = 0; i < keys.length; i++) {
			input.put(keys[i],  values[i]);
		}
		
		assertEquals(1, AllQuestions.mostCommonDigit(input));
		
		
		//Testing that it does not count non-digits with 1 digit
		input = new HashMap<String, String>();
		keys = new String[]{"A", "B", "C", "D"};
		values = new String[] {"aaaaaa", "aaaaaa", "aaaaaaa", "aaaaaa1"};
		for(int i = 0; i < keys.length; i++) {
			input.put(keys[i],  values[i]);
		}
		
		assertEquals(1, AllQuestions.mostCommonDigit(input));
		
		
		//Testing that it does not count non-digits with 1 digit
		input = new HashMap<String, String>();
		keys = new String[]{"A", "B", "C", "D"};
		values = new String[] {"aaaaaa1", "aaaaaa", "aaaaaaa", "aaaaaa"};
		for(int i = 0; i < keys.length; i++) {
			input.put(keys[i],  values[i]);
		}
		
		assertEquals(1, AllQuestions.mostCommonDigit(input));
		
		
		input = new HashMap<String, String>();
		keys = new String[]{"A", "B", "C", "D"};
		values = new String[] {"aaaaaa1234", "aaaaaa123", "aaaaaaa12", "aaaaaa1"};
		for(int i = 0; i < keys.length; i++) {
			input.put(keys[i],  values[i]);
		}
		
		assertEquals(1, AllQuestions.mostCommonDigit(input));
		
		
		input = new HashMap<String, String>();
		keys = new String[]{"A", "B", "C", "D"};
		values = new String[] {"1", "2", "3", "1"};
		for(int i = 0; i < keys.length; i++) {
			input.put(keys[i],  values[i]);
		}
		
		assertEquals(1, AllQuestions.mostCommonDigit(input));
	}

	@Test
	public void testPairedDiff() {
		//Test 1
		Integer[] inputArray = {1, 2, 3, 4, 5, 5, 4, 3, 2, 1};
		ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(inputArray));
		
		assertEquals(0, AllQuestions.pairedDiff(input));
		
		
		//Test 2
		inputArray = new Integer[] {1, 2, 3, 4, 20, 8, 13, 15};
		input = new ArrayList<Integer>(Arrays.asList(inputArray));
		
		assertEquals(3, AllQuestions.pairedDiff(input));
		
		
		//Test 3
		inputArray = new Integer[] {22, 12, 35, 100, 101, 30, 27, 11};
		input = new ArrayList<Integer>(Arrays.asList(inputArray));
		
		assertEquals(2, AllQuestions.pairedDiff(input));
		
		
		//Big test 1 (adds 101 pairs of the same number to the array)
		//should result in a count of 0
		input = new ArrayList<Integer>();
		for(int i = 100; i >= 0; i--) {
			input.add(0, i);
			input.add(i);
		}
		
		assertEquals(0, AllQuestions.pairedDiff(input));
		
		
		//Big test 2 (adds 101 pairs of numbers that differ by 10 exactly)
		input = new ArrayList<Integer>();
		for(int i = 100; i >= 0; i--) {
			input.add(0, i+10);
			input.add(i);
		}
		
		assertEquals(101, AllQuestions.pairedDiff(input));
		
		
		//Big test 3 (adds 101 pairs of numbers that differ by 10 exactly)
		input = new ArrayList<Integer>();
		for(int i = 100; i >= 0; i--) {
			input.add(0, i-10);
			input.add(i);
		}
		
		assertEquals(101, AllQuestions.pairedDiff(input));
		
		
		//Big test 4 (adds 101 pairs of numbers that differ by 100 exactly)
		input = new ArrayList<Integer>();
		for(int i = 100; i >= 0; i--) {
			input.add(0, i+100);
			input.add(i);
		}
		
		assertEquals(101, AllQuestions.pairedDiff(input));
		
		
		//Big test 5 (adds 101 pairs of numbers that differ by 100 exactly)
		input = new ArrayList<Integer>();
		for(int i = 100; i >= 0; i--) {
			input.add(0, i-100);
			input.add(i);
		}
		
		assertEquals(101, AllQuestions.pairedDiff(input));
		
		
		//Big test 6 (adds 100 pairs of numbers, of which half will differ
		//by exactly 10)
		input = new ArrayList<Integer>();
		for(int i = 99; i >= 0; i--) {
			if(i%2 == 0)
				input.add(0, i+10);
			else
				input.add(0, i);
			input.add(i);
		}
		
		assertEquals(50, AllQuestions.pairedDiff(input));
		
		
		//Big test 7 (adds 100 pairs of numbers, of which half will differ
		//by exactly 10)
		input = new ArrayList<Integer>();
		for(int i = 99; i >= 0; i--) {
			if(i%2 == 0)
				input.add(0, i-10);
			else
				input.add(0, i);
			input.add(i);
		}
		
		assertEquals(50, AllQuestions.pairedDiff(input));
		
		
		//Big test 8 (adds 100 pairs of numbers, of which half will differ
		//by exactly 100)
		input = new ArrayList<Integer>();
		for(int i = 99; i >= 0; i--) {
			if(i%2 == 0)
				input.add(0, i+100);
			else
				input.add(0, i);
			input.add(i);
		}
		
		assertEquals(50, AllQuestions.pairedDiff(input));
		
		
		//Big test 9 (adds 100 pairs of numbers, of which half will differ
		//by exactly 100)
		input = new ArrayList<Integer>();
		for(int i = 99; i >= 0; i--) {
			if(i%2 == 0)
				input.add(0, i-100);
			else
				input.add(0, i);
			input.add(i);
		}
		
		assertEquals(50, AllQuestions.pairedDiff(input));
	}
	
	
	// **************************************************************
	// Test: highestZeroSum
	// **************************************************************
	@Test
	public void testHighestZeroSum() {
		
		//edge cases
		int[] testInput = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		assertEquals(45, AllQuestions.highestZeroSum(testInput));
		
		testInput = new int[] {0, 1, 0};
		assertEquals(1, AllQuestions.highestZeroSum(testInput));
		
		testInput = new int[] {0, 1, 0, 2, 0, 3, 0};
		assertEquals(3, AllQuestions.highestZeroSum(testInput));
		
		testInput = new int[] {0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0};
		assertEquals(4, AllQuestions.highestZeroSum(testInput));
		
		testInput = new int[] {0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0};
		assertEquals(4, AllQuestions.highestZeroSum(testInput));
		
		testInput = new int[] {0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0};
		assertEquals(4, AllQuestions.highestZeroSum(testInput));
		
		testInput = new int[] {0, 100, 0, 1, 1, 1, 0, 1, 1, 1, 0};
		assertEquals(100, AllQuestions.highestZeroSum(testInput));
		
		testInput = new int[] {0, 1, 1, 1, 0, 100, 0, 1, 1, 1, 0};
		assertEquals(100, AllQuestions.highestZeroSum(testInput));
		
		testInput = new int[] {0, 1, 1, 1, 0, 1, 1, 1, 0, 100, 0};
		assertEquals(100, AllQuestions.highestZeroSum(testInput));
		
		testInput = new int[] {0, 0};
		assertEquals(0, AllQuestions.highestZeroSum(testInput));
		
		testInput = new int[] {0, 1000, 0, 1000, 0, 1000, 0};
		assertEquals(1000, AllQuestions.highestZeroSum(testInput));
	}

}
