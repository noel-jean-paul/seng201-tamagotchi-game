package gui;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;

import player.Player;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class ScoreWindow {

	private JFrame frame;

	private ArrayList<Player> playerList;

	/**
	 * Create the application.
	 * 
	 * @param playerList the list of players in the game.
	 */
	public ScoreWindow(ArrayList<Player> playerList) {
		this.playerList = playerList;

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 230, 200 + 37 * playerList.size());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblScores = new JLabel("Scores:");
		lblScores.setHorizontalAlignment(SwingConstants.CENTER);
		lblScores.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblScores.setBounds(10, 11, 194, 29);
		frame.getContentPane().add(lblScores);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 38, 194, 2);
		frame.getContentPane().add(separator);
		
		addPlayers();
		this.frame.setVisible(true);
	}
	
	public void addPlayers() {
		ArrayList<Integer> scoreList = new ArrayList<Integer>();
		for (Player player : playerList){
			scoreList.add(player.getFinalScore());
		}
		for (int i = 0; i < playerList.size(); i++) {
			int max = Collections.max(scoreList);
			addPlayer(playerList.get(scoreList.indexOf(max)), i);
			scoreList.set(scoreList.indexOf(max), -1);
			
		}
	}
	
	public void addPlayer(Player player, int i) {
		JLabel lblPlayerI = new JLabel(player.getPlayerName() + " : " + player.getFinalScore());
		lblPlayerI.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPlayerI.setBounds(20, 51 + 37 * i, 184, 26);
		frame.getContentPane().add(lblPlayerI);
	}
}
