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
	 * @param winner the given player (1 or 2)
	 * @param currentPlayer the player who's turn it is at the moment (1 or 2)
	 */
	public boolean canWin(int[][] board, int winner, int currentPlayer) {
		if (game.won(board, winner)) return true;
		if (game.finished(board, currentPlayer)) return false;

		Game.Move[] moves = game.legalMoves(board, currentPlayer);
		int[][] newBoard;

		if (currentPlayer == winner) {
			for (int i = 0; i < moves.length; i++) {
				newBoard = game.makeMove(board, currentPlayer, moves[i]);
				if (canWin(newBoard, winner, 3 - currentPlayer)) return true;
			}
			return false;
		}
		else {
			for (int i = 0; i < moves.length; i++) {
				newBoard = game.makeMove(board, currentPlayer, moves[i]);
				if (!canWin(newBoard, winner, 3 - currentPlayer)) return false;
			}
			return true;
		}
	}

	/**
	 * Prints all the subsequent states in which the game has been won by <code>winner</code>.
	 * In these states, it is the <code>winner</code>'s turn
	 * @param board current state of the board
	 * @param winner the player who wins the game in the printed states
	 * @param currentPlayer the player whose turn it is
	 */
	public void printAllWins(int[][] board, int winner, int currentPlayer) {
		if (canWin(board, winner, currentPlayer) && !winNextTurn(board, currentPlayer)) {
			char player = currentPlayer == 1 ? game.p1Char() : game.p2Char();
			System.out.println(String.format("%c's turn", player));
			printBoard(board, game);
			return;
		}
		if (game.finished(board, currentPlayer)) return;

		Game.Move[] moves = game.legalMoves(board, currentPlayer);
		int[][] newBoard;
		for (Game.Move move : moves) {
			newBoard = game.makeMove(board, currentPlayer, move);
			printAllWins(newBoard, winner, 3 - currentPlayer);
		}
	}

	/**
	 * Sees whether the game will be won this turn by the current player.
	 * @param board current state of the board
	 * @param currentPlayer player who's turn it is
	 * @return whether currentPlayer can make a game-winning move this turn
	 */
	public boolean winNextTurn(int[][] board, int currentPlayer) {
		int[][] newBoard;
		for (Game.Move move : game.legalMoves(board, currentPlayer)) {
			newBoard = game.makeMove(board, currentPlayer, move);
			if (game.won(newBoard, currentPlayer)) return true;
		}
		return false;
	}

	/**
	 * Prints out the game board with hyphens where there are no players and standard p1 and p2 characters
	 * for the other player's locations
	 * @param board
	 * @param game game that is being played
	 */
	public static void printBoard(int[][] board, Game game) {
		char outputChar = '-';
		for (int row = 0; row < game.boardHeight(); row++) {
			for (int col = 0; col < game.boardWidth(); col++) {
				switch (board[row][col]) {
					case 0:
						outputChar = '-';
						break;
					case 1:
						outputChar = game.p1Char();
						break;
					case 2:
						outputChar = game.p2Char();
						break;
				}
				System.out.print(outputChar + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}