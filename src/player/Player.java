package player;

import java.util.ArrayList;

import food.Food;
import pets.Pet;
import toys.Toy;

/**
 * The class representing players in the game.
 * 
 * @author nbi21
 */
public class Player {

	//
	// Fields
	//

	/** Name of the player **/
	private String playerName;
	/** The pets the player owns */
	private ArrayList<Pet> petList = new ArrayList<Pet>();
	/** The toys a player owns */
	private ArrayList<Toy> toyList = new ArrayList<Toy>();
	/** The foods a player owns */
	private ArrayList<Food> foodList = new ArrayList<Food>();
	/**
	 * Constant which determines how much currency players are given per pet per
	 * day of gameplay
	 */
	private static final int DAILY_ALLOWANCE = 40;
	/** The number of pets a player owns */
	private int numPets;
	/**
	 * Amount of in game currency the player possesses. This is determined by
	 * the number of pets a player owns and the number of days the game spans
	 */
	private int accountBalance;
	/**The player's final score for the game*/
	private int finalScore;
	

	//
	// Constructors
	//

	/**
	 * Constructor for the player class. Sets the initial accountBalance for the
	 * player based off their daily allowance, how many pets they have and how
	 * many days the game spans.
	 * 
	 * @param name
	 *            The name of the player.
	 * @param numPets
	 *            The number of pets the player owns.
	 * @param numDays
	 *            The number of days the game is played for.
	 */
	public Player(String name, int numPets, int numDays) {
		playerName = name;
		this.numPets = numPets;
		accountBalance = DAILY_ALLOWANCE * numDays * numPets;
	}

	//
	// Methods
	//

	//
	// Accessor methods
	//

	/**
	 * Adds a pet to the petList of the player.
	 * 
	 * @param pet
	 *            The pet to be added to the list.
	 */
	public void addPet(Pet pet) {
		petList.add(pet);
	}

	/**
	 * Adds a food to the foodList of the player.
	 * 
	 * @param food
	 *            The food to be added to the list
	 * @param amount The quantiy of the food being added.
	 */
	public void addFood(Food food, int amount) {
		if (!foodList.contains(food)){
			foodList.add(food);
			this.addFood(food, amount - 1);
		}
		else {
			//Get the index of the Food item so we are using the Food object in the player's foodList, not the reference object
			//from the store.
			int index = foodList.indexOf(food);
			
			//get the Food object at the index and increase it's quantity by 1.
			foodList.get(index).changeQuantity(amount);
		}
	}

	/**
	 * Adds a toy to the toyList of the player
	 * 
	 * @param toy
	 *            The toy to be added to the toyList
	 */
	public void addToy(Toy toy) {
		if (!toyList.contains(toy))
			toyList.add(toy);
		else {
			//Get the index of the Toy item so we are using the Toy object in the player's toyList,
			//not the reference object from the store.
			int index = toyList.indexOf(toy);
			
			//Get the Toy object at the index and increase it's quantity by 1. Could use the 
			//getToyAtIndexMethod here
			toyList.get(index).changeQuantity(1);
		}
	}

	/**
	 * Returns the pet located at a specific index in a player's pet list.
	 * 
	 * @param index
	 *            The index of the pet to be returned.
	 * @return The Pet object at the specified index.
	 */
	public Pet getPetAtIndex(int index) {
		return petList.get(index);
	}

	/**
	 * Returns the food located at a specified index in a player's food list.
	 * 
	 * @param index
	 *            The index of the food to be returned.
	 * @return The Food object at the specified index.
	 */
	public Food getFoodAtIndex(int index) {
		return foodList.get(index);
	}

	/**
	 * Returns the Toy object located at a specified index in a player's toy
	 * list.
	 * 
	 * @param index
	 *            The index of the toy to be returned.
	 * @return The Toy object at the index.
	 */
	public Toy getToyAtIndex(int index) {
		return toyList.get(index);
	}

	/**
	 * Returns an ArrayList of the pets a player owns.
	 * 
	 * @return The petList of the player as an ArrayList of Pet objects.
	 */
	public ArrayList<Pet> getPetList() {
		return petList;
	}

	/**
	 * Returns an ArrayList of the foods a player owns.
	 * 
	 * @return The foodList of the player as an ArrayList of Food objects.
	 */
	public ArrayList<Food> getFoodList() {
		return foodList;
	}

	/**
	 * Returns an ArrayList of the toys a player owns.
	 * 
	 * @return The toyList of the player as an ArrayList of Toy objects.
	 */
	public ArrayList<Toy> getToyList() {
		return toyList;
	}

	/**
	 * Returns the accountBalance of the player.
	 * 
	 * @return The accountBalance of the player as an int.
	 */
	public int getAccountBalance() {
		//Do we still need this method? Maybe for scoring as a bonus score for having funds left
		//available.
		return accountBalance;
	}

	/**
	 * Returns the number of pets a player owns.
	 * 
	 * @return The number of pets a player owns as an int.
	 */
	public int getNumPets() {
		return numPets;
	}

	/**
	 * Returns the name of the player.
	 * 
	 * @return The name of the player as a String.
	 */
	public String getPlayerName() {
		return playerName;
	}
	
	/**
	 * Get the player's final score.
	 * 
	 * @return The final score of the player as an int.
	 */
	public int getFinalScore() {
		return calculateFinalScore();
	}
	
	
	
	/**
	 * Removes the specified food from the player's foodList.
	 * 
	 * @param food The food to be removed.
	 */
	public void removeFood(Food food) {
		int index= foodList.indexOf(food);
		//Get the appropriate Food object from the player's foodList.
		Food foodItem = foodList.get(index);
		if (!foodItem.changeQuantity(-1))
			//remove the food using the .remove method of java.util.ArrayList
			foodList.remove(food);
	}
	
	/**
	 * Removes the specified toy from the player's toyList.
	 * 
	 * @param toy The toy to be removed.
	 */
	public void removeToy(Toy toy) {
		int index = toyList.indexOf(toy);
		Toy toyItem = toyList.get(index);
		if (toyItem.getQuantity() == 1)
			toyList.remove(toy);
		else {
			//Reuce the quantity of that toy by 1
			toyItem.changeQuantity(-1);
			toyItem.resetDurability();
			toyItem.resetBroken();
			//Reset the durability of the Toy as we are now effectively using a new, unused Toy.
			toyItem.resetDurability();
			
		}
	}

	//
	// Other Methods
	//

	/**
	 * If the player has sufficient funds, returns true and charges the account of the player by an 
	 * amount, reducing their balance. Else returns false to indicate that the transaction has
	 * failed.
	 * 
	 * @param amount
	 *            The int amount the player's account balance is charged.
	 *            
	 * @return a boolean representing whether the transaction was successful.
	 */
	public boolean chargeAccount(int amount) {
		if (accountBalance - amount >= 0) {
			accountBalance -= amount;
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Computes the final score of the player as an average of the scores of the pets
	 * a player owns. Updates finalScore to this value so it can be displayed on the end screen.
	 * 
	 * @return The player's score as an int.
	 */
	public int calculateFinalScore() {
		int total = 0;
		for(Pet pet : petList) {
			total += pet.getScore();
		}
		finalScore = total / numPets;
		return finalScore;
	}
	

	


}
