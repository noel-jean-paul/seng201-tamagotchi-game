package toyTests;
import toys.Toy;

/**
 * Mock of the abstract class Toy to allow us to test it. Should only be used within the Testing source folder/
 * testing packages. Behaves in the same way as every other subclass of Toy.
 *
 */
public class MockToy extends Toy {
	private static final int toyPrice = 20;
	private static final int toyHappinessIncrease = 40;
	private static final int toyDurability = 80;
	private static final int toyExertion = 30;
	
	public MockToy(String type) {
		super(toyPrice, type, toyHappinessIncrease, toyDurability, toyExertion);
	}
	
	public void resetDurability() {
		setDurability(toyDurability);
	}

}