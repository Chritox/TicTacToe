package de.christianochs.tictactoe.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.christianochs.tictactoe.Mainframe;

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
public class MenuActionListener implements ActionListener {
	private Mainframe mainframe;

	/**
	 * Konstruktor
	 * 
	 * @param mainframe
	 *            wird ben�tigt um auf die ActionEvents richtig reagieren zu k�nnen.
	 */
	public MenuActionListener(Mainframe mainframe) {
		this.mainframe = mainframe;
	}

	/**
	 * Wird aufgerufen, wenn auf den Play-Button gedr�ckt wird. Zum einen wird
	 * reagiert, wenn der Button im Hauptmen� gedr�ckt wird und zum Anderen, wenn eine Runde
	 * beendet wurde und der Button gedr�ckt wird.
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() instanceof JButton) {
			JButton button = (JButton) event.getSource();
			if (button.getText().equals("Spielen")) {
				if (mainframe.getMain().getMainframe().isValidInput()) {
					mainframe.getMain().setupGame();
				} else {
					mainframe.updateInstruction("Bitte Eingaben �berpr�fen!");
				}
			} else if (button.getText().equals("Nochmal")) {
				mainframe.getMain().setupNewRound();
			}
		}

	}

}
