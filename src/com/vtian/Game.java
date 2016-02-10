package com.vtian;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;

import com.vtian.gui.UiPanel;

/*
 * Game By Veronica Tian
 * Have a 1 by 6 board (a single column of six rows).
 * Place a tile, each with a distinct letter, into each of the six positions.
 * Respond as keys are typed by removing a tile when its letter is typed.
 * Have tiles above the removed tile drop down.
 * End the game when all tiles have been removed.
 * 
 */

public class Game {

	public Game() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				JFrame frame = new JFrame("KeyBricks-VT");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(new UiPanel());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				frame.setResizable(true);
			}
		});
	}

	public static void main(String[] args) {
		new Game();

	}

}