package main.com.show;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class GameChooseUI implements ActionListener {

	static final int BUTTON_SIZE = 200;
	public static JFrame mainFrame;
	public static int SCORE = 0;

	Panel controlPanel;
	Button rainGameButton;
	Button harvestingGameButton;

	public GameChooseUI() {
		mainFrame = new JFrame();
		controlPanel = new Panel();
		rainGameButton = new Button("RainGame");
		harvestingGameButton = new Button("MineGame");
		//showUI();
	}

	public void showUI() {

		mainFrame.setBounds(100, 100, 800, 600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);
		
		controlPanel.setLayout(null);

		
		rainGameButton.setBounds(101, 150, BUTTON_SIZE, BUTTON_SIZE);
		harvestingGameButton.setBounds(451, 150, BUTTON_SIZE, BUTTON_SIZE);
		
		rainGameButton.addActionListener(this);		
		harvestingGameButton.addActionListener(this);

		controlPanel.add(rainGameButton);
		controlPanel.add(harvestingGameButton);
		

		mainFrame.add(controlPanel);
		mainFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//controlPanel.setVisible(false);
		mainFrame.remove(controlPanel);

		if (e.getSource() == rainGameButton) {
			new RainGameUIPanel();
		}

		if (e.getSource() == harvestingGameButton) {
			new MineGameUIPanel();
		}

	}

}
