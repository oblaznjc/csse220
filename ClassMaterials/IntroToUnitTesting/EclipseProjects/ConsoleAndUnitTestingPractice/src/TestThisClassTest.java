import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestThisClassTest {

	@Test
	public void testNumberOfXs() {

		assertEquals(TestThisClass.numberOfXs("abcde"), 0); // test no x, X
		assertEquals(TestThisClass.numberOfXs(""), 0); // test empty string
		assertEquals(TestThisClass.numberOfXs("xxxxxx"), 6); // test many x
		assertEquals(TestThisClass.numberOfXs("XXXXX"), 5); // test many X
		assertEquals(TestThisClass.numberOfXs("xXxXX"), 5); // test a mixture of x, X
		assertEquals(TestThisClass.numberOfXs("xXxXX1234!"), 5); // test a complicated combination
		
		// x, y, z all return 15 which fails by over counting
		assertEquals(TestThisClass.numberOfXs("abcdefghijklmnopqrstuvwxyz"), 1);
		// x, y, z all return 11 which fails by over counting
		assertEquals(TestThisClass.numberOfXs("ABCDEFGHIJKLMNOPQRSTUVWXYZ"), 1);
	}

	@Test
	public void testCountChocula() {
		assertEquals(TestThisClass.countChocula(""), 0); // test empty string
		assertEquals(TestThisClass.countChocula("chocula"), 0); // test case sensitive
		assertEquals(TestThisClass.countChocula("ChoculaXXX"), 1);

		// Fails to recognize "Chocula" alone because the inputString.length() 
			//demands more than 7 characters in its for loop
		assertEquals(TestThisClass.countChocula("Chocula"), 1); // common test case at minimum length
		
		// Fails to Recognize Colcula when it is is at the end of a string
		assertEquals(TestThisClass.countChocula("XXXChocula"), 1);
	}

	@Test
	public void testPaintCost() { 
		assertEquals(TestThisClass.paintCost(1, 1, 0), 0); // free paint
		assertEquals(TestThisClass.paintCost(0, 0, 1), 0); // no paint needed
		assertEquals(TestThisClass.paintCost(1, 1, 1), 1); // simple test
		assertEquals(TestThisClass.paintCost(1, 1, 1), 1); // simple test
		assertEquals(TestThisClass.paintCost(0, 0, -1), -1); // includes a negative
		assertEquals(TestThisClass.paintCost(0, -1, -1), -1); // includes 2 negatives


	}

	@Test
	public void testPizzaCostCalculator() {
		ArrayList<String> special = new ArrayList<String>();
		special.add("pepperoni");
		special.add("onions");
		special.add("sausage");
		assertEquals(TestThisClass.pizzaCostCalculator(special), 12); //special pizza
		
		ArrayList<String> toppingsList0 = new ArrayList<String>();
		assertEquals(TestThisClass.pizzaCostCalculator(toppingsList0), 8); //empty pizza
		
		ArrayList<String> toppingsList1 = new ArrayList<String>();
		toppingsList1.add("bananna");
		assertEquals(TestThisClass.pizzaCostCalculator(toppingsList1), 10); // 1 topping pizza
		
		ArrayList<String> toppingsList2 = new ArrayList<String>();
		toppingsList2.add("bananna");
		toppingsList2.add("apple");
		assertEquals(TestThisClass.pizzaCostCalculator(toppingsList2), 12); // 2 topping pizza
		
		ArrayList<String> toppingsList3 = new ArrayList<String>();
		toppingsList3.add("bananna");
		toppingsList3.add("apple");
		toppingsList3.add("ice cream");
		assertEquals(TestThisClass.pizzaCostCalculator(toppingsList3), 13); // 3 topping pizza
		
		ArrayList<String> toppingsList4 = new ArrayList<String>();
		toppingsList4.add("bananna");
		toppingsList4.add("apple");
		toppingsList4.add("ice cream");
		toppingsList4.add("bark");
		assertEquals(TestThisClass.pizzaCostCalculator(toppingsList4), 14); // 4 topping pizza
		
		ArrayList<String> specialMAX = new ArrayList<String>();
		specialMAX.add("pepperoni");
		specialMAX.add("onions");
		specialMAX.add("sausage");
		specialMAX.add("bananna");
		assertEquals(TestThisClass.pizzaCostCalculator(special), 13); //special pizza with extra ingredients
		// any pizza including the special ingredients will always return 12!
	}

}
