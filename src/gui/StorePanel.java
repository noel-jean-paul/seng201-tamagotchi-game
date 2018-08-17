package gui;

import java.awt.CardLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import food.*;
import toys.*;

public class StorePanel {

	private JPanel storePanel;
	private ArrayList<JToggleButton> foodToggles = new ArrayList<JToggleButton>();
	private ArrayList<JToggleButton> toyToggles = new ArrayList<JToggleButton>();
	private int selectedFood;
	private int selectedToy;
	private JPanel foodCardsPanel;
	private JPanel toyCardsPanel;
	private JSpinner lblFoodSpinner;
	private JSpinner lblToySpinner;
	private JButton btnBuyFood;
	private JButton btnBuyToy;
	private JLabel lblPlayerBalance;

	/**
	 * The foods available in the game.
	 */
	private ArrayList<Food> foodList = new ArrayList<Food>(
			Arrays.asList(new Bone(), new Carrot(), new Greenery(), new Lasagne(), new PetBiscuits(), new Tuna()));

	/**
	 * The toys available in the game.
	 */
	private ArrayList<Toy> toyList = new ArrayList<Toy>(
			Arrays.asList(new BeachBall(), new Rock(), new SoftToy(), new SqueakyToy(), new ToyMouse(), new Yarn()));

	public StorePanel(GameController controller) {
		storePanel = new JPanel();
		storePanel.setLayout(null);
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 51, 664, 2);
		storePanel.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(341, 51, 2, 599);
		storePanel.add(separator_3);

		lblPlayerBalance = new JLabel("Player i - $100");
		lblPlayerBalance.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerBalance.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblPlayerBalance.setBounds(10, 11, 333, 42);
		storePanel.add(lblPlayerBalance);

		JToggleButton btnBone = new JToggleButton("Bone - $" + foodList.get(0).getPrice());
		btnBone.setBounds(10, 118, 150, 100);
		btnBone.setActionCommand("food1");
		btnBone.setSelected(true);
		btnBone.addActionListener(controller);
		foodToggles.add(btnBone);
		storePanel.add(btnBone);

		JToggleButton btnCarrot = new JToggleButton("Carrot - $" + foodList.get(1).getPrice());
		btnCarrot.setBounds(171, 118, 150, 100);
		btnCarrot.setActionCommand("food2");
		btnCarrot.addActionListener(controller);
		foodToggles.add(btnCarrot);
		storePanel.add(btnCarrot);

		JToggleButton btnGreenery = new JToggleButton("Greenery - $" + foodList.get(2).getPrice());
		btnGreenery.setBounds(10, 229, 150, 100);
		btnGreenery.setActionCommand("food3");
		btnGreenery.addActionListener(controller);
		foodToggles.add(btnGreenery);
		storePanel.add(btnGreenery);

		JToggleButton btnLasagne = new JToggleButton("Lasagne - $" + foodList.get(3).getPrice());
		btnLasagne.setBounds(171, 229, 150, 100);
		btnLasagne.setActionCommand("food4");
		btnLasagne.addActionListener(controller);
		foodToggles.add(btnLasagne);
		storePanel.add(btnLasagne);

		JToggleButton btnPetBiscuits = new JToggleButton("Pet Biscuits - $" + foodList.get(4).getPrice());
		btnPetBiscuits.setBounds(10, 340, 150, 100);
		btnPetBiscuits.setActionCommand("food5");
		btnPetBiscuits.addActionListener(controller);
		foodToggles.add(btnPetBiscuits);
		storePanel.add(btnPetBiscuits);

		JToggleButton btnTuna = new JToggleButton("Tuna - $" + foodList.get(5).getPrice());
		btnTuna.setBounds(171, 340, 150, 100);
		btnTuna.setActionCommand("food6");
		btnTuna.addActionListener(controller);
		foodToggles.add(btnTuna);
		storePanel.add(btnTuna);

		JLabel lblFood = new JLabel("Food");
		lblFood.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblFood.setBounds(10, 64, 83, 29);
		storePanel.add(lblFood);

		JPanel foodBuyPanel = new JPanel();
		foodBuyPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		foodBuyPanel.setBounds(10, 451, 311, 199);
		storePanel.add(foodBuyPanel);
		foodBuyPanel.setLayout(null);

		foodCardsPanel = new JPanel(new CardLayout());
		foodCardsPanel.setBounds(10, 11, 291, 114);
		foodBuyPanel.add(foodCardsPanel);

		for (Food food : foodList) {
			foodCardsPanel.add(foodCard(food), food.getType());
		}

