/**
 * Provides the Pet superclass and its sub classes, the 6 species of pet which
 * players can own in the game.
 */

package pets;

import java.util.*;

import player.*;
import toys.*;
import gui.GuiEnvironment;
import food.Food;


/**
 * The class representing pets
 */
public abstract class Pet {

	//
	// Fields
	//
	
	/** Name of the pet **/
	private String name;
	/** Species of the pet **/
	private String species;
	
	/** How hungry the pet is **/
	private int hunger = 50;
	/** How tired the pet is **/
	private int tiredness = 50;
	/** How happy the pet is **/
	private int happiness = 70;
	/** How healthy the pet is **/
	private int health = 100;
	/** How badly the pet needs the toilet **/
	private int toiletNeed = 50;
	
	/** Weight of the pet **/
	private float weight;
	/** Rate at which the pet's need for the toilet increases **/
	private int toiletNeedChange;
	/** Rate at which the pet becomes hungry **/
	private int hungerChange;
	/**Rate at which the pet becomes tired*/
	private int tirednessChange;
	/**Rate at which the pet becomes bored*/
	private int happinessChange;
	/**Rate at which the pet becomes unhealthy*/
	private int healthChange;
	
	/** The pet's favourite toy.**/
	private Toy favouriteToy;
	/** The pet's least favourite toy **/
	private Toy leastFavToy;
	/** The pet's favourite food **/
	private Food favouriteFood;
	
	/** The pet's owner **/
	private Player owner;
	/** Whether the pet is alive **/
	private boolean alive = true;
	/** Whether the pet has been dead **/
	private boolean hasBeenRevived = false;
	/** Number of turns remaining **/
	private int actionsRemaining = 2;
	/** How roughly the pet plays with toys **/
	private int playRoughness;
	/**Whether the pet is misbehaving or not*/
	private boolean isMisbehaving = false;
	/**The number of days for which the pet has been misbehaving*/
	private int daysMisbehaving = 0;
	/**Whether the pet is sick or not*/
	private boolean isSick = false;
	/**The number of days the pet has been sick for*/
	private int daysSick = 0;
	/**The score associated with the pet, initialised to 0.*/
	private int score = 0;
	/**The Random object used for random number generation throughout the class*/
	private Random rand;
	//
	// Constructors
	//

	/**import java.util.Random;
	 * Constructs an instance of Pet. Uses random numbers to determine its
	 * favourite foods and toys as well as to set it's weight.
	 * The Random object parameter allows for testing of the methods involving random number 
	 * generation.
	 * 
	 * @param petName The name of the pet.
	 * @param petSpecies Species of the pet.
	 * @param petOwner Owner of the pet.
	 * @param meanWeight Value used to calculate the weight of the pet(weight within 20% of this value.
	 * @param pettoiletNeedChange Increase of pet's need for the toilet per day.
	 * @param petHungerChange Increase of the pet's hunger per day.
	 * @param petPlayRoughness How rough the pet is with toys.
	 * @param petTirednessChange Increase of the pet's tiredness per day.
	 * @param petHealthChange Decrease of the pet's health per day.
	 * @param petHappinessChange Decrease of the pet's happiness per day.
	 * @param rand The Random object used to generate random numbers. 
	 */
	public Pet(String petName, String petSpecies, Player petOwner, float meanWeight, 
			int pettoiletNeedChange,int petHungerChange, int petPlayRoughness, int petTirednessChange,
			int petHealthChange, int petHappinessChange, Random rand) {
		name = petName;
		species = petSpecies;
		owner = petOwner;
		toiletNeedChange = pettoiletNeedChange;
		hungerChange = petHungerChange;
		tirednessChange = petTirednessChange;
		healthChange = petHealthChange;
		happinessChange = petHappinessChange;
		playRoughness = petPlayRoughness;
		this.rand = rand;
		
		//Generates a random number between 0 and 1 then
		//multiplies it by 2. Subtracting this from 1 gives a float between -1.0 and 1.0 inclusive.
		//Multiplying by 20% of the mean weight and adding the mean weight yields a random weight as a float
		//between meanWeight + meanWeight/5 and meanWeight - meanWeight/5.
		weight = meanWeight + (1 - rand.nextFloat() * 2) * (meanWeight / 5);  
		
		// Create a game environment object used only in this constructor.
		GuiEnvironment tempGame = new GuiEnvironment();
		ArrayList<Toy> toyList = tempGame.getToyList();
		
		//Random int from 0-5 for the 6 toys in the game.
		int favToyIndex = rand.nextInt(5); 
		favouriteToy = toyList.get(favToyIndex);
		
		//Favourite toy cannot be an option for least favourite toy so remove it from the list
		toyList.remove(favouriteToy);

		// Now there are only 5 toys to choose from.
		int leastFavToyIndex = rand.nextInt(4); 
		leastFavToy = toyList.get(leastFavToyIndex);
		
		// Same process, but for favourite food.
		int favFoodIndex = rand.nextInt(5); 
		favouriteFood = tempGame.getFoodList().get(favFoodIndex);

		
	};

