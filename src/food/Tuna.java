package food;

/**
 * Subclass of Food representing a Tuna.
 * @author nbi21
 *
 */
public class Tuna extends Food {
	
	//
	//Fields 
	//
	/**The type of Tuna*/
	private static final String tunaType = "tuna";
	/**The price of some tuna*/
	private static final int tunaPrice = 20;
	/**The nutrition provided by some tuna(pet hunger decrease provided)*/
	private static final int tunaNutrition = 10;
	/**The tastiness of a tuna(pet happiness increase provided by consumption*/
	private static final int tunaTastiness = 30;
	/**The healthiness of some tuna/the amount a pet's health is increased upon consumption*/
	private static final int tunaHealthiness = 30;
	/**The amount eating some tuna increases a pet's toilet need*/
	private static final int tunaToiletNeedIncrease = 10;
	
	
	//
	//Constructors
	//
	
	/**
	 * Constructor for the Tuna class. Calls the super constructor of Food to initialise
	 * its attributes.
	 */
	public Tuna() {
		super(tunaType, tunaPrice, tunaNutrition, tunaTastiness, tunaHealthiness, tunaToiletNeedIncrease);
		
	}

}
