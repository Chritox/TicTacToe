package de.christianochs.tictactoe;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import de.christianochs.tictactoe.listener.GameActionListener;

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
public class PlayGround {
	private JButton[][] felder = new JButton[3][3];
	private Main main;

	private GameActionListener al;

	/**
	 * Konstruktor Weist "al" ein Object zu; die Spielfelder werden erzeugt, deren
	 * Gr��e sowie Position und Schriftgr��e festgelegt und der Actionlistener wird
	 * diesen hinzugef�gt.
	 * 
	 * @param main
	 *            �bergibt ein Objekt vom Typ Main an PlayGround
	 */
	public PlayGround(Main main) {
		this.main = main;
		al = new GameActionListener(this);
		for (int x = 0; x < felder.length; x++) {
			for (int y = 0; y < felder[x].length; y++) {
				felder[x][y] = new JButton();
				felder[x][y].setBounds(x * 145 + 80, y * 145 + 120, 140, 140);
				felder[x][y].setBackground(Color.WHITE);
				felder[x][y].setFont(new Font(felder[x][y].getFont().getName(), Font.PLAIN, 100));
				felder[x][y].addActionListener(al);
				felder[x][y].setFocusable(false);
				// Erzeugt die Rahmenlinien
				int left = 0, top = 0, right = 0, bottom = 0;
				if (x >= 0 && x < 2)
					right = 1;
				if (x > 0)
					left = 1;
				if (y >= 0 && y < 2)
					bottom = 1;
				if (y > 0)
					top = 1;
				felder[x][y].setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK));
			}
		}
	}

	/**
	 * Setzt das Spielfeld zur�ck
	 */
	public void resetGame() {
		for (int i = 0; i < felder.length; i++) {
			for (JButton button : felder[i]) {
				button.setEnabled(true);
				button.setText("");
				button.setBackground(Color.WHITE);
			}
		}
	}

	/**
	 * Setzt alle Spielfelder auf disabled
	 */
	public void disableFields() {
		for (int i = 0; i < felder.length; i++) {
			for (JButton button : felder[i]) {
				button.setEnabled(false);
			}
		}

	}

	/**
	 * Pr�ft auf einen Sieg und gibt das Zeichen zur�ck, mit dem gewonnen wurde.
	 * Wenn kein Sieg vorliegt wird null zur�ckgegeben. Bei einem Sieg werden
	 * au�erdem die Siegfelder markiert.
	 * 
	 * @return Zeichen, mit dem gewonnen wurde
	 */
	public String checkForWin() {
		String result = null;
		for (int y = 0; y < felder[0].length; y++) {
			if (felder[0][y].getText().length() > 0) {
				if (felder[0][y].getText().equals(felder[1][y].getText())
						&& felder[1][y].getText().equals(felder[2][y].getText())) {
					setMarked(felder[0][y], felder[1][y], felder[2][y]);
					result = felder[0][y].getText();
				}
			}
		}
		for (int x = 0; x < felder.length; x++) {
			if (felder[x][0].getText().length() > 0) {
				if (felder[x][0].getText().equals(felder[x][1].getText())
						&& felder[x][1].getText().equals(felder[x][2].getText())) {
					setMarked(felder[x][0], felder[x][1], felder[x][2]);
					result = felder[x][0].getText();
				}
			}
		}
		if (felder[1][1].getText().length() > 0) {
			if (felder[0][0].getText().equals(felder[1][1].getText())
					&& felder[1][1].getText().equals(felder[2][2].getText())) {
				setMarked(felder[0][0], felder[1][1], felder[2][2]);
				result = felder[1][1].getText();

			}
			if (felder[0][2].getText().equals(felder[1][1].getText())
					&& felder[1][1].getText().equals(felder[2][0].getText())) {
				setMarked(felder[0][2], felder[1][1], felder[2][0]);
				result = felder[1][1].getText();

			}
		}
		return result;
	}

	/**
	 * Setzt den Hintergrund der �bergebenen Buttons auf die Farbe Gr�n
	 * 
	 * @param b0
	 *            1. Button, der markiert werden soll.
	 * @param b1
	 *            2. Button, der markiert werden soll.
	 * @param b2
	 *            3. Button, der markiert werden soll.
	 */
	public void setMarked(JButton b0, JButton b1, JButton b2) {
		b0.setBackground(Color.GREEN);
		b1.setBackground(Color.GREEN);
		b2.setBackground(Color.GREEN);
	}

	/**
	 * Pr�ft, ob das Spielfeld komplett gef�llt ist
	 * 
	 * @return true, wenn Spielfeld voll
	 */
	public boolean isFilled() {
		for (int i = 0; i < felder.length; i++) {
			for (JButton b : felder[i]) {
				if (b.getText().equals(""))
					return false;
			}
		}
		return true;
	}

	/**
	 * Gibt den zweidimensionalen Array mit den Spielfeldern zur�ck
	 * 
	 * @return Spielfelder
	 */
	public JButton[][] getFields() {
		return felder;
	}

	/**
	 * Gibt das Main-Objekt zur�ck, das im Konstruktor on PlayGround �bergeben wurde
	 * 
	 * @return Objekt der Main-Klasse
	 */
	public Main getMain() {
		return main;
	}

}
