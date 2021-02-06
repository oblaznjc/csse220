import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import org.junit.Test;

public class SmallProblemsTest {
	
	//*******************************
	//     test for greaterSum
	//*******************************
	@Test
	public void testGreaterSum() {
		String expectFirst = "first";
		String expectSecond = "second";
		
		int[] first = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] second = {2, 2, 2};
		assertEquals(expectFirst, SmallProblems.greaterSum(first, second));
		
		first = new int[] {1, 2, 3, 4};
		second = new int[] {5, 6, 7};
		assertEquals(expectSecond, SmallProblems.greaterSum(first, second));
		
		first = new int[] {1, 1, 1, 1};
		second = new int[] {1, 1, 1};
		assertEquals(expectFirst, SmallProblems.greaterSum(first, second));
		
		first = new int[] {1, 1, 1};
		second = new int[] {1, 1, 1, 1};
		assertEquals(expectSecond, SmallProblems.greaterSum(first, second));
		
		first = new int[] {0};
		second = new int[] {1};
		assertEquals(expectSecond, SmallProblems.greaterSum(first, second));
		
		first = new int[] {1};
		second = new int[] {0};
		assertEquals(expectFirst, SmallProblems.greaterSum(first, second));
		
		
		//big tests
		first = new int[100];
		second = new int[100];
		for(int i = 0; i < 100; i++) {
			first[i] = i;
			second[i] = -i;
		}
		assertEquals(expectFirst, SmallProblems.greaterSum(first, second));
		
		for(int i = 0; i < 100; i++) {
			first[i] = -i;
			second[i] = i;
		}
		assertEquals(expectSecond, SmallProblems.greaterSum(first, second));
		
