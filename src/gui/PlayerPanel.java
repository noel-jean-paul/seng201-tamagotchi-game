package gui;

import java.awt.CardLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import pets.Pet;
import player.Player;

public class PlayerPanel {

	private JPanel playerPanel;
	private CardLayout petCards;
	private JPanel petCardPanel;
	private JPanel petSelectionPanel;
	private JLabel lblDayNumber;
	private ArrayList<JToggleButton> petToggles = new ArrayList<JToggleButton>();
	private ArrayList<PetPanel> petPanels = new ArrayList<PetPanel>();
	private int numPets = 0;
	private int currentPet = 0;
	private int currentDay = 0;

	public PlayerPanel(Player player, GameController controller, int numDays) {
		playerPanel = new JPanel();
		playerPanel.setLayout(null);

		JButton btnEndTurn = new JButton("End Turn");
		btnEndTurn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnEndTurn.setBounds(439, 603, 235, 47);
		btnEndTurn.setActionCommand("endTurn");
		playerPanel.add(btnEndTurn);
		btnEndTurn.addActionListener(controller);

		JScrollPane petsScrollPane = new JScrollPane();
		petsScrollPane.setBounds(10, 11, 174, 639);
		playerPanel.add(petsScrollPane);

		petSelectionPanel = new JPanel();
		petsScrollPane.setViewportView(petSelectionPanel);
		petSelectionPanel.setLayout(new BoxLayout(petSelectionPanel, BoxLayout.Y_AXIS));

		JButton btnVisitStore = new JButton("Visit Store");
		btnVisitStore.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnVisitStore.setBounds(194, 603, 235, 47);
		btnVisitStore.setActionCommand("store");
		btnVisitStore.addActionListener(controller);
		playerPanel.add(btnVisitStore);

		petCardPanel = new JPanel();
		petCardPanel.setBounds(194, 66, 480, 513);
		playerPanel.add(petCardPanel);
		petCards = new CardLayout(0, 0);
		petCardPanel.setLayout(petCards);

		JSeparator separator = new JSeparator();
		separator.setBounds(194, 590, 480, 2);
		playerPanel.add(separator);

		JLabel lblPlayerName = new JLabel(player.getPlayerName());
		lblPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPlayerName.setBounds(194, 11, 235, 44);
		playerPanel.add(lblPlayerName);

		lblDayNumber = new JLabel("Day " + ++currentDay + " of " + numDays);
		lblDayNumber.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDayNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDayNumber.setBounds(439, 11, 235, 44);
		playerPanel.add(lblDayNumber);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(194, 53, 480, 2);
		playerPanel.add(separator_1);
	}

	public JPanel getPanel() {
		return playerPanel;
	}

	public void addPetPanel(PetPanel panel, Pet pet, GameController controller) {
		petCardPanel.add(panel.getPanel());
		JToggleButton toggleButton = new JToggleButton("<html> <center>" + pet.getName() + "<br> 2 actions remaining");
		toggleButton.setHorizontalTextPosition(SwingConstants.CENTER);
		toggleButton.setIcon(new ImageIcon(PlayerPanel.class.getResource("/gui/img/thumb/" + pet.getSpecies().toLowerCase() + "Thumb.png")));
		toggleButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		toggleButton.setHorizontalTextPosition(SwingConstants.CENTER);
		toggleButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		toggleButton.setAlignmentX(0.5f);
		toggleButton.setActionCommand("selectPet" + numPets++);
		if (numPets == 1) toggleButton.setSelected(true);
		toggleButton.addActionListener(controller);
		petToggles.add(toggleButton);
		petPanels.add(panel);
		petSelectionPanel.add(toggleButton);
	}
	
	public void updateActionsRemaining(Pet pet, int petNum) {
		if (pet.isAlive()){
			petToggles.get(petNum).setText("<html> <center>" + pet.getName() + "<br> " + pet.getActionsRemaining() +" actions remaining");
		}
		else {
			petToggles.get(petNum).setText("<html> <center>" + pet.getName() + "<br> " + "Dead");

		}
	}

	public void selectPet(int newPet) {
		petToggles.get(currentPet).setSelected(false);
		petToggles.get(newPet).setSelected(true);
		int n = newPet - currentPet;
		if (n > 0) for(int i = 0; i < n; i++) petCards.next(petCardPanel);
		else for(int i = 0; i > n; i--) petCards.previous(petCardPanel);
		currentPet = newPet;
	}
	
	public void nextDay(int numDays) {
		lblDayNumber.setText("Day " + ++currentDay + " of " +numDays);
	}
	
	public void updatePetStats() {
		petPanels.get(currentPet).updateStats();
	}
	
}
