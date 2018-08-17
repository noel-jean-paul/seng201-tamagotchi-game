package toys;

/** Describes the squeaky toy subclass **/
public class SqueakyToy extends Toy {

	/** The price of a squeaky toy **/
	private static final int squeakyToyPrice = 25;
	/** The amount of happiness given by a squeaky toy **/
	private static final int squeakyToyHappinessIncrease = 32;
	/** The durability of a squeaky toy **/
	private static final int squeakyToyDurability = 30;
	/**The amount the squeaky toy increases a pet's tiredness and hunger upon playing*/
	private static final int squeakyToyExertion= 20;
	
	/** squeaky toy constructor **/
	public SqueakyToy() {
		super(squeakyToyPrice, "squeaky toy", squeakyToyHappinessIncrease, squeakyToyDurability, squeakyToyExertion);
	}
	
	@Override
	/**
	 * @inherit 
	 */
	public void resetDurability() {
		setDurability(squeakyToyDurability);
	}
}
