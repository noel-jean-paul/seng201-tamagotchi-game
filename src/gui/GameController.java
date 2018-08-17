package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import food.Food;
import pets.Pet;
import player.Player;
import toys.Toy;

public class GameController implements ActionListener, ChangeListener {

	private GuiEnvironment model;
	private GameView view;
	private ArrayList<PlayerPanel> playerPanelList = new ArrayList<PlayerPanel>();
	private ArrayList<PetPanel> petPanelList = new ArrayList<PetPanel>();
	private int currentPetNum = 0;

	/**
	 * Initialises the controller and sets itself as the ActionListener for the
	 * view
	 * 
	 * @param view
	 *            The SetupView object which draws the GUI
	 * @param model
	 *            The GuiEnvironment object which stores the game data
	 */
	public GameController(GameView view, GuiEnvironment model) {
		this.view = view;
		view.setController(this);
		for (Player player : model.getPlayerList()) {
			PlayerPanel playerPanel = new PlayerPanel(player, this, model.getNumDays());
			playerPanelList.add(playerPanel);
			for (Pet pet : player.getPetList()) {
				PetPanel petPanel = new PetPanel(pet, this);
				playerPanel.addPetPanel(petPanel, pet, this);
				petPanelList.add(petPanel);
			}
			view.addPlayerPanel(playerPanelList.get(playerPanelList.size() - 1).getPanel());

		}
		this.model = model;
		model.selectPet(0);
		view.getStore().setPlayerLabel(model.getCurrentPlayer().getPlayerName(),
				model.getCurrentPlayer().getAccountBalance());
	}

