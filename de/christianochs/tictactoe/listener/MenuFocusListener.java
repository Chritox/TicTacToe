package de.christianochs.tictactoe.listener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

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
public class MenuFocusListener implements FocusListener {
	/**
	 * Wird aufgerufen, wenn eines der Eingabefelder für Spielernamen und
	 * Spielerzeichen den Focus erhält. Durch die Markierung aller Zeichen soll der
	 * Nutzer schnell die Eingaben ändern können.
	 */
	@Override
	public void focusGained(FocusEvent event) {
		if (event.getComponent() instanceof JTextField) {
			JTextField text = (JTextField) event.getComponent();
			text.selectAll();
		}
	}

	/**
	 * Methode wird nicht benötigt, aber muss implementiert sein. Die Methode hat keine Funktion.
	 */
	@Override
	public void focusLost(FocusEvent event) {

	}

}
