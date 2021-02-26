package sll;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SinglyLinkedListTest {

	SinglyLinkedList emptyList, list, list2, list3;

	@Before
	public void setUp() {
		this.emptyList = new SinglyLinkedList();
		this.list = new SinglyLinkedList();
		this.list2 = new SinglyLinkedList();
		this.list3 = new SinglyLinkedList();
	}

	/*
	 * Populates the list with the items in the given array, in the order they're
	 * given in the array.
	 */
	private void populateList(SinglyLinkedList list, Integer[] items) {
		for (int i = items.length - 1; i >= 0; i--) {
			list.addAtHead(items[i]);
		}
	}

	@After
	public void tearDown() throws Exception {
		this.emptyList = null;
		this.list = null;
		this.list2 = null;
		this.list3 = null;
	}

	// *****************************************************************************
	// allOddsOrEvens
	// *****************************************************************************

	@Test
	public void testAllPositiveOrNegative() {

		// ALL TRUE
		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 10 });
		assertTrue(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 10, 12 });
		assertTrue(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 2, 2, 2, 2, 2, 2, 2 });
		assertTrue(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { -10 });
		assertTrue(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { -10, -12 });
		assertTrue(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { -2, -2, -2, -2, -2, -2, -2 });
		assertTrue(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, 2, 3, 4, 9 });
		assertTrue(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { -1, -5, -9 });
		assertTrue(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, 1, 1, 1, 1, 1, 1, 1, 1 });
		assertTrue(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { -1, -1, -1, -1, -1, -1, -1, -1, -1 });
		assertTrue(list.allPositiveOrNegative());

		// ALL FALSE
		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { -1, 2, -3, 4, -5, 6, -7, 8, -9 });
		assertFalse(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, -2, 3, -4, 5, -6, 7, -8, 9 });
		assertFalse(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { -1, -1, -1, -1, -1, -1, -1, -1, 1 });
		assertFalse(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, -1, -1, -1, -1, -1, -1, -1, -1 });
		assertFalse(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { -1, 1, 1, 1, 1, 1, 1, 1, 1 });
		assertFalse(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, 1, 1, 1, 1, 1, 1, 1, -1 });
		assertFalse(list.allPositiveOrNegative());

		// CONTAINS 0
		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 0 });
		assertFalse(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 });
		assertFalse(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, 2, 3, 4, 5, 6, 7, 0 });
		assertFalse(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7 });
		assertFalse(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, 2, 3, 0, 4, 5, 6, 7 });
		assertFalse(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { -1, -2, -3, -4, -5, -6, -7, -8, -9, 0 });
		assertFalse(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 0, -1, -2, -3, -4, -5, -6, -7, -8, -9 });
		assertFalse(list.allPositiveOrNegative());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { -1, -2, -3, -4, 0, -5, -6, -7, -8, -9 });
		assertFalse(list.allPositiveOrNegative());

	}

	// *****************************************************************************
	// double2s
	// *****************************************************************************
	@Test
	public void testDouble2s() {

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, 5, 3 });
		this.list.double2s();
		assertEquals("[1->5->3]", this.list.toString());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] {});
		this.list.double2s();
		assertEquals("[]", this.list.toString());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 2 });
		this.list.double2s();
		assertEquals("[2->2]", this.list.toString());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 2, 2 });
		this.list.double2s();
		assertEquals("[2->2->2->2]", this.list.toString());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 2, 2, 2 });
		this.list.double2s();
		assertEquals("[2->2->2->2->2->2]", this.list.toString());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		this.list.double2s();
		assertEquals("[1->2->2->3->4->5->6->7->8->9]", this.list.toString());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 2, 1, 2, 2, 3, 4, 2 });
		this.list.double2s();
		assertEquals("[2->2->1->2->2->2->2->3->4->2->2]", this.list.toString());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, 3, 4, 5, 6, 7, 8, 9, 10, 11 }); // 10 elements no 2
		this.list.double2s();
		assertEquals("[1->3->4->5->6->7->8->9->10->11->-1]", this.list.toString());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }); // 10 elements with 2
		this.list.double2s();
		assertEquals("[1->2->2->3->4->5->6->7->8->9->10->-1]", this.list.toString());

		for (int num = 20; num <= 100; num += 10) {
			this.list = new SinglyLinkedList();
			Integer[] listArray = new Integer[num];
			int val = 3;
			String result = "[";
			for (int i = 0; i < listArray.length; i++) {
				listArray[i] = val;
				result += (i > 0) ? "->" + val++ : "" + val++;
			}

			int div = num;
			while (div >= 10) {
				result += "->-1";
				div -= 10;
			}

			result += "]";

			this.list = new SinglyLinkedList();
			populateList(this.list, listArray);
			this.list.double2s();
			assertEquals(result, this.list.toString());
		}

		for (int num = 20; num <= 100; num += 10) {
			this.list = new SinglyLinkedList();
			Integer[] listArray = new Integer[num];
			int val = 1;
			String result = "[";
			for (int i = 0; i < listArray.length; i++) {
				if (val > 10)
					val = 1;
				listArray[i] = val;
				if (val == 2)
					result += (i > 0) ? "->" + val + "->" + val++ : "" + val + "->" + val++;
				else
					result += (i > 0) ? "->" + val++ : "" + val++;

			}

			int div = num;
			while (div >= 10) {
				result += "->-1";
				div -= 10;
			}

			result += "]";

			this.list = new SinglyLinkedList();
			populateList(this.list, listArray);
			this.list.double2s();
			assertEquals(result, this.list.toString());
		}

	}

	// *****************************************************************************
	// removeAllBetween
	// *****************************************************************************

	@Test
	public void testRemoveAllBetween() {
		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, 2, 3, 4, 5, 6, 2, 7, 8, 9 });
		this.list.removeAllBetween(2);
		assertEquals("[1->2->2->7->8->9]", this.list.toString());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 2, 9 });
		this.list.removeAllBetween(2);
		assertEquals("[1->2->2->9]", this.list.toString());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, 3, 2, 2, 7, 8, 9 });
		this.list.removeAllBetween(2);
		assertEquals("[1->3->2->2->7->8->9]", this.list.toString());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 9, 2, 3, 4, 5, 6, 2, 7, 8, 9 });
		this.list.removeAllBetween(9);
		assertEquals("[9->9]", this.list.toString());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, 2, 3, 4, 5, 6, 2, 7, 8, 9 });
		this.list.removeAllBetween(5);
		assertEquals("[1->2->3->4->5]", this.list.toString());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, 2, 3, 4, 5, 6, 2, 7, 8, 9, 5 });
		this.list.removeAllBetween(5);
		assertEquals("[1->2->3->4->5->5]", this.list.toString());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 5, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		this.list.removeAllBetween(5);
		assertEquals("[5->5->6->7->8->9]", this.list.toString());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, 2, 3, 4, 5, 6, 2, 7, 8, 9 });
		this.list.removeAllBetween(1);
		assertEquals("[1]", this.list.toString());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, 2, 3, 4, 5, 6, 9, 8, 9 });
		this.list.removeAllBetween(9);
		assertEquals("[1->2->3->4->5->6->9->9]", this.list.toString());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, 2, 3, 4, 5, 6, 9, 9 });
		this.list.removeAllBetween(9);
		assertEquals("[1->2->3->4->5->6->9->9]", this.list.toString());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 9, 9, 1, 2, 3, 4, 5, 6 });
		this.list.removeAllBetween(9);
		assertEquals("[9->9->1->2->3->4->5->6]", this.list.toString());

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, 2, 3, 4, 5, 6, 9 });
		this.list.removeAllBetween(9);
		assertEquals("[1->2->3->4->5->6->9]", this.list.toString());

		// big test remove all
		this.list = new SinglyLinkedList();
		Integer[] listArray = new Integer[100];
		int val = 1;
		listArray[0] = -1;
		listArray[99] = -1;
		for (int i = 1; i < listArray.length - 1; i++) {
			listArray[i] = val++;
		}

		String result = "[-1->-1]";

		this.list = new SinglyLinkedList();
		populateList(this.list, listArray);
		this.list.removeAllBetween(-1);
		assertEquals(result, this.list.toString());

		// big test remove all but outer
		this.list = new SinglyLinkedList();
		listArray = new Integer[100];
		val = 1;
		listArray[0] = -1;
		listArray[1] = 0;
		listArray[98] = 0;
		listArray[99] = -1;
		for (int i = 2; i < listArray.length - 2; i++) {
			listArray[i] = val++;
		}

		result = "[-1->0->0->-1]";

		this.list = new SinglyLinkedList();
		populateList(this.list, listArray);
		this.list.removeAllBetween(0);
		assertEquals(result, this.list.toString());

		// big test remove middle
		this.list = new SinglyLinkedList();
		listArray = new Integer[100];
		val = 1;
		result = "[";
		for (int i = 0; i < listArray.length; i++) {
			if (i == 24 || i == 74) {
				listArray[i] = -1;
				result += "->-1";
			} else {
				listArray[i] = val;
				if (i < 24 || i > 74)
					result += (i > 0) ? "->" + val++ : "" + val++;
			}

		}

		result += "]";

		this.list = new SinglyLinkedList();
		populateList(this.list, listArray);
		this.list.removeAllBetween(-1);
		assertEquals(result, this.list.toString());

		// big test remove beginning
		this.list = new SinglyLinkedList();
		listArray = new Integer[100];
		val = 1;
		result = "[";
		for (int i = 0; i < listArray.length; i++) {
			if (i == 0 || i == 50) {
				listArray[i] = -1;
				result += (i > 0) ? "->-1" : "-1";
			} else {
				listArray[i] = val;
				if (i > 50)
					result += (i > 0) ? "->" + val++ : "" + val++;
			}

		}

		result += "]";

		this.list = new SinglyLinkedList();
		populateList(this.list, listArray);
		this.list.removeAllBetween(-1);
		assertEquals(result, this.list.toString());

		// big test remove end
		this.list = new SinglyLinkedList();
		listArray = new Integer[100];
		val = 1;
		result = "[";
		for (int i = 0; i < listArray.length; i++) {
			if (i == 50 || i == 99) {
				listArray[i] = -1;
				result += "->-1";
			} else {
				listArray[i] = val;
				if (i < 50)
					result += (i > 0) ? "->" + val++ : "" + val++;
			}

		}

		result += "]";

		this.list = new SinglyLinkedList();
		populateList(this.list, listArray);
		this.list.removeAllBetween(-1);
		assertEquals(result, this.list.toString());
	}

	// *****************************************************************************
	// moveNextToLast
	// *****************************************************************************

	@Test
	public void testMoveNextToLast() {

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, 2, 3 });
		this.list.moveNextToLast();
		String actual = this.list.toString();
		assertEquals("[1->3->2]", actual);

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 10, 20, 30 });
		this.list.moveNextToLast();
		actual = this.list.toString();
		assertEquals("[20->10->30]", actual);

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] {});
		this.list.moveNextToLast();
		actual = this.list.toString();
		assertEquals("[]", actual);

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 100, 101, 102 });
		this.list.moveNextToLast();
		actual = this.list.toString();
		assertEquals("[100->102->101]", actual);

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 99, 100, 101 });
		this.list.moveNextToLast();
		actual = this.list.toString();
		assertEquals("[100->99->101]", actual);

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 1, 2 });
		this.list.moveNextToLast();
		actual = this.list.toString();
		assertEquals("[2->1]", actual);

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 10, 20 });
		this.list.moveNextToLast();
		actual = this.list.toString();
		assertEquals("[10->20]", actual);

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 10, 10, 20, 20, 30 });
		this.list.moveNextToLast();
		actual = this.list.toString();
		assertEquals("[20->10->10->20->30]", actual);

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 11, 22, 33, 44, 55, 66, 77 });
		this.list.moveNextToLast();
		actual = this.list.toString();
		assertEquals("[11->22->33->44->55->77->66]", actual);

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 70, 60, 50, 40, 30, 20, 10 });
		this.list.moveNextToLast();
		actual = this.list.toString();
		assertEquals("[20->70->60->50->40->30->10]", actual);

		this.list = new SinglyLinkedList();
		populateList(this.list, new Integer[] { 70, 60, 50, 40, 30, 21, 10 });
		this.list.moveNextToLast();
		actual = this.list.toString();
		assertEquals("[70->60->50->40->30->10->21]", actual);

		// big test, NOT divisible by 5
		this.list = new SinglyLinkedList();
		Integer[] listArray = new Integer[100];
		int val = 1;
		int remember = 0;
		String result = "[";
		for (int i = 0; i < listArray.length; i++) {
			if (val > 4)
				val = 1;
			listArray[i] = val;
			if (i == listArray.length - 2)
				remember = val++;
			else
				result += (i > 0) ? "->" + val++ : "" + val++;

		}

		result += "->" + remember + "]";

		this.list = new SinglyLinkedList();
		populateList(this.list, listArray);
		this.list.moveNextToLast();
		assertEquals(result, this.list.toString());

		this.list = new SinglyLinkedList();
		listArray = new Integer[100];
		val = 5;
		remember = 0;
		result = "";
		for (int i = 0; i < listArray.length; i++) {
			listArray[i] = val;
			if (i == listArray.length - 2)
				remember = val;
			else
				result += (i > 0) ? "->" + val : "" + val;

			val += 5;
		}

		result = "[" + remember + "->" + result + "]";

		this.list = new SinglyLinkedList();
		populateList(this.list, listArray);
		this.list.moveNextToLast();
		assertEquals(result, this.list.toString());
	}

} // SinglyLinkedListTest
