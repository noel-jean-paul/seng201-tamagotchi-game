package toys;

/** Describes the beach ball subclass **/
public class BeachBall extends Toy {

	/** The price of a beach ball **/
	private static final int beachBallPrice = 45;
	/** The amount of happiness given by a beach ball **/
	private static final int beachBallHappinessIncrease = 37;
	/** The durability of a beach ball **/
	private static final int beachBallDurability = 50;
	/**The amount a pet's hunger and tiredness increase after playing
	 * with a beach ball.
	 */
	private static final int beachBallExertion = 29;

	/** beach ball constructor **/
	public BeachBall() {
		super(beachBallPrice, "beach ball", beachBallHappinessIncrease, beachBallDurability, beachBallExertion);
	}
	
	@Override
	/**
	 * @inherit 
	 */
	public void resetDurability() {
		setDurability(beachBallDurability);
	}
}