package food;

/**
 * Subclass of Food representing a bone.
 * @author nbi21
 *
 */
public class Bone extends Food {
	
	//
	//Fields 
	//
	/**The type of bone*/
	private static final String boneType = "Bone";
	/**The price of a bone*/
	private static final int bonePrice = 20;
	/**The nutrition provided by a bone(pet hunger decrease provided)*/
	private static final int boneNutrition = 10;
	/**The tastiness of a bone(pet happiness increase provided by consumption*/
	private static final int boneTastiness = 30;
	/**The healthiness of a bone/the amount a pet's health is increased upon consumption*/
	private static final int boneHealthiness = 30;
	/**The amount eating a bone increases a pet's toilet need*/
	private static final int boneToiletNeedIncrease = 10;
	
	//
	//Constructors
	//
	
	/**
	 * Constructor for the Bone class. Calls the super constructor of Food to initialise
	 * its attributes.
	 */
	public Bone() {
		super(boneType, bonePrice, boneNutrition, boneTastiness, boneHealthiness, boneToiletNeedIncrease);
		
	}

}
