package ticTacToeApplication;

public class TicTacToe {

	/*******************************/
	/* Picture of Game with Index: */
	/* FOR STORAGE:............... */
	/* 0 | 1 | 2 ................. */
	/* ---------- ................ */
	/* 3 | 4 | 5 ................. */
	/* ---------- ................ */
	/* 6 | 7 | 8 ................. */
	/* WHAT THE USER THINKS: ..... */
	/* 1 | 2 | 3 ................. */
	/* ---------- ................ */
	/* 4 | 5 | 6 ................. */
	/* ---------- ................ */
	/* 7 | 8 | 9 ................. */
	/*******************************/
	/* UI Picture of Game: ....... */
	/* INIT: ..................... */
	/* | - | - | - | ............. */
	/* ------------- ............. */
	/* | - | - | - | ............. */
	/* ------------- ............. */
	/* | - | - | - | ............. */
	/* GAMEPLAY: ................. */
	/* | 0 | - | 0 | ............. */
	/* ------------- ............. */
	/* | - | X | - | ............. */
	/* ------------- ............. */
	/* | - | - | X | ............. */

	/* Declare a board, containing X's and O's */
	protected char[] board;
	/* Define the markers for the two players */
	protected char userMarker;
	protected char aiMarker;
	/* Declare a winner */
	protected char winner;
	/* Keep track of who's turn it is */
	protected char currentMarker;

	/* Constructor for the TicTacToe class */
	public TicTacToe(char userMarkerIn, char aiMarkerIn) {
		/* Initialize the markers, and set the winner to undetermined '-' */
		this.userMarker = userMarkerIn;
		this.aiMarker = aiMarkerIn;
		this.winner = '-';
		this.currentMarker = userMarkerIn; /* The user gets to go first */
		this.board = setBoard();
	}

	/* Create and initialize a board */
	public static char[] setBoard() {
		/* Create the board */
		char[] board = new char[9];
		/* Initialize the board with '-' for not played spaces */
		for (int i = 0; i < board.length; i++) {
			board[i] = '-';
		}

		/* Return the new board */
		return board;
	}

	/*
	 * Play a turn in spot, return true if it worked ok, or false if there was a
	 * problem
	 */
	public boolean playTurn(int spot) {
		/* Is the spot valid? */
		boolean isValid = withinRange(spot) && !isSpotTaken(spot);
		/* If it is a valid spot, then make the move */
		if (isValid) {
			/* Mark the spot on the board, with the current Marker */
			board[spot - 1] = currentMarker;
			/* It is the other persons turn */
			currentMarker = (currentMarker == userMarker) ? aiMarker : userMarker;
		}
		/* Return status of playing the turn */
		return isValid;
	}

	/* Check if our spot is in range */
	public boolean withinRange(int spot) {
		/* Return true if this is a valid spot */
		return 0 < spot && spot < board.length + 1;
	}

	/*
	 * Is the spot on the board taken, return true if taken, false if available
	 */
	public boolean isSpotTaken(int spot) {
		/* Return true if the spot is taken, false if it is available */
		return board[spot - 1] != '-';
	}

	/* Print out the board */
	/* Try to create: */
	/* | - | - | - | */
	/* ------------- */
	/* | - | - | - | */
	/* ------------- */
	/* | - | - | - | */
	public void printBoard() {
		System.out.println();
		System.out.println(" -------------");
		/* Loop thru the spots on the board */
		for (int i = 0; i < board.length; i++) {
			/* See if we are at a break in the line */
			if (i % 3 == 0 && i != 0) {
				System.out.println(" |");
				System.out.println(" |-----------|");
			}
			/* Print the next spot on the board */
			System.out.print(" | " + board[i]);
		}
		/* Print a newline at the end */
		System.out.println(" |");
		System.out.println(" -------------");
	}
	
	/* Print out the numbers marking each possible spot for the player to play */
	public static void printIndexBoard() {
		System.out.println();
		System.out.println(" -------------");
		/* Loop thru the spots on the board */
		for (int i = 0; i < 9; i++) {
			/* See if we are at a break in the line */
			if (i % 3 == 0 && i != 0) {
				System.out.println(" |");
				System.out.println(" |-----------|");
			}
			/* Print the number for the next spot on the board */
			System.out.print(" | " + (i+1));
		}
		/* Print a newline at the end */
		System.out.println(" |");
		System.out.println(" -------------");
	}
	
	/* See if there is a winner */
	public boolean isThereAWinner() {
		/* Check the right and left diagonals, and 2nd col and 2nd row */
		boolean diagonalsAndMiddles = (rightDiagonal() ||
									  leftDiagonal() ||
									  middleRow() ||
									  secondColumn()) &&
									  board[4] != '-';
		/* Check the top row, and first column */
		boolean topAndFirst = (topRow() || firstCol()) && board[0] != '-';
		/* Check the bottom row, and third column */
		boolean bottomAndThird = (bottomRow() || thirdColumn()) && board[8] != '-';
		/* If a diagonal or middles, the winner is in the center square (common to all) */
		if (diagonalsAndMiddles) {
			this.winner = board[4];
		/* If top or first, the winner is in the upper left corner */
		} else if (topAndFirst) {
			this.winner = board[0];
		/* If bottom or third, the winner is in the lower right corner */
		} else if (bottomAndThird) {
			this.winner = board[8];
		}
		return diagonalsAndMiddles || topAndFirst || bottomAndThird;
	}

	private boolean topRow() {
		/* Check the top row for matching */
		return board[0] == board[1] && board[1] == board[2];
	}
	

	private boolean middleRow() {
		/* Check the middle row for matching */
		return board[3] == board[4] && board[4] == board[5];
	}
	
	private boolean bottomRow() {
		/* Check the bottom row for matching */
		return board[6] == board[7] && board[7] == board[8];
	}

	private boolean firstCol() {
		/* Check the bottom row for matching */
		return board[0] == board[3] && board[3] == board[6];
	}

	private boolean secondColumn() {
		/* Check the bottom row for matching */
		return board[1] == board[4] && board[4] == board[7];
	}

	private boolean thirdColumn() {
		/* Check the bottom row for matching */
		return board[2] == board[5] && board[5] == board[8];
	}

	private boolean rightDiagonal() {
		/* Check the top row for matching */
		return board[6] == board[4] && board[4] == board[2];
	}
	
	private boolean leftDiagonal() {
		/* Check the top row for matching */
		return board[0] == board[4] && board[4] == board[8];
	}
	
	/* See if the board if filled */
	public boolean isTheBoardFilled() {
		/* Scan the board from beginning to the end */
		for (int i = 0; i < board.length; i++) {
			/* Is this space unclaimed? */
			if (board[i] == '-') {
				/* Empty spot on the board, return false */
				return false;
			}
		}
		/* We checked all the spots, it must be full, return true */
		return true;
	}
	
	/* Is the game over? */
	public String gameOver() {
		/* See if there is a winner */
		boolean didSomeoneWin = isThereAWinner();
		/* Did someone win? */
		if (didSomeoneWin) {
			/* Yes, we have a winner */
			return "We have a winner!  The winner is " + this.winner + "'s";
		/* Is the board filled up? */
		} else if (isTheBoardFilled()) {
			/* Board filled, game over, it's a draw */
			return "Draw: Game Over!";
		} else {
			/* It isn't over yet */
			return "notOver";
		}
	}

}
