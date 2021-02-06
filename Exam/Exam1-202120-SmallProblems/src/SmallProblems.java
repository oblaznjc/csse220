import java.util.ArrayList;
import java.util.Arrays;

public class SmallProblems {

	/*
	 * INSTRUCTIONS: To pass this portion of the exam, you only need to pass all
	 * tests for any three problems. There are 4 total below. If you pass all tests
	 * to all 4 parts, this may be used as a bonus of sorts towards the rest of your
	 * exam grade (e.g., if you were really close to passing a different part, if
	 * you complete all 4 questions below, it may be enough to pass the other part
	 * as well).
	 * 
	 */

	/**
	 * For this problem, you are given two integer arrays named first and second.
	 * You will return the name of the array (e.g., either "first" or "second") that
	 * has the greatest sum of all elements. In other words, you will find the sum
	 * of both arrays, and if the sum of the first is greater, you will return the
	 * string "first". If the sum of the second array is greater, you will return
	 * the string "second". (You will ONLY either return "first" or "second")
	 * 
	 * The arrays will not necessarily be guaranteed to have the same length.
	 * 
	 * You may assume that one array has a higher sum and that you will never see
	 * the case when the two sums are equivalent, i.e., one sum will always be
	 * greater between the two.
	 * 
	 * 
	 * Examples: first = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1} second = {2, 2, 2} The sum
	 * of the first is 10 and the sum of the second is 6. Since the sum of the first
	 * is greater than the second, you will return the string "first".
	 * 
	 * 
	 * first = {1, 2, 3, 4} second = {5, 6, 7} The sum of the first is 10 and the
	 * sum of the second is 18. Since the sum of the second is greater than the
	 * first, you should return the string "second"
	 * 
	 * 
	 * @param first  - the first array
	 * @param second - the second array
	 * @return the string "first" if the sum of elements in first is greater than
	 *         the sum of the elements in second. Return "second" otherwise.
	 */
	public static String greaterSum(int[] first, int[] second) {
		int firstSum = 0;
		int secondSum = 0;
		for (int number : first) {
			firstSum = firstSum + number;
		}
		for (int number : second) {
			secondSum = secondSum + number;
		}
		if (firstSum > secondSum) {
			return "first";
		} else {
			return "second";
		}
	}

	/**
	 * In this problem, you are given two arguments: input and numTimesToFind. You
	 * will return an ArrayList of Strings built from the strings in the input. Your
	 * task is to find all the strings in the input array that appear in the array
	 * exactly numTimesToFind times. So, if numTimesToFind were 3, you would build
	 * an ArrayList containing all the strings that appear in input exactly 3 times.
	 * 
	 * The order of the elements you add to the ArrayList do not matter. You can
	 * also assume that numTimesTofind > 0 for every possible call to this method.
	 * 
	 * NOTE: Each string in the ArrayList that you return should only appear ONCE,
	 * i.e., there should be no strings that appear in the returned ArrayList more
	 * than once.
	 * 
	 * NOTE: You may assume that case matters and "HELLO" is not the same string as
	 * "hello"
	 * 
	 * You should be able to solve this without a HashMap, but we will not take any
	 * credit away if you use a HashMap for this problem.
	 * 
	 * 
	 * Examples: input = {"hello", "there", "this", "is", "a", "sentence", "and",
	 * "hello", "is", "a", "word", "so", "hello", "sentence"}
	 * 
	 * We will use the above input in a few examples below:
	 * 
	 * numTimesToFind = 4 -> return an empty ArrayList since no strings appear 4
	 * times
	 * 
	 * numTimesToFind = 3 -> return ArrayList {"hello"} (the only string that
	 * appears 3 times is "hello")
	 * 
	 * numTimesToFind = 2 -> return ArrayList {"is", "a", "sentence"}
	 * 
	 * numTimesToFind = 1 -> return ArrayList {"there", "this", "and", "word", "so"}
	 * 
	 * 
	 * 
	 * input = {"a", "b", "c", "a", "b", "a", "abc", "abc", "abc", "abc", "bc",
	 * "cb", "ab", "ab", "ba"}
	 * 
	 * numTimeToFind = 5 -> return an empty ArrayList since no strings appear 5
	 * times
	 * 
	 * numTimesToFind = 4 -> return ArrayList {"abc"}
	 * 
	 * numTimesToFind = 3 -> return ArrayList {"a"}
	 * 
	 * numTimesToFind = 2 -> return ArrayList {"b", "ab"}
	 * 
	 * numTimesToFind = 1 -> return ArrayList {"c", "bc", "cb", "ba"}
	 * 
	 * 
	 * @param input          - an array of Strings
	 * @param numTimesToFind - the number of times a string should appear to add to
	 *                       the output
	 * @return an ArrayList of Strings that contains the strings that appear in
	 *         input exactly numTimesToFind times
	 */
	public static ArrayList<String> appearsXTimes(String[] input, int numTimesToFind) {
		ArrayList<String> resultList = new ArrayList<String>();
		ArrayList<String> checkedList = new ArrayList<String>();

		for (String string1 : input) {
			if (!checkedList.contains(string1)) {
				checkedList.add(string1);
				int numTimesFound = 0;
				String stringBeingCounted = string1;
				for (String string2 : input) {
					if (string2.equals(stringBeingCounted)) {
						++numTimesFound;
					}
				}
				if (numTimesFound == numTimesToFind) {
					resultList.add(string1);
				}
			}
		}
		return resultList;
	}