		lblFoodSpinner = new JSpinner();
		lblFoodSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		lblFoodSpinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFoodSpinner.setBounds(83, 150, 57, 26);
		lblFoodSpinner.addChangeListener(controller);
		foodBuyPanel.add(lblFoodSpinner);

		btnBuyFood = new JButton(
				"Purchase - $" + foodList.get(selectedFood).getPrice() * (int) lblFoodSpinner.getValue());
		btnBuyFood.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuyFood.setBounds(150, 136, 151, 52);
		btnBuyFood.setActionCommand("purchaseFood");
		btnBuyFood.addActionListener(controller);
		foodBuyPanel.add(btnBuyFood);

		JLabel lblFoodQuantity = new JLabel("Quantity:");
		lblFoodQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFoodQuantity.setBounds(10, 136, 76, 52);
		foodBuyPanel.add(lblFoodQuantity);

		JLabel lblToys = new JLabel("Toys");
		lblToys.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblToys.setBounds(363, 64, 83, 29);
		storePanel.add(lblToys);

		JToggleButton btnBeachBall = new JToggleButton("Beach Ball - $" + toyList.get(0).getPrice());
		btnBeachBall.setBounds(363, 118, 150, 100);
		btnBeachBall.setSelected(true);
		btnBeachBall.setActionCommand("toy1");
		btnBeachBall.addActionListener(controller);
		toyToggles.add(btnBeachBall);
		storePanel.add(btnBeachBall);

		JToggleButton btnRock = new JToggleButton("Rock - $" + toyList.get(1).getPrice());
		btnRock.setBounds(524, 118, 150, 100);
		btnRock.setActionCommand("toy2");
		btnRock.addActionListener(controller);
		toyToggles.add(btnRock);
		storePanel.add(btnRock);

		JToggleButton btnSoftToy = new JToggleButton("Soft Toy - $" + toyList.get(2).getPrice());
		btnSoftToy.setBounds(524, 229, 150, 100);
		btnSoftToy.setActionCommand("toy3");
		btnSoftToy.addActionListener(controller);
		toyToggles.add(btnSoftToy);
		storePanel.add(btnSoftToy);

		JToggleButton btnSqueakyToy = new JToggleButton("Squeaky Toy - $" + toyList.get(3).getPrice());
		btnSqueakyToy.setBounds(363, 229, 150, 100);
		btnSqueakyToy.setActionCommand("toy4");
		btnSqueakyToy.addActionListener(controller);
		toyToggles.add(btnSqueakyToy);
		storePanel.add(btnSqueakyToy);

		JToggleButton btnToyMouse = new JToggleButton("Toy Mouse - $" + toyList.get(4).getPrice());
		btnToyMouse.setBounds(363, 340, 150, 100);
		btnToyMouse.setActionCommand("toy5");
		btnToyMouse.addActionListener(controller);
		toyToggles.add(btnToyMouse);
		storePanel.add(btnToyMouse);

		JToggleButton btnYarn = new JToggleButton("Yarn - $" + toyList.get(5).getPrice());
		btnYarn.setBounds(524, 340, 150, 100);
		btnYarn.setActionCommand("toy6");
		btnYarn.addActionListener(controller);
		toyToggles.add(btnYarn);
		storePanel.add(btnYarn);

		JPanel toyBuyPanel = new JPanel();
		toyBuyPanel.setLayout(null);
		toyBuyPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		toyBuyPanel.setBounds(363, 451, 311, 199);
		storePanel.add(toyBuyPanel);

		toyCardsPanel = new JPanel(new CardLayout());
		toyCardsPanel.setBounds(10, 11, 291, 114);
		toyBuyPanel.add(toyCardsPanel);

		for (Toy toy : toyList) {
			toyCardsPanel.add(toyCard(toy), toy.getType());
		}

		JLabel lblToyQuantity = new JLabel("Quantity:");
		lblToyQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblToyQuantity.setBounds(10, 136, 76, 52);
		toyBuyPanel.add(lblToyQuantity);

		lblToySpinner = new JSpinner();
		lblToySpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		lblToySpinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblToySpinner.setBounds(83, 150, 57, 26);
		lblToySpinner.addChangeListener(controller);
		toyBuyPanel.add(lblToySpinner);

		btnBuyToy = new JButton("Purchase - $" + toyList.get(selectedToy).getPrice() * (int) lblToySpinner.getValue());
		btnBuyToy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuyToy.setBounds(150, 136, 151, 52);
		btnBuyToy.setActionCommand("purchaseToy");
		btnBuyToy.addActionListener(controller);
		toyBuyPanel.add(btnBuyToy);

