import java.util.ArrayList;
import java.util.HashMap;

public class AllQuestions {

	/*
	 * *************************************** INSTRUCTIONS
	 * *************************************** Below, you will find 4 problems: 2
	 * HashMap problems and 2 Recursion problems. To pass this part, you must pass
	 * all the tests for any 3 problems. An exception may be made if you pass all
	 * tests for any 2 problems, and most tests for BOTH the other 2 problems.
	 * 
	 * *****************************************************************************
	 * ***************
	 */

	/**
	 * For this problem, you will be given a HashMap called phonebook. The phonebook
	 * is a special hashmap that will track multiple phone numbers for a specific
	 * name. The phonebook hashmap uses unique names (Strings) as the key, and the
	 * value is an ArrayList of Strings that are phone numbers. To be clear, the
	 * hashmap named phonebook already has names mapped to ArrayLists of phone
	 * numbers.
	 * 
	 * You are also given two more arrays of Strings that are parallel arrays,
	 * meaning the name at names[0] corresponds to the new number at newMunbers[0].
	 * 
	 * Your task is to add the new number in newNumbers[i] for the person named
	 * names[i]. The catch is that you should not add a specific number if that
	 * number already exist in the arraylist of numbers for that person. If the new
	 * number for a person is not already in the list, you should add that number to
	 * the arraylist of numbers for that person. You may also receive a name and
	 * number such that the name is not yet in the phonebook. If that is the case,
	 * you should create a new entry in the phonebook for that person that contains
	 * an arraylist of one phone number.
	 * 
	 * For this problem, there is nothing to return, your changes should be to the
	 * phonebook hashmap.
	 * 
	 * Examples: phonebook = {"John Smith" -> {"111-1111", "222-2222"} "Anne Jones"
	 * -> {"333-3333"} "Stacy Jones" -> {"444-4444", "555-5555", "777-7777"} }
	 * 
	 * names = {"John Smith", "Alex Davies", "Anne Jones", "Anne Jones", "John
	 * Smith", "Taylor Swift", "Taylor Swift", "Stacy Jones", "Stacy Jones", "Stacy
	 * Jones"}
	 * 
	 * newNumbers = {"888-8888", "999-9999", "000-0000", "123-1234", "987-9876",
	 * "121-2121", "787-8787", "444-4444", "555-5555", "030-3030"}
	 * 
	 * 
	 * 
	 * (NOTE: Because names and newNumbers are parallel arrays, that means to add
	 * the number "888-8888" to "John Smith", etc.)
	 * 
	 * When this method runs, the result should be: phonebook = {"John Smith" ->
	 * {"111-1111", "222-2222", "888-8888", "987-9876"} "Anne Jones" -> {"333-3333",
	 * "000-0000", "123-1234"} "Stacy Jones" -> {"444-4444", "555-5555", "777-7777",
	 * "030-3030"} "Alex Davies" -> {"999-9999"} "Taylor Swift" -> {"121-2121",
	 * "787-8787"} }
	 * 
	 * NOTE: notice in the parallel arrays that for Stacy jones, while there were 3
	 * newNumbers for that name, only one was added because the other two were
	 * duplicates. You should NOT add a duplicate number for any single name (two
	 * people sharing the same number is OK, but the same number should NOT appear
	 * twice in any single ArrayList for a specific name).
	 * 
	 * NOTE: Alex Davies was added and had only one number, but still an ArrayList
	 * was added with only one entry.
	 * 
	 * NOTE: Taylor Swift was added only once, and then another number was found for
	 * the same name.
	 * 
	 * @param phonebook  - A HashMap that maps String names to ArrayList<String> of
	 *                   phone numbers
	 * @param names      - An array of names with corresponding (possible) new
	 *                   numbers
	 * @param newNumbers - An Array of new numbers corresponding to the names
	 * 
	 *                   When finished, all the changes should appear in the
	 *                   phonebook HashMap
	 */
	public static void updatePhoneBook(HashMap<String, ArrayList<String>> phonebook, String[] names,
			String[] newNumbers) {
		for (int i = 0; i < names.length; i++) {
			String name = names[i];
			String newNumber = newNumbers[i];
			if (!phonebook.containsKey(name)) {
				phonebook.put(name, new ArrayList<String>());
				phonebook.get(name).add(newNumber);
			}
			ArrayList<String> oldNumbers = phonebook.get(name);
			if (!oldNumbers.contains(newNumber)) {
				oldNumbers.add(newNumber);
			}
		}
		return;
	}

