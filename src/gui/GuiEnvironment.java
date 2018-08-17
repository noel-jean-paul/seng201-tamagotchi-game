package gui;

import java.util.ArrayList;
import java.util.Arrays;

import food.*;
import player.Player;
import toys.*;
import pets.*;

/**
 * GUI model which holds the game data and interfaces between the GUI
 * view/controller and the background classes containing the game logic and
 * objects.
 */
public class GuiEnvironment {
	
	//
	// Constructors
	//
	/**
	 * Constructor for the game environment.
	 */
	public GuiEnvironment() {
		
	}

	//
	// Fields
	//

	/** The number of days the game spans */
	private int numDays;
	/** Which day it is **/
	private int dayNumber = 1;
	/** The number of players in the game */
	private int numPlayers;

	/**
	 * Array List containing the player objects of the current game. Populated
	 * at the start of each game.
	 **/
	private ArrayList<Player> playerList = new ArrayList<Player>();

	/** The player currently playing their turn. **/
	private int currentPlayer = 0;
	
	/** The pet currently being interacted with in the GUI. */
	private Pet currentPet;

	/**
	 * Array List containing the names of the players.
	 */
	private ArrayList<String> playerNameList = new ArrayList<String>();

	/**
	 * Array List containing the names of the pets.
	 */
	private ArrayList<String> petNameList = new ArrayList<String>();

	/**
	 * The foods available in the game.
	 */
	private ArrayList<Food> foodList = new ArrayList<Food>(
			Arrays.asList(new Bone(), new Greenery(), new Carrot(), new Lasagne(), new PetBiscuits(), new Tuna()));

	/**
	 * The toys available in the game.
	 */
	private ArrayList<Toy> toyList = new ArrayList<Toy>(
			Arrays.asList(new BeachBall(), new Rock(), new SoftToy(), new SqueakyToy(), new ToyMouse(), new Yarn()));

	/**
	 * The different species of pet a player can own.
	 */
	private ArrayList<String> speciesList = new ArrayList<String>(
			Arrays.asList("Cat", "Dog", "Dolphin", "Pony", "Panda", "Turtle"));


	public Player getCurrentPlayer() {
		return playerList.get(currentPlayer);
	}

	public int getCurrentPlayerNum() {
		return currentPlayer;
	}
	
	public int getDayNumber() {
		return dayNumber;
	}

	public void nextPlayer() {
		if (++currentPlayer == playerList.size()){
			dayNumber++;
			currentPlayer = 0;
		}
	}

	public Pet getCurrentPet() {
		return currentPet;
	}

	public void setCurrentPet(Pet currentPet) {
		this.currentPet = currentPet;
	}

	
	/**
	 * get the number of days the game will span.
	 * 
	 * @return An int representing the number of days the game will span.
	 */

	//
	// Accessor methods
	//

	public int getNumDays() {
		return numDays;
	}

	/**
	 * Set the number of days the game will span.
	 * 
	 * @param numDays
	 *            The number of days the game is played for.
	 */
	public void setNumDays(int numDays) {
		this.numDays = numDays;
	}

	/**
	 * Get the number of players playing the game
	 * 
	 * @return An int representing the number of players playing.
	 */
	public int getNumPlayers() {
		return numPlayers;
	}

	/**
	 * Set the number of players playing the game.
	 * 
	 * @param numPlayers
	 *            The number of players who are going to play the game
	 */
	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	/**
	 * Get the list of the species of pet available.
	 * 
	 * @return The list of species as an ArrayList of Strings.
	 */
	public ArrayList<String> getSpeciesList() {
		return speciesList;
	}

	/**
	 * Get the list of pet names currently in the game.
	 * 
	 * @return The list of pet names as an ArrayList of Strings.
	 */
	public ArrayList<String> getPetNameList() {
		return petNameList;
	}

	/**
	 * Get the list of player names.
	 * 
	 * @return The player name list as an Array List of Player objects.
	 */
	public ArrayList<String> getPlayerNameList() {
		return playerNameList;
	}

	/**
	 * Return the list of player objects in the game.
	 * 
	 * @return The list of players in the game as an Array List of player
	 *         objects.
	 */
	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	/**
	 * Returns the list of foods in the game.
	 * 
	 * @return The list of foods available in the game as an ArrayList of Food
	 *         objects.
	 */
	public ArrayList<Food> getFoodList() {
		return foodList;
	}

	/**
	 * Return the list of toys in the game.
	 * 
	 * @return The list of toys in the game as an ArrayList of Toy objects.
	 */
	public ArrayList<Toy> getToyList() {
		return toyList;
	}

	//
	// Other methods
	//

	/**
	 * Add a player to the player list.
	 * 
	 * @param p
	 *            The player object to be added.
	 */
	public void addPlayer(Player p) {
		playerNameList.add(p.getPlayerName());
		playerList.add(p);
	}

	/**
	 * Add a new pet name to the pet name list.
	 * 
	 * @param s
	 *            The pet name to be added.
	 */
	public void addPetName(String s) {
		petNameList.add(s);
	}

	/**
	 * Feed the specified pet the food.
	 * 
	 * @param food
	 *            The food to be fed.
	 */
	public void feed(Food food) {
		currentPet.feed(food);
	}

	/**
	 * Toilet the pet.
	 * 
	 */
	public void toilet() {
		currentPet.toilet();
	}
	
	public boolean play(Toy toy) {
		int i = getCurrentPlayer().getToyList().size();
		currentPet.play(toy);
		return i == getCurrentPlayer().getToyList().size();
	}

	/**
	 * Make the pet sleep.
	 * 
	 * @return true if the pet slept, false otherwise.
	 */
	public boolean sleep() {
		if (currentPet.getActionsRemaining() > 0) {
			currentPet.sleep();
			return true;
		} else
			return false;
	}
	
	public void selectPet(int i) {
		currentPet = playerList.get(currentPlayer).getPetAtIndex(i);
	}

}
