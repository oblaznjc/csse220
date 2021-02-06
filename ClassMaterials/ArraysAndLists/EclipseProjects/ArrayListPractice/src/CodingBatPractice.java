import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CodingBatPractice {

	public static void main(String[] args) {
		System.out.println(fizzArray(10));
		fizzArray(10);
		fizzArray(0);

		// Example print to check method functionality
		System.out.println("fizzArray3(5, 10)");
		System.out.println( " Expected: [5, 6, 7, 8, 9]" );
		System.out.println( " Actual:" + Arrays.toString( fizzArray3(5, 10) ) );

		// TODO create calls to methods to test them here

	}

	/**
	 * Solve this method from: https://codingbat.com/prob/p142539
	 * 
	 * Explanation of pieces of method signature:
	 * 
	 * public = method can be accessed from any other class (anywhere) start, end =
	 * input parameters int[] = return type (this method returns an int array)
	 * static = because main is static (we will learn about static more later in the
	 * course) public static int[] fizzArray3(int start, int end) {
	 */
	public static String fizzArray(int n) {
		int[] output = new int[n];
		for (int i = 0; i < n; i++) {
			output[i] = i;
		}
		return output.toString();
	}

	public static int[] fizzArray3(int start, int end) {
		int length = end - start;
		int[] output = new int[length];
		for (int i = 0; i < length; i++) {
			output[i] = i + start;
		}
		return output;
	}

	public int[] shiftLeft(int[] nums) {
		int[] output = new int[nums.length];
		for (int i = 0; i < nums.length - 1; i++) {
			output[i] = nums[i + 1];
		}
		if (nums.length > 0) {
			output[nums.length - 1] = nums[0];
		}
		return output;
	}

	public int bigDiff(int[] nums) {
		int maximum = 0;
		int minimum = 999;
		for (int num : nums) {
			maximum = Math.max(maximum, num);
			minimum = Math.min(minimum, num);
		}
		return maximum - minimum;
	}

}