	/**
	 * For this problem, you are given a HashMap that maps Strings to other Strings.
	 * The keys are fairly inconsequential in that they could be anything, but the
	 * values will contain both letters and digits. You are to search through all
	 * the String values in the input HashMap and determine what is the most common
	 * digit found among all the values of the input HashMap. Note, the values could
	 * contain letters, and you should not count those. The values could also
	 * contain several digits, and you should consider them as single digits. You
	 * will return the most common digit among all the values of the input HashMap.
	 * 
	 * HINTS: 1) To keep a count of how many times each digit appear, you should use
	 * a HashMap. It might be easier to map a Character to an Integer count, but you
	 * can do whatever you wish.
	 * 
	 * 2) To determine if a char named currentCharacter is a digit, you can use
	 * Character.isDigit(currentCharacter) which will return true if the character
	 * named currentCharacter is a digit 0-9.
	 * 
	 * 3) In your code, you are likely tracking characters or strings. To convert a
	 * character named someChar to a String named strName, you can say: String
	 * strName = "" + someChar To convert a String named strName to an int named
	 * count, you can say: int count = Integer.parseInt(strName) Given the above
	 * two, if you have a char named commonDigit and you want to convert it to an
	 * int, you can say: int count = Integer.parseInt("" + commonDigit)
	 * 
	 * You can assume that there will always be a most common digit and there will
	 * be no ties.
	 * 
	 * You will definitely need to loop through the HashMap called input, but you
	 * will not need to do anything per se with the keys in input other than using
	 * them to loop through the input HashMap
	 * 
	 * @param input - the HashMap of String keys and String values
	 * @return the most common digit (as an int) among all the values in the input
	 *         HashMap
	 */
	public static int mostCommonDigit(HashMap<String, String> input) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i <= 9; i++) {
			map.put(i, 0);
		}
		for (String string : input.values()) {
			// System.out.println(string);
			for (char character : string.toCharArray()) {
				if (Character.isDigit(character)) {
					int number = Integer.parseInt("" + character);
					map.put(number, map.get(number) + 1);
					// System.out.println(character);
				}
			}
		}
		int mostCommonDigit = 0;
		int mostCommonDigitScore = 0;
		for (int key : map.keySet()) {
			if (map.get(key) > mostCommonDigitScore) {
				mostCommonDigit = key;
				mostCommonDigitScore = map.get(key);
			}
		}
		return mostCommonDigit;
	}

	/**
	 * For this problem, you are to use recursion to determine the number of
	 * respective outer pairs of the ArrayList that differ by 10 or more.
	 * 
	 * For simplicity, you can assume the size of the ArrayList input is always even
	 * (every item has a pair).
	 * 
	 * Each item has a pair in the array list. The first item's pair is the last
	 * element, the second item's pair is the second to last, etc.
	 * 
	 * You are to count the pairs that differ by 10 or more (using Math.abs might be
	 * useful here).
	 * 
	 * (You do not need a recursive helper method for this problem, but you may if
	 * you wish.)
	 * 
	 * You are allowed to make changes to the ArrayList in your solution.
	 * 
	 * For instance, given the following array list: input = {1, 2, 3, 4, 5, 5, 4,
	 * 3, 2, 1} The pairs are (1 and 1), (2 and 2), (3 and 3), (4 and 4), (5 and 5).
	 * In this case, none of the pairs differ by 10 or more (all the pairs are
	 * equal), so return a count of 0 for this example.
	 * 
	 * For another example, given the following array list: input = {1, 2, 3, 4, 20,
	 * 8, 13, 15} the pairs are: (1 and 15), (2 and 13), (3 and 8), (4 and 20) Given
	 * the above pairs, the number of pairs that differ by 10 or more is 3 (the
	 * pairs (1 and 15), (2 and 13), (4 and 20) all differ by 10 or more)
	 * 
	 * 
	 * As a final example, given the following array list: input = {22, 12, 35, 100,
	 * 101, 30, 27, 11} the pairs are (22 and 11), (12 and 27), (35 and 30), (100
	 * and 101) Given the above pairs, the number of pairs that differ by 10 or more
	 * is 2 (the pairs (22 and 11), (12 and 27) both differ by 10 or more)
	 * 
	 * 
	 * @param input
	 * @return the count of pairs that differ by 10 or more
	 */
	static int pairedDiff(ArrayList<Integer> input) {
		if (input.size() < 2) {
			return 0;
		} else if (Math.abs(input.get(0) - input.get(input.size() - 1)) >= 10) {
			input.remove(0);
			input.remove(input.size() - 1);
			return 1 + pairedDiff(input);
		} else {
			input.remove(0);
			input.remove(input.size() - 1);
			return pairedDiff(input);
		}
	}

	/**
	 * For this problem, you are given an array of values. You are to find the
	 * highest sum that appears between two zeros. That is, the array contains
	 * portions that start and end with a 0. For every set of integers between a
	 * pair of zeros, return the highest sum of any sequence of numbers that appear
	 * between any pair of zeros. (You can assume that there are no values that
	 * appear outside of a pair of zeros.)
	 * 
	 * You will want a recursive helper method for this one.
	 * 
	 * For example: input = {0, 1, 2, 3, 4, 0, 5, 6, 7, 8, 0, 10, 11, 0} Notice
	 * above, there are three sets of numbers appearing between two different zeros.
	 * The sum of the first set is = 1+2+3+4 = 10 The sum of the second set is =
	 * 5+6+7+8 = 26 The sum of the third set is = 10+11 = 21
	 * 
	 * Since 26 is the highest sum above, you should return the value 26.
	 * 
	 * As a final example: input = {0, 1, 1, 1, 0, 2, 2, 2, 0, 3, 0, 4, 0}
	 * 
	 * The highest sum above is 2+2+2 = 6.
	 * 
	 * @param input an array of integers for which you should calculate the sum of
	 *              all values between each pair of zeros
	 * @return the highest sum of values between any pair of zeros
	 */
	public static int highestZeroSum(int[] input) {
		// find first zero
		for (int index = 0; index < input.length; index++) {
			if (input[index] == 0) {
				return highestZeroSumHelper(index, input, 0, 0);
			}
		}
		return 0;
	}

	public static int highestZeroSumHelper(int index, int[] input, int currentSum, int storedMax) {
		if (index >= input.length) {
			return storedMax;
		} else if (input[index] != 0) {
			return highestZeroSumHelper(index + 1, input, currentSum + input[index], storedMax);
		} else {
			if (currentSum > storedMax) {
				return highestZeroSumHelper(index + 1, input, 0, currentSum);
			} else {
				return highestZeroSumHelper(index + 1, input, 0, storedMax);
			}
		}
	}
}
