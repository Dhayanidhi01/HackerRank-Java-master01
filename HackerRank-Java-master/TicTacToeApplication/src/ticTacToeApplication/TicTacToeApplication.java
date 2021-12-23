package ticTacToeApplication;

import java.util.Scanner;

public class TicTacToeApplication {

	public static void main(String[] args) {
		/* Instantiate a Scanner to read standard input */
		Scanner stdIn = new Scanner(System.in);

		/* Assume we want to play forever */
		boolean doYouWantToPlay = true;
		
		/* Loop until we don't want to play */
		while (doYouWantToPlay) {
			/* Explain how to play the game */
			System.out.println("Welcome to Tic Tac Toe! You are about to go against " +
					"the master of Tic Tac Toe.  Are you ready?  I hope so!\n BUT FIRST, you" +
					" must pick what character you want to be and which character I will be");
			System.out.println();
			/* Enter your marker for the game */
			System.out.println("Enter a single character that will represent you on the board (X/O)");
			char playerToken = stdIn.next().charAt(0);
			/* Enter your opponents marker */
			System.out.println("Enter a single character that will represent your opponent on the board(X/O)");
			char opponentToken = stdIn.next().charAt(0);
			
			/* Create a new game */
			TicTacToe game = new TicTacToe(playerToken, opponentToken);
			
			/* Create a new AI character */
			AI ai = new AI();
			
			/* Print the index board */
			System.out.println();
			System.out.println("Now we can start the game.  To play, enter a number and your token shall be put " +
						"in its place.\nThe numbers go from 1-9, left to right. We shall see who will win this round.");
			TicTacToe.printIndexBoard();
			System.out.println();
			
			/* Let's play */
			/* Loop until the game is over */
			while(game.gameOver().equals("notOver")) {
				/* Is it the users turn? */
				if (game.currentMarker == game.userMarker) {
					/* User turn */
					System.out.println("It's your turn!  Enter a spot for your token");
					int spot = stdIn.nextInt();
					/* While the spot is invalid */
					while(!game.playTurn(spot)) {
						System.out.println("Try again. " + spot + " is invalid.  This spot is already taken" +
								" or it is out of range");
						/* Get another spot */
						spot = stdIn.nextInt();
					}
					System.out.println("You picked " + spot + "!");
				} else {
					System.out.println("It's my turn!");
					/* AI takes a turn */
					int aiSpot = ai.pickSpot(game);
					/* Play the spot */
					game.playTurn(aiSpot);
					System.out.println("I picked " + aiSpot + "!");
				}
				/* Print out the game board */
				System.out.println("The game board now looks like");
				game.printBoard();
			}
			/* Print out the results of the game */
			System.out.println(game.gameOver());
			System.out.println();
			/* Setup another game? */
			System.out.println("Do you want to play again?  Enter Y if you do."
					+ " Enter anything else if you are tired of me.");
			/* Read the user response */
			char response = stdIn.next().charAt(0);
			/* Play again if the user responds Y */
			doYouWantToPlay = (response == 'Y');
			System.out.println();
			System.out.println();
		}
	}

}
