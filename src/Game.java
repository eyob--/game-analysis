/**
 * Interface representing a 2-player identical piece game
 */
public abstract class Game {

	/**
	 * Return the game's board width. Should be constant
	 * @return board width of the game
	 */
	public abstract int boardWidth();

	/**
	 * Return the game's board height. Should be constant
	 * @return board height of the game
	 */
	public abstract int boardHeight();

	/**
	 * Check if a player has actually won at a given state of the game
	 * @param board board at the given state of the game
	 * @param player player to be checked
	 * @return true if the given player has won on the given board, false if they have not
	 */
	public abstract boolean won(int[][] board, int player);

	/**
	 * Gives back an array of legal moves for the player to make on the given board
	 * @param board board at the desired state of the game
	 * @param player player whose moves will be given back
	 * @return array of legal moves for the given player
	 */
	public abstract Move[] legalMoves(int[][] board, int player);

	/**
	 * Plays a given legal move for the given player on the given board
	 * @param board boar at the desired state of the game
	 * @param player player who will make the move
	 * @param legalMove the legal move to be made
	 * @return the board after the move has been made
	 */
	public abstract int[][] makeMove(int[][] board, int player, Move legalMove);

	/**
	 * Whether the game can proceed or not
	 * @param board board at the desired state of the game
	 * @param currentPlayer player whose turn it is
	 * @return true if the game cannot proceed, false if it still can
	 */
	public boolean finished(int[][] board, int currentPlayer) {
		return won(board, 1) || won(board, 2) || legalMoves(board, currentPlayer).length == 0;
	}

	/**
	 * Representation of a "move", presumably putting a piece down at a certain location
	 */
	public static class Move {

		private int x, y;

		public Move(int x, int y) {
			this.x = x; this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}

}
