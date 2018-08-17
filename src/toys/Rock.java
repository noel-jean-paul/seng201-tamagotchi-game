package toys;

/** Describes th rock subclass **/
public class Rock extends Toy {

	/** The price of a rock **/
	private static final int rockPrice = 20;
	/** The amount of happiness given by a rock **/
	private static final int rockHappinessIncrease = 20;
	/** The durability of a rock **/
	private static final int rockDurability = 90;
	/**The amount the rock increases a pet's tiredness and hunger upon playing*/
	private static final int rockExertion = 13;

	/** Rock constructor **/
	public Rock() {
		super(rockPrice, "Rock", rockHappinessIncrease, rockDurability, rockExertion);
	}
	
	@Override
	/**
	 * @inherit 
	 */
	public void resetDurability() {
		setDurability(rockDurability);
	}
}
