package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		SetupView view = new SetupView();
		GuiEnvironment model = new GuiEnvironment();
		JFrame frame = view.getUI();
		new SetupController(view, model);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