	//
	// Methods
	//

	//
	// Accessor methods
	//

	/**
	 * Getter for pet.name
	 * 
	 * @return The name of the pet as a string
	 **/
	public String getName() {
		return name;
	}

	/**
	 * Getter for pet.species
	 * 
	 * @return The species of the pet as a string
	 **/
	public String getSpecies() {
		return species;
	}

	/**
	 * Getter for pet.hunger
	 * 
	 * @return How hungry the pet is as an int
	 **/
	public int getHunger() {
		return hunger;
	}

	/**
	 * Getter for pet.tiredness
	 * 
	 * @return The tiredness of the pet as an int
	 **/
	public int getTiredness() {
		return tiredness;
	}

	/**
	 * Getter for pet.happiness
	 * 
	 * @return The happiness of a pet as an int
	 **/
	public int getHappiness() {
		return happiness;
	}

	/**
	 * Getter for pet.toiletNeed
	 * 
	 * @return How badly the pet needs to go to the toilet as an int
	 **/
	public int getToiletNeed() {
		return toiletNeed;
	}

	/**
	 * Getter for pet.health
	 * 
	 * @return The pet's health as an int
	 **/
	public int getHealth() {
		return health;
	}
	

	/**
	 * Getter for pet.hasBeenRevived
	 * 
	 * @return Whether the pet has been dead or not as a boolean
	 **/
	public boolean getHasBeenRevived() {
		return hasBeenRevived;
	}

	/**
	 * Getter for pet.alive
	 * 
	 * @return Whether the pet is alive or not as a boolean
	 **/
	public boolean isAlive() {
		return alive;
	}

	/**
	 * Getter for pet.weight
	 * 
	 * @return The pet's weight as an int
	 **/
	public float getWeight() {
		return weight;
	}

	/**
	 * Getter for pet.actionsRemaining
	 * 
	 * @return The number of turns remaining as an int
	 **/
	public int getActionsRemaining() {
		return actionsRemaining;
	}

	/**
	 * Getter for pet.favouriteToy
	 * 
	 * @return The pet's favourite toy as a Toy
	 **/
	public Toy getFavouriteToy() {
		return favouriteToy;
	}
	
	/**
	 * Determines whether the pet is sick or not.
	 * 
	 * @return The sickness state of the pet as a boolean.
	 */
	public boolean isSick() {
		return isSick;
	}

	/**
	 * Determines whether the pet is misbehaving or not.
	 * 
	 * @return The misbehaviour state of the pet as a boolean.
	 */
	public boolean isMisbehaving() {
		return isMisbehaving;
	}
	
	/**
	 * Returns the score associated with the pet.
	 * 
	 * @return The score of the pet as an int.
	 */
	public int getScore() {
		return score;
	}
	
	//
	// Other methods
	//

	/**
	 * Have the pet consume some food. It's weight and happiness will increase
	 * according to the food consumed. A pet's favourite food provides double
	 * happiness. Remove the food from the player's foodList.
	 * 
	 * @param food The food to be fed to the pet.
	 */
	public void feed(Food food) {
		if (food == favouriteFood) { 
			//Double the tastiness value for a favourite food.
			happiness += food.getTastiness() * 2;    
		} 
		else {
			//Else normal tastiness.
			happiness += food.getTastiness();        
		}
		//update pet health.
		health += food.getHealthiness() ;
		//update pet hunger.
		hunger -= food.getNutrition();				
		//Increase toiletNeed relative to size of meal
		toiletNeed += food.getToiletNeedIncrease();
		//update pet weight based on the size of the meal. e.g nutrition of 40 means a weight
		//increase of 5%
		weight *= 1 + food.getNutrition() / 800;
		//remove food from player's food list or decrease it's quantiy by 1.
		owner.removeFood(food);	
		//Reduce the actions left for the pet that day by 1.
		actionsRemaining -= 1;						
		
		//For each stat that has been updated, check that it is not outside the max/min 
		//bounds and if it is, set it to the relevant max/min bound.
		if (health > 100)			
			health = 100;				
		if (happiness > 100)					
			happiness = 100;
		if (hunger < 0)
			hunger = 0;
		if (toiletNeed > 100)
			toiletNeed = 0;
		
	}
	
