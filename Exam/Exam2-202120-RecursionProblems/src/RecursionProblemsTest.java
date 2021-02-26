import static org.junit.Assert.*;

import org.junit.Test;

public class RecursionProblemsTest {

	@Test
	public void testNumPairs() {
		String input = "123456654321";
		assertEquals(6, RecursionProblems.numPairs(input));
		
		input = "123456674829";
		assertEquals(3, RecursionProblems.numPairs(input));
		
		input = "abc123w21bbb";
		assertEquals(3, RecursionProblems.numPairs(input));
		
		input = "11111111";
		assertEquals(4, RecursionProblems.numPairs(input));
		
		input = "1234567890";
		assertEquals(0, RecursionProblems.numPairs(input));
		
		input = "1234567890123456789009876543210987654321";
		assertEquals(20, RecursionProblems.numPairs(input));
		
		input = "abcdefghijklmnopqrstuvwxyz12345678900987654321zyxwvutsrqponmlkjihgfedcba";
		assertEquals(36, RecursionProblems.numPairs(input));
		
		input = "abcdefghijklmnopqrstuvwxyz1234567890";
		assertEquals(0, RecursionProblems.numPairs(input));
		
		
		//Big tests
		input = "";
		String reverse = "";
		String reverse2 = "";
		String reverse3 = "";
		int digit = 0;
		for(int i = 0; i < 500; i++) {
			input += "" + digit;
			reverse = "" + digit + reverse;
			if(digit%2==0) {
				reverse2 = "" + digit + reverse2;
				reverse3 = "" + ((digit<9)?digit+1:0) + reverse3;
			}
			else {
				reverse2 = "" + ((digit<9)?digit+1:0) + reverse2;
				reverse3 = "" + digit + reverse3;
			}
			digit = (digit < 9) ? digit+1 : 0;
		}
		
		assertEquals(0, RecursionProblems.numPairs(input));
		
		
		assertEquals(500, RecursionProblems.numPairs(input+reverse));
		
		assertEquals(250, RecursionProblems.numPairs(input+reverse2));
		
		assertEquals(250, RecursionProblems.numPairs(input+reverse3));
	}

	@Test
	public void testEquals() {
		String input1 = "Hello";
		assertTrue(RecursionProblems.equals(input1, input1));
		
		String input2 = "hello";
		assertFalse(RecursionProblems.equals(input1, input2));
		
		input1 = "12345";
		input2 = "12345";
		assertTrue(RecursionProblems.equals(input1, input2));
		
		input2 = "1234";
		assertFalse(RecursionProblems.equals(input1, input2));
		
		input2 = "123456";
		assertFalse(RecursionProblems.equals(input1, input2));
		
		input1 = "1a2b3c4d";
		input2 = "1a2b3c4d";
		assertTrue(RecursionProblems.equals(input1, input2));
		
		input2 = "1a2b3c4";
		assertFalse(RecursionProblems.equals(input1, input2));
		
		input2 = "1a2b3c4d5";
		assertFalse(RecursionProblems.equals(input1, input2));
		
		input1 = "";
		input2 = "";
		assertTrue(RecursionProblems.equals(input1, input2));
		
		input2 = "a";
		assertFalse(RecursionProblems.equals(input1, input2));
		
		input1 = "1";
		input2 = "";
		assertFalse(RecursionProblems.equals(input1, input2));
		
		
		//Big tests
		input1 = "";
		input2 = "";
		String input3 = "";
		char letter = 'a';
		for(int i = 0; i < 500; i++) {
			input1 += letter;
			input2 += letter;
			input3 = letter + input3;
			if(letter < 'z')
				letter++;
			else
				letter = 'a';
		}
		
		assertTrue(RecursionProblems.equals(input1, input2));
		assertFalse(RecursionProblems.equals(input1, (input2+'a')));
		assertFalse(RecursionProblems.equals(input1, input3));
	}
	
