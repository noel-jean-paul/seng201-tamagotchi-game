package toyTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ToyTest {
	private static MockToy fluffball;
	private static MockToy billy;
	private static MockToy teddy;

	@Before
	public void setUp() throws Exception {
		fluffball = new MockToy("Best toy ever");
		billy = new MockToy("Teddy bear");
		teddy = new MockToy("Teddy bear");
	}

	@Test
	public void testGetPrice() {
		assertEquals(20, fluffball.getPrice());
	}

	@Test
	public void testGetType() {
		assertEquals("Best toy ever", fluffball.getType());
	}

	@Test
	public void testGetDurability() {
		assertEquals(80, fluffball.getDurability());
	}

	@Test
	public void testGetHappinessIncrease() {
		assertEquals(40, fluffball.getHappinessIncrease());
	}

	@Test
	public void testGetExertion() {
		assertEquals(30, fluffball.getExertion());
	}

	@Test
	public void testUse() {
		fluffball.use(40);
		assertEquals(40, fluffball.getDurability());
		fluffball.use(50);
		assertEquals(0, fluffball.getDurability());
		assertEquals(true, fluffball.isBroken());
		
	}
	
	@Test
	public void testChangeQuantity() {
		Boolean bool = fluffball.changeQuantity(-1);
		assertEquals(1, fluffball.getQuantity());
		assertEquals(bool, false);
		bool = fluffball.changeQuantity(5);
		assertEquals(6, fluffball.getQuantity());
		assertEquals(true, bool);
	}
	
	@Test
	public void testChangeQuantityZero() {
		Boolean bool = fluffball.changeQuantity(0);
		assertEquals(1, fluffball.getQuantity());
		assertEquals(bool, false);
	}
	
	@Test
	public void testSameType() {
		assertEquals(false, fluffball.equals(billy));
	}
	
	@Test
	public void testNotEquals() {
		assertEquals(true, billy.equals(teddy));
	}
	
	@Test
	public void resetDurability() {
		fluffball.use(50);
		fluffball.resetDurability();
		assertEquals(80, fluffball.getDurability());
	}
	
	@Test
	public void testToString() {
		assertEquals("Best toy ever (1)", fluffball.toString());
	}
}