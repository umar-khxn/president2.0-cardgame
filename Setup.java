package President2;

import java.util.ArrayList;
import java.util.Collections;


public class Setup extends President2{

	public static void rules() {
		/* Purpose: Output the rules of the game
		 * Parameters: N/A
		 * Return: N/A
		 */
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ WELCOME TO PRESIDENT ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("1. The user will begin by placing one card, or a set which is two or more cards of the same rank. For example, 2 Kings, or 3 7’s.\r\n"
				+ "2. Any player after that can either play or pass. \r\n"
				+ "\t- If they choose to play, they must match the quantity of the cards and the rank of the card(s) must be equal to or greater \n\t  than the rank of the previously played card. \r\n"
				+ "\t- The card hierarchy is as follows: 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A\r\n"
				+ "\t- A player cannot play a card that is less than the card previously played or a set that has more or less cards than the \n\t  number of cards in the current set. If they cannot do this, they are forced to pass.\r\n"
				+ "3. A player may choose to pass one round and play on another round. However if 3 players consecutively pass their turn and it returns \n   to the player that just played a card, the card pile is “flushed” or removed, and this player will play the new starting card and set.\r\n"
				+ "4. This process repeats until one player is able to discard all the cards in their hand. They are now the President or the winner!\r\n"
				+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
	}


	public static void initializeDecks() {
		/* Purpose: Initialize the 4 hands by creating a standard deck of cards and distributing it to each player
		 * Parameters: N/A
		 * Return: N/A
		 */
		ArrayList<Card> deck = new ArrayList<>();
		
		// Add 4 of each card to the deck
		for(int j=0;j<4;j++) {
			for(int i=0; i<13; i++) {
				deck.add(Card.values()[i]);
			}
		}
		Collections.shuffle(deck);
		
		// Distribute 13 cards to each player
		for(int i=0;i<13;i++) {
			userDeck.add(deck.get(0));
			deck.remove(deck.get(0));
		}
		for(int i=0;i<13;i++) {
			comp1.add(deck.get(0));
			deck.remove(deck.get(0));
		}
		for(int i=0;i<13;i++) {
			comp2.add(deck.get(0));
			deck.remove(deck.get(0));
		}
		for(int i=0;i<13;i++) {
			comp3.add(deck.get(0));
			deck.remove(deck.get(0));
		}
		
		// Sort and order the hands
		Collections.sort(userDeck);
		Collections.sort(comp1);
		Collections.sort(comp2);
		Collections.sort(comp3);

		Collections.reverse(userDeck);
		Collections.reverse(comp1);
		Collections.reverse(comp2);
		Collections.reverse(comp3);
	}


	public static void printDecks() {
		/* Purpose: Print the decks of each player
		 * Parameters: N/A
		 * Return: N/A
		 */
		System.out.println("User's Cards: "+userDeck);
		System.out.println("Computer 1's Cards: "+comp1);
		System.out.println("Computer 2's Cards: "+comp2);
		System.out.println("Computer 3's Cards: "+comp3);

	}


	public static String convertCardValue(String cardValue) {
		/* Purpose: Initialize the 4 hands by creating a standard deck of cards and distributing it to each player
		 * Parameters: String cardValue - String of what integer the user entered
		 * Return: String equivalent of each entered card value
		 */
		switch (cardValue) {
		case "2":
			return "TWO";
		case "3":
			return "THREE";
		case "4":
			return "FOUR";
		case "5":
			return "FIVE";
		case "6":
			return "SIX";
		case "7":
			return "SEVEN";
		case "8":
			return "EIGHT";
		case "9":
			return "NINE";
		case "10":
			return "TEN";
		case "J":
			return "JACK";
		case "Q":
			return "QUEEN";
		case "K":
			return "KING";
		case "A":
			return "ACE";
		default:
			return "Invalid card value";
		}
	}


	public static void win() {
		/* Purpose: Announce game winner if their deck is empty
		 * Parameters: N/A
		 * Return: N/A
		 */
		System.out.println();
		if(userDeck.isEmpty()) {
			System.out.println("The User is the President! YOU WON!");
		}
		else if(comp1.isEmpty()) {
			System.out.println("Computer 1 is the President!");
		}
		else if(comp2.isEmpty()) {
			System.out.println("Computer 2 is the President!");
		}
		else if(comp3.isEmpty()) {
			System.out.println("Computer 3 is the President!");
		}
	}

}
