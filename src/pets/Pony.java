package pets;

import player.*;
import java.util.Random;

/** Describes the Pony subclass **/
public class Pony extends Pet {
	/**
	 * Average weight of a Pony. The constructor will create a Pony with a weight
	 * within 20% of this value
	 **/
	private static final float weightRange = (float) 180;
	/** The amount a Pony's need for the toilet increases each day **/
	private static final int ponyToiletPerDay = 26;
	/** The amount a Pony's hunger increases each day **/
	private static final int ponyHungerChange = 34;
	/** How rough a Pony plays with its toys **/
	private static final int ponyPlayRoughness = 32;
	/**The amount a Pony's tiredness increases each day*/
	private static final int ponyTirednessChange = 25;
	/**The amount a Pony's health decreases each day*/
	private static final int ponyHealthChange = 23;
	/**The amount a Cat's happiness decreases per day*/
	private static final int ponyHappinessChange = 24;

	/**
	 * Constructs an instance of Pony. Calls the super constructor to initialise it's attributes.
	 * 
	 * @param petName The name of the Pony.
	 * @param petOwner The Pony's owner.
	 */
	public Pony(String petName, Player petOwner) {
		super(petName, "Pony", petOwner, weightRange, ponyToiletPerDay, ponyHungerChange, ponyPlayRoughness, ponyTirednessChange,
				ponyHealthChange, ponyHappinessChange, new Random());
	}
}
