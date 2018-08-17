package pets;

import player.*;
import java.util.Random;

/** Describes the Dog subclass **/
public class Dog extends Pet {
	/**
	 * Average weight of a Dog. The constructor will create a Dog with a weight
	 * within 20% of this value
	 **/
	private static final float weightRange = (float) 10;
	/** The amount a Dog's need for the toilet increases each day **/
	private static final int dogToiletPerDay = 30;
	/** The amount a Dog's hunger increases each day **/
	private static final int dogHungerChange = 35;
	/** How roughly a Dog plays with its toys **/
	private static final int dogPlayRoughness = 30;
	/**The amount a Dog's tiredness increases each day*/
	private static final int dogTirednessChange = 25;
	/**The amount a Dog's health decreases each day*/
	private static final int dogHealthChange = 24;
	/**The amount a Dog's happiness decreases per day*/
	private static final int dogHappinessChange = 32;

	/**
	 * Constructs an instance of Dog. Calls the super constructor to initialise it's attributes.
	 * 
	 * @param petName The name of the Dog.
	 * @param petOwner The Dog's owner.
	 */
	public Dog(String petName, Player petOwner) {
		super(petName, "Dog", petOwner, weightRange, dogToiletPerDay, dogHungerChange, dogPlayRoughness, dogTirednessChange,
				dogHealthChange, dogHappinessChange, new Random());
	}
}