		JButton btnLeaveStore = new JButton("Leave Store >>");
		btnLeaveStore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLeaveStore.setBounds(509, 11, 165, 29);
		btnLeaveStore.setActionCommand("store");
		btnLeaveStore.addActionListener(controller);
		storePanel.add(btnLeaveStore);

	}

	private JPanel foodCard(Food food) {
		JPanel foodCard = new JPanel();
		foodCard.setLayout(null);

		JLabel lblNutrition = new JLabel("Nutrition: " + food.getNutrition());
		lblNutrition.setBounds(10, 89, 135, 14);
		foodCard.add(lblNutrition);

		JLabel lblHealthiness = new JLabel("Healthiness: " + food.getHealthiness());
		lblHealthiness.setBounds(10, 64, 135, 14);
		foodCard.add(lblHealthiness);

		JLabel lblTastiness = new JLabel("Tastiness: " + food.getTastiness());
		lblTastiness.setBounds(10, 39, 135, 14);
		foodCard.add(lblTastiness);

		JLabel lblToiletNeedIncrease = new JLabel("Toilet need increase: " + food.getToiletNeedIncrease());
		lblToiletNeedIncrease.setBounds(146, 64, 135, 14);
		foodCard.add(lblToiletNeedIncrease);
		
//		JLabel lblWeightGain = new JLabel("Weight gain: " + food.getHeaviness());
//		lblWeightGain.setBounds(146, 39, 135, 14);
//		foodCard.add(lblWeightGain);

		JLabel lblFood_1 = new JLabel(food.getType());
		lblFood_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFood_1.setBounds(10, 11, 135, 17);
		foodCard.add(lblFood_1);
		return foodCard;
	}

	private JPanel toyCard(Toy toy) {
		JPanel toyCard = new JPanel();
		toyCard.setLayout(null);
		toyCard.setBounds(10, 11, 291, 114);

		JLabel lblDurability = new JLabel("Durability: " + toy.getDurability());
		lblDurability.setBounds(10, 39, 135, 14);
		toyCard.add(lblDurability);

		JLabel lblEnjoyment = new JLabel("Enjoyment: " + toy.getHappinessIncrease());
		lblEnjoyment.setBounds(146, 39, 135, 14);
		toyCard.add(lblEnjoyment);

		JLabel lblExertion = new JLabel("Exertion: " + toy.getExertion());
		lblExertion.setBounds(10, 64, 135, 14);
		toyCard.add(lblExertion);

		JLabel lblToy = new JLabel(toy.getType());
		lblToy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblToy.setBounds(10, 11, 135, 17);
		toyCard.add(lblToy);
		return toyCard;
	}

	public Food getSelectedFood() {
		try {
			return foodList.get(selectedFood).getClass().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Toy getSelectedToy() {
		return toyList.get(selectedToy);
	}

	public void selectFood(int i) {
		foodToggles.get(selectedFood).setSelected(false);
		foodToggles.get(i).setSelected(true);
		selectedFood = i;
		CardLayout cl = (CardLayout) (foodCardsPanel.getLayout());
		cl.show(foodCardsPanel, foodList.get(i).getType());
		updatePrices();
	}

	public void selectToy(int i) {
		toyToggles.get(selectedToy).setSelected(false);
		toyToggles.get(i).setSelected(true);
		selectedToy = i;
		CardLayout cl = (CardLayout) (toyCardsPanel.getLayout());
		cl.show(toyCardsPanel, toyList.get(i).getType());
		updatePrices();
	}

	public int getFoodQuantity() {
		return (int) lblFoodSpinner.getValue();
	}

	public int getToyQuantity() {
		return (int) lblToySpinner.getValue();
	}

	public void updatePrices() {
		btnBuyFood.setText("Purchase - $" + foodList.get(selectedFood).getPrice() * (int) lblFoodSpinner.getValue());
		btnBuyToy.setText("Purchase - $" + toyList.get(selectedToy).getPrice() * (int) lblToySpinner.getValue());
	}

	public void setPlayerLabel(String name, int balance) {
		lblPlayerBalance.setText(name + " - $" + balance);
	}

	public JPanel getPanel() {
		return storePanel;
	}

	public int getFoodPrice() {
		return foodList.get(selectedFood).getPrice() * (int) lblFoodSpinner.getValue();
	}

	public int getToyPrice() {
		return toyList.get(selectedToy).getPrice() * (int) lblToySpinner.getValue();
	}
}
