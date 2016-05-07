/**
 * Interface representing a 2-player identical piece game
 */
public abstract class Game {

	public abstract int boardWidth();

	public abstract int boardHeight();

	public abstract boolean won(boolean[][] board, boolean player);

	public abstract Move[] legalMoves(boolean[][] board, boolean player);

	public boolean finished(boolean[][] board, boolean currentPlayer) {
		return won(board, true) || won(board, false) || legalMoves(board, currentPlayer).length == 0;
	}

	/**
	 * Representation of a "move", presumably putting a piece down at a certain location
	 */
	class Move {

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
