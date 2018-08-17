package petTests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import player.Player;
import food.*;
import foodTests.MockFood;
import toyTests.MockToy;
import toys.*;
import java.util.ArrayList;
import java.util.Random;

public class PetTest {
	MockPet fluffy;
	Player hagrid;
	Food favFood;
	MockFood normFood;
	MockToy ball;
	ArrayList<Food> foodList;
	MockPet jeff;
	

	@Before
	public void setUp() {
		hagrid = new Player("Hagrid", 1, 2);
		fluffy = new MockPet("Fluffy", hagrid);
		favFood = fluffy.getFavouriteFood();
		normFood = new MockFood("Triple doggy treats");
		ball = new MockToy("Ball");
		foodList = new ArrayList<Food>();
		jeff = new MockPet("Jeff", hagrid, 7);
	}

	@Test
	public void testPetWeightAssignment() {
		Random rand = new Random(7);
		MockPet jeff = new MockPet("jeff", hagrid, 7);
		float weight = jeff.getMeanWeight() + (1 - rand.nextFloat() * 2) * (jeff.getMeanWeight() / 5);  
		assertEquals(weight,jeff.getWeight(), 0);
	}
	
	@Test
	public void testPetFavouriteToyAssignment() {
		assertEquals(new ToyMouse(), jeff.getFavouriteToy());
	}
	
	@Test
	public void testPetLeastFavToyASsignment() {
		assertEquals(new SoftToy(), jeff.getLeastFavToy());
	}
	
	@Test
	public void testPetFavFoodAssignment() {
		assertEquals(new PetBiscuits(), jeff.getFavouriteFood());
	}
	

	@Test
	public void testGetName() {
		assertEquals(fluffy.getName(), "Fluffy");
	}

	@Test
	public void testFeedFavFood() {
		int initialHappiness = fluffy.getHappiness();
		hagrid.addFood(favFood, 1);
		fluffy.feed(favFood);
		int expectedHappiness = initialHappiness + 2 * favFood.getTastiness(); 
		if (expectedHappiness > 100)
			expectedHappiness = 100;
		assertEquals(expectedHappiness, fluffy.getHappiness());
	}
	
	@Test
	//Lots of asserts in this one but they all test very basic changes in attribute values. Splitting up the
	//test into many individual ones would be unnecessary and time consuming.
	public void testFeedNormalFood() {
		int expectedHappiness = fluffy.getHappiness() + normFood.getTastiness();
		float expectedWeight = fluffy.getWeight() * (1+ normFood.getNutrition()/800);
		fluffy.decreaseHealth();
		hagrid.addFood(normFood, 1);
		fluffy.feed(normFood);
		assertEquals(expectedHappiness, fluffy.getHappiness());
		assertEquals(expectedWeight, fluffy.getWeight(), 0.0005);
		
		
		assertEquals(40, fluffy.getHealth());	
		assertEquals(30, fluffy.getHunger());
		assertEquals(100, fluffy.getToiletNeed());
		assertEquals(foodList, hagrid.getFoodList());
		assertEquals(1, fluffy.getActionsRemaining());
		}
	
	@Test
	public void testPlayWithToy() {
		fluffy.play(ball);
		assertEquals(80, fluffy.getHunger());
		assertEquals(80, fluffy.getTiredness());
		assertEquals(100, fluffy.getHappiness());
	}
	
	@Test 
	public void testPlayAndBreakFavToy() {
		Toy favToy = fluffy.getFavouriteToy();
		hagrid.addToy(favToy);
		if( favToy.getDurability() <= fluffy.getPlayRoughness())
			fluffy.play(favToy);
		else {
			favToy.use(favToy.getDurability() - 1);
			fluffy.play(favToy);
		}
		assertEquals(70-2*favToy.getHappinessIncrease(), fluffy.getHappiness());
		assertEquals(true, favToy.isBroken());
		
	}
	
	
	@Test
	public void testSleep() {
		hagrid.addToy(ball);
		hagrid.addToy(ball);
		fluffy.play(ball);
		fluffy.play(ball);
		fluffy.sleep();
		assertEquals(10, fluffy.getTiredness());
	}

	@Test
	public void testTotalSleep() {
		fluffy.decreaseHealth();
		fluffy.sleep();
		assertEquals(0, fluffy.getTiredness());
		assertEquals(1, fluffy.getActionsRemaining());
		assertEquals(15, fluffy.getHealth());
		assertEquals(65, fluffy.getHunger());
	}
	
