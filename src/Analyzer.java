/**
 * 2-player identical piece game analyzer
 */
public class Analyzer {

	private Game game;

	public Analyzer(Game g) {
		game = g;
	}

	/**
	 * Returns whether or not a given player is guaranteed a win if they play perfectly
	 * @param board current state of the board
	 * @param winner the given player
	 * @param currentPlayer the player who's turn it is at the moment
	 */
	public boolean canWin(boolean[][] board, boolean winner, boolean currentPlayer) {
		return false;
	}

}