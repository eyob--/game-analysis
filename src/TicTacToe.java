import java.util.ArrayList;

/**
 * Game for Tic-Tac-Toe contained on a n x n grid
 */
public class TicTacToe extends Game {

	private final int BOARD_LENGTH;

	public TicTacToe(int boardLength) {
		BOARD_LENGTH = boardLength;
	}

	@Override
	public int boardWidth() {
		return BOARD_LENGTH;
	}

	@Override
	public int boardHeight() {
		return BOARD_LENGTH;
	}

	@Override
	public boolean won(int[][] board, int player) {
		return wonInRows(board, player) || wonInColumns(board, player) || wonOnDiagonals(board, player);
	}

	/**
	 * Whether the player won by getting a completed row
	 * @param board current board
	 * @param player player who may have won
	 * @return true if the player won, false if they didn't
	 */
	private boolean wonInRows(int[][] board, int player) {
		boolean won;
		for (int i = 0; i < boardHeight(); i++) {
			won = true;
			for (int j = 0; j < boardWidth(); j++) {
				if (board[i][j] != player) {
					won = false;
					break;
				}
			}
			if (won) return true;
		}
		return false;
	}

	/**
	 * Whether the player won by getting a completed column
	 * @param board current board
	 * @param player player who may have won
	 * @return true if the player won, false if they didn't
	 */
	private boolean wonInColumns(int[][] board, int player) {
		boolean won;
		for (int i = 0; i < boardWidth(); i++) {
			won = true;
			for (int j = 0; j < boardHeight(); j++) {
				if (board[j][i] != player) {
					won = false;
					break;
				}
			}
			if (won) return true;
		}
		return false;
	}

	/**
	 * Whether the player won by getting a completed diagonal
	 * @param board current board
	 * @param player player who may have won
	 * @return true if the player won, false if they didn't
	 */
	private boolean wonOnDiagonals(int[][] board, int player) {
		boolean first = true, second = true;
		for (int i = 0; i < BOARD_LENGTH; i++) {
			if (board[i][i] != player) {
				first = false;
				break;
			}
		}
		for (int i = 0; i < BOARD_LENGTH; i++) {
			if (board[i][BOARD_LENGTH - i] != player) {
				second = false;
				break;
			}
		}
		return first || second;
	}

	@Override
	public Move[] legalMoves(int[][] board, int player) {
		ArrayList<Move> moves = new ArrayList<>();
		for (int i = 0; i < boardHeight(); i++) {
			for (int j = 0; j < boardWidth(); j++) {
				if (board[i][j] == 0) {
					moves.add(new Move(j, i));
				}
			}
		}
		return moves.toArray(new Move[moves.size()]);
	}

	@Override
	public int[][] makeMove(int[][] board, int player, Move legalMove) {
		int[][] newBoard = new int[boardHeight()][boardWidth()];
		for (int i = 0; i < boardHeight(); i++) {
			for (int j = 0; j < boardWidth(); j++) {
				newBoard[i][j] = board[i][j];
			}
		}

		newBoard[legalMove.getY()][legalMove.getX()] = player;
		return newBoard;
	}
}
