package toys;

/** Describes the Yarn subclass **/
public class Yarn extends Toy {

	/** The price of yarn **/
	private static final int yarnPrice = 20;
	/** The amount of happiness given by yarn **/
	private static final int yarnHappinessIncrease = 28;
	/** The durability of yarn **/
	private static final int yarnDurability = 30;
	/**The amount the yarn increases a pet's tiredness and hunger upon playing*/
	private static final int yarnExertion = 37;

	/** Yarn constructor **/
	public Yarn() {
		super(yarnPrice, "Yarn", yarnHappinessIncrease, yarnDurability, yarnExertion);
	}
	
	@Override
	/**
	 * @inherit 
	 */
	public void resetDurability() {
		setDurability(yarnDurability);
	}
}
