package playerTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import player.Player;
import petTests.MockPet;
import pets.Pet;
import java.util.ArrayList;
import toys.Toy;
import food.Food;
import foodTests.MockFood;
import toyTests.MockToy;


public class PlayerTest {
	Player joshua;
	MockPet samuel;
	MockPet mottled;
	MockFood ham;
	MockFood salami;
	MockToy ribbon;
	ArrayList<Pet> petList;
	ArrayList<Food> foodList;
	ArrayList<Toy> toyList;
	
	

	@Before
	public void setUp() throws Exception {
		joshua = new Player("Joshua", 2, 3);
		samuel = new MockPet("Samuel", joshua);
		mottled = new MockPet("Mottled", joshua);
		ham = new MockFood("Ham");
		salami = new MockFood("Salami");
		ribbon = new MockToy("Ribbon");
		
		petList = new ArrayList<Pet>();
		
		
		foodList = new ArrayList<Food>();
		foodList.add(salami);
		
		toyList = new ArrayList<Toy>();
		toyList.add(ribbon);
	}
	
	@Test
	public void testPlayer() {
		assertEquals((2*3*40), joshua.getAccountBalance());
	}
	
	@Test
	public void testAddPet() {
		joshua.addPet(mottled);
		petList.add(mottled);
		assertEquals(petList, joshua.getPetList());
	}

	@Test
	public void testAddUniqueFoods() {
		joshua.addFood(salami, 1);
		joshua.addFood(ham, 1);
		foodList.add(ham);
		assertEquals(foodList, joshua.getFoodList());
	}
	
	@Test
	public void testAddDuplicateFood() {
		joshua.addFood(salami, 2);

		assertEquals(foodList, joshua.getFoodList());
		assertEquals(2, salami.getQuantity());
	}

	@Test
	public void testAddToy() {
		joshua.addToy(ribbon);
		assertEquals(joshua.getToyList(), toyList);
	}
	
	@Test
	public void testAddDuplicateToy() {
		joshua.addToy(ribbon);
		joshua.addToy(ribbon);
	
		assertEquals(toyList, joshua.getToyList());
		assertEquals(2, ribbon.getQuantity());
	}

	@Test
	public void testGetPetAtIndex() {
		joshua.addPet(mottled);
		assertEquals(mottled, joshua.getPetAtIndex(0));
	}

	@Test
	public void testGetFoodAtIndex() {
		joshua.addFood(salami, 1);
		assertEquals(salami, joshua.getFoodAtIndex(0));
	}

	@Test
	public void testGetToyAtIndex() {
		joshua.addToy(ribbon);
		assertEquals(ribbon, joshua.getToyAtIndex(0));
	}

	@Test
	public void testRemoveUniqueFood() {
		joshua.addFood(salami, 1);
		joshua.removeFood(salami);
		foodList.remove(salami);
		assertEquals(foodList, joshua.getFoodList());
	}
	
	@Test
	public void testRemoveDuplicateFood() {
		joshua.addFood(salami, 1);
		joshua.addFood(salami, 1);
		joshua.removeFood(salami);
		assertEquals(foodList, joshua.getFoodList());
		assertEquals(1, salami.getQuantity());
	}

	@Test
	public void testRemoveUniqueToy() {
		joshua.addToy(ribbon);
		joshua.removeToy(ribbon);
		toyList.remove(ribbon);
		assertEquals(toyList, joshua.getToyList());
	}
	
	@Test
	public void testRemoveDuplicateToy() {
		joshua.addToy(ribbon);
		joshua.addToy(ribbon);
		joshua.removeToy(ribbon);
		assertEquals(toyList, joshua.getToyList());
		assertEquals(1, ribbon.getQuantity());
		assertEquals(false, ribbon.isBroken());
	}

	@Test
	public void testChargeAccountSuccessfully() {
		//Initial account balance = 240
	Boolean bool = joshua.chargeAccount(200);
	assertEquals(true, bool);
	assertEquals(40, joshua.getAccountBalance());
	
	}
	
	@Test
	public void testChargeAccountUnSuccessfully() {
	//Initial account balance = 240.
	Boolean bool = joshua.chargeAccount(250);
	assertEquals(false, bool);
	assertEquals(240, joshua.getAccountBalance());
	
	}
	
	@Test
	public void testCalculateFinalScore() {
		samuel.generateDailyScore();
		mottled.generateDailyScore();
		joshua.addPet(samuel);
		joshua.addPet(mottled);
		joshua.calculateFinalScore();
		assertEquals(520, joshua.getFinalScore());
		
	}

}
