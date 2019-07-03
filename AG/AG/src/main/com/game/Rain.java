package main.com.game;

import java.awt.Color;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.com.show.GameChooseUI;

public class Rain extends Thread {
	public static LinkedList<JLabel> words = new LinkedList<>();
	public static int[] randomMove = new int[50];

	Word word_creat;
	JPanel rainPanel;
	ImageIcon lifeIcon;
	CheckTheGameEnd playTime;

	public Rain(JPanel rainPanel,CheckTheGameEnd total_play_time) {
		playTime = total_play_time;
		this.rainPanel = rainPanel;
		word_creat = new Word();
	}

	public void setWordPosition() {
		JLabel tempLabel;

		for (int i = 0; i < word_creat.words.size(); i++) {
			tempLabel = new JLabel(word_creat.words.get(i));

			tempLabel.setFont(new Font("Times", Font.BOLD, 12));
			tempLabel.setForeground(Color.WHITE);
			tempLabel.setBounds((int) (Math.random() * 450) + 50, -10, 150, 20);
			tempLabel.setVisible(true);

			words.add(tempLabel);
			randomMove[i] = (int) (Math.random() * 20) + 10;
			rainPanel.add(words.get(i));
		}

		GameChooseUI.mainFrame.add(rainPanel);
		GameChooseUI.mainFrame.setVisible(true);

	}

	public void run() {
		while (CheckTheGameEnd.gamePlayTime > 0) {
			moveWord();
		}
	}

	public void moveWord() {
		 
		try {
			
			for(int i=0;i<words.size();i++) {
				words.get(i).setLocation(words.get(i).getX() ,words.get(i).getY() + randomMove[i]);
				if(words.get(i).getY() > 550 && words.get(i).isVisible()) {
					words.get(i).setVisible(false);
					
					if(RainGame.lifeMark.isEmpty()) {
						playTime.interrupt();
					}
					RainGame.lifeMark.poll().setVisible(false);
				}
			}
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void checkTheDead(JLabel each) {
		
	}
	
	public void showHeart() {
		
	}

}
