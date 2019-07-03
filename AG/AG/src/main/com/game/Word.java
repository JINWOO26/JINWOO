package main.com.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Word {
	public ArrayList<String> words = new ArrayList<>();

	public Word() {
		try {
			Scanner inputStream = new Scanner(new File("word.txt"));

			while (inputStream.hasNextLine()) {
				this.words.add(inputStream.nextLine());
			}

			Collections.shuffle(this.words);

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}

	public ArrayList<String> getWords() {
		return words;
	}

}
