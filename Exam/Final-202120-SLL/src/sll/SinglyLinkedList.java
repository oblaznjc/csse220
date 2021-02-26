package sll;

public class SinglyLinkedList {

	// ***************** INSTRUCTIONS ****************************
	/*
	 * Below, you will find 4 problems. To pass this part, you must pass all the
	 * tests for any three problems. An exception may be made if you are passing all
	 * tests for 2 parts and most of the tests for the other two.
	 * 
	 * The code immediately below should NOT be altered. The problems are below that
	 * part.
	 * 
	 * NOTE: There is ONLY a head pointer and not a tail pointer below.
	 */
	// ***********************************************************

	// ***********************************************************
	// DO NOT CHANGE THE CODE from here to line 73 below
	// ***********************************************************

	private class Node {
		public Integer data;
		public Node next;

		public Node(Integer data, Node next) {
			this.data = data;
			this.next = next;
		} // Node
	} // Node Class

	private Node head;

	// ************************************************************

	// Do not change constructor
	public SinglyLinkedList() {
		head = null;
	} // SinglyLinkedList

	// ************************************************************

	// Do not change addAtHead
	public void addAtHead(int x) {
		Node p = new Node(x, this.head);
		this.head = p;
	} // addAtHead

	// ************************************************************

	// Do not change toStringHelper
	private String toStringHelper(Node p) {
		if (p == null) {
			return "";
		} else {
			return p.data + ((p.next != null) ? "->" : "") + toStringHelper(p.next);
		} // end if
	} // toStringHelper

	// ************************************************************

	// Do not change toString
	@Override
	public String toString() {
		return "[" + toStringHelper(head) + "]";
	} // toString

	// ************************************************************
	// To Do Section
	// ************************************************************