	/**
	 * Have the pet sleep. It's tiredness is reduced by 90. Reduces the remaining actions of the pet by 1.
	 * 
	 */
	public void sleep() {
		//Decrease the pet's tiredness by 90 if this will keep tiredness >= 0.
		if (tiredness >= 90)               
			tiredness -= 90;
		else       
			//Else set tiredness to 0.
			tiredness = 0; 
		//Reduce the actions remaining for the pet by 1.
		actionsRemaining -= 1;  
		//Increase the hunger and health of the pet.
		health += 15;
		hunger += 15;
	}

	/**
	 * Have the pet play with a toy. It's happiness increases according to the
	 * type of toy. The toy's durability deacreases according to the roughness
	 * of the pet. If the durability is reduced to 0, the toy is broken and removed from
	 * the player's toyList.
	 * 
	 * @param toy The toy being played with.
	 */
	public void play(Toy toy) {
		//Use one of the pet's remaining actions
		actionsRemaining--;
		//Update the pet's tiredness.
		tiredness += toy.getExertion();     
		//Update the pet's hunger.
		hunger += toy.getExertion(); 	
		//Use the toy, reducing its durability, which may break it.
		toy.use(playRoughness);	
		
		if(toy.isBroken()) {
			//Check if the toy is the pet's favourite toy.
			if (toy.equals(favouriteToy))     
				//Favourite toy breaking gives double unhappiness.
				happiness -= toy.getHappinessIncrease() * 2;
			 
			else if (toy.equals(leastFavToy))
				//Least favourite toy breaking gives half happiness decrease.
				happiness -= toy.getHappinessIncrease() / 2;         
			else
				//Other toys reduce happiness by their happinessIncrease value.
				happiness -= toy.getHappinessIncrease(); 
			
			owner.removeToy(toy);
		}
		else {     
			//Increasing the pet's happiness if the toy does not break based off of whether 
			//it is their favourite, least favourite or just an average toy.
			if (toy.equals(favouriteToy))							
				happiness += toy.getHappinessIncrease() * 2;        
			else if (toy.equals(leastFavToy))
				happiness += toy.getHappinessIncrease() / 2;
			else
				happiness += toy.getHappinessIncrease();
		}
		//Ensure that stats updated in the method have not gone out of bounds and set them to the
		//relevant bound if they have.
		if (tiredness > 100)			
			tiredness = 100;			
		if (hunger > 100)
			hunger = 100;
		if (happiness > 100) 
			happiness = 100;

		}
	
	/**
	 * If the owener has sufficient funds: Reset the pet's health to 100 and set alive and hasBeenRevived 
	 * to true, reviving the pet. Charge the player for this and reduce their score.
	 * The pet can only be revived if it has not been revived in the past.
	 * 
	 * @return true if the pet was revived, false otherwise.
	 */
	public boolean revive() {
		//Reset the pet's stats to some new values.
		if (owner.chargeAccount(20)){
		health = 100;       
		happiness = 70;              
		hunger = 60;
		toiletNeed = 60;
		tiredness = 30;
		
		//Make the pet alive again.
		alive = true;				
		//Update whether the pet has been revived or not.
		hasBeenRevived = true;	
		//Update pet's score.
		score -= 50;    
		return true;
		}
		else return false;
	}
	
	/**
	 * Kill the pet
	 */
	private void die() {
		//Kill the pet
		alive = false;			
		//Reduce the pet's score.
		score -= 150;	
		if (score < 0)
			score = 0;
		}

