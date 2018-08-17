package petTests;

import pets.Pet;
import player.Player;
import java.util.Random;

/**
 * Class to allow us to create pet objects for our JUint tests as Pet is an
 * abstract class. 
 */
public class MockPet extends Pet {
	/**Species of the mock pet*/
	private static final String petSpecies = "3-Headed Dog";
	/**Weight range of the mock pet, it's weight will be set to a random value within 20% of this value by the
	 * super constructor.
	 */
	private static final float petMeanWeight = 200;
	/**Rate of change of the pet's toilet need*/
	private static final int petToiletPerDay = 40;
	/**Rate of change of the pet's hunger*/
	private static final int petHungerPerDay = 40;
	/**How roughly the pet plays with its toys*/
	private static final int petRoughness = 50;
	/**The rate at which a pet's tiredness changes*/
	private static final int petTirednessChange = 20;
	/**The rate at which a pet's health changes*/
	private static final int petHealthChange = 10;
	/**The amount a pet's happiness decreases per day*/
	private static final int petHappinessChange = 20;
	
	

	/**
	 * Constructor for the class. Calls the super constructor to initialise its attributes.
	 * 
	 * @param petName The name of the Mock Pet.
	 * @param petOwner The Mock Pet's owner.
	 */
	public MockPet(String petName, Player petOwner) {
		super(petName, petSpecies, petOwner, petMeanWeight, petToiletPerDay, petHungerPerDay, petRoughness, 
				petTirednessChange, petHealthChange, petHappinessChange, new Random());
	}
	
	/**
	 * Constructor allowing a seed to be passed in for testing of methods involving random number generation.
	 * 
	 * @param petName The name of the Mock Pet.
	 * @param petOwner The owner of the Mock Pet.
	 * @param seed The seed to be fed into the Random object created in the super constructor.
	 */
	public MockPet(String petName, Player petOwner, int seed) {
		super(petName, petSpecies, petOwner, petMeanWeight, petToiletPerDay, petHungerPerDay, petRoughness, 
				petTirednessChange, petHealthChange, petHappinessChange, new Random(seed));
	}
	
	/**
	 * Getter for mean weight for the purpose of testing.
	 * 
	 * @return The mean weight of the pet as an int.
	 */
	public float getMeanWeight() {
		return petMeanWeight;
	}
	
}
