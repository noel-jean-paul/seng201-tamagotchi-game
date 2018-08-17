package foodTests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


/**
 * JUnit tests of the Food class.
 * 
 */
public class FoodTest {
	private static MockFood food;
	private static MockFood sausage;
	private static MockFood pene;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		food = new MockFood("Pasta");
		sausage = new MockFood("Sausage");
		pene = new MockFood("Pasta");
	}

	@Test
	public void testGetPrice() {
		assertEquals(10, food.getPrice());
	}

	@Test
	public void testGetType() {
		assertEquals("Pasta", food.getType());
	}

	@Test
	public void testGetNutrition() {
		assertEquals(20, food.getNutrition());
	}

	@Test
	public void testGetTastiness() {
		assertEquals(30, food.getTastiness());
	}

	@Test
	public void testGetHealthiness() {
		assertEquals(40, food.getHealthiness());
	}

	@Test
	public void testGetToiletNeedIncrease() {
		assertEquals(50, food.getToiletNeedIncrease());
	}
	
	@Test
	public void testChangeQuantity() {
		Boolean bool = food.changeQuantity(-1);
		assertEquals(1, food.getQuantity());
		assertEquals(bool, false);
		bool = food.changeQuantity(5);
		assertEquals(6, food.getQuantity());
		assertEquals(true, bool);
	}
	
	@Test
	public void testChangeQuantityZero() {
		Boolean bool = food.changeQuantity(0);
		assertEquals(1, food.getQuantity());
		assertEquals(bool, false);
	}
	
	@Test
	public void testEquals() {
		assertEquals(false, food.equals(sausage));
		assertEquals(true, food.equals(pene));
	}
	
	@Test
	public void testToString() {
		assertEquals("Pasta (1)", food.toString());
	}
}