package com.vtian.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.vtian.dataModel.Model;

/*
 * KeyPressHandler handle key typed event and get notifications. 
 */
public class KeyPressHandler implements KeyListener {

	private Model _model;

	public KeyPressHandler(Model m) {
		_model = m;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		_model.remove(e.getKeyChar());
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}