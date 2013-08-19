package java_ttt;
import java.util.*;

public class GameBoard  {
	String spots[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

	void showBoard() {
		System.out.printf("\n------------------\n");
		System.out.printf("|%3s  |%3s  |%3s  |\n", spots[0], spots[1], spots[2]);
		System.out.printf("------------------\n");
		System.out.printf("|%3s  |%3s  |%3s  |\n", spots[3], spots[4], spots[5]);
		System.out.printf("------------------\n");
		System.out.printf("|%3s  |%3s  |%3s  |\n", spots[6], spots[7], spots[8]);
		System.out.printf("------------------\n\n");		
	}	
	List <String> availableSpots() {
		int spot;
		LinkedList <String> accessible_spots = new LinkedList <String>();
		for (spot=0; spot<9; spot++) {
			if(spots[spot].equals("O") || spots[spot].equals("X"));			
			else 
				accessible_spots.add(spots[spot]); }
		return accessible_spots;
	}	
	void markChoiceSpot(int choice_spot, String current_player) {
		spots[choice_spot-1] = current_player;
	}
}

