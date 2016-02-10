package com.vtian.dataModel;

import java.awt.Color;

/*
 * A Tile object can hold information about both character and color of tile
 */
public class Tile {
	private char keyChar;
	private Color color;

	public Tile(char ch, Color c) {
		keyChar = ch;
		color = c;
	}

	public char getKeyChar() {
		return keyChar;
	}

	public void setKeyChar(char keyChar) {
		this.keyChar = keyChar;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
