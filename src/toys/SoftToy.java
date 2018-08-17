package toys;

/** Describes the soft toy subclass **/
public class SoftToy extends Toy {

	/** The price of a soft toy **/
	private static final int softToyPrice = 40;
	/** The amount of happiness given by a soft toy **/
	private static final int softToyHappinessIncrease = 40;
	/** The durability of a soft toy **/
	private static final int softToyDurability = 15;
	/**The amount the soft toy increases a pet's tiredness and hunger upon playing*/
	private static final int softToyExertion = 14;

	/** soft toy constructor **/
	public SoftToy() {
		super(softToyPrice, "soft toy", softToyHappinessIncrease, softToyDurability, softToyExertion);
	}
	
	@Override
	/**
	 * @inherit 
	 */
	public void resetDurability() {
		setDurability(softToyDurability);
	}
}