	@Test
	public void testAlmostEquals() {
		//TESTS WITH 0 THRESHOLD
		String input1 = "Hello";
		assertTrue(RecursionProblems.almostEquals(input1, input1, 0));
		
		String input2 = "hello";
		assertFalse(RecursionProblems.almostEquals(input1, input2, 0));
		
		input1 = "12345";
		input2 = "12345";
		assertTrue(RecursionProblems.almostEquals(input1, input2, 0));
		
		input2 = "1234";
		assertFalse(RecursionProblems.almostEquals(input1, input2, 0));
		
		input2 = "123456";
		assertFalse(RecursionProblems.almostEquals(input1, input2, 0));
		
		input1 = "1a2b3c4d";
		input2 = "1a2b3c4d";
		assertTrue(RecursionProblems.almostEquals(input1, input2, 0));
		
		input2 = "1a2b3c4";
		assertFalse(RecursionProblems.almostEquals(input1, input2, 0));
		
		input2 = "1a2b3c4d5";
		assertFalse(RecursionProblems.almostEquals(input1, input2, 0));
		
		input1 = "";
		input2 = "";
		assertTrue(RecursionProblems.almostEquals(input1, input2, 0));
		
		input2 = "a";
		assertFalse(RecursionProblems.almostEquals(input1, input2, 0));
		
		input1 = "1";
		input2 = "";
		assertFalse(RecursionProblems.almostEquals(input1, input2, 0));
		
		
		//Big tests
		input1 = "";
		input2 = "";
		String input3 = "";
		char letter = 'a';
		for(int i = 0; i < 500; i++) {
			input1 += letter;
			input2 += letter;
			input3 = letter + input3;
			if(letter < 'z')
				letter++;
			else
				letter = 'a';
		}
		
		assertTrue(RecursionProblems.almostEquals(input1, input2, 0));
		assertFalse(RecursionProblems.almostEquals(input1, (input2+'a'), 0));
		assertFalse(RecursionProblems.almostEquals(input1, input3, 0));
		
		
		//TESTS WITH NON-ZERO THRESHOLD
		input1 = "Hello";
		assertTrue(RecursionProblems.almostEquals(input1, input1, 1));
		
		input2 = "hello";
		assertTrue(RecursionProblems.almostEquals(input1, input2, 1));
		
		input1 = "12345";
		input2 = "12345";
		assertTrue(RecursionProblems.almostEquals(input1, input2, 1));
		
		input2 = "1234";
		assertTrue(RecursionProblems.almostEquals(input1, input2, 1));
		
		input2 = "123456";
		assertTrue(RecursionProblems.almostEquals(input1, input2, 1));
		
		input2 = "12z45";
		assertTrue(RecursionProblems.almostEquals(input1, input2, 1));
		
		input1 = "1a2b3c4d";
		input2 = "1a2b3c4d";
		assertTrue(RecursionProblems.almostEquals(input1, input2, 1));
		
		input2 = "1a2b3c4";
		assertTrue(RecursionProblems.almostEquals(input1, input2, 1));
		
		input2 = "1a2b3c4d5";
		assertTrue(RecursionProblems.almostEquals(input1, input2, 1));
		
		input1 = "";
		input2 = "";
		assertTrue(RecursionProblems.almostEquals(input1, input2, 1));
		
		input2 = "a";
		assertTrue(RecursionProblems.almostEquals(input1, input2, 1));
		
		input1 = "1";
		input2 = "";
		assertTrue(RecursionProblems.almostEquals(input1, input2, 1));
		
		
		//Big tests
		input1 = "";
		input2 = "";
		input3 = "";
		letter = 'a';
		for(int i = 0; i < 500; i++) {
			input1 += letter;
			input2 += letter;
			input3 = letter + input3;
			if(letter < 'z')
				letter++;
			else
				letter = 'a';
		}
		
		assertTrue(RecursionProblems.almostEquals(input1, input2, 1));
		assertTrue(RecursionProblems.almostEquals(input1, (input2+'a'), 1));
		assertFalse(RecursionProblems.almostEquals(input1, input3, 1));
		
		
		//MORE COMPLICATED
		input1 = "abcdefg";
		input2 = "abzdxfg"; 
		int threshold = 2;
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input1 = "abzdxfg";
		input2 = "abcdefg";
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input1 = "1234567"; 
		input2 = "abc4567"; 
		threshold = 4;
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input1 = "abc4567";
		input2 = "1234567";
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input1 = "hello there"; 
		input2 = "hello again"; 
		threshold = 5;
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input2 = "hello there"; 
		input1 = "hello again";
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input1 = "abcdef"; 
		input2 = "abc"; 
		threshold = 3;
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input2 = "abcdef"; 
		input1 = "abc";
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input1 = "ab"; 
		input2 = "abcdefgh"; 
		threshold = 6;
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input2 = "ab"; 
		input1 = "abcdefgh";
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input1 = ""; 
		input2 = "abc";
		threshold = 3;
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input2 = ""; 
		input1 = "abc";
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input1 = "1234"; 
		input2 = ""; 
		threshold = 4; 
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input2 = "1234"; 
		input1 = ""; 
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		
		
		
		
		input1 = "abcdef"; 
		input2 = "zzcdef"; 
		threshold = 1;
		assertFalse(RecursionProblems.almostEquals(input1, input2, threshold));
		
		threshold = 2;
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input2 = "abcdef"; 
		input1 = "zzcdef";
		threshold = 1;
		assertFalse(RecursionProblems.almostEquals(input1, input2, threshold));
		
		threshold = 2;
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input1 = "1234567"; 
		input2 = "1234abc"; 
		threshold = 2; 
		assertFalse(RecursionProblems.almostEquals(input1, input2, threshold));
		
		threshold = 3;
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input2 = "1234567"; 
		input1 = "1234abc";
		threshold = 2;
		assertFalse(RecursionProblems.almostEquals(input1, input2, threshold));
		
		threshold = 3;
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input1 = "abc"; 
		input2 = "abcdefg"; 
		threshold = 3;
		assertFalse(RecursionProblems.almostEquals(input1, input2, threshold));
		
		threshold = 4;
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input2 = "abc"; 
		input1 = "abcdefg";
		threshold = 3;
		assertFalse(RecursionProblems.almostEquals(input1, input2, threshold));
		
		threshold = 4;
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input1 = "1234567"; 
		input2 = "123"; 
		threshold = 3;
		assertFalse(RecursionProblems.almostEquals(input1, input2, threshold));
		
		threshold = 4;
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input2 = "1234567"; 
		input1 = "123";
		threshold = 3;
		assertFalse(RecursionProblems.almostEquals(input1, input2, threshold));
		
		threshold = 4;
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input1 = "hello"; 
		input2 = "there"; 
		threshold = 4;
		assertFalse(RecursionProblems.almostEquals(input1, input2, threshold));
		
		threshold = 5;
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		input2 = "hello"; 
		input1 = "there";
		threshold = 4;
		assertFalse(RecursionProblems.almostEquals(input1, input2, threshold));
		
		threshold = 5;
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		
		
		//BIG TESTS
		input1 = "";
		input2 = "";
		input3 = "";
		String input4 = "";
		letter = 'a';
		for(int i = 0; i < 500; i++) {
			input1 += letter;
			input2 += letter;
			if(i%2==0)
				input3 += letter;
			else
				input3 += (letter<'z')?(char)(letter+1):'a';
			input4 += (letter<'z')?(char)(letter+1):'a';
			
			if(letter < 'z')
				letter++;
			else
				letter = 'a';
		}
		
		threshold = 0;
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		assertFalse(RecursionProblems.almostEquals(input1, input3, threshold));
		
		threshold = 1;
		assertTrue(RecursionProblems.almostEquals(input1, input2, threshold));
		assertFalse(RecursionProblems.almostEquals(input1, input3, threshold));
		
		threshold = 250;
		assertTrue(RecursionProblems.almostEquals(input1, input3, threshold));
		threshold = 249;
		assertFalse(RecursionProblems.almostEquals(input1, input3, threshold));
		threshold = 0;
		assertFalse(RecursionProblems.almostEquals(input1, input3, threshold));
		
		
		threshold = 500;
		assertTrue(RecursionProblems.almostEquals(input1, input4, threshold));
		threshold = 499;
		assertFalse(RecursionProblems.almostEquals(input1, input4, threshold));
		threshold = 0;
		assertFalse(RecursionProblems.almostEquals(input1, input4, threshold));
	}
	
