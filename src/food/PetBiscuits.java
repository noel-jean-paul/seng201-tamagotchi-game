package food;

/**
 * Subclass of Food representing a PetBiscuits.
 * @author nbi21
 *
 */
public class PetBiscuits extends Food {
	
	//
	//Fields 
	//
	
	/**The type of PetBiscuits*/
	private static final String petBiscuitsType = "Pet Biscuits";
	/**The price of a petBiscuits*/
	private static final int petBiscuitsPrice = 35;
	/**The nutrition provided by a petBiscuits(pet hunger decrease provided)*/
	private static final int petBiscuitsNutrition = 40;
	/**The tastiness of a petBiscuits(pet happiness increase provided by consumption*/
	private static final int petBiscuitsTastiness = 25;
	/**The healthiness of a petBiscuits/the amount a pet's health is increased upon consumption*/
	private static final int petBiscuitsHealthiness = 35;
	/**The amount eating a petBiscuits increases a pet's toilet need*/
	private static final int petBiscuitsToiletNeedIncrease = 35;
	
	//
	//Constructors
	//
	
	/**
	 * Constructor for the petBiscuits class. Calls the super constructor of Food to initialise
	 * its attributes.
	 */
	public PetBiscuits() {
		super(petBiscuitsType, petBiscuitsPrice, petBiscuitsNutrition, petBiscuitsTastiness, 
				petBiscuitsHealthiness, petBiscuitsToiletNeedIncrease);
		
	}

}