	@Test
	public void testMedicate() {
		fluffy.makeSick();
		int expectedBalance = hagrid.getAccountBalance() - 60;
		fluffy.medicate();
		assertEquals(expectedBalance, hagrid.getAccountBalance());
		assertEquals(false, fluffy.isSick());
		
	}
	
	@Test
	//Not worth asserting the other basic attribute resets.
	public void testRevive() {
		fluffy.killPet();
		fluffy.revive();
		fluffy.generateDailyScore();
		assertEquals(470, fluffy.getScore());
		assertEquals(true, fluffy.getHasBeenRevived());
		assertEquals(true, fluffy.isAlive());
		assertEquals(60, hagrid.getAccountBalance());
	}

	@Test
	public void testToilet() {
		float expectedWeight = fluffy.getWeight() * 95/100;
		fluffy.toilet();
		assertEquals(0, fluffy.getToiletNeed());
		assertEquals(expectedWeight, fluffy.getWeight(), 0.0005);
		
	}
	
	@Test
	public void testHasActionsRemaining() {
		assertEquals(true, fluffy.hasActionsRemaining());
		fluffy.sleep();
		fluffy.sleep();
		assertEquals(false, fluffy.hasActionsRemaining());
	}
	
	@Test
	public void testGenerateDailyScore() {
		fluffy.generateDailyScore();
		assertEquals(520, fluffy.getScore());
		
	}
	
	@Test
	public void punish() {
		int expectedHappiness = fluffy.getHappiness() - 20;
		fluffy.setMisbehaving();
		fluffy.punish();
		assertEquals(expectedHappiness, fluffy.getHappiness());
		assertEquals(false, fluffy.isMisbehaving());
	}
	
	@Test
	//Most of the updates of pet attributes aren't worth testing.
	public void newDayNoEvent() {
		fluffy.newDay();
		assertEquals(390, fluffy.getScore());
		
	}
	
	
	@Test
	//There are 5 paths through the if statement, no point in testing all of them.
	//Case 1 is tiredness = 100
	public void testDieCase1() {
		hagrid.addToy(ball);
		//Make tiredness = 100
		fluffy.play(ball);
		fluffy.play(ball);
		fluffy.newDay();
		assertEquals(100, fluffy.getTiredness());
		assertFalse(fluffy.isAlive());
	}
	
	@Test
	//Reducing the pet's happiness through punishment instead of implementing another method in the 
	//Pet class used purely for testing.
	//Case 2 is health<45 and happiness < 20.
	public void testDieCase2() {
		//Set health to 0
		jeff.decreaseHealth();
		//Set happiness to 0
		for(int i = 0; i < 4; i++) {
			jeff.punish();
		}
		jeff.newDay();
		assertFalse(jeff.isAlive());
	}
	
	@Test
	//Case 2 is health < 45 and hunger+tiredness+toiletNeed >=260)
	public void testDieCase3() {
		//Set score to 220.
		jeff.generateDailyScore();
		
		//Setting up the required stats for death using other Pet methods. 
		hagrid.addFood(normFood, 1);
		jeff.feed(normFood);
		jeff.decreaseHealth();
		jeff.play(ball);
		hagrid.addToy(ball);
		jeff.play(ball);
		
		
		jeff.newDay();
		assertFalse(jeff.isAlive());
		assertEquals(370, jeff.getScore());
		
	}
	
	
	@Test
	public void testNewDayMisbehave() {
		MockPet andy = new MockPet("andy", hagrid, 71);
		andy.newDay();
		assertTrue(andy.isMisbehaving());
		assertEquals(1, andy.getDaysMisbehaving());
		
	}
	
	@Test
	public void testNewDayMisbehaveAndGetSick() {
		MockPet mathew = new MockPet("Mathew", hagrid, 3);
		mathew.newDay();
		assertTrue(mathew.isMisbehaving());
		assertTrue(mathew.isSick());
		
	}
	
	@Test
	public void testNewDayGetSick() {
		MockPet connor = new MockPet("connor", hagrid, 3);
		connor.newDay();
		assertTrue(connor.isSick());
		assertEquals(1, connor.getDaysSick());
		
	}
	
	
	@Test
	public void testNewDayContinueMisbehaving() {
		jeff.setMisbehaving();
		jeff.generateDailyScore();
		jeff.newDay();
		assertEquals(820, jeff.getScore());
		assertEquals(2, jeff.getDaysMisbehaving());
	}
	
	@Test
	//Sick for 2 days
	public void testNewDayUnMedicated() {
		jeff.makeSick();
		jeff.generateDailyScore();
		jeff.newDay();
		assertEquals(820, jeff.getScore());
		assertEquals(2, jeff.getDaysSick());
	}
}
