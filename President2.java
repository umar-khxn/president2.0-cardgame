package President2;
import java.util.*;
public class President2 {

	public enum Card { // Initialize cards in a deck
		ACE,
		KING,
		QUEEN,
		JACK,
		TEN,
		NINE,
		EIGHT,
		SEVEN,
		SIX,
		FIVE,
		FOUR,
		THREE,
		TWO;
	}
	
	// Create card hands of players
	public static ArrayList<Card> userDeck = new ArrayList<>();
	public static ArrayList<Card> comp1 = new ArrayList<>();
	public static ArrayList<Card> comp2 = new ArrayList<>();
	public static ArrayList<Card> comp3 = new ArrayList<>();
	public static ArrayList<String>justPlayed = new ArrayList<>();
	
	// Counter for passes/resets
	public static int pass = 0;
	public static boolean turnPassed = false;

	public static void main(String[] args) {
		
		Setup.rules(); // Output game rules
		Setup.initializeDecks(); // Create a standard deck of cards and randomly distribute over 4  hands
		
		// Print starting decks
		System.out.println("STARTTING DECKS");
		Setup.printDecks();
		
		System.out.println("\nLET THE GAME BEGIN!");

		// Keep playing until someone plays all their cards
		while (!userDeck.isEmpty() && !comp1.isEmpty() && !comp2.isEmpty() && !comp3.isEmpty()) {
			UserPlay.userTurn();
			if (isAnyDeckEmpty()) break;

			ComputerPlay.compTurn(comp1, "1");
			if (isAnyDeckEmpty()) break;

			ComputerPlay.compTurn(comp2, "2");
			if (isAnyDeckEmpty()) break;

			ComputerPlay.compTurn(comp3, "3");
			if (isAnyDeckEmpty()) break;

			System.out.println();
		}
		
		Setup.win(); // Call win announcement
	}

	
	// Helper method to check if any deck is empty
	private static boolean isAnyDeckEmpty() {
		return userDeck.isEmpty() || comp1.isEmpty() || comp2.isEmpty() || comp3.isEmpty();
	}

}
