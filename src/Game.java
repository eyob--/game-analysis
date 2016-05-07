/**
 * Interface representing a 2-player identical piece game
 */
public abstract class Game {

	public abstract int boardWidth();

	public abstract int boardHeight();

	public abstract boolean won(int[][] board, int player);

	public abstract Move[] legalMoves(int[][] board, int player);

	public abstract boolean[][] makeMove(int[][] board, int player, Move legalMove);

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
