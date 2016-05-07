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
		if (game.won(board, winner)) return true;
		if (game.finished(board, currentPlayer)) return true;

		Game.Move[] moves = game.legalMoves(board, currentPlayer);
		boolean[][] newBoard;

		if (currentPlayer == winner) {
			for (int i = 0; i < moves.length; i++) {
				newBoard = game.makeMove(board, currentPlayer, moves[i]);
				if (canWin(board, winner, !currentPlayer)) return true;
			}
			return false;
		}
		else {
			for (int i = 0; i < moves.length; i++) {
				newBoard = game.makeMove(board, currentPlayer, moves[i]);
				if (!canWin(board, winner, !currentPlayer)) return false;
			}
			return true;
		}
	}

}