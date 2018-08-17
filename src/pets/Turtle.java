package pets;

import player.*;
import java.util.Random;

/** Describes the Turtle subclass **/
public class Turtle extends Pet {
	/**
	 * Average weight of a Turtle. The constructor will create a Turtle with a weight
	 * within 20% of this value
	 **/
	private static final float weightRange = (float) 60;
	/** The amount a Turtle's need for the toilet increases each day **/
	private static final int turtleToiletPerDay = 25;
	/** The amount a Turtle's hunger increases each day **/
	private static final int turtleHungerChange = 35;
	/** How rough a Turtle plays with its toys **/
	private static final int turtlePlayRoughness = 22;
	/**The amount a Turtle's tiredness increases each day*/
	private static final int turtleTirednessChange = 24;
	/**The amount a Turtle's health decreases each day*/
	private static final int turtleHealthChange = 45;
	/**The amount a Cat's happiness decreases per day*/
	private static final int turtleHappinessChange = 31;

	/**
	 * Constructs an instance of Turtle. Calls the super constructor to initialise it's attributes.
	 * 
	 * @param petName The name of the Turtle.
	 * @param petOwner The Turtle's owner.
	 */
	public Turtle(String petName, Player petOwner) {
		super(petName, "Turtle", petOwner, weightRange, turtleToiletPerDay, turtleHungerChange, 
				turtlePlayRoughness,turtleTirednessChange, turtleHealthChange, turtleHappinessChange, new Random());
	}
}