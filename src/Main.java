public class Main {

	public static void main(String[] args) {
		Analyzer a = new Analyzer(new TicTacToe(3));
		int[][] board = new int[3][3];
		board[1][1] = 1;
		System.out.println(a.canWin(board, 2, 2));
		a.printAllWins(board, 2, 2);
	}

}
