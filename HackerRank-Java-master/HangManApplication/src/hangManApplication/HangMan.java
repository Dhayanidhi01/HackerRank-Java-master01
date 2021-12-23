package hangManApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class HangMan {

	/* Declare some properties */
	String mysteryWord; /* The word the user needs to guess */
	StringBuilder currentGuess; /*
								 * Add the guessed characters by building a
								 * string
								 */
	/* Characters guessed */
	ArrayList<Character> previousGuesses = new ArrayList<Character>();
	/* Maximum allowable tries */
	int maxTries = 6;
	/* Current Try */
	int currentTry = 0;
	/* Our dictionary of possible mystery words */
	ArrayList<String> dictionary = new ArrayList<String>();
	/* Access an external file of words */
	private static FileReader fileReader;
	private static BufferedReader bufferedFileReader;

	/* Constructor for Hangman */
	public HangMan() throws IOException {
		/* Read the file */
		initializeStreams();
		/* Pick a mystery word */
		mysteryWord = pickWord();
		/* Initialize the current Guess */
		currentGuess = initializeCurrentGuess();
	}

	/* Read the dictionary file, and load into the dictionary */
	private void initializeStreams() throws IOException {
		try {
			/*
			 * Open the file dictionary.txt, and create a file reader and
			 * buffered file reader
			 */
			File inFile = new File("dictionary.txt");
			fileReader = new FileReader(inFile);
			bufferedFileReader = new BufferedReader(fileReader);

			/* Read the first line of the file */
			String currentLine = bufferedFileReader.readLine();

			/* Loop thru the file, until the end of the file */
			while (currentLine != null) {
				/* Add the current line to the dictionary */
				dictionary.add(currentLine);
				/* Read the next line of the file */
				currentLine = bufferedFileReader.readLine();
			}
			/* Close the file reader and buffered file readers */
			bufferedFileReader.close();
			fileReader.close();
		} catch (IOException exception) {
			System.out.println("Could not read the dictionary");
		}
	}

	/* Return a random word from the dictionary */
	private String pickWord() {
		/* Generate a random number */
		Random rand = new Random();

		/* Find the index of the mystery word randomly in the dictionary */
		int wordIndex = Math.abs(rand.nextInt()) % dictionary.size();
		/* Return the mystery Word */
		return dictionary.get(wordIndex);
	}

	/*
	 * Build a string like: _ A _ _ _ _ _, where each _ is a character to guess.
	 */
	private StringBuilder initializeCurrentGuess() {
		/* Create a StringBuilder instance */
		StringBuilder current = new StringBuilder();
		/* Loop thru 2*length of the mystery word (spaces between characters) */
		for (int i = 0; i < mysteryWord.length() * 2; i++) {
			/* If even index i, add an _ for another character */
			if (i % 2 == 0) {
				current.append("_");
			} else {
				current.append(" ");
			}
		}

		/* Return the current guess string */
		return current;
	}
	
	/* Return the current guess, showing correctly guessed characters in word */
	public String getFormalCurrentGuess() {
		return "Current Guess: " + currentGuess.toString();
	}
	
	/* Return true if the game is over */
	public boolean gameOver() {
		/* Did we win? */
		if (didWeWin()) {
			System.out.println();
			System.out.println("Congrats!  You won!  You guessed the right word!");
			return true;
		} else if (didWeLose()) {
			System.out.println();
			System.out.println("Sorry, you lost.  You spent all of your 6 tries.  "
					+ "The word was " + mysteryWord + ".");
			return true;
		}
		
		return false;
	}
	
	/* Did we lose? */
	public boolean didWeLose() {
		/* Have we had more than 6 tries? */
		return (currentTry >= maxTries);
	}
	
	/* Did we win? */
	public boolean didWeWin() {
		String guess = getCondensedCurrentGuess();
		return guess.equals(mysteryWord);
	}
	
	/* Produce a current guess string with all the spaces removed */
	public String getCondensedCurrentGuess() {
		/* Convert the current Guess StringBuilder to a string */
		String guess = currentGuess.toString();
		/* Remove all of the spaces from the string and return it */
		return guess.replace(" ",  "");
	}
	
	/* Has the character been guessed already */
	public boolean isGuessedAlready(char guess) {
		/* Return true if guess is in the previous guesses array */
		return previousGuesses.contains(guess);
	}
	
	/* Play the guessed character */
	public boolean playGuess(char guess) {
		/* Assume it is not a good guess */
		boolean isItAGoodGuess = false;
		
		/* Loop thru the mysteryWord searching for matching letters */
		for (int i=0; i < mysteryWord.length(); i++) {
			/* See if the ith character of the mysteryWord matches the guess */
			if (mysteryWord.charAt(i) == guess) {
				/* We have a match, update the currentGuess (the *2, is to skip over spaces) */
				currentGuess.setCharAt(i*2,  guess);
				/* It is a good guess */
				isItAGoodGuess = true;
			}
		}
		/* Add the guess to the previous Guesses list */
		previousGuesses.add(guess);
		
		/* If it was not a good guess, increment the try counter */
		if (!isItAGoodGuess) {
			currentTry++;
		}
		
		/* Return true if it was a good guess, false otherwise */
		return isItAGoodGuess;
	}

	/* .- - - - - ... */
	/* | ...... | ... */
	/* | ...... 0 ... */
	/* | .... / | \ . */
	/* | ...... | ... */
	/* | ..... / \... */
	/* | ............ */
	/* | ............ */
	/* Draw a picture of the hanged man */
	public String drawPicture() {
		/* Call different functions depending upon the try number */
		switch (currentTry) {
		case 0:
			return noPersonDraw();
		case 1:
			return addHeadDraw();
		case 2:
			return addBodyDraw();
		case 3:
			return addOneArmDraw();
		case 4:
			return addSecondArmDraw();
		case 5:
			return addLegDraw();
		default:
			return fullPersonDraw();
		}

	}

	private String noPersonDraw() {
		return 
				" - - - - -    \n" +
				"|        |    \n" +
				"|             \n" +
				"|             \n" +
				"|             \n" +
				"|             \n" +
				"|             \n" +
				"|             \n";
	}

	private String addHeadDraw() {
		return 
				" - - - - -    \n" +
				"|        |    \n" +
				"|        0    \n" +
				"|             \n" +
				"|             \n" +
				"|             \n" +
				"|             \n" +
				"|             \n";
	}

	private String addBodyDraw() {
		return 
				" - - - - -    \n" +
				"|        |    \n" +
				"|        0    \n" +
				"|        |    \n" +
				"|        |    \n" +
				"|             \n" +
				"|             \n" +
				"|             \n";
	}

	private String addOneArmDraw() {
		return 
				" - - - - -    \n" +
				"|        |    \n" +
				"|        0    \n" +
				"|      / |    \n" +
				"|        |   \n" +
				"|             \n" +
				"|             \n" +
				"|             \n";
	}

	private String addSecondArmDraw() {
		return 
				" - - - - -    \n" +
				"|        |    \n" +
				"|        0    \n" +
				"|      / | \\ \n" +
				"|        |    \n" +
				"|             \n" +
				"|             \n" +
				"|             \n";
	}

	private String addLegDraw() {
		return 
				" - - - - -    \n" +
				"|        |    \n" +
				"|        0    \n" +
				"|      / | \\ \n" +
				"|        |    \n" +
				"|       /     \n" +
				"|             \n" +
				"|             \n";
	}

	private String fullPersonDraw() {
		return 
			" - - - - -    \n" +
			"|        |    \n" +
			"|        0    \n" +
			"|      / | \\ \n" +
			"|        |    \n" +
			"|       / \\  \n" +
			"|             \n" +
			"|             \n";
	}


}
