package de.christianochs.tictactoe;

import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import de.christianochs.tictactoe.listener.MenuActionListener;
import de.christianochs.tictactoe.listener.MenuFocusListener;

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
public class Mainframe extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Main main;
	private JLabel instruction, scoreboardnames, scoreboardpoints;
	private JTextField playername0, playername1, playerchar0, playerchar1;
	private Container pinnwand;
	private JButton play;
	private MenuFocusListener fl;
	private MenuActionListener al;

	public Mainframe(Main main) {
		this.main = main;
		pinnwand = this.getContentPane();
		pinnwand.setLayout(null);
		setTitle("TicTacToe");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setupStartScreen();
		setSize(600, 600);
		this.setResizable(false);
		setVisible(true);
	}

	/**
	 * Erstellt das Start-Menü
	 */
	public void setupStartScreen() {
		pinnwand.setVisible(true);
		fl = new MenuFocusListener();
		al = new MenuActionListener(this);
		instruction = new JLabel("Bitte Namen eingeben");
		playername0 = new JTextField("Spieler 0");
		playername1 = new JTextField("Spieler 1");
		playerchar0 = new JTextField("X");
		playerchar1 = new JTextField("O");
		play = new JButton("Spielen");

		instruction.setBounds(0, 10, 600, 30);
		instruction.setFont(new Font(instruction.getFont().getName(), Font.PLAIN, 24));
		playername0.setBounds(200, 60, 180, 30);
		playername1.setBounds(200, 90, 180, 30);
		playerchar0.setBounds(380, 60, 20, 30);
		playerchar1.setBounds(380, 90, 20, 30);
		play.setBounds(180, 400, 240, 100);

		playername0.addFocusListener(fl);
		playername1.addFocusListener(fl);
		playerchar0.addFocusListener(fl);
		playerchar1.addFocusListener(fl);

		play.addActionListener(al);

		instruction.setHorizontalAlignment(SwingConstants.CENTER);

		pinnwand.add(instruction);
		pinnwand.add(playername0);
		pinnwand.add(playername1);
		pinnwand.add(playerchar0);
		pinnwand.add(playerchar1);
		pinnwand.add(play);
	}

	/**
	 * Bereitet die erste Spielrunde vor.
	 */
	public void setupGame() {
		pinnwand.removeAll();
		instruction.setText(main.getCurrentPlayer().getName() + " ist am Zug");
		pinnwand.add(instruction);
		scoreboardnames = new JLabel(main.getPlayer0().getName() + "[" + main.getPlayer0().getMarker() + "]" + " : "
				+ main.getPlayer1().getName() + "[" + main.getPlayer1().getMarker() + "]");
		scoreboardnames.setBounds(0, 50, 600, 20);
		scoreboardnames.setFont(new Font(scoreboardnames.getFont().getName(), Font.PLAIN, 18));
		scoreboardnames.setHorizontalAlignment(SwingConstants.CENTER);
		scoreboardpoints = new JLabel(main.getPlayer0().getWins() + " : " + main.getPlayer1().getWins());
		scoreboardpoints.setBounds(0, 70, 600, 20);
		scoreboardpoints.setFont(new Font(scoreboardpoints.getFont().getName(), Font.PLAIN, 18));
		scoreboardpoints.setHorizontalAlignment(SwingConstants.CENTER);
		pinnwand.add(scoreboardnames);
		pinnwand.add(scoreboardpoints);

		play.setText("Nochmal");
		play.setBounds(200, 270, 200, 60);
		play.setVisible(false);
		pinnwand.add(play);
		PlayGround pg = main.getPlayGround();

		for (int i = 0; i < pg.getFields().length; i++) {
			for (JButton button : pg.getFields()[i]) {
				pinnwand.add(button);
			}
		}
		// Obligatorisches Aktualisieren des ContentPanes
		repaint();
	}

	/**
	 * Gibt das Main-Objekt der Klasse zurück
	 * 
	 * @return main
	 */
	public Main getMain() {
		return main;
	}

	/**
	 * Prüft, ob alle Spielereigaben korrekt sind.
	 * 
	 * @return true or false
	 */
	public boolean isValidInput() {
		return PlayerNamesAreGiven() && PlayerCharsAreCorrect();
	}

	/**
	 * Gibt zurück, welcher Name in das Eingabefeld playername0 eingegeben wurde.
	 * 
	 * @return Name von Player 0
	 */
	public String getPlayer0Name() {
		return playername0.getText().trim();
	}

	/**
	 * Gibt zurück, welcher Name in das Eingabefeld playername1 eingegeben wurde.
	 * 
	 * @return Name von Player 1
	 */
	public String getPlayer1Name() {
		return playername1.getText().trim();
	}

	/**
	 * Gibt zurück, welches Zeichen in das Eingabefeld playerchar0 eingegeben wurde.
	 * 
	 * @return Zeichen von Player 0
	 */
	public String getPlayer0Char() {
		return playerchar0.getText().trim();
	}

	/**
	 * Gibt zurück, welches Zeichen in das Eingabefeld playerchar1 eingegeben wurde.
	 * 
	 * @return Zeichen von Player 1
	 */
	public String getPlayer1Char() {
		return playerchar1.getText().trim();
	}

	/**
	 * Setzt den Text des Labels instruction
	 * 
	 * @param s Text
	 */
	public void updateInstruction(String s) {
		instruction.setText(s);
	}

	/**
	 * Aktualisiert das Scoreboard
	 */
	public void updatePoints() {
		scoreboardpoints.setText(main.getPlayer0().getWins() + " : " + main.getPlayer1().getWins());
	}

	/**
	 * Aktiviert bzw. deaktiviert den Button play
	 */
	public void toggleButton() {
		if (play.isVisible()) {
			play.setVisible(false);
		} else {
			play.setVisible(true);
		}
	}

	/**
	 * Prüft, ob Spielernamen angegeben sind und ob diese nicht gleich sind.
	 * 
	 * @return true oder false
	 */
	public boolean PlayerNamesAreGiven() {
		if (getPlayer0Name().length() > 0 && getPlayer1Name().length() > 0
				&& !getPlayer0Name().equals(getPlayer1Name()))
			return true;
		return false;
	}

	/**
	 * Prüft, ob Spielerzeichen angegeben sind und ob diese nicht gleich sind und ob
	 * die Länge maximal 1 ist
	 * 
	 * @return true oder false
	 */
	private boolean PlayerCharsAreCorrect() {
		return getPlayer0Char().length() == 1 && getPlayer1Char().length() == 1
				&& !getPlayer0Char().equals(getPlayer1Char());

	}
}