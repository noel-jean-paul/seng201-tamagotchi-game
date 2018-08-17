package food;

/**
 * The abstract superclass Food from which the foods pets can eat are inherited
 * 
 * @author nbi21
 */
public abstract class Food {

	//
	// Fields
	//

	/** Type of the food. */
	private String type;
	/** Price of the food. */
	private int price;
	/** Nutrition value/pet hunger decrease of the food. */
	private int nutrition;
	/** Tastiness/happiness increase of pet upon eating. */
	private int tastiness;
	/**The amount the health of a pet changes upon eating the food*/
	private int healthiness;
	/** Amount the consumption of food increases pet's toilet need. */
	private int toiletNeedIncrease;
	/**The quantity of the item in the player's foodList/inventory.*/
	private int quantity = 1;
	
	//
	//Constructors
	//
	
	/**
	 * The constructor of the Food class.
	 * @param type The type of the food.
	 * @param price The price of the food.
	 * @param nutrition The nutrition value of the food.
	 * @param tastiness The tastiness of the food.
	 * @param healthiness The healthiness of the food.
	 * @param toiletNeedIncrease The amount the consumption of the food increases a pet's toilet need.
	 */
	
	public Food(String type, int price, int nutrition, int tastiness, int healthiness,
			int toiletNeedIncrease) {
		this.type = type;
		this.price = price;
		this.nutrition = nutrition;
		this.tastiness = tastiness; 
		this.healthiness = healthiness;
		this.toiletNeedIncrease = toiletNeedIncrease;
		
	}

	//
	// Methods
	//

	//
	// Accessor methods
	//

	/**
	 * Returns the price of the food.
	 * 
	 * @return The price of the food as an int.
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Returns the type of the food.
	 * 
	 * @return The type of the food as a String.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Returns the nutrition value of the food.
	 * 
	 * @return The nutrition value of the food as an int.
	 */
	public int getNutrition() {
		return nutrition;
	}

	/**
	 * Return the tastiness of the food.
	 * 
	 * @return The tastiness of the food as an int.
	 */
	public int getTastiness() {
		return tastiness;
	}
	
	/**
	 * Return the healthiness of the food.
	 * 
	 * @return The healthiness of the food as an int.
	 */
	public int getHealthiness() {
		return healthiness;
	}

	/**
	 * Return the toiletNeedIncrease of the food.
	 * 
	 * @return The toiletNeedIncrease of the food as an int.
	 */
	public int getToiletNeedIncrease() {
		return toiletNeedIncrease;
	}
	
	
	/**
	 *Returns the quantity of the food in the player's inventory/toyList.
	 *
	 * @return the quanity of the food in the player's toyList as an int.
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Increase the quantity of the food by 'change' if the change is non-zero
	 * and if quantity is greater than one. Return a boolean to indicate
	 * whether the change was successful.
	 * 
	 * @param change The amount for food quantity to be changed by.
	 * @return true if the change was successful, false otherwise.
	 */
	public boolean changeQuantity(int change) {
		if ((quantity + change) < 1 || change == 0)
			return false;
		else {
			quantity += change;
			return true;
		}
	}
	
	/**
	 * Overrides the toString() method of java.lang.object.
	 * 
	 * @return A string showing the food type and its quantity.
	 */
	@Override
	public String toString() {
		return type + " (" + quantity + ")";
	}
	
	/**
	 * Compares two foods based on their type attribute.
	 * 
	 * @return true if the food's types are equal, false otherwise. 
	 */
	@Override
	public boolean equals(Object obj) {
		//first check to see if the objects are in fact the same object.
		if (obj == this) {				
			return true;
		}
		//Makes sure that the obj is not null and that the objects
		//being compared are instances of the same class.
		if (obj == null || obj.getClass() != this.getClass()) {   
			return false;
		}
		//Cast obj to a Food.
		Food other = (Food) obj;		
		//Return true iff the type of obj is not null and if the 2 objects have 
		//the same type property.
		return (other.type != null && other.type.equals(type));	  
	}
	
	/**
	 * Updates the hashCode for the type attribute in line with it being overriden above. hashCode
	 * must be overriden when java.lang.equals is overridden.
	 * 
	 * @return the hashCode of the type attribute as an int.
	 */
	@Override 
	//Override hashCode as we are overrriding java.lang.object.equals
	public int hashCode() {		
		//This hashCode change is for a String such as type.
		return type.hashCode() * 31 + 17;  
	}
	 

}