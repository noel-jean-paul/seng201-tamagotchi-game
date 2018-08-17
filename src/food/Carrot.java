package food;

/**
 * Subclass of Food representing a carrot.
 * @author nbi21
 *
 */
public class Carrot extends Food {
	
	//
	//Fields 
	//
	/**The type of carrot*/
	private static final String carrotType = "carrot";
	/**The price of a carrot*/
	private static final int carrotPrice = 20;
	/**The nutrition provided by a carrot(pet hunger decrease provided)*/
	private static final int carrotNutrition = 25;
	/**The tastiness of a carrot(pet happiness increase provided by consumption*/
	private static final int carrotTastiness = 30;
	/**The healthiness of a carrot/the amount a pet's health is increased upon consumption*/
	private static final int carrotHealthiness = 35;
	/**The amount eating a carrot increases a pet's toilet need*/
	private static final int carrotToiletNeedIncrease = 20;
	
	//
	//Constructors
	//
	
	/**
	 * Constructor for the Carrot class. Calls the super constructor of Food to initialise
	 * its attributes.
	 */
	public Carrot() {
		super(carrotType, carrotPrice, carrotNutrition, carrotTastiness, carrotHealthiness, carrotToiletNeedIncrease);
		
	}

}