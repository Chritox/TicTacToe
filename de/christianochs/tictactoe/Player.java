package de.christianochs.tictactoe;

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
public class Player {
	private int wins;
	private final String name;
	private final String marker;

	/**
	 * Konstruktor
	 * 
	 * @param name
	 *            der Name des Spielers
	 * @param marker
	 *            das Zeichen, mit dem der Spieler spielt
	 */
	public Player(String name, String marker) {
		this.marker = marker;
		this.name = name;
	}

	/**
	 * Gibt den Namen des Spielers zurück
	 * 
	 * @return Name des Spielers
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gibt die Anzahl der Siege des Spielers zurück
	 * 
	 * @return Siege des Spielers
	 */
	public int getWins() {
		return wins;
	}

	/**
	 * Fügt den Siegen des Spielers einen weiteren Sieg hinzu.
	 */
	public void addWin() {
		wins = wins + 1;
	}

	/**
	 * Gibt das Zeichen zurück, mit dem der Spieler spielt
	 * 
	 * @return Zeichen des Spielers
	 */
	public String getMarker() {
		return marker;
	}

}


