package pets;

import player.*;
import java.util.Random;

/** Describes the Dolphin subclass **/
public class Dolphin extends Pet {
	/**
	 * Average weight of a Dolphin. The constructor will create a Dolphin with a weight
	 * within 20% of this value
	 **/
	private static final float weightRange = (float) 50;
	/** The amount a Dolphin's need for the toilet increases each day **/
	private static final int dolphinToiletPerDay = 30;
	/** The amount a Dolphin's hunger increases each day **/
	private static final int dolphinHungerChange = 25;
	/** How rough a Dolphin plays with its toys **/
	private static final int dolphinPlayRoughness = 15;
	/**The amount a Dolphin's tiredness increases each day*/
	private static final int dolphinTirednessChange = 20;
	/**The amount a Dolphin's health decreases each day*/
	private static final int dolphinHealthChange = 30;
	/**The amount a Dolphin's happiness decreases per day*/
	private static final int dolphinHappinessChange = 42;

	/** 
	 * Constructs an instance of Dolphin. Calls the super constructor to initialise it's attributes.
	 * 
	 * @param petName The name of the Dolphin.
	 * @param petOwner The Dolphin's owner.
	 */
	public Dolphin(String petName, Player petOwner) {
		super(petName, "Dolphin", petOwner, weightRange, dolphinToiletPerDay, dolphinHungerChange, dolphinPlayRoughness, 
				dolphinTirednessChange, dolphinHealthChange, dolphinHappinessChange, new Random());
	}
}
