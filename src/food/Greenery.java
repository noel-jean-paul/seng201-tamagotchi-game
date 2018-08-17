package food;

/**
 * Subclass of Food representing some Greenery.
 * @author nbi21
 *
 */
public class Greenery extends Food {
	
	//
	//Fields 
	//
	/**The type of greenery*/
	private static final String greeneryType = "greenery";
	/**The price of some greenery*/
	private static final int greeneryPrice = 25;
	/**The nutrition provided by some greenery(pet hunger decrease provided)*/
	private static final int greeneryNutrition = 30;
	/**The tastiness of some greenery(pet happiness increase provided by consumption*/
	private static final int greeneryTastiness = 15;
	/**The healthiness of some greenery/the amount a pet's health is increased upon consumption*/
	private static final int greeneryHealthiness = 35;
	/**The amount eating some greenery increases a pet's toilet need*/
	private static final int greeneryToiletNeedIncrease = 30;

	//
	//Constructors
	//
	
	/**
	 * Constructor for the Greenery class. Calls the super constructor of Food to initialise
	 * its attributes.
	 */
	public Greenery() {
		super(greeneryType, greeneryPrice, greeneryNutrition, greeneryTastiness, greeneryHealthiness, 
				greeneryToiletNeedIncrease);
		
	}

}
