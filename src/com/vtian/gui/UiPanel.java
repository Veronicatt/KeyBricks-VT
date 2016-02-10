package com.vtian.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.vtian.dataModel.Model;

/*
 * UI 
 * JPanel JPanel with a GridLayout applied.
 * contains the requisite 6 of JButtons and implements Observer
 * 
 */
public class UiPanel extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;

	// data model
	private Model _model;
	// buttons that represent tiles
	private JButton[] buttons = new JButton[6];

	// Constructor , add buttons to layout
	public UiPanel() {
		_model = new Model();
		_model.addObserver(this);
		KeyPressHandler keyHandler = new KeyPressHandler(_model);
		addKeyListener(keyHandler);
		setFocusable(true);
		GridLayout brickLayout = new GridLayout(6, 1);
		addButtons(this);
		setLayout(brickLayout);
		requestFocus();
		setVisible(true);
	}

	// creates button and add it to layout
	public void addButtons(JPanel panel) {
		for (int j = 0; j < 6; j++) {
			char l = _model.getletter(j);
			buttons[j] = new JButton("" + l);
			buttons[j].setFocusable(false);
			buttons[j].setContentAreaFilled(false);
			buttons[j].setOpaque(true);
			buttons[j].setBackground(_model.getColor(j));
			buttons[j].setPreferredSize(new Dimension(180, 50));
		}
		for (int i = 5; i >= 0; i--)
			panel.add(buttons[i]);
	}

	/*
	 * observer of the data model, so that when the data model changes the GUI
	 * receives notification.
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		updateButtons();
		updateUI();
		int dialogButton = JOptionPane.YES_NO_OPTION;
		if (_model.isGameover()) {
			int dialogResult = JOptionPane.showConfirmDialog(null,
					"YOU WIN! Would You Like to play again?", "YOU WIN!",
					dialogButton);
			if (dialogResult == JOptionPane.YES_OPTION) {
				_model = new Model();
				_model.addObserver(this);
				updateButtons();
			} else {
				System.exit(0);
			}
		}
	}

	/*
	 * update buttons from model data
	 */
	private void updateButtons() {
		for (int j = 0; j < 6; j++) {
			char l = _model.getletter(j);
			buttons[j].setText("" + l);
			buttons[j].setBackground(_model.getColor(j));
			buttons[j].setOpaque(true);
			buttons[j].setFocusable(false);
		}
		updateUI();
	}

}