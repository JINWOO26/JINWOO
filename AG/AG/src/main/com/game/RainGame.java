package main.com.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.com.show.GameChooseUI;

public class RainGame implements KeyListener {
	public static Queue<JLabel> lifeMark = new LinkedList<JLabel>(); 
	
	static final int WORD_COUNT = 27; // 기본 단어 갯수
	static final int HEART_SIZE =3;
	
	int wordCount =27;
	LinkedList<JLabel> words;
	CheckTheGameEnd total_play_time; // 전체 플레이타임
	
	int gameTime;
	ImageIcon icon,lifeIcon;
	JPanel minePanel;
	JTextField inputText; 
	CheckTheGameEnd check;
	Word word_create;
	Rain rain;

	
	public RainGame(int gameTime){
		this.gameTime= gameTime;
		
		word_create = new Word();
		words = new LinkedList<JLabel>();
		icon = new ImageIcon("img/background.jpg");
		lifeIcon = new ImageIcon("img/life3.png");
		
		total_play_time = new CheckTheGameEnd(this.gameTime, wordCount);
		
		inputText = new JTextField(2);
		check = new CheckTheGameEnd(gameTime, wordCount);
		
				
		minePanel = new JPanel() {
			public void paintComponent(Graphics g) {

				g.drawImage(icon.getImage(), 0, 0, null);

				setOpaque(false);
				super.paintComponent(g);
			}
		};
		rain = new Rain(minePanel,total_play_time);
		
		showUI();

	}
	
	public void showUI() {
		JLabel eachHeart;
		
		inputText.addKeyListener(this);
		inputText.setBounds(350, 490, 100, 30);
		inputText.setOpaque(true);
		inputText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		for (int i = 0; i < HEART_SIZE; i++) {
			eachHeart = new JLabel(lifeIcon);
			eachHeart.setBounds((i * 80), 490, 80, 80);
			eachHeart.setOpaque(false);			
			eachHeart.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			lifeMark.add(eachHeart);
		
			minePanel.add(eachHeart);
		}
		
		total_play_time.playTime.setBounds(390, 0, 200, 50);
		total_play_time.playTime.setFont(new Font("Dialog", Font.BOLD, 30));
		total_play_time.playTime.setForeground(Color.white);
		
		rain.setWordPosition();
		
		minePanel.add(inputText); 
		minePanel.add(total_play_time.playTime);
		minePanel.setLayout(null);
		
		GameChooseUI.mainFrame.getContentPane().add(minePanel, BorderLayout.CENTER);
		GameChooseUI.mainFrame.add(minePanel);
		GameChooseUI.mainFrame.setVisible(true);
		
		total_play_time.start();
		rain.start();
		
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_ENTER) {
			
			for(JLabel each : Rain.words) {
				
				if(each.getText().equals(inputText.getText())) {
					each.setVisible(false);
					GameChooseUI.SCORE++;
				}
			}
			
			inputText.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
