package main.com.show;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import main.com.game.MineGame;

public class GameUI {
	int speed = 3000; // �⺻ �ڵ����� ���ǵ�
	

	JButton startButton, lowButton, highButton, midButton;
	JPanel mineUI;
	ImageIcon icon, buttonIcon, buttonOnclick, lifeIcon, lowIcon, lowIconClick, midIcon, midIconClick, highIcon,
			highIconClick;

	public GameUI(String background) {

		icon = new ImageIcon("img/" + background + ".jpg");
		buttonIcon = new ImageIcon("img/button.png");
		buttonOnclick = new ImageIcon("img/buttonclick.png");
		lifeIcon = new ImageIcon("img/life3.png");
		lowIcon = new ImageIcon("img/low.png");
		lowIconClick = new ImageIcon("img/lowclick.png");
		midIcon = new ImageIcon("img/mid.png");
		midIconClick = new ImageIcon("img/midclick.png");
		highIcon = new ImageIcon("img/high.png");
		highIconClick = new ImageIcon("img/highclick.png");

		midButton = new JButton(midIcon);
		highButton = new JButton(highIcon);
		lowButton = new JButton(lowIcon);
		startButton = new JButton(buttonIcon);

		mineUI = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false); // �׸��� ǥ���ϰ� ����,�����ϰ� ����
				super.paintComponent(g);
			}
		};

		
	}

	public void showUI(ActionListener action) {

		startButton.setRolloverIcon(buttonOnclick);
		startButton.setOpaque(false);
		startButton.setBounds(560, 360, 100, 43);
		startButton.addActionListener(action);
		startButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		startButton.setBorderPainted(false); // ��ư �׵θ�
		startButton.setFocusPainted(false); // ��Ŀ�� ǥ�� ����
		startButton.setContentAreaFilled(false); // ��ư ���� ��� ǥ�� ����

		lowButton.setOpaque(false);
		lowButton.setBounds(555, 310, 40, 43);
		lowButton.addActionListener(action);
		lowButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		lowButton.setBorderPainted(false);
		lowButton.setFocusPainted(false);
		lowButton.setContentAreaFilled(false);

		midButton.setOpaque(false);
		midButton.setBounds(590, 310, 40, 43);
		midButton.addActionListener(action);
		midButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		midButton.setBorderPainted(false);
		midButton.setFocusPainted(false);
		midButton.setContentAreaFilled(false);

		highButton.setOpaque(false);
		highButton.setBounds(625, 310, 40, 43);
		highButton.addActionListener(action);
		highButton.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		highButton.setBorderPainted(false);
		highButton.setFocusPainted(false);
		highButton.setContentAreaFilled(false);

		mineUI.add(startButton);
		mineUI.add(lowButton);
		mineUI.add(midButton);
		mineUI.add(highButton);
		mineUI.setVisible(true);

		GameChooseUI.mainFrame.getContentPane().add(mineUI, BorderLayout.CENTER);
		mineUI.setLayout(null);
		GameChooseUI.mainFrame.add(mineUI);
		GameChooseUI.mainFrame.setVisible(true);
	}

}
