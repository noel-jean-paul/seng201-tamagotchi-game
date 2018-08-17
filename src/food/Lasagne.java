package food;

/**
 * Subclass of Food representing a Lasagne.
 * @author nbi21
 *
 */
public class Lasagne extends Food {
	
	//
	//Fields 
	//
	/**The type of lasagne*/
	private static final String lasagneType = "lasagne";
	/**The price of a lasagne*/
	private static final int lasagnePrice = 60;
	/**The nutrition provided by a lasagne(pet hunger decrease provided)*/
	private static final int lasagneNutrition = 50;
	/**The tastiness of a lasagne(pet happiness increase provided by consumption*/
	private static final int lasagneTastiness = 50;
	/**The healthiness of a lasagne/the amount a pet's health is increased upon consumption*/
	private static final int lasagneHealthiness = 5;
	/**The amount eating a lasagne increases a pet's toilet need*/
	private static final int lasagneToiletNeedIncrease = 40;

	//
	//Constructors
	//
	
	/**
	 * Constructor for the Lasagne class. Calls the super constructor of Food to initialise
	 * its attributes.
	 */
	public Lasagne() {
		super(lasagneType, lasagnePrice, lasagneNutrition, lasagneTastiness, lasagneHealthiness, 
				lasagneToiletNeedIncrease);
		
	}

}