	/**
	 * Have the pet go to the toilet. The pet's weight changed depending on how
	 * badly the pet needed the toilet, and its toiletNeed drops to 0.	
	 */
	public void toilet() {
		//Reduce the pet's weight by 5%.
		weight -= 0.05 * weight;
		//Set the pet's toiletNeed to 0.
		toiletNeed = 0;					
		actionsRemaining--;
	}
	
	
	/**Punish the pet for its disobedience, stopping it misbehaving but reducing its 
	 * happiness.
	 */
	public void punish() {
		isMisbehaving = false;
		happiness -= 20;
	}
	
	/**
	 * Give the pet medicine for a cost, curing its sickness
	 */
	public void medicate() {
		//Cure the pet's sickness.
		isSick = false;			
		//Charge the player's account.
		owner.chargeAccount(60);
		//Increase the pet's happiness
		happiness += 30;
		//Increase the pet's health
		health += 20;
		
	}
	
	/**
	 * Calculates the daily score for the pet based off of its attributes + an offset to ensure the score goes up each day. 
	 * Increases the total score of the pet by this amount.
	 */
	public void generateDailyScore() {
		//Factor to keep the score increasing.
		int scoreOffset = 500;                            
		//Compute a total of the daily attributes.
		//Add scoreOffset to keep the score positive as there are 2 
		//'positive' attributes and 3 'negative' attributes.
		int dailyScore = scoreOffset + happiness + health - tiredness - hunger - toiletNeed;
		//Update the pet's score.
		score += dailyScore;             
	}
	
	/**
	 * Determine if the pet will get Sick.
	 * 
	 * @return true is the pet becomes sick, false otherwise.
	 */
	private boolean rollForSickness() {
		if (health < 50) {
			//SicknessChance of 40 corresponds to a probability of the pet getting sick of 40/100 = 40%.
			int unhealthySicknessChance = 40;   
			//Generate a random number in the range 0-99 inclusive.
			int comparisonValue = rand.nextInt(100);     
			//If true, pet will get sick.
			if (comparisonValue <= unhealthySicknessChance)          
				return true;
			else
				return false;
		
		}
		
		else {
			 //sicknessChance of 20 corresponds to a probability of the pet getting sick of 
			 //20/100 = 20%.generateDailyScore()
			int healthySicknessChance = 20;  
			//Generate a random number in the range 0-99 inclusive.
			int comparisonValue = rand.nextInt(100);     
			//If true, pet will get sick.
			if (comparisonValue <= healthySicknessChance)          
				return true;
			else
				return false;
		}
		
	}
	
	/**
	 * Determine if the pet will begin misbehaving.
	 * 
	 * @return true if the pet begins misbehaving, false otherwise.
	 */
	
	
	
	
	
	
	
	
	

	private boolean rollForMisbehaving() {
		if (happiness < 50 || tiredness > 50 || hunger > 50) {

			//misbehavingChance of 40 corresponds to a probability of the pet getting sick of 40/100 = 40%.
			int unhappyMisbehavingChance = 40;   
			//Generate a random number in the range 0-99 inclusive.
			int comparisonValue = rand.nextInt(100);
			//If true, pet will get sick.
			if (comparisonValue <= unhappyMisbehavingChance)  {

				return true;
			}
			else
				return false;
		
		}
		
		else {
			//misbehavingChance of 20 corresponds to a probability of the pet getting sick of 
			//20/100 = 20%.
			int happyMisbehavingChance = 20;   
			//Generate a random number in the range 0-99 inclusive.
			int comparisonValue = rand.nextInt(100);     
			//If true, pet will begin misbehaving.
			if (comparisonValue <= happyMisbehavingChance)          
				return true;
			else
				return false;
		}
		
	}
	
	
	/**
	 * Return whether the pet has any actions remaining which it can execute that day.
	 * 
	 * @return Whether the pet has any actions remaining as a boolean.
	 */
	public boolean hasActionsRemaining() {
		if (actionsRemaining > 0)
			return true;
		else
			return false;
	}
	
