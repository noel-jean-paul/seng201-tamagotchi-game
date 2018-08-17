package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import pets.Cat;
import pets.Dog;
import pets.Dolphin;
import pets.Pet;
import pets.Pony;
import pets.Panda;
import pets.Turtle;
import player.Player;

public class SetupController implements ActionListener {

	private GuiEnvironment model;
	private SetupView view;
	private int playerNumber = 1;
	private int petNumber = 1;
	private Player newPlayer;
	private String selectedSpecies = "Cat";

	/**
	 * Initialises the controller and sets itself as the ActionListener for the
	 * view
	 * 
	 * @param view
	 *            The SetupView object which draws the GUI
	 * @param model
	 *            The GuiEnvironment object which stores the game data
	 */
	public SetupController(SetupView view, GuiEnvironment model) {
		this.view = view;
		this.view.setController(this);
		this.view.setActionListener(this);
		this.model = model;
	}

	/**
	 * Executes a function when a GUI action is performed
	 * 
	 * @param e
	 *            The action performed
	 */
	@SuppressWarnings("rawtypes")
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		// When the player clicks next on the numDays prompt, set numDays in the
		// model and display the next card
		case "numDaysNext":
			model.setNumDays(view.getNumDaysSpinner());
			view.nextCard();
			break;
		// When the player clicks next on the numPlayers prompt, set numPlayers
		// in the model, add a player card to the view and display it
		case "numPlayersNext":
			model.setNumPlayers(view.getNumPlayersSpinner());
			view.addPlayerCard(playerNumber++);
			view.nextCard();
			break;

		// Call the newPlayerPrompt function to create a player object
		case "playerInfoNext":
			newPlayerPrompt();
			break;
		// Call the newPetPrompt function to create a new pet
		case "petInfoNext":
			newPetPrompt();
			break;
		// When the player makes a selection on the petSpecies combo box, update
		// the local variable storing the selected species
		case "speciesComboBox":
			selectedSpecies = (String) ((JComboBox) e.getSource()).getSelectedItem();
		}

	}

	/**
	 * Checks the name the player has entered and warns them if it is empty or
	 * not unique. Otherwise it creates a player object and adds it to the
	 * model. It adds a new pet panel and displays it.
	 **/
	private void newPlayerPrompt() {
		// Warn the user if they have not entered a name
		if (view.getPlayerName().equals("")) {
			view.showError("Please enter a name");
		}
		// Warn the user if they have entered the name of another player
		else if (model.getPlayerNameList().contains(view.getPlayerName())) {
			view.showError("Name must be unique");
		}
		// Create a new player and add it to the model. Add a new pet card and
		// display it
		else {
			newPlayer = new Player(view.getPlayerName(), view.getNumPetsSpinner(), model.getNumDays());
			model.addPlayer(newPlayer);
			view.addPetCard(petNumber++, model.getSpeciesList());
			view.nextCard();
		}
	}

	/**
	 * Checks the name the player has entered and warns them if it is empty or
	 * not unique, otherwise creates a pet object for them and adds it to the
	 * model. If the player has more pets to create, it adds a pet card and
	 * displays the next card. Otherwise it checks if there are more players to
	 * initialise and adds a newPlayer panel and displays it. Otherwise launches
	 * the main GUI window
	 **/
	private void newPetPrompt() {
		if (view.getPetName().equals("")) {
			view.showError("Please enter a name");
		} else if (model.getPetNameList().contains(view.getPetName())) {
			view.showError("Name must be unique");
		} else {
			newPlayer.addPet(newPet(selectedSpecies, view.getPetName(), newPlayer));
			model.addPetName(view.getPetName());
			if (petNumber <= view.getNumPetsSpinner()) {
				view.addPetCard(petNumber++, model.getSpeciesList());
				view.nextCard();
			} else if (playerNumber <= view.getNumPlayersSpinner()) {
				view.addPlayerCard(playerNumber++);
				petNumber = 1;
				view.nextCard();
			} else {
				GameView gameView = new GameView();
				new GameController(gameView, model);
				gameView.getUI().setVisible(true);
				view.getUI().dispose();
				
			}
		}
	}

	/**
	 * Takes a species, name and player and returns a corresponding pet object
	 * 
	 * @param petSpecies
	 *            The desired species of the pet
	 * @param petName
	 *            The new pet's name
	 * @param player
	 *            The owner of the pet
	 * @return the pet being created.
	 */
	private Pet newPet(String petSpecies, String petName, Player player) {
		switch (petSpecies) {
		case "Cat":
			return new Cat(petName, player);
		case "Dog":
			return new Dog(petName, player);
		case "Dolphin":
			return new Dolphin(petName, player);
		case "Pony":
			return new Pony(petName, player);
		case "Panda":
			return new Panda(petName, player);
		default:
			return new Turtle(petName, player);
		}
	}
}