	@Test
	public void testHorizontalWordFinder() {
		char[][] puzzle = {{'a', 'b', 'h', 'e', 'l', 'l', 'o'},
				   {'c', 't', 'h', 'e', 'r', 'e', 'd'},
				   {'h', 'o', 'w', 'e', 'a', 'r', 'e'},
				   {'f', 'g', 'h', 'i', 't', 'h', 'i'},
				   {'n', 'g', 's', 'j', 'k', 't', 'o'},
				   {'d', 'a', 'y', 'l', 'm', 'n', 'o'}};


		String word = "hello";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "abhello";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "abhellocth";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "abhellocthered";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "there";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "cthered";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "octhered";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "ctheredho";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "how";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "are";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "howeare";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "dhoweare";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "dhowearef";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "things";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "thingsjkto";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "today";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "todaylmno";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "red";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "mno";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "abhelloctheredhowearefghithingsjktodaylmno";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "mnop";
		assertFalse(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "abhellod";
		assertFalse(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "abhellp";
		assertFalse(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "therd";
		assertFalse(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "abhelloctheredhowearefghithingsjktodaylmnop";
		assertFalse(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "abhelloctheredhowearefghithingsjktodaylmnp";
		assertFalse(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		
		puzzle = new char[][] {{'1', '2', '3', '4', '5'},
						       {'6', '7', '8', '9', '0'},
						       {'0', '9', '8', '7', '6'},
						       {'5', '4', '3', '2', '1'},
						       {'a', 'b', 'c', 'd', 'e'}};
						       
		word = "123";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "12345";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "1234567";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "567890";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "678900";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "00987";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "54321";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "654321";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "654321ab";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "abcde";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "de";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "12345678900987654321abcde";
		assertTrue(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "12345678900987654321abcdef";
		assertFalse(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "123457";
		assertFalse(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "125";
		assertFalse(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "abcdef";
		assertFalse(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "1abcdef";
		assertFalse(RecursionProblems.horizontalWordFinder(puzzle, word));
		
		word = "def";
		assertFalse(RecursionProblems.horizontalWordFinder(puzzle, word));
	}
}
