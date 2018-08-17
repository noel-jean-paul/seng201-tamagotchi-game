package foodTests;
import food.Food;
/**
 * Class to allow us to instantiate a subclass of the abstract Food class so that it's public methods can be tested.
 */

public class MockFood extends Food {
	//
	//Fields 
	//
	/**The price of a mockFood*/
	private static final int mockFoodPrice = 10;
	/**The nutrition provided by a mockFood(pet hunger decrease provided)*/
	private static final int mockFoodNutrition = 20;
	/**The tastiness of a mockFood(pet happiness increase provided by consumption*/
	private static final int mockFoodTastiness = 30;
	/**The healthiness of a mockFood/the amount a pet's health is increased upon consumption*/
	private static final int mockFoodHealthiness = 40;
	/**The amount eating a MockFoodincreases a pet's toilet need*/
	private static final int mockFoodToiletNeedIncrease = 50;
	
	//
	//Constructors
	//
	/**
	 * Constructor for the Mock Pet class.
	 * 
	 * @param type The type of the MockFood object.
	 */
	public MockFood(String type) {
		super(type, mockFoodPrice, mockFoodNutrition, mockFoodTastiness, mockFoodHealthiness, 
				mockFoodToiletNeedIncrease);
	}
}