	/**
	 * In this problem, you are given 4 parameters: input, toFind, replaceWith and
	 * maxTimes. The simple part is that we want to replace the character in the
	 * input that matches toFind with the character given by replaceWith. The
	 * catch/tough part is that we only want you to do the replace no more than
	 * maxTimes.
	 * 
	 * So, if maxTimes were 3, no matter how many times toFind appears in input, you
	 * should only replace it with the replaceWith character 3 times, leaving the
	 * other cases as is.
	 * 
	 * You can assume that maxTimes >= 0
	 * 
	 * 
	 * Examples: input = "abcdefabcabcabcabc" toFind = 'a', replaceWith = 'z' and
	 * maxTimes = 2 -> return the string "zbcdefzbcabcabcabc" (The first two a's are
	 * replaced with z, but only the first two)
	 * 
	 * 
	 * input = "abcdefabcabcabcabc" toFind = 'a', replaceWith = 'z' and maxTimes = 3
	 * -> return the string "zbcdefzbczbcabcabc"
	 * 
	 * input = "abcdefabcabcabcabc" toFind = 'a', replaceWith = 'z' and maxTimes = 4
	 * -> return the string "zbcdefzbczbczbcabc"
	 * 
	 * input = "abcdefabcabcabcabc" toFind = 'a', replaceWith = 'z' and maxTimes =
	 * 300 -> return the string "zbcdefzbczbczbczbc" (All instances were changed
	 * since there weren't 300 instances of the letter 'a')
	 * 
	 * 
	 * input = "12311122233" toFind = '1', replaceWith = 'X' and maxTimes = 1 ->
	 * return the string "X2311122233"
	 * 
	 * input = "12311122233" toFind = '1', replaceWith = 'X' and maxTimes = 2 ->
	 * return the string "X23X1122233"
	 * 
	 * input = "12311122233" toFind = '1', replaceWith = 'X' and maxTimes = 3 ->
	 * return the string "X23XX122233"
	 * 
	 * input = "12311122233" toFind = '1', replaceWith = 'X' and maxTimes = 4 ->
	 * return the string "X23XXX22233"
	 * 
	 * 
	 * input = "12311122233" toFind = '2', replaceWith = 'X' and maxTimes = 1 ->
	 * return the string "1X311122233"
	 * 
	 * input = "12311122233" toFind = '2', replaceWith = 'X' and maxTimes = 2 ->
	 * return the string "1X3111X2233"
	 * 
	 * input = "12311122233" toFind = '2', replaceWith = 'X' and maxTimes = 3 ->
	 * return the string "1X3111XX233"
	 * 
	 * input = "12311122233" toFind = '2', replaceWith = 'X' and maxTimes = 4 ->
	 * return the string "1X3111XXX33"
	 * 
	 * 
	 * input = "12311122233" toFind = '3', replaceWith = 'X' and maxTimes = 1 ->
	 * return the string "12X11122233"
	 * 
	 * input = "12311122233" toFind = '3', replaceWith = 'X' and maxTimes = 2 ->
	 * return the string "12X111222X3"
	 * 
	 * input = "12311122233" toFind = '3', replaceWith = 'X' and maxTimes = 3 ->
	 * return the string "12X111222XX"
	 * 
	 * 
	 * input = "12311122233" toFind = '9', replaceWith = 'X' and maxTimes = 1 ->
	 * return the string "12311122233" (did not change since the character '9' was
	 * not in the string)
	 * 
	 * @param input
	 * @param toFind
	 * @param replaceWith
	 * @param maxTimes
	 * @return
	 */
	public static String replaceXTimes(String input, char toFind, char replaceWith, int maxTimes) {
		String stringToFind = "" + toFind;
		String stringReplaceWith = "" + replaceWith;
		for (int i = 0; i < maxTimes; i++) {
			input = input.replaceFirst(stringToFind, stringReplaceWith);
		}
		return input;
	}

