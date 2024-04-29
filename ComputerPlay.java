package President2;

import java.util.ArrayList;
import java.util.Collections;


public class ComputerPlay extends President2 {
	
	static boolean setBool=false;

	public static void compTurn(ArrayList<Card> comp, String compNum) {
		/* Purpose: To simulate a computer playing a card/set using game logic based on constraints
		 * Parameters: 
		 * 		- ArrayList<Card> comp: card hand of the computer
		 * 		- compNum: number of computer that is playing 
		 * Return: N/A
		 */
		
		// If computer is starting the round
		if(justPlayed.isEmpty()==true) {

			System.out.println("\nThe table is clear. Computer may play anything.");
			
			System.out.println("\nCOMPUTER "+compNum+" TURN");
			System.out.println("Computer "+compNum+" Cards: "+comp);
			
			// Play the lowest card in the computer's hand with the highest amount
			Card lowestCard=comp.get(0);
			int amount=Collections.frequency(comp, lowestCard);
			justPlayed.add(lowestCard.toString());
			justPlayed.add(Integer.toString(amount));
			turnPassed=false;

			for(int i=0;i<amount;i++) {
				comp.remove(lowestCard);
			}
			turnPassed=false;
			pass=0;
			
			setBool=true;
		}

		// If computer is not playing first
		else if(justPlayed.isEmpty()==false) {
			
			System.out.println("\nCOMPUTER "+compNum+" TURN");
			System.out.println("Computer "+compNum+" Cards: "+comp);
			
			// Find the lowest possible card to play with the right set amount
			String curCard = justPlayed.get(0);
			int set =Integer.parseInt(justPlayed.get(1));
			Card compCard = null;
			
			// Compare until a valid card is found
			for(int i=0; i<comp.size(); i++) {
				if(Card.valueOf(curCard).compareTo(comp.get(i))>=0) {
					if(Collections.frequency(comp, comp.get(i))>=set) {
						compCard=comp.get(i);
						justPlayed.clear();
						break;
					}
				}
			}
			
			// Add what the computer played to justPlayed list
			if(justPlayed.isEmpty()==true) {
				justPlayed.add(compCard.toString());
				justPlayed.add(Integer.toString(set));
				for(int i=0;i<set;i++) {
					comp.remove(compCard);
				}
				turnPassed=false;
				pass=0;
			}
			
			// If the computer couldn't play, it passes so add to pass count
			else {
				turnPassed=true;
				pass++;
				checkPasses();
			}

		}
		// Output what the computer just played or if it passed
		if (!turnPassed) {
		    int cardCount = Integer.parseInt(justPlayed.get(1));
		    String timesString = cardCount == 1 ? "time" : "times";
		    System.out.println("Computer "+compNum+" played the " + justPlayed.get(0) + " card " + cardCount + " " + timesString);
		} else {
		    System.out.println("Computer "+compNum+" is passing");
		}
		
		// Output the round's current set if necessary
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