	/**
	 * Executes a function when a GUI action is performed
	 * 
	 * @param e
	 *            The action performed
	 */
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		// If the player ends their turn
		case "endTurn":
			// Update the day number label
			playerPanelList.get(model.getCurrentPlayerNum()).nextDay(model.getNumDays());
			// Switch to the next player's card
			view.nextPlayer();
			// Update the model to the next player
			model.nextPlayer();
			// If all days have been played show the score window and close the
			// main one
			if (model.getDayNumber() > model.getNumDays()) {
				new ScoreWindow(model.getPlayerList());
				view.getUI().dispose();
			}
			// Select the player's first pet
			model.selectPet(0);
			currentPetNum = 0;
			// Update the store player balance label
			view.getStore().setPlayerLabel(model.getCurrentPlayer().getPlayerName(),
					model.getCurrentPlayer().getAccountBalance());
			// Notify each pet that a new day has started
			for (int i = 0; i < model.getCurrentPlayer().getPetList().size(); i++) {
				model.getCurrentPlayer().getPetAtIndex(i).newDay();
				playerPanelList.get(model.getCurrentPlayerNum()).updateActionsRemaining(model.getCurrentPet(), i);
				;
			}
			break;
		case "store":
			// If the player clicks the visit store button display the store
			view.visitStore();
			break;
		// if the player purchases food
		case "purchaseFood":
			// If the player can afford it, add it to their inventory
			if (model.getCurrentPlayer().chargeAccount(view.getStore().getFoodPrice())) {
				model.getCurrentPlayer().addFood(view.getStore().getSelectedFood(), view.getStore().getFoodQuantity());
				view.getStore().setPlayerLabel(model.getCurrentPlayer().getPlayerName(),
						model.getCurrentPlayer().getAccountBalance());
			}
			// Otherwise display an insufficient funds error
			else {
				view.moneyError();
			}
			break;
		// If the player clicks the purchase toy button do the same as above
		case "purchaseToy":
			if (model.getCurrentPlayer().chargeAccount(view.getStore().getToyPrice())) {
				model.getCurrentPlayer().addToy(view.getStore().getSelectedToy());
				view.getStore().setPlayerLabel(model.getCurrentPlayer().getPlayerName(),
						model.getCurrentPlayer().getAccountBalance());
			} else {
				view.moneyError();
			}
			break;
		// if the player clicks the feed button
		case "feed":
			// check whether the pet is dead and prompt the player to revive the
			// if that's the case
			if (!model.getCurrentPet().isAlive() && !model.getCurrentPet().getHasBeenRevived()) {
				if (view.deadWarning()) {
					if (!model.getCurrentPet().revive()) {
						view.moneyError();
					}
				}
			}
			// Do not prompt the player of the pet is dead for a second time
			else if (!model.getCurrentPet().isAlive()) {
				view.secondDeath();
			}
			// Only perform the action if the pet has turns remaining
			else if (model.getCurrentPet().hasActionsRemaining()) {
				Food food = view.feedSelection(model.getCurrentPlayer().getFoodList().toArray());
				if (food != null) {
					model.feed(food);
					// Notify the player if it was fed its favourite food
					if (model.getCurrentPet().getFavouriteFood().equals(food)) {
						view.favouriteFood();
					}
				}
			} else {
				view.turnsError();
			}
			break;
		// do the same as above but for toys
		case "play":
			if (!model.getCurrentPet().isAlive() && !model.getCurrentPet().getHasBeenRevived()) {
				if (view.deadWarning()) {
					if (!model.getCurrentPet().revive()) {
						view.moneyError();
					}
				}
			} else if (!model.getCurrentPet().isAlive()) {
				view.secondDeath();
			} else if (model.getCurrentPet().hasActionsRemaining()) {
				Toy toy = view.toySelection(model.getCurrentPlayer().getToyList().toArray());
				if (toy != null) {
					if (!model.play(toy)) {
						view.brokenToy();
					}

					if (model.getCurrentPet().getFavouriteToy().equals(toy)) {
						view.favouriteToy();
					} else if (model.getCurrentPet().getLeastFavToy().equals(toy)) {
						view.leastFavouriteToy();
					}
				}
			} else {
				view.turnsError();
			}
			break;
		// if the player clicks the toilet button
		case "toilet":
			if (!model.getCurrentPet().isAlive() && !model.getCurrentPet().getHasBeenRevived()) {
				if (view.deadWarning()) {
					if (!model.getCurrentPet().revive()) {
						view.moneyError();
					}
				}
			} else if (!model.getCurrentPet().isAlive()) {
				view.secondDeath();
			} else if (model.getCurrentPet().hasActionsRemaining()) {
				model.toilet();
			} else {
				view.turnsError();
			}
			break;
		// if the player clicks the sleep button
		case "sleep":
			if (!model.getCurrentPet().isAlive() && !model.getCurrentPet().getHasBeenRevived()) {
				if (view.deadWarning()) {
					if (!model.getCurrentPet().revive()) {
						view.moneyError();
					}
				}
			} else if (!model.getCurrentPet().isAlive()) {
				view.secondDeath();
			} else if (model.getCurrentPet().hasActionsRemaining()) {
				model.sleep();
			} else {
				view.turnsError();
			}
			break;
		// commands that require string manipulation
		default:
			// if the player has selected a different pet update the view and
			// model and prompt the player if the pet is sick or misbehaving
			if (e.getActionCommand().startsWith("selectPet")) {
				int newPet = Integer.parseInt(e.getActionCommand().substring(9));
				currentPetNum = newPet;
				playerPanelList.get(model.getCurrentPlayerNum()).selectPet(newPet);
				model.selectPet(newPet);
				playerPanelList.get(model.getCurrentPlayerNum()).updatePetStats();
				if (model.getCurrentPet().isMisbehaving()) {
					if (view.misbehaving()) {
						model.getCurrentPet().punish();
					}
				}
				if (model.getCurrentPet().isSick()) {
					if (view.sick()) {
						model.getCurrentPet().medicate();
					}
				}
			} else if (e.getActionCommand().startsWith("food")) {
				int foodNum = Integer.parseInt(e.getActionCommand().substring(4));
				view.getStore().selectFood(foodNum - 1);
			} else if (e.getActionCommand().startsWith("toy")) {
				int toyNum = Integer.parseInt(e.getActionCommand().substring(3));
				view.getStore().selectToy(toyNum - 1);
			}
		}
		// update the pet stats field
		playerPanelList.get(model.getCurrentPlayerNum()).updatePetStats();
		playerPanelList.get(model.getCurrentPlayerNum()).updateActionsRemaining(model.getCurrentPet(), currentPetNum);
	}

	/**
	 * Update the total purchase price when the value on the store spinners is
	 * changed
	 */
	public void stateChanged(ChangeEvent e) {
		view.getStore().updatePrices();
	}
}
