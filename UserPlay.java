package President2;

import java.util.Collections;
import java.util.Scanner;


public class UserPlay extends President2 {
	
	static boolean setBool=false;

	public static void userTurn() {
		/* Purpose: User plays a round in the game
		 * Parameters: N/A
		 * Return: N/A
		 */
		
		// If the user is starting the round
		if(justPlayed.isEmpty()==true) {
			System.out.println("\nThe table is clear. You may play anything.");
		}
		
		// Ask the user for what card they wish to play, or if they wish to pass
		System.out.println("\nUSER'S TURN");
		System.out.println("User's Cards: "+userDeck);
		Scanner input = new Scanner(System.in);  // Create a Scanner object
		System.out.print("Enter a card to play (Enter 0 to pass): ");
		String play = input.nextLine();
		boolean verCard=false;
		String convCard="";

		if(!(play.equals("0"))) {
			
			// If the user is starting the round
			if(justPlayed.isEmpty()==true) {
				
				// Verify the card they entered
				while(verCard!=true) {
					if(play.matches("[2-9]|10|[JQKA]")) {
						convCard = Setup.convertCardValue(play);
						Card card = Card.valueOf(convCard);
						if(Collections.frequency(userDeck,card)!=0) {
							verCard=true;
						}
					}
					if(verCard==false){
						System.out.print("Invalid input! Enter a card again (Enter 0 to pass): ");
						play = input.nextLine();
						if(play.equals("0")) {
							break;
						}
					}

				}
				if(verCard==true) {
					System.out.print("How many cards would you like to play: ");
					int amount = input.nextInt();
					while(amount>Collections.frequency(userDeck,Card.valueOf(convCard)) || amount==0) {
						System.out.print("You don't have that many cards! Try again: ");
						amount = input.nextInt();
					}

					justPlayed.add(Card.valueOf(convCard).toString());
					justPlayed.add(Integer.toString(amount));
					for(int i=0;i<amount;i++) {
						userDeck.remove(Card.valueOf(convCard));
					}
					turnPassed=false;

				}
				setBool=true;

			}

			// If the user is not starting the round
			else if(justPlayed.isEmpty()==false) {
				int set=Integer.parseInt(justPlayed.get(1));
				String curCard = justPlayed.get(0);
				
				// Verify the card they entered
				while(verCard!=true) {
					if(play.matches("[2-9]|10|[JQKA]")) {
						convCard = Setup.convertCardValue(play);
						Card card = Card.valueOf(convCard);
						if(Card.valueOf(curCard).compareTo(card)>=0 && Collections.frequency(userDeck,card)>=set) {
							verCard=true;
						}
					}
					if(verCard==false){
						System.out.print("Invalid input! Enter a card again (Enter 0 to pass): ");
						play = input.nextLine();
						if(play.equals("0")) {
							break;
						}
					}

				}
				if(verCard==true) {
					justPlayed.clear();
					justPlayed.add(Card.valueOf(convCard).toString());
					justPlayed.add(Integer.toString(set));
					for(int i=0;i<set;i++) {
						userDeck.remove(Card.valueOf(convCard));
					}
					turnPassed=false;

				}
			}
			pass=0;
		}
		
		// If the user decides to pass instead
		if(play.equals("0")) {
			turnPassed=true;
			pass++;
			checkPasses();
		}
		
		// Output what the user played or if they chose to pass
		if (!turnPassed) {
		    int cardCount = Integer.parseInt(justPlayed.get(1));
		    String timesString = cardCount == 1 ? "time" : "times";
		    System.out.println("The User played the " + justPlayed.get(0) + " card " + cardCount + " " + timesString);
		} else {
		    System.out.println("The User is passing");
		}
		
		// Output set if the user started the round
		if (setBool==true){
			System.out.println("\nTHE SET FOR THIS ROUND IS: "+justPlayed.get(1));
			setBool=false;
		}

		
	}
	
	
	public static void checkPasses() {
		/* Purpose: Reset if 3 players in a row pass
		 * Parameters: N/A
		 * Return: N/A
		 */
		if(pass==3) {
			justPlayed.clear();
		}
	}
	
}

