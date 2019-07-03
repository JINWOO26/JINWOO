package main.com.show;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.com.game.RainGame;

public class RainGameUIPanel extends GameUI implements ActionListener {

	static String backGround = "background";
	int gameTime = 120;
	public RainGameUIPanel() {
		super(backGround);
		super.showUI(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton) {
			mineUI.setVisible(false); // ���� Panel �����ְ�
			new RainGame(gameTime);
		}

		if (e.getSource() == lowButton) {
			lowButton.setIcon(lowIconClick);
			midButton.setIcon(midIcon);
			highButton.setIcon(highIcon);

			// ���̵� ����
			gameTime = 120;
		}

		if (e.getSource() == midButton) {
			midButton.setIcon(midIconClick);
			lowButton.setIcon(lowIcon);
			highButton.setIcon(highIcon);

			// ���̵� ����
			gameTime = 60;
		}

		if (e.getSource() == highButton) {
			highButton.setIcon(highIconClick);
			lowButton.setIcon(lowIcon);
			midButton.setIcon(midIcon);

			// ���̵� ����
			gameTime = 30;
		}

	}
}
