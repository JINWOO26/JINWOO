package main.com.game;

import javax.swing.JLabel;

import main.com.show.GameChooseUI;

public class CheckTheGameEnd extends Thread {
	public static int gamePlayTime = 0;
	public JLabel playTime;
	int wordCount;

	public CheckTheGameEnd(int gameTime, int wordCount) {
		this.wordCount = wordCount;
		gamePlayTime = gameTime;
		playTime = new JLabel(Integer.toString(gamePlayTime));
	}

	public void run() {
		try {
			checkTheEnd();
		} catch (InterruptedException e) {
			new ResultView(GameChooseUI.SCORE, wordCount);
		}
	}

	public void checkTheEnd() throws InterruptedException {
		while ((gamePlayTime > 0 && wordCount > 0)) {
				Thread.sleep(1000);
			
			playTime.setText(gamePlayTime + "");
			gamePlayTime--;
		}

		throw new InterruptedException();
	}
}
