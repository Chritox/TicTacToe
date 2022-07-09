package de.christianochs.tictactoe;

/**
 * TicTacToe
 * <p>
 * TicTacToe ist ein kleines Strategie-Spiel, bei dem zwei Spieler abwechselnd
 * ihre Zeichen in Felder setzen. Schafft es ein Spieler 3 Zeichen
 * horizontal/diagonal/vertikal nebeneinander zu platzieren, so gewinnt dieser.
 *
 * @author Christian Ochs
 * @version 1.0
 */
public class Main {
    private final Mainframe mainframe;
    private final PlayGround playGround;
    private Player player0;
    private Player player1;
    private Player currentPlayer;

    public Main() {
        mainframe = new Mainframe(this);
        playGround = new PlayGround(this);
    }

    /**
     * Erstellt ein neues Spiel, indem die Spielernamen und Spielerchars aus den
     * Textfelden ausgelesen werden und das Spielfeld generiert wird.
     */
    public void setupGame() {
        player0 = new Player(mainframe.getPlayer0Name(), mainframe.getPlayer0Char());
        player1 = new Player(mainframe.getPlayer1Name(), mainframe.getPlayer1Char());
        toggleCurrentPlayer();
        mainframe.setupGame();
    }

    /**
     * Startet eine neue Runde
     */
    public void setupNewRound() {
        toggleCurrentPlayer();
        mainframe.toggleButton();
        mainframe.updateInstruction(getCurrentPlayer().getName() + " ist am Zug");
        playGround.resetGame();
    }

    /**
     * Methode, die abhandelt, was nach einem jedem Zug passiert. Wird über den
     * ActionListener der Spielfelder aufgerufen
     */
    public void handleUpdate() {
        if (playGround.checkForWin() != null) {
            playGround.disableFields();
            Player winner = playerFromMarker(playGround.checkForWin());
            mainframe.updateInstruction(winner.getName() + " hat gewonnen!");
            mainframe.toggleButton();
            winner.addWin();
            mainframe.updatePoints();
        } else if (playGround.isFilled()) {
            mainframe.updateInstruction("Unentschieden");
            mainframe.toggleButton();
            playGround.disableFields();
        } else {
            toggleCurrentPlayer();
            mainframe.updateInstruction(currentPlayer.getName() + " ist an der Reihe");
        }
    }

    /**
     * Wechselt den aktuellen Spieler
     */
    public void toggleCurrentPlayer() {
        if (currentPlayer == player0) {
            currentPlayer = player1;
        } else {
            currentPlayer = player0;
        }

    }

    /**
     * Gibt den 1. Spieler zurück
     *
     * @return player0
     */
    public Player getPlayer0() {
        return player0;
    }

    /**
     * Gibt den 2. Spieler zurück
     *
     * @return player1
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Gibt zurück, welcher Spieler am Zug ist
     *
     * @return currentPlayer
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Gibt das PlayGround-Objekt der Klasse zurück
     *
     * @return playGround
     */
    public PlayGround getPlayGround() {
        return playGround;
    }

    /**
     * Gibt das Mainfram-Objekt der Klasse zurück
     *
     * @return mainframe
     */
    public Mainframe getMainframe() {
        return mainframe;
    }

    /**
     * Gibt den Spieler aus, der zum übergebenen Marker gehört.
     *
     * @param marker Übergebener Marker
     * @return player0 oder player1
     */
    public Player playerFromMarker(String marker) {
        if (marker.equals(player0.getMarker()))
            return player0;
        return player1;
    }

    /**
     * Obligatorische Startmethode, die das Programm startet.
     *
     * @param args Startparameter
     */
    public static void main(String[] args) {
        new Main();
    }

}