	/**
	 * Checks to see if the pet is sick or misbehaving and if it is not, determines if it will get sick
	 * or begin to misbhave using rollForSickness() and rollForMisbehaving(). Also updates the pet's associated 
	 * score and pet.daysSick / pet.daysMisbehaving if the pet is already sick or misbehaving at the start of a new day.
	 */
	private void randomEvent() {
		//if the pet is sick or misbehaving:
		if (isMisbehaving == true) {
			//if the pet has already been sick or misbehaving for at least a  day, decrease the pet's 
			//score relative to the number of days it has been sick or misbehaving. 
			//Also increment daysSick and/or daysMisbehaving by 1.
			score -= 90 * daysMisbehaving;
			daysMisbehaving += 1;
			//Ensure score does not drop below 0. Should not happen but possible.
			if (score < 0)
				score = 0;
		
		}
		
		else {
			isMisbehaving = rollForMisbehaving();
			if (isMisbehaving)
				daysMisbehaving += 1;
		}
		
		//if the pet is sick.
		if (isSick == true) {
			//The pet has already been sick for at least a  day, decrease the pet's score relative 
			//to the number of days it has been sick. Also increment daysSick by 1.
			score -= 90 * daysSick;
			daysSick += 1;
			//Ensure score does not drop below 0. Should not happen but possible.
			if (score < 0)
				score = 0;
				
		}

		else {
			isSick = rollForSickness();
			if (isSick)
				daysSick = 1;
		}	
	}
	
	/**
	 * Determines if the pet should die based off of it's current stat levels.
	 */
	private void determineDeath() {
		//First condition for death, any one stat being too low.
		if(hunger == 100 || tiredness == 100 || happiness <= 10 
				|| toiletNeed == 100 || health < 10)  
			//Kill the pet.
			die();  

		else {
			//Second death condition, relatively low health and other stats being too 
			//high or low overall.
			if(health < 45 && (hunger + tiredness + 
					toiletNeed >= 260 || happiness < 20))  
				die();
		}
	}
	
	/**
	 * Updates the status of the pet when the day is incremented. Also determines if random events of death
	 */
	public void newDay() {
		//If the pet is alive, update their stats for the day.
		if (alive) {
			//Increase the pet's hunger
			hunger += hungerChange;    
			//Increase the pet's tiredness
			tiredness += tirednessChange; 
			//Decrease the pet's happiness
			happiness -= happinessChange; 
			//Increase the pet's toilet need
			toiletNeed += toiletNeedChange; 
			//Decrease the pet's health.
			health -= healthChange; 
			//Reset the actions the pet has remaining to 2.
			actionsRemaining = 2;  
		
			//Ensure that the pet's stats do not go below zero or above 100.
			if (hunger > 100)
				hunger = 100;
			if (tiredness > 100)
				tiredness = 100;
			if (happiness < 0)
				happiness = 0;
			if (toiletNeed > 100)
				toiletNeed = 100;
			if (health < 0)
				health = 0;
		}
		
		
		//Determine if the pet will die.
		determineDeath();
		
		//If the pet is alive Determine if the pet will get sick or misbehave and update 
		//attributes if it is in one of these states already. Compute the score for the day
		//which has just passed for the pet.
		if (alive) {
			randomEvent();
			generateDailyScore();
		}
	}
	
	//
	//Methods used for testing.
	//
	/**
	 * Return the pet's favourite food
	 * 
	 * @return The pet's favourite food as a Food object.
	 * */
	public Food getFavouriteFood() {
		return favouriteFood;
	}
	
	/**
	 * Return the pet's favourite food
	 * 
	 * @return The pet's favourite food as a Food object.
	 * */
	public Toy getLeastFavToy() {
		return leastFavToy;
	}
	
	/**
	 * Make the pet misbehave for the purposes of testing.
	 */
	public void setMisbehaving() {
		daysMisbehaving = 1;
		isMisbehaving = true;
	}
	
	/**
	 * Make the pet sick for the purposes of testing.
	 */
	public void makeSick() {
		daysSick = 1;
		isSick = true;
	}
	
	/**
	 * Return the pet's play roughness for testing.
	 * 
	 * @return The play roughness of the pet as an int.
	 */
	public int getPlayRoughness() {
		return playRoughness;
	}
	
	/**
	 * Sets the health of the pet to zero to allow for testing.
	 */
	public void decreaseHealth() {
		health = 0;
	}
	
	/** 
	 * Kills the pet so the revive method can be tested.
	 */
	public void killPet() {
		alive = false;
	}
	
	/**
	 * Getter for daysMisbehaving. Used purely for testing newDay().
	 * @return The days the pet has been misbehaving for as an int.
	 */
	public int getDaysMisbehaving() {
		return daysMisbehaving;
	}
	
	/**
	 * Getter for daysSick. Used purely for testing newDay().
	 * @return The days the pet has been sick for as an int.
	 */
	public int getDaysSick() {
		return daysSick;
	}
	
}