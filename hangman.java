import java.util.Scanner;

/* Final Project: Hangman
 * 
 * Author: Aidan Fernandes
 * Date: 11/16/20
 * Course: Intro to Computer Programming 2
 * 
 * Summary: This program will randomly select a word from the ones I gave it and count the length of each word determining the amount of hidden characters are to be placed and guessed
 * 
 * 
 * Start, create word bank, select a word. count the length of selected word, replace each character with a period (.)
 * User has 7 guesses, if the correct letter is guessed it will go into it's corresponding place in the word (whether the word has that letter once or multiple times)
 * If the user guess the word in under 7 tries, they win, otherwise each incorrect guess will add to the count which is linked to the Hangman graphic
 * 
 */
public class hangman {

	private static String[] words = {"apple", "ability", "able", "about", "above", "back", "bad", "become", "black", "blue", "business", "camera", "capital", "career", "center", "carry", "computer", "contain", };
	private static String word = words[(int) (Math.random() * words.length)];
	private static String hidden = new String(new char[word.length()]).replace("\0", ".");
	private static int count = 0;
	
/*
 * Creating the words
 * letter quantity and characters
 * replace the letter with periods
 * set count to 0, if count = 7 game over
 * 
 * 
 */

	
	//This code will ask the user for input while the count is < 7 and the letter to be chosen has not been selected yet already
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);

		while (count < 7 && hidden.contains(".")) {
			System.out.println("Guess a letter");
			System.out.println(hidden);
			String guess = sc.next();
			hang(guess);
		}
		sc.close();
	}

	//Basically this code will put the letter you chose in the correct spot, even if the letter appears more than once
	//also I learned how to use += here
	public static void hang(String guess) {
		String newhidden = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess.charAt(0)) {
				newhidden += guess.charAt(0);
			} else if (hidden.charAt(i) != '.') {
				newhidden += word.charAt(i);
			} else {
				newhidden += ".";
			}
		}

		if (hidden.equals(newhidden)) {
			count++;
			hangdude();
		} else {
			hidden = newhidden;
		}
		//if the all the guessed letters are in the corresponding position in the word to make, well, the word, you win
		if (hidden.equals(word)) {
			System.out.println("Correct! The word was " + word);
		}
	}
	
	/*
	 * These next few lines gradually create the Hangman each time  
	 *  you guess incorrectly
	 *
	 */
	
	public static void hangdude() {
		if(count == 1) {
			System.out.println("+---+\r\n"
					+ "  |   |\r\n"
					+ "      |\r\n"
					+ "      |\r\n"
					+ "      |\r\n"
					+ "      |\r\n"
					+ "=========");
		}
		if(count == 2) {
			System.out.println(" +---+\r\n"
					+ "  |   |\r\n"
					+ "  O   |\r\n"
					+ "      |\r\n"
					+ "      |\r\n"
					+ "      |\r\n"
					+ "=========");
		}
		if(count == 3) {
			System.out.println(" +---+\r\n"
					+ "  |   |\r\n"
					+ "  O   |\r\n"
					+ "  |   |\r\n"
					+ "      |\r\n"
					+ "      |\r\n"
					+ "=========");
		}
		if(count == 4) {
			System.out.println("+---+\r\n"
					+ "  |   |\r\n"
					+ "  O   |\r\n"
					+ " /|   |\r\n"
					+ "      |\r\n"
					+ "      |\r\n"
					+ "=========");
		}
		if(count == 5) {
			System.out.println("+---+\r\n"
					+ "  |   |\r\n"
					+ "  O   |\r\n"
					+ " /|\\  |\r\n"
					+ "      |\r\n"
					+ "      |\r\n"
					+ "=========");
		}
		if(count == 6) {
			System.out.println(" +---+\r\n"
					+ "  |   |\r\n"
					+ "  O   |\r\n"
					+ " /|\\  |\r\n"
					+ " /    |\r\n"
					+ "      |\r\n"
					+ "=========");
		}
		if(count == 7) {
			System.out.println("Game Over! You Lose!");
			System.out.println(" +---+\r\n"
					+ "  |   |\r\n"
					+ "  O   |\r\n"
					+ " /|\\  |\r\n"
					+ " / \\  |\r\n"
					+ "      |\r\n"
					+ "=========");
			System.out.println("The word was " + word);
		}
	}
}

// The end :)