	/**
	 * For this problem, you are given two separate arrays that are already sorted.
	 * You are to return an array that has the merged elements of both arrays while
	 * maintaining sorted order. That is, you will return an array that contains all
	 * the elements from the first AND second array, but the array you return must
	 * also be in sorted order having merged the elements from both arrays together.
	 * 
	 * Be careful, the arrays are NOT guaranteed to be the same size.
	 * 
	 * Examples: first = {1, 3, 5, 7, 9, 11} second = {2, 4, 6, 8, 10 , 12, 14, 16,
	 * 18}
	 * 
	 * Given the above two sorted arrays, you should return -> {1, 2, 3, 4, 5, 6, 7,
	 * 8, 9, 10, 11, 12, 14, 16, 18}
	 * 
	 * 
	 * first = {10, 50, 100} second = {9, 11, 13, 15, 30, 75, 500}
	 * 
	 * return -> {9, 10, 11, 13, 15, 30, 75, 100, 500}
	 * 
	 * 
	 * first = {1, 2, 3, 4, 5} second = {10, 11, 12, 13, 14, 15}
	 * 
	 * return {1, 2, 3, 4, 5, 10, 11, 12, 13, 14, 15}
	 * 
	 * 
	 * first = {1} second = {3}
	 * 
	 * return {1, 3}
	 * 
	 * 
	 * @param first  - the first array of sorted integers
	 * @param second - the second array of sorted integers
	 * @return an array of both arrays merged together such that the array returned
	 *         is in sorted order
	 */
	public static int[] mergeSorted(int[] first, int[] second) {
		// System.out.println(Arrays.toString(first) + ", length: " + first.length);
		// System.out.println(Arrays.toString(second) + ", length: " + second.length);

		int[] result = new int[first.length + second.length];

		int currentFirstIndex = 0;
		int currentSecondIndex = 0;

		for (int i = 0; i < result.length; i++) {
			// System.out.println("Index to compare: First: " + currentFirstIndex + " and
			// Second: " + currentSecondIndex);
			// System.out.println("Before: " + Arrays.toString(result));

			if (first[currentFirstIndex] < second[currentSecondIndex]) {
				result[i] = first[currentFirstIndex];
				++currentFirstIndex;
				if (currentFirstIndex == first.length) {
					for (int j = i + 1; j < result.length; j++) {
						result[j] = second[currentSecondIndex];
						++currentSecondIndex;
					}
					// System.out.println("Final: " + Arrays.toString(result));
					return result;
				}
			} else {
				result[i] = second[currentSecondIndex];
				++currentSecondIndex;
				if (currentSecondIndex == second.length) {
					for (int j = i + 1; j < result.length; j++) {
						result[j] = first[currentFirstIndex];
						++currentFirstIndex;
					}
					// System.out.println("Final: " + Arrays.toString(result));
					return result;
				}

			}
			// System.out.println("After: " + Arrays.toString(result));
		}
		return result;
	}
}
