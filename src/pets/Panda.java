package pets;

import player.*;
import java.util.Random;

/** Describes the panda subclass **/
public class Panda extends Pet {
	/**
	 * Average weight of a panda. The constructor will create a panda with a weight
	 * within 20% of this value
	 **/
	private static final float weightRange = (float) 100;
	/** The amount a Panda's need for the toilet increases each day **/
	private static final int pandaToiletPerDay = 22;
	/** The amount a Panda's hunger increases each day **/
	private static final int pandaHungerChange = 33;
	/** How roughly a Panda plays with its toys **/
	private static final int pandaPlayRoughness = 17;
	/**The amount a Panda's tiredness increases each day*/
	private static final int pandaTirednessChange = 28;
	/**The amount a Panda's health decreases each day*/
	private static final int pandaHealthChange = 31;
	/**The amount a Panda's happiness decreases per day*/
	private static final int pandaHappinessChange = 37;

	/** 
	 * Constructs an instance of Panda. Calls the super constructor to initialise it's attributes.
	 * 
	 * @param petName The name of the Panda.
	 * @param petOwner The Panda's owner.
	 */
	public Panda(String petName, Player petOwner) {
		super(petName, "Panda", petOwner, weightRange, pandaToiletPerDay, 
				pandaHungerChange, pandaPlayRoughness, pandaTirednessChange, pandaHealthChange,
				pandaHappinessChange, new Random());
	}
}
