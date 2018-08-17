package toys;


/**
 * Class representing the in-game toys
 */
public abstract class Toy {

	//
	// Fields
	//
	/** The price of the toy **/
	private int price;
	/** The type of the toy **/
	private String type;
	/** The amount the toy increases a pet's happiness by **/
	private int happinessIncrease;
	/** How damaged the toy is **/
	private int durability;
	/**How much the pets hunger and tiredness increase after using the toy*/
	private int exertion;
	/**Whether the toy is broken or not*/
	private boolean broken = false;
	/**Quantity of the toy in the player's toyList/inventory*/
	private int quantity = 1;

	//
	// Constructors
	//
	/** 
	 * Constructs an instance of Toy 
	 * 
	 * @param toyPrice The price of the toy.
	 * @param toyType The type of the toy.
	 * @param toyHappinessIncrease The amount a toy increases a pet's happiness.
	 * @param toyDurability The durability of the toy.
	 * @param toyExertion The amount a toy increases a pet's hunger and tiredness.
	 */
	public Toy(int toyPrice, String toyType, int toyHappinessIncrease, int toyDurability, int toyExertion) {
		price = toyPrice;
		type = toyType;
		happinessIncrease = toyHappinessIncrease;
		durability = toyDurability;
		exertion = toyExertion;
	};

	//
	// Methods
	//

	//
	// Accessor methods
	//
	/**
	 * Getter for toy.price
	 * 
	 * @return The price of the toy as an int
	 **/
	public int getPrice() {
		return price;
	}

	/**
	 * Getter for toy.type
	 * 
	 * @return The type of the toy as a string
	 **/
	public String getType() {
		return type;
	}

	/**
	 * Getter for toy.durability
	 * 
	 * @return The durability of the toy as an int
	 **/
	public int getDurability() {
		return durability;
	}

	/**
	 * Getter for toy.happinessIncrease
	 * 
	 * @return  How much the toy increases a pet's happiness as an int
	 **/
	public int getHappinessIncrease() {
		return happinessIncrease;
	}
	
	
	/**
	 * Getter for Toy.exertion
	 * 
	 * @return How much the toy increases the pets tiredness and hunger upon being played with as an int.
	 */
	public int getExertion() {
		return exertion;
	}
	
	/**
	 * Returns whether the toy is broken or not
	 * 
	 * @return a boolean representing the state of the toy, true if broken else false.
	 */
	public boolean isBroken() {
		return broken;
	}
	
	/**
	 *Returns the quantity of the toy in the player's inventory/toyList.
	 *
	 * @return the quanity of the toy in the player's toyList as an int.
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Setter for the durability attribute. Used by the Toy subclasses to reset their durabilities
	 * 
	 * @param durability The value for the durability to be set to.
	 */
	public void setDurability(int durability) {
		this.durability = durability;
	}
	
	

	//
	// Other methods
	//
	
	/**
	 * Increase the quantity of the food by 'change' if the change is non-zero
	 * and if quantity is greater than one. Return a boolean to indicate whether
	 * the change was successful.
	 * 
	 * @param change
	 *            The amount quantity is changed by.
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
	 * Reset the durability of the toy to the initial value for each type of toy. 
	 */
	public abstract void resetDurability();
	
	/**
	 * Reset broken to false.
	 */
	public void resetBroken() {
		broken = false;
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
	* Compares two toys based on their type attribute. Used for determining if
	 * a toy is a favourite or least favourite toy.
	 * 
	 * @return true if the toy's types are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {				//first check to see if the objects are in fact the same object.
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {   //Makes sure that the obj is not null and that the objects
																  //being compared are instances of the same class.
			return false;
		}
		Toy other = (Toy) obj;									  //Cast obj to a Toy.
		return (other.type != null && other.type.equals(type));	  //Return true iff the type of obj is not null and if
																  //the 2 objects have the same type property.
		
		
	}
	/**
	 * Updates the hashCode for the type attribute in line with it being overriden above. hashCode
	 * must be overriden when java.lang.equals is overridden.
	 * 
	 * @return the hashCode of the type attribute as an int.
	 */
	@Override 
	public int hashCode() {				   //Override hashCode as we are overrriding java.lang.object.equals
		return type.hashCode() * 31 + 17;  //This hashCode change is for a String such as type.
	}
	 
	/**
	 * Use the toy and damage it according to the pet's roughness. If the durability drops to 0,
	 * return true so that the toy can be removed from the player's inventory and the happiness of the pet
	 * can be adjusted accordingly. Else returns false indicating that the toy is sill intact.
	 * 
	 * @param petRoughness The roughness of the pet with toys.
	 **/
	public void use(int petRoughness) {
		durability -= petRoughness;
		if(durability <= 0) {
			durability = 0;             //Ensures durability is never < 0, values which do not make sense.
			broken = true;				//indicates that the toy has broken.
		}
	}

}