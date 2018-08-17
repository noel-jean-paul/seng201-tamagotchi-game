package toys;

/** Describes the toy mouse subclass **/
public class ToyMouse extends Toy {

	/** The price of a toy mouse **/
	private static final int toyMousePrice = 37;
	/** The amount of happiness given by a toy mouse **/
	private static final int toyMouseHappinessIncrease = 28;
	/** The durability of a toy mouse **/
	private static final int toyMouseDurability = 26;
	/**The amount the toy mouse increases a pet's tiredness and hunger upon playing*/
	private static final int toyMouseExertion = 34;

	/** toy mouse constructor **/
	public ToyMouse() {
		super(toyMousePrice, "toy mouse", toyMouseHappinessIncrease, toyMouseDurability, toyMouseExertion);
	}
	
	@Override
	/**
	 * @inherit 
	 */
	public void resetDurability() {
		setDurability(toyMouseDurability);
	}
}