	/**
	 * allPositiveOrNegative
	 * 
	 * For this problem, you should return true if all the numbers in the list
	 * (pointed to by this.head) are all positive, OR you should return true of all
	 * the numbers in this list are all negative. For any other case, you should
	 * return false.
	 * 
	 * Note, if 0 appears anywhere in the list, you should return FALSE.
	 * 
	 * You must step through the list instead of using the toString().
	 * 
	 * Examples: [1->2->3->4->9] returns true (all positive) [-1-> -5 -> -9] (spaces
	 * added to see negative signs) returns true (all negative) [9->5->0->19->23]
	 * return false (has a 0) [-2 -> -4 -> 0 -> -8-> -16 -> -10] returns false (has
	 * a 0) [-1 -> 2 -> -3 -> 4] returns false (not all positive or negative) [-1 ->
	 * 2 -> 0 -> -3 -> 4] returns false (several reasons
	 * 
	 * [1->1->1->1->1->1->1->1->1] returns true (all positive) [-1 -> -1 -> -1 -> -1
	 * -> -1 -> -1 -> -1] returns true (all negative) [0->0->0->0->0->0] returns
	 * false (has a 0)
	 */
	public boolean allPositiveOrNegative() {
		Node node = this.head;
		if (this.head.data > 0) {
			while (node != null) {
				if (node.data > 0) {
					node = node.next;
				} else {
					return false;
				}
			}
			return true;
		} else if (this.head.data < 0) {
			while (node != null) {
				if (node.data < 0) {
					node = node.next;
				} else {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * For this problem, there are two things to do. First, every time you find a 2
	 * in the list, add another 2 immediately after it.
	 * 
	 * Second, for every 10 elements in the list (before adding any 2's), add a -1
	 * at the end of the list. So, if there are originally 30 elements in the list,
	 * you would add 3 nodes at the end of the list that each contain -1. You do not
	 * need to add a -1 for 9 or less elements. (With 9 elements exactly, you would
	 * not add any -1 to the list; with 29 original elements, you would add exactly
	 * 2 -1's to the list).
	 * 
	 * If the list is empty, do nothing. If the list contains no 2's, and contains <
	 * 10 items, then do nothing.
	 * 
	 * You are NOT permitted to use toString() to solve this problem.
	 * 
	 * HINT: Be careful not to enter into an infinite process of adding a 2 and
	 * thinking that 2 was there before you started...
	 * 
	 * For example (with less than 10 elements): [] becomes [] (no change) [2]
	 * becomes [2->2] [1->2->3] becomes [1->2->2->3] [1->2->2->3] becomes
	 * [1->2->2->2->2->3] [3->5->9->2->1->4->2->7] becomes
	 * [3->5->9->2->2->1->4->2->2->7] [2->2->2->2] becomes [2->2->2->2->2->2->2->2]
	 * 
	 * considering lists with 10 or more elements: [1->2->3->4->5->6->7->8->9->10]
	 * becomes [1->2->2->3->4->5->6->7->8->9->10->-1]
	 * 
	 * [1->2->3->4->5->6->7->8->9->10->1->2->3->4->5->6->7->8->9->10] (with 20
	 * elements) becomes
	 * [1->2->2->3->4->5->6->7->8->9->10->1->2->2->3->4->5->6->7->8->9->10-> -1->
	 * -1] (spaces added for clarity, note the 2's were also doubled)
	 * 
	 * [1->2->3->4->5->6->7->8->9->10->1->2->3->4->5->6->7->8->9->10->1->2->3->4->5->6->7->8->9->10]
	 * (with 30 elements) becomes
	 * [1->2->2->3->4->5->6->7->8->9->10->1->2->2->3->4->5->6->7->8->9->10->1->2->2->
	 * 3->4->5->6->7->8->9->10-> -1 -> -1 -> -1] (spaces added for clarity and 2's
	 * doubled)
	 * 
	 * 
	 * IMPORTANT EXAMPLE:
	 * [1->2->3->4->5->6->7->8->9->10->1->2->3->4->5->6->7->8->9->10->1->2->3->4->5->6->7->8->9]
	 * (with 29 ORIGINAL elements) becomes
	 * [1->2->2->3->4->5->6->7->8->9->10->1->2->2->3->4->5->6->7->8->9->10->1->2->2->
	 * 3->4->5->6->7->8->9->10-> -1 -> -1] (spaces added for clarity, NOTE: Because
	 * there were 29 ORIGINAL elements that -1 was only added twice even though
	 * after the 2's were added, there would be 32 elements when finished, you are
	 * only concerned with the number of original elements)
	 */
	public void double2s() {
		if (this.head == null) {
			return;
		}
		Node node = this.head;
		Node storedNode = this.head;
		int count = 0;
		while (node != null) {
			count++;
			storedNode = node;
			if (node.data == 2) {
				Node tempNode = node.next;
				node.next = new Node(2, tempNode);
				node = tempNode;
			} else {
				node = node.next;
			}
		}
		for (int i = 0; i < count / 10; i++) {
			storedNode.next = new Node(-1, null);
			storedNode = storedNode.next;
		}
		return;
	}

	/**
	 * You are to remove all Nodes between the two that contain the value given as
	 * the parameter. If the value only appears once, you should remove all Nodes
	 * after the first instance.
	 * 
	 * For example: list = [1->9->5->4->9->3] between = 9 You should change the list
	 * so that it is [1->9->9->3]
	 * 
	 * list = [1->90->90->3] between = 90 You should change the list so that it is
	 * [1->90->90->3]
	 * 
	 * list = [2->3->4->5->6->7->2] between = 2 You should change the list so that
	 * it is [2->2]
	 * 
	 * 
	 * As another example, if the value only appears once list = [2->4->6->8->10]
	 * between = 6 You should change the list so that it is [2->4->6]
	 * 
	 * list = [10->3->4->5->6->7] between = 10 You should change the list so that it
	 * is [10]
	 * 
	 * For simplicity, the value is guaranteed to be in the list at least once.
	 * 
	 * @param between - the value to find and remove nodes between the two instances
	 *                of the value
	 * 
	 * @return nothing
	 * 
	 */
	public void removeAllBetween(int between) {
		if (this.head == null) {
			return;
		}
		Node node = this.head;
		Node storedNode = null;
		int count = 0;
		while (node.next != null) {
			if (node.data == between) {
				if (node.next.data == between) {
					if (node.next.next == null) {
						return;
					} else {
						node = node.next.next;
					}
				} else {
					node.next = node.next.next;
				}
			} else {
				node = node.next;
			}
		}
		return;
	}

	/**
	 * For this problem, there are several steps. First, with this.head as the first
	 * node in the list, REMOVE the next-to-last element from the list (making sure
	 * that you don't end up with two separate lists). Next, place the element that
	 * was just REMOVED (i.e., the next-to-last element) back in the list according
	 * to the following rules:
	 * 
	 * 1) If the next-to-last element that was removed is divisible by 5, place that
	 * element at the FRONT of the list (i.e., as the first node in the linked-list)
	 * 
	 * 2) If the next-to-last element that was removed is NOT divisible by 5, place
	 * that element at the END of the list (i.e., as the last node in the
	 * linked-list)
	 * 
	 * If the list contains less than two elements, therefore it would not have a
	 * next-to-last element, just leave the list unchanged and return.
	 * 
	 * You are NOT permitted to use toString() to solve this problem.
	 * 
	 * Examples: [] becomes [] (no change) [1->2->3] (here, 2 is the next-to-last
	 * element) becomes [1->3->2] (element moved to the end because it was not
	 * divisible by 5)
	 * 
	 * [10->20->30] (here, 20 is the next-to-last element) becomes [20->10->30]
	 * (element moved to the beginning because it was divisible by 5)
	 * 
	 * [100->101->102] becomes [100->102->101] (moved to the end since 101 is NOT
	 * divisible by 5) [99->100->101] becomes [100->99->101] (moved to the front of
	 * the list since 100 is divisible by 5)
	 * 
	 * [1->2] (note here, 1 is the next-to-last even though it is the head) becomes
	 * [2->1] since 1, the next-to-last, is not divisible by 5, it is moved to the
	 * end of the list)
	 * 
	 * [10->20] (note here, 10 is the next-to-last even though it is the head)
	 * becomes [10->20] since 10, the next-to-last, is divisible by 5, it is moved
	 * to the beginning of the list, so the list is unchanged when finished)
	 * 
	 * [10->10->20->20->30] (where 20 is the next-to-last) becomes
	 * [20->10->10->20->30] (20 is divisible by 5 so moved to the beginning)
	 * 
	 * [11->22->33->44->55->66->77] (where 66 is next-to-last) becomes
	 * [11->22->33->44->55->77->66]
	 * 
	 * [70->60->50->40->30->20->10] (where 20 is next-to-last) becomes
	 * [20->70->60->50->40->30->10]
	 * 
	 * [70->60->50->40->30->21->10] (where 20 is next-to-last) becomes
	 * [70->60->50->40->30->10->21]
	 * 
	 */
	public void moveNextToLast() {
		if (this.head == null || this.head.next == null) {
			return;
		}
		Node oldHead = this.head;
		Node lastNode = this.head.next;
		Node node = this.head;
		Node storedNode = this.head;
		while (node.next.next != null) {
			storedNode = node;
			node = node.next;
		}
		storedNode.next = node.next;
		node.next = null;
		if (node.data % 5 == 0) {
			this.head = node;
			this.head.next = oldHead;
		} else if (storedNode.next != null) {
			storedNode.next.next = node;
		}
		return;
	}
}
// end class "SinglyLinkedList"