		for(int i = 0; i < 99; i++) {
			first[i] = i;
			second[i] = i;
		}
		first[99] = 1;
		second[99] = 0;
		assertEquals(expectFirst, SmallProblems.greaterSum(first, second));
		
		
		first[99] = 0;
		second[99] = 1;
		assertEquals(expectSecond, SmallProblems.greaterSum(first, second));
	}
	
	
	
	
	//*******************************
	//     test for appearsXTimes
	//*******************************
	@Test
	public void testAppearsXTimes() {
		
		String[] input = {"hello", "there", "this", "is", "a", "sentence", "and", "hello", "is", 
				          "a", "word", "so", "hello", "sentence"};
		
		int numTimesToFind = 4;
		String[] expArray = {};
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList(expArray));
		Collections.sort(expected);
		ArrayList<String> actual = SmallProblems.appearsXTimes(input, numTimesToFind);
		Collections.sort(actual);
		assertEquals(expected, actual);
		
		numTimesToFind = 3;
		expArray = new String[] {"hello"};
		expected = new ArrayList<String>(Arrays.asList(expArray));
		Collections.sort(expected);
		actual = SmallProblems.appearsXTimes(input, numTimesToFind);
		Collections.sort(actual);
		assertEquals(expected, actual);
		
		numTimesToFind = 2;
		expArray = new String[] {"is", "a", "sentence"};
		expected = new ArrayList<String>(Arrays.asList(expArray));
		Collections.sort(expected);
		actual = SmallProblems.appearsXTimes(input, numTimesToFind);
		Collections.sort(actual);
		assertEquals(expected, actual);
		
		numTimesToFind = 1;
		expArray = new String[] {"there", "this", "and", "word", "so"};
		expected = new ArrayList<String>(Arrays.asList(expArray));
		Collections.sort(expected);
		actual = SmallProblems.appearsXTimes(input, numTimesToFind);
		Collections.sort(actual);
		assertEquals(expected, actual);
		
		
		
		input = new String[] {"a", "b", "c", "a", "b", "a", "abc", "abc", "abc", "abc", "bc", "cb", "ab", "ab", "ba"};
		
		numTimesToFind = 5;
		expArray = new String[] {};
		expected = new ArrayList<String>(Arrays.asList(expArray));
		Collections.sort(expected);
		actual = SmallProblems.appearsXTimes(input, numTimesToFind);
		Collections.sort(actual);
		assertEquals(expected, actual);
		
		numTimesToFind = 4;
		expArray = new String[] {"abc"};
		expected = new ArrayList<String>(Arrays.asList(expArray));
		Collections.sort(expected);
		actual = SmallProblems.appearsXTimes(input, numTimesToFind);
		Collections.sort(actual);
		assertEquals(expected, actual);
		
		numTimesToFind = 3;
		expArray = new String[] {"a"};
		expected = new ArrayList<String>(Arrays.asList(expArray));
		Collections.sort(expected);
		actual = SmallProblems.appearsXTimes(input, numTimesToFind);
		Collections.sort(actual);
		assertEquals(expected, actual);
		
		numTimesToFind = 2;
		expArray = new String[] {"b", "ab"};
		expected = new ArrayList<String>(Arrays.asList(expArray));
		Collections.sort(expected);
		actual = SmallProblems.appearsXTimes(input, numTimesToFind);
		Collections.sort(actual);
		assertEquals(expected, actual);
		
		numTimesToFind = 1;
		expArray = new String[] {"c", "bc", "cb", "ba"};
		expected = new ArrayList<String>(Arrays.asList(expArray));
		Collections.sort(expected);
		actual = SmallProblems.appearsXTimes(input, numTimesToFind);
		Collections.sort(actual);
		assertEquals(expected, actual);
		
		
		input = new String[] {"1", "1", "1"};
		
		numTimesToFind = 3;
		expArray = new String[] {"1"};
		expected = new ArrayList<String>(Arrays.asList(expArray));
		Collections.sort(expected);
		actual = SmallProblems.appearsXTimes(input, numTimesToFind);
		Collections.sort(actual);
		assertEquals(expected, actual);
		
		numTimesToFind = 2;
		expArray = new String[] {};
		expected = new ArrayList<String>(Arrays.asList(expArray));
		Collections.sort(expected);
		actual = SmallProblems.appearsXTimes(input, numTimesToFind);
		Collections.sort(actual);
		assertEquals(expected, actual);
		
		numTimesToFind = 1;
		expArray = new String[] {};
		expected = new ArrayList<String>(Arrays.asList(expArray));
		Collections.sort(expected);
		actual = SmallProblems.appearsXTimes(input, numTimesToFind);
		Collections.sort(actual);
		assertEquals(expected, actual);
		
		
		input = new String[] {"1", "1"};
		
		numTimesToFind = 2;
		expArray = new String[] {"1"};
		expected = new ArrayList<String>(Arrays.asList(expArray));
		Collections.sort(expected);
		actual = SmallProblems.appearsXTimes(input, numTimesToFind);
		Collections.sort(actual);
		assertEquals(expected, actual);
		
		numTimesToFind = 1;
		expArray = new String[] {};
		expected = new ArrayList<String>(Arrays.asList(expArray));
		Collections.sort(expected);
		actual = SmallProblems.appearsXTimes(input, numTimesToFind);
		Collections.sort(actual);
		assertEquals(expected, actual);
		
		
		
		input = new String[] {"1"};
		
		numTimesToFind = 2;
		expArray = new String[] {};
		expected = new ArrayList<String>(Arrays.asList(expArray));
		Collections.sort(expected);
		actual = SmallProblems.appearsXTimes(input, numTimesToFind);
		Collections.sort(actual);
		assertEquals(expected, actual);
		
		numTimesToFind = 1;
		expArray = new String[] {"1"};
		expected = new ArrayList<String>(Arrays.asList(expArray));
		Collections.sort(expected);
		actual = SmallProblems.appearsXTimes(input, numTimesToFind);
		Collections.sort(actual);
		assertEquals(expected, actual);
		
		
		
		//big tests
		input = new String[500];
		int num = 0;
		int count = 1;
		int ind = 0;
		int round = 10;
		HashMap<Integer, ArrayList<String>> countToList = new HashMap<Integer, ArrayList<String>>();
		while(ind < 500) {
			if(count > round) 	
				count = 1;
			
			int numActual = 0;
			for(int i = 0; i < count && ind < 500; i++) {
				input[ind++] = ""+num;
				numActual++;
			}
			if(countToList.containsKey(numActual)) 
				countToList.get(numActual).add(""+num);
			else {
				ArrayList<String> newList = new ArrayList<String>();
				newList.add(""+num);
				countToList.put(numActual, newList);
			}
			count++;
			num++;
		}
		
		for(int i = 1; i <= round; i++) {
			numTimesToFind = i;
			//expArray = new String[] {"1"};
			expected = countToList.get(i);
			Collections.sort(expected);
			actual = SmallProblems.appearsXTimes(input, numTimesToFind);
			Collections.sort(actual);
			assertEquals(expected, actual);
		}
		
		numTimesToFind = round+1;
		expArray = new String[] {};
		expected = new ArrayList<String>(Arrays.asList(expArray));
		Collections.sort(expected);
		actual = SmallProblems.appearsXTimes(input, numTimesToFind);
		Collections.sort(actual);
		assertEquals(expected, actual);
	}
	
	
	
	
	//*******************************
	//     test for replaceXTimes 
	//*******************************
	@Test
	public void testReplaceXTimes() {
		String input = "abcdefabcabcabcabc";
		char toFind = 'a';
		char replaceWith = 'z';
		int maxTimes = 1;
		
		String expected = "zbcdefabcabcabcabc";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		maxTimes = 2;
		expected = "zbcdefzbcabcabcabc";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 3;
		expected = "zbcdefzbczbcabcabc";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 4;
		expected = "zbcdefzbczbczbcabc";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 5;
		expected = "zbcdefzbczbczbczbc";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 6;
		expected = "zbcdefzbczbczbczbc";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		
		maxTimes = 1;
		toFind = 'b';
		expected = "azcdefabcabcabcabc";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 2;
		expected = "azcdefazcabcabcabc";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 3;
		expected = "azcdefazcazcabcabc";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 4;
		expected = "azcdefazcazcazcabc";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 5;
		expected = "azcdefazcazcazcazc";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 6;
		expected = "azcdefazcazcazcazc";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		
		
		maxTimes = 1;
		toFind = 'c';
		expected = "abzdefabcabcabcabc";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 2;
		expected = "abzdefabzabcabcabc";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 3;
		expected = "abzdefabzabzabcabc";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 4;
		expected = "abzdefabzabzabzabc";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 5;
		expected = "abzdefabzabzabzabz";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 6;
		expected = "abzdefabzabzabzabz";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		
		
		
		input = "12311122233";
		toFind = '1'; 
		replaceWith = 'X'; 
		maxTimes = 1; 
		expected = "X2311122233";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 2; 
		expected = "X23X1122233";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 3; 
		expected = "X23XX122233";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 4; 
		expected = "X23XXX22233";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		maxTimes = 5; 
		expected = "X23XXX22233";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		
		toFind = '2';  
		maxTimes = 1; 
		expected = "1X311122233";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 2; 
		expected = "1X3111X2233";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 3; 
		expected = "1X3111XX233";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 4; 
		expected = "1X3111XXX33";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 5; 
		expected = "1X3111XXX33";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		
		
		toFind = '3';  
		maxTimes = 1; 
		expected = "12X11122233";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 2; 
		expected = "12X111222X3";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 3; 
		expected = "12X111222XX";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 4; 
		expected = "12X111222XX";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		input = "11111";
		replaceWith = 'Y';
		toFind = '1';
		maxTimes = 1;
		expected = "Y1111";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 2;
		expected = "YY111";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 3;
		expected = "YYY11";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 4;
		expected = "YYYY1";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 5;
		expected = "YYYYY";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		maxTimes = 6;
		expected = "YYYYY";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		
		maxTimes = 1;
		toFind = '2';
		expected = "11111";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		maxTimes = 2;
		toFind = '2';
		expected = "11111";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		input = "A";
		replaceWith = 'B';
		toFind = 'A';
		maxTimes = 1;
		expected = "B";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		toFind = 'A';
		maxTimes = 2;
		expected = "B";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		toFind = 'B';
		maxTimes = 1;
		expected = "A";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
		
		
		toFind = 'C';
		maxTimes = 1;
		expected = "A";
		assertEquals(expected, SmallProblems.replaceXTimes(input, toFind, replaceWith, maxTimes));
	}
	
	
	
	
	//*******************************
	//     test for mergeSorted 
	//*******************************
	@Test
	public void testMergeSorted() {
		int[] first = {1, 3, 5, 7, 9, 11};
		int[] second = {2, 4, 6, 8, 10, 12, 14, 16, 18};
		int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 16, 18};
		assertArrayEquals(expected, SmallProblems.mergeSorted(first, second));
		
		first = new int[] {2, 4, 6, 8, 10, 12, 14, 16, 18};
		second = new int[] {1, 3, 5, 7, 9, 11};
		expected = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 16, 18};
		assertArrayEquals(expected, SmallProblems.mergeSorted(first, second));
		
		
		first = new int[] {10, 50, 100};
		second = new int[] {9, 11, 13, 15, 30, 75, 500};
		expected = new int[] {9, 10, 11, 13, 15, 30, 50, 75, 100, 500};
		assertArrayEquals(expected, SmallProblems.mergeSorted(first, second));
		
		first = new int[] {9, 11, 13, 15, 30, 75, 500};
		second = new int[] {10, 50, 100};
		expected = new int[] {9, 10, 11, 13, 15, 30, 50, 75, 100, 500};
		assertArrayEquals(expected, SmallProblems.mergeSorted(first, second));
		
		
		first = new int[] {1, 2, 3, 4, 5};
		second = new int[] {10, 11, 12, 13, 14, 15};
		expected = new int[] {1, 2, 3, 4, 5, 10, 11, 12, 13, 14, 15};
		assertArrayEquals(expected, SmallProblems.mergeSorted(first, second));
		
		first = new int[] {10, 11, 12, 13, 14, 15};
		second = new int[] {1, 2, 3, 4, 5};
		expected = new int[] {1, 2, 3, 4, 5, 10, 11, 12, 13, 14, 15};
		assertArrayEquals(expected, SmallProblems.mergeSorted(first, second));
		
		
		
		first = new int[] {1};
		second = new int[] {3};
		expected = new int[] {1, 3};
		assertArrayEquals(expected, SmallProblems.mergeSorted(first, second));
		
		first = new int[] {3};
		second = new int[] {1};
		expected = new int[] {1, 3};
		assertArrayEquals(expected, SmallProblems.mergeSorted(first, second));
		
		
		
		//big tests
		first = new int[100];
		int firstInd = 0;
		second = new int[100];
		int secondInd = 0;
		expected = new int[200];
		for(int i = 0; i < 200; i++) {
			if(i%2==0)
				first[firstInd++] = i;
			else
				second[secondInd++] = i;
			
			expected[i] = i;
		}
		assertArrayEquals(expected, SmallProblems.mergeSorted(first, second));
		
		
		first = new int[100];
		firstInd = 0;
		second = new int[100];
		secondInd = 0;
		expected = new int[200];
		for(int i = 0; i < 200; i++) {
			if(i%2==0)
				second[secondInd++] = i;
			else
				first[firstInd++] = i;
				
			
			expected[i] = i;
		}
		assertArrayEquals(expected, SmallProblems.mergeSorted(first, second));
		
		
		first = new int[50];
		firstInd = 0;
		second = new int[100];
		secondInd = 0;
		expected = new int[150];
		for(int i = 0; i < 150; i++) {
			expected[i] = i;
			if(firstInd > 49) {
				second[secondInd++] = i;
				continue;
			}
			
			if(i%2==0)
				first[firstInd++] = i;
			else
				second[secondInd++] = i;
		}
		assertArrayEquals(expected, SmallProblems.mergeSorted(first, second));
		
		first = new int[50];
		firstInd = 0;
		second = new int[100];
		secondInd = 0;
		expected = new int[150];
		for(int i = 0; i < 150; i++) {
			expected[i] = i;
			if(firstInd > 49) {
				second[secondInd++] = i;
				continue;
			}
			
			if(i%2==0)
				second[secondInd++] = i;
			else
				first[firstInd++] = i;
				
		}
		assertArrayEquals(expected, SmallProblems.mergeSorted(first, second));
		
		
		
		first = new int[100];
		firstInd = 0;
		second = new int[50];
		secondInd = 0;
		expected = new int[150];
		for(int i = 0; i < 150; i++) {
			expected[i] = i;
			if(secondInd > 49) {
				first[firstInd++] = i;
				continue;
			}
			
			if(i%2==0)
				first[firstInd++] = i;
			else
				second[secondInd++] = i;
		}
		assertArrayEquals(expected, SmallProblems.mergeSorted(first, second));
		
		first = new int[100];
		firstInd = 0;
		second = new int[50];
		secondInd = 0;
		expected = new int[150];
		for(int i = 0; i < 150; i++) {
			expected[i] = i;
			if(secondInd > 49) {
				first[firstInd++] = i;
				continue;
			}
			
			if(i%2==0)
				second[secondInd++] = i;
			else
				first[firstInd++] = i;
		}
		assertArrayEquals(expected, SmallProblems.mergeSorted(first, second));
	}
}
