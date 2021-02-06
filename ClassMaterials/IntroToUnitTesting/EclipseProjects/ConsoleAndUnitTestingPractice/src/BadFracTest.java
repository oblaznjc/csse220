import static org.junit.Assert.*;

import org.junit.Test;

public class BadFracTest {

	private BadFrac bf12 = new BadFrac(1, 2);
	private BadFrac bf51 = new BadFrac(5, 1);

	private BadFrac bf24 = new BadFrac(2, 4);
	private BadFrac bf02 = new BadFrac(0, 2);

	@Test
	public void testIsReduced() {
		assertTrue(bf12.isReduced());
		assertTrue(bf51.isReduced());
		
		assertFalse(bf24.isReduced());
		assertFalse(bf02.isReduced());



	}

	@Test
	public void testAddBadFrac() {
		BadFrac actual11 = bf12.add(bf12);
		assertEquals(bf11, actual11);
	}

}
