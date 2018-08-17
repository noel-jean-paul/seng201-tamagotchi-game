package gui;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;

import food.Food;
import toys.Toy;

import javax.swing.JOptionPane;

public class GameView {

	private JFrame frame;
	private GameController controller;
	private CardLayout mainCards;
	private CardLayout playerCards;
	private JPanel mainPanel;
	private StorePanel storePanel;

	public void enable() {
		GameView window = new GameView();
		window.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	GameView() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		mainCards = new CardLayout(0, 0);
		frame.getContentPane().setLayout(mainCards);

		mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, "name_22682102134935");
		playerCards = new CardLayout(0, 0);
		mainPanel.setLayout(playerCards);

	}

	public void addPlayerPanel(JPanel panel) {
		mainPanel.add(panel);
	}

	public JFrame getUI() {
		return frame;
	}

	public void setController(GameController controller) {
		this.controller = controller;
		storePanel = new StorePanel(this.controller);
		frame.getContentPane().add(storePanel.getPanel(), "name_19687345955546");
	}

	public void visitStore() {
		mainCards.next(frame.getContentPane());
	}

	public void nextPlayer() {

		playerCards.next(mainPanel);
	}

	public StorePanel getStore() {
		return storePanel;
	}

	public void moneyError() {
		JOptionPane.showMessageDialog(frame, "You can't afford this", "Insufficient funds",
				JOptionPane.WARNING_MESSAGE);
	}

	public void turnsError() {
		JOptionPane.showMessageDialog(frame, "This pet has no actions remaining", "No actions remaining",
				JOptionPane.WARNING_MESSAGE);
	}

	public Food feedSelection(Object[] foodList) {
		if (foodList.length == 0) {
			JOptionPane.showMessageDialog(frame, "You have no food in your inventory. Buy some at the store", "No food",
					JOptionPane.WARNING_MESSAGE);
			return null;
		} else {
			return (Food) JOptionPane.showInputDialog(frame, "Select a food", "Feed", JOptionPane.QUESTION_MESSAGE,
					null, foodList, foodList[0]);
		}
	}

	public Toy toySelection(Object[] toyList) {
		if (toyList.length == 0) {
			JOptionPane.showMessageDialog(frame, "You have no toys in your inventory. Buy some at the store", "No toys",
					JOptionPane.WARNING_MESSAGE);
			return null;
		} else {
			return (Toy) JOptionPane.showInputDialog(frame, "Select a toy", "Play with", JOptionPane.QUESTION_MESSAGE,
					null, toyList, toyList[0]);
		}
	}

	public boolean deadWarning() {
		return JOptionPane.showConfirmDialog(frame, "This pet has died. Would you like to revive it for $20", "Revive?",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
	}

	public void secondDeath() {
		JOptionPane.showMessageDialog(frame, "Your pet has died for a second time and cannot be revived. Sorry",
				"Death", JOptionPane.INFORMATION_MESSAGE);
	}

	public boolean misbehaving() {
		return JOptionPane.showConfirmDialog(frame, "This pet is misbehaving, would you like to punish it?", "Punish",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
	}

	public boolean sick() {
		return JOptionPane.showConfirmDialog(frame, "This pet is sick, would you like to treat it?", "Sick",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
	}

	public void favouriteFood() {
		JOptionPane.showMessageDialog(frame, "You just fed your pet its favourite food!", "Favourite Food",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void favouriteToy() {
		JOptionPane.showMessageDialog(frame, "Your pet just played with its favourite toy!", "Favourite Toy",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void leastFavouriteToy() {
		JOptionPane.showMessageDialog(frame, "Your pet just played with its least favourite toy. Oh dear.",
				"Least favourite toy", JOptionPane.INFORMATION_MESSAGE);
	}

	public void brokenToy() {
		JOptionPane.showMessageDialog(frame, "Your pet was too rough with the toy and it broke.", "Toy broke",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
