package gui;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;

public class SetupView {

	/**
	 * Create the application.
	 */

	private JFrame frame;
	private JTextField playerNameField;
	private JTextField petNameField;
	private JSpinner numDaysSpinner;
	private JSpinner numPlayersSpinner;
	private JSpinner numPetsSpinner;
	private JComboBox<String> speciesComboBox;
	private JButton btnNext1;
	private JButton btnNext2;
	private JButton btnNext3;
	private JButton btnNext4;
	private CardLayout cards;
	private SetupController controller;
	private JLabel lblError;

	/** initialise the GUI to show the numDays prompt **/
	public SetupView() {

		// Create the frame and layout
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 200);
		cards = new CardLayout(0, 0);
		frame.getContentPane().setLayout(cards);
		frame.setTitle("Setup");
		
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
		        @Override
		        public void windowClosing(WindowEvent e) {
		                // Ask for confirmation before terminating the program.
		                int option = JOptionPane.showConfirmDialog(
		                        frame, 
		                        "Are you sure you want to exit?",
		                        "Close Confirmation", 
		                        JOptionPane.YES_NO_OPTION, 
		                        JOptionPane.QUESTION_MESSAGE);
		                if (option == JOptionPane.YES_OPTION) {
		                        System.exit(0);
		                }
		        }
		});

		// Create the numDays panel
		JPanel numDaysPanel = new JPanel();
		frame.getContentPane().add(numDaysPanel, "name_279388143464");
		GridBagLayout gbl_numDaysPanel = new GridBagLayout();
		gbl_numDaysPanel.columnWidths = new int[] { 0, 60, 0, 0 };
		gbl_numDaysPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_numDaysPanel.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_numDaysPanel.rowWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		numDaysPanel.setLayout(gbl_numDaysPanel);

		// Create the label
		JLabel lblNumDays = new JLabel("How many days will the game span?");
		GridBagConstraints gbc_lblNumDays = new GridBagConstraints();
		gbc_lblNumDays.gridwidth = 3;
		gbc_lblNumDays.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumDays.gridx = 0;
		gbc_lblNumDays.gridy = 0;
		numDaysPanel.add(lblNumDays, gbc_lblNumDays);

		// Create the spinner
		numDaysSpinner = new JSpinner();
		numDaysSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(20), new Integer(1)));
		GridBagConstraints gbc_numDaysSpinner = new GridBagConstraints();
		gbc_numDaysSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_numDaysSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_numDaysSpinner.gridx = 1;
		gbc_numDaysSpinner.gridy = 1;
		numDaysPanel.add(numDaysSpinner, gbc_numDaysSpinner);

		// Create the next button
		btnNext1 = new JButton("Next >>");
		GridBagConstraints gbc_btnNext1 = new GridBagConstraints();
		gbc_btnNext1.gridwidth = 3;
		gbc_btnNext1.gridx = 0;
		gbc_btnNext1.gridy = 2;
		btnNext1.setActionCommand("numDaysNext");
		numDaysPanel.add(btnNext1, gbc_btnNext1);

		// Create the numPlayers panel
		JPanel numPlayersPanel = new JPanel();
		frame.getContentPane().add(numPlayersPanel, "name_661475522154");
		GridBagLayout gbl_numPlayersPanel = new GridBagLayout();
		gbl_numPlayersPanel.columnWidths = new int[] { 0, 60, 0, 0 };
		gbl_numPlayersPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_numPlayersPanel.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_numPlayersPanel.rowWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		numPlayersPanel.setLayout(gbl_numPlayersPanel);

		// Create the numPlayers label
		JLabel lblNumPlayers = new JLabel("How many people are playing?");
		GridBagConstraints gbc_lblNumPlayers = new GridBagConstraints();
		gbc_lblNumPlayers.gridwidth = 3;
		gbc_lblNumPlayers.insets = new Insets(0, 0, 5, 0);
		gbc_lblNumPlayers.gridx = 0;
		gbc_lblNumPlayers.gridy = 0;
		numPlayersPanel.add(lblNumPlayers, gbc_lblNumPlayers);

		// Create the spinner
		numPlayersSpinner = new JSpinner();
		numPlayersSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(5), new Integer(1)));
		GridBagConstraints gbc_numPlayersSpinner = new GridBagConstraints();
		gbc_numPlayersSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_numPlayersSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_numPlayersSpinner.gridx = 1;
		gbc_numPlayersSpinner.gridy = 1;
		numPlayersPanel.add(numPlayersSpinner, gbc_numPlayersSpinner);

		// Create the next button
		btnNext2 = new JButton("Next >>");
		GridBagConstraints gbc_btnNext2 = new GridBagConstraints();
		gbc_btnNext2.gridwidth = 3;
		gbc_btnNext2.gridx = 0;
		gbc_btnNext2.gridy = 2;
		btnNext2.setActionCommand("numPlayersNext");
		numPlayersPanel.add(btnNext2, gbc_btnNext2);
	}

	/**
	 * return the current value of the numDays spinner
	 * 
	 * @return the number of days on the spinner as an integer
	 */
	public int getNumDaysSpinner() {
		return (int) numDaysSpinner.getValue();
	}

	/**
	 * return the current value of the numPlayes spinner
	 * 
	 * @return the number of players on the spinner as an integer
	 */
	public int getNumPlayersSpinner() {
		return (int) numPlayersSpinner.getValue();
	}

	/**
	 * return the current value of the numPets spinner
	 * 
	 * @return the number of pets on the spinner as an integer
	 */
	public int getNumPetsSpinner() {
		return (int) numPetsSpinner.getValue();
	}

	/**
	 * return the inputed player name
	 * 
	 * @return the name the user inputed as a string
	 */
	public String getPlayerName() {
		return playerNameField.getText();
	}

	/**
	 * return the inputed pet name
	 * 
	 * @return the pet name the user inputed as a string
	 */
	public String getPetName() {
		return petNameField.getText();
	}

	/**
	 * add an ActionListener for the buttons
	 * 
	 * @param controller
	 *            an ActionListener
	 */
	public void setController(SetupController controller) {
		this.controller = controller;
	}

	/**
	 * Set the action listener for the next buttons on the numPlayers and
	 * numDays panels
	 * 
	 * @param a
	 *            an ActionListener
	 */
	public void setActionListener(ActionListener a) {
		btnNext1.addActionListener(a);
		btnNext2.addActionListener(a);
	}

	/**
	 * Get the current selected item on the pet species combo box
	 * 
	 * @return the selected item on the combo box as a string
	 */
	public String getComboBox() {
		return (String) speciesComboBox.getSelectedItem();
	}

	/**
	 * Switch the layout to the next card
	 * 
	 */
	public void nextCard() {
		cards.next(frame.getContentPane());
	}

	/**
	 * Change the error label colour to red and add text
	 * 
	 * @param errorText
	 *            a message to display as an error
	 */
	public void showError(String errorText) {
		lblError.setText(errorText);
		lblError.setForeground(Color.RED);
	}

	/**
	 * Add a card for another player to the frame
	 * 
	 * @param i
	 *            What number player is being created
	 */
	public void addPlayerCard(int i) {
		JPanel playerInfoPanel = new JPanel();
		frame.getContentPane().add(playerInfoPanel, "name_942354783031");
		GridBagLayout gbl_playerInfoPanel = new GridBagLayout();
		gbl_playerInfoPanel.columnWidths = new int[] { 0, 0, 60, 0, 0 };
		gbl_playerInfoPanel.rowHeights = new int[] { 0, 0, 30, 0, 0, 0 };
		gbl_playerInfoPanel.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_playerInfoPanel.rowWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		playerInfoPanel.setLayout(gbl_playerInfoPanel);

		JLabel lblPlayer = new JLabel("Player " + i);
		GridBagConstraints gbc_lblPlayer = new GridBagConstraints();
		gbc_lblPlayer.gridwidth = 4;
		gbc_lblPlayer.insets = new Insets(0, 0, 5, 0);
		gbc_lblPlayer.gridx = 0;
		gbc_lblPlayer.gridy = 0;
		playerInfoPanel.add(lblPlayer, gbc_lblPlayer);

		JLabel lblPlayerName = new JLabel("What is your name?");
		GridBagConstraints gbc_lblPlayerName = new GridBagConstraints();
		gbc_lblPlayerName.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayerName.gridx = 0;
		gbc_lblPlayerName.gridy = 1;
		playerInfoPanel.add(lblPlayerName, gbc_lblPlayerName);

		playerNameField = new JTextField();
		GridBagConstraints gbc_playerNameField = new GridBagConstraints();
		gbc_playerNameField.gridwidth = 2;
		gbc_playerNameField.insets = new Insets(0, 0, 5, 5);
		gbc_playerNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_playerNameField.gridx = 1;
		gbc_playerNameField.gridy = 1;
		playerInfoPanel.add(playerNameField, gbc_playerNameField);
		playerNameField.setColumns(10);

		lblError = new JLabel("");
		lblError.setForeground(new Color(0, 0, 0, 0));
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.gridwidth = 2;
		gbc_lblError.insets = new Insets(0, 0, 5, 5);
		gbc_lblError.gridx = 1;
		gbc_lblError.gridy = 2;
		playerInfoPanel.add(lblError, gbc_lblError);

		JLabel lblNumPets = new JLabel("How many pets would you like?");
		GridBagConstraints gbc_lblNumPets = new GridBagConstraints();
		gbc_lblNumPets.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumPets.gridx = 0;
		gbc_lblNumPets.gridy = 3;
		playerInfoPanel.add(lblNumPets, gbc_lblNumPets);

		numPetsSpinner = new JSpinner();
		numPetsSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(10), new Integer(1)));
		GridBagConstraints gbc_numPetsSpinner = new GridBagConstraints();
		gbc_numPetsSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_numPetsSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_numPetsSpinner.gridx = 2;
		gbc_numPetsSpinner.gridy = 3;
		playerInfoPanel.add(numPetsSpinner, gbc_numPetsSpinner);

		btnNext3 = new JButton("Next >>");
		GridBagConstraints gbc_btnNext3 = new GridBagConstraints();
		gbc_btnNext3.gridwidth = 4;
		gbc_btnNext3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNext3.gridx = 0;
		gbc_btnNext3.gridy = 4;
		btnNext3.setActionCommand("playerInfoNext");
		btnNext3.addActionListener(controller);
		playerInfoPanel.add(btnNext3, gbc_btnNext3);

	}

	/**
	 * Create and add another new pet card to the frame
	 * 
	 * @param j
	 *            The number pet being created
	 * @param speciesList
	 *            An array list of strings representing the possible species for
	 *            the combo box
	 */
	public void addPetCard(int j, ArrayList<String> speciesList) {
		JPanel petInfoPanel = new JPanel();
		frame.getContentPane().add(petInfoPanel, "name_1669560656944");
		GridBagLayout gbl_petInfoPanel = new GridBagLayout();
		gbl_petInfoPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_petInfoPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_petInfoPanel.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_petInfoPanel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		petInfoPanel.setLayout(gbl_petInfoPanel);

		JLabel lblPet = new JLabel("Pet " + j);
		GridBagConstraints gbc_lblPet = new GridBagConstraints();
		gbc_lblPet.gridwidth = 4;
		gbc_lblPet.insets = new Insets(0, 0, 5, 0);
		gbc_lblPet.gridx = 0;
		gbc_lblPet.gridy = 0;
		petInfoPanel.add(lblPet, gbc_lblPet);

		JLabel lblPetKind = new JLabel("What kind of pet do you want?");
		GridBagConstraints gbc_lblPetKind = new GridBagConstraints();
		gbc_lblPetKind.insets = new Insets(0, 0, 5, 5);
		gbc_lblPetKind.gridx = 0;
		gbc_lblPetKind.gridy = 1;
		petInfoPanel.add(lblPetKind, gbc_lblPetKind);

		speciesComboBox = new JComboBox<String>();
		String[] speciesListArray = speciesList.toArray(new String[speciesList.size()]);
		speciesComboBox = new JComboBox<String>(speciesListArray);
		GridBagConstraints gbc_speciesComboBox = new GridBagConstraints();
		gbc_speciesComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_speciesComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_speciesComboBox.gridx = 2;
		gbc_speciesComboBox.gridy = 1;
		petInfoPanel.add(speciesComboBox, gbc_speciesComboBox);
		speciesComboBox.setActionCommand("speciesComboBox");
		speciesComboBox.addActionListener(controller);

		JLabel lblPetName = new JLabel("What is its name?");
		GridBagConstraints gbc_lblPetName = new GridBagConstraints();
		gbc_lblPetName.insets = new Insets(0, 0, 5, 5);
		gbc_lblPetName.gridx = 0;
		gbc_lblPetName.gridy = 2;
		petInfoPanel.add(lblPetName, gbc_lblPetName);

		petNameField = new JTextField();
		GridBagConstraints gbc_petNameField = new GridBagConstraints();
		gbc_petNameField.insets = new Insets(0, 0, 5, 5);
		gbc_petNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_petNameField.gridx = 2;
		gbc_petNameField.gridy = 2;
		petInfoPanel.add(petNameField, gbc_petNameField);
		petNameField.setColumns(10);

		lblError = new JLabel("");
		lblError.setForeground(new Color(0, 0, 0, 0));
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.gridwidth = 2;
		gbc_lblError.insets = new Insets(0, 0, 5, 5);
		gbc_lblError.gridx = 1;
		gbc_lblError.gridy = 3;
		petInfoPanel.add(lblError, gbc_lblError);

		btnNext4 = new JButton("Next >>");
		GridBagConstraints gbc_btnNext4 = new GridBagConstraints();
		gbc_btnNext4.gridwidth = 4;
		gbc_btnNext4.insets = new Insets(0, 0, 0, 5);
		gbc_btnNext4.gridx = 0;
		gbc_btnNext4.gridy = 3;
		btnNext4.setActionCommand("petInfoNext");
		btnNext4.addActionListener(controller);
		petInfoPanel.add(btnNext4, gbc_btnNext4);
	}

	/**
	 * return the JFrame object
	 * 
	 * @return the Setup window frame
	 */
	public JFrame getUI() {
		return this.frame;
	}

}
