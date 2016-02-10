package com.vtian.dataModel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Random;

/*
 * represent the game board
 */
public class Model extends Observable {

	// Tiles on board
	private ArrayList<Tile> tiles;
	// is game over
	private boolean gameover = false;

	public Model() {
		tiles = new ArrayList<Tile>();
		// possible letters
		ArrayList<Character> allletters = new ArrayList<Character>();
		// add all lowercase letters in array
		for (int i = 97; i < 122; i++) {
			allletters.add(((char) i));
		}
		// shuffle array with letters
		long seed = System.nanoTime();
		Collections.shuffle(allletters, new Random(seed));

		// make color list
		ArrayList<Color> colors = new ArrayList<Color>();
		colors.add(Color.red);
		colors.add(Color.blue);
		colors.add(Color.orange);
		colors.add(Color.green);
		colors.add(Color.yellow);
		colors.add(Color.magenta);

		// shuffle array with colors
		Collections.shuffle(colors, new Random(seed));
		// create tiles and set letter and color on it
		for (int i = 0; i < 6; i++) {
			Tile t = new Tile((char) allletters.get(i), colors.get(i));
			tiles.add(t);
		}
	}

	// remove tiles
	public void remove(char keyChar) {
		keyChar = Character.toLowerCase(keyChar);
		for (Tile t : tiles) {
			if (t.getKeyChar() == keyChar) {
				tiles.remove(t);
				if (tiles.size() == 0)
					setGameover(true);
				setChanged();
				notifyObservers();

				return;
			}
		}
	}

	// get letters for buttons
	public char getletter(int j) {
		if (j > tiles.size() - 1)
			return ' ';
		return tiles.get(j).getKeyChar();
	}

	// get color for buttons
	public Color getColor(int j) {
		if (j > tiles.size() - 1)
			return Color.white;
		return tiles.get(j).getColor();
	}

	public boolean isGameover() {
		return gameover;
	}

	public void setGameover(boolean gameover) {
		this.gameover = gameover;
	}

}
