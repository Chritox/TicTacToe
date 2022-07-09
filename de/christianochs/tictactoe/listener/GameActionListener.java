package de.christianochs.tictactoe.listener;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.christianochs.tictactoe.PlayGround;

/**
 * TicTacToe
 * 
 * TicTacToe ist ein kleines Strategie-Spiel, bei dem zwei Spieler abwechselnd
 * ihre Zeichen in Felder setzen. Schafft es ein Spieler 3 Zeichen
 * horizontal/diagonal/vertikal nebeneinander zu platzieren, so gewinnt dieser.
 * 
 * @author Christian Ochs
 * @version 1.0
 */

public class GameActionListener implements ActionListener {

	private PlayGround playground;

	/**
	 * Konstruktor.
	 * 
	 * @param playground
	 *            wird benötigt, um auf ein ActionEvent richtig reagieren zu können.
	 */
	public GameActionListener(PlayGround playground) {
		this.playground = playground;
	}

	/**
	 * Methode wird aufgerufen, wenn eines der Spielfelder angeklickt wird. Ist in
	 * diesem Feld kein Zeichen, so wird dort das Zeichen des aktuellen Spielers
	 * eingefügt. Anschließend wird handleUpdate() der Main-Klasse aufgerufen.
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() instanceof JButton) {
			JButton source = (JButton) event.getSource();
			if (source.getText().equals("")) {
				source.setText(playground.getMain().getCurrentPlayer().getMarker());
				playground.getMain().handleUpdate();
			}
		}
	}

}
