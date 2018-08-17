package gui;

import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import pets.Pet;

public class PetPanel {

	private Pet pet;
	private JPanel petPanel;
	private JLabel lblPetName;
	private JLabel lblHealth;
	private JLabel lblHunger;
	private JLabel lblTiredness;
	private JLabel lblHappiness;
	private JLabel lblToiletNeed;
	private JLabel lblWeight;
	private JLabel lblIsSick;
	private JLabel lblIsMisbehaving;
	private JLabel lblHasBeenDead;

	public PetPanel(Pet pet, GameController controller) {
		this.pet = pet;

		petPanel = new JPanel();
		petPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		petPanel.setLayout(null);

		JLabel lblImage = new JLabel();
		lblImage.setIcon(
				new ImageIcon(PetPanel.class.getResource("/gui/img/" + pet.getSpecies().toLowerCase() + ".png")));
		lblImage.setBackground(UIManager.getColor("Button.background"));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(10, 11, 245, 245);
		petPanel.add(lblImage);

		JButton btnFeed = new JButton("Feed...");
		btnFeed.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFeed.setBounds(265, 11, 205, 53);
		btnFeed.setActionCommand("feed");
		btnFeed.addActionListener(controller);
		petPanel.add(btnFeed);

		JButton btnPlay = new JButton("Play with...");
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPlay.setBounds(265, 75, 205, 53);
		btnPlay.setActionCommand("play");
		btnPlay.addActionListener(controller);
		petPanel.add(btnPlay);

		JButton btnSleep = new JButton("Put to sleep");
		btnSleep.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSleep.setBounds(265, 139, 205, 53);
		btnSleep.setActionCommand("sleep");
		btnSleep.addActionListener(controller);
		petPanel.add(btnSleep);

		JButton btnToilet = new JButton("Take to toilet");
		btnToilet.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnToilet.setBounds(265, 203, 205, 53);
		btnToilet.setActionCommand("toilet");
		btnToilet.addActionListener(controller);
		petPanel.add(btnToilet);

		lblPetName = new JLabel(pet.getName());
		lblPetName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPetName.setBounds(10, 267, 245, 22);
		petPanel.add(lblPetName);

		lblHealth = new JLabel("Health: " + pet.getHealth());
		lblHealth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHealth.setBounds(10, 300, 135, 22);
		petPanel.add(lblHealth);

		lblHunger = new JLabel("Hunger: " + pet.getHunger());
		lblHunger.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHunger.setBounds(10, 333, 135, 22);
		petPanel.add(lblHunger);

		lblTiredness = new JLabel("Tiredness: " + pet.getTiredness());
		lblTiredness.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTiredness.setBounds(10, 366, 135, 22);
		petPanel.add(lblTiredness);

		lblHappiness = new JLabel("Happiness: " + pet.getHappiness());
		lblHappiness.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHappiness.setBounds(10, 399, 135, 22);
		petPanel.add(lblHappiness);

		lblToiletNeed = new JLabel("Toilet Need: " + pet.getToiletNeed());
		lblToiletNeed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblToiletNeed.setBounds(10, 432, 135, 22);
		petPanel.add(lblToiletNeed);

		DecimalFormat df = new DecimalFormat("###.##");
		lblWeight = new JLabel("Weight: " + df.format(pet.getWeight()));
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWeight.setBounds(10, 465, 110, 22);
		petPanel.add(lblWeight);

		if (pet.isSick()) {
			lblIsSick = new JLabel("Is sick: Yes");
		} else {
			lblIsSick = new JLabel("Is sick: No");
		}
		lblIsSick.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIsSick.setBounds(196, 300, 110, 22);
		petPanel.add(lblIsSick);

		if (pet.isMisbehaving())
			lblIsMisbehaving = new JLabel("Is misbehaving: Yes");
		else
			lblIsMisbehaving = new JLabel("Is misbehaving: No");
		lblIsMisbehaving.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIsMisbehaving.setBounds(196, 333, 151, 22);
		petPanel.add(lblIsMisbehaving);
		if (pet.getHasBeenRevived())
			lblHasBeenDead = new JLabel("Has been dead: Yes");
		else
			lblHasBeenDead = new JLabel("Has been dead: No");
		lblHasBeenDead.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHasBeenDead.setBounds(196, 366, 151, 22);
		petPanel.add(lblHasBeenDead);
	}

	public void updateStats() {
		lblHealth.setText("Health: " + pet.getHealth());
		lblHunger.setText("Hunger: " + pet.getHunger());
		lblTiredness.setText("Tiredness: " + pet.getTiredness());
		lblHappiness.setText("Happiness: " + pet.getHappiness());
		lblToiletNeed.setText("Toilet need: " + pet.getToiletNeed());
		DecimalFormat df = new DecimalFormat("###.##");
		lblWeight.setText("Weight: " + df.format(pet.getWeight()));
		if (pet.isSick())
			lblIsSick.setText("Is sick: Yes");
		else
			lblIsSick.setText("Is sick: No");
		if (pet.isMisbehaving())
			lblIsMisbehaving.setText("Is misbehaving: Yes");
		else
			lblIsMisbehaving.setText("Is misbehaving: No");
		if (pet.getHasBeenRevived())
			lblHasBeenDead.setText("Has been dead: Yes");
		else
			lblHasBeenDead.setText("Has been dead: No");
	}

	public JPanel getPanel() {
		return petPanel;
	}
}
