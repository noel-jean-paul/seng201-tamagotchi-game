package pets;

import player.*;
import java.util.Random;

/** Describes the cat subclass **/
public class Cat extends Pet {
	/**
	 * Average weight of a Cat. The constructor will create a cat with a weight
	 * within 20% of this value
	 **/
	private static final float catMeanWeight = (float) 4.5;
	/** The amount a Cat's need for the toilet increases each day **/
	private static final int catToiletPerDay = 24;
	/** The amount a Cat's hunger increases each day **/
	private static final int catHungerChange = 29;
	/** How rough a Cat plays with its toys **/
	private static final int catPlayRoughness = 21;
	/**The amount a Cat's tiredness increases each day*/
	private static final int catTirednessChange = 37;
	/**The amount a Cat's health decreases each day*/
	private static final int catHealthChange = 14;
	/**The amount a Cat's happiness decreases per day*/
	private static final int catHappinessChange = 34;

	/** 
	 * Constructs an instance of cat. Calls the super constructor to initialise its attributes.
	 * 
	 * @param petName The name of the Cat.
	 * @param petOwner The Cat's owner.
	 */
	
	//public Pet(String petName, String petSpecies, Player petOwner, float weightRange, int petToiletPerDay,
			//int petHungerChange, int petPlayRoughness, int petTirednessChange, int petHealthChange)
	public Cat(String petName, Player petOwner) {
		super(petName, "Cat", petOwner, catMeanWeight, catToiletPerDay, catHungerChange, catPlayRoughness, 
				catTirednessChange, catHealthChange, catHappinessChange, new Random());
	}
}
