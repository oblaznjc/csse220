import java.util.ArrayList;

public class ArrayListFunctions {

	/**
	 * 
	 * Write a function that takes an array of strings and returns an arraylist. The
	 * arraylist should contain only the strings in the original list that begin
	 * with 'A'
	 * 
	 * So arrayListOfAs({"Abc","foo","AAA", "bar"}) yields ["Abc","AAA"]
	 */
	public static ArrayList<String> arraylistOfAs(String[] strings) {
		ArrayList<String> output = new ArrayList<String>();
		for (String string : strings) {
			if (string.length() > 0) {
				if (string.charAt(0) == 'A') {
					output.add(string);
				}
			}
		}
		return output;
	}

	/**
	 * Takes an arrayList of numbers in sorted (ascending) order and a number to
	 * add.
	 * 
	 * Adds the number in the correct place in the sorted list.
	 * 
	 * so insertIntoSorted([1,5,9],6) yields [1,5,6,9]
	 * 
	 */
	public static void insertIntoSorted(ArrayList<Integer> list, int number) {
		System.out.println("Adding " + number + " into list:" + list);
		if (list.size() == 0) {
			list.add(number);
			System.out.println("Result: " + list);
			return;
		}
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("Check if " + number + " is less than " + list.get(i));
				if (number < list.get(i)) {
					list.add(i, number);
					System.out.println("Result: " + list);
					return;
				}
			}
			list.add(number);
			System.out.println("Result: " + list);
			return;
		}
	}

	/**
	 * Takes an arraylist of strings and removes all strings longer than 3
	 * characters.
	 * 
	 * So removeLongStrings(["a","xxxx","b","zzzzz"]) yields ["a","b"]
	 */
	public static void removeLongStrings(ArrayList<String> strings) {
		System.out.println("strings is: " + strings);
		for (int i = strings.size() - 1; i > 0; i--) {
			System.out.println("Check if: " + strings.get(i) + " is larger than 3");
			if (strings.get(i).length() > 3) {
				strings.remove(strings.get(i));
				System.out.println("Result is: " + strings);
			}
		}
		return;
	}
}
