package java_ttt;
import java.util.*;

public class Human {
	void ChooseSpot (GameBoard gameboard, String current_player) {
		chooseMsg(current_player);
		Scanner scan = new Scanner(System.in);
		String input = scan.next(); 
		int choice_spot = Integer.parseInt(input);		
		try {
			if (Arrays.asList(gameboard.spots).contains(input)) {
				gameboard.markChoiceSpot(choice_spot, current_player); }
			else 
				unavailableSpot(gameboard, current_player); }
		catch (ArrayIndexOutOfBoundsException error) {
			System.out.println("Your answer is out of bounds. Please Enter a number in bounds");
			ChooseSpot (gameboard, current_player); }
	}
	void chooseMsg(String current_player) {
		System.out.printf("[ %s ] Enter a number of your choice : ", currentPlayer(current_player));
	}
	void errorMsg() {
		System.out.println("\nThat is not an available number. Please choose a different number. :");
	}
	void unavailableSpot(GameBoard gameboard, String current_player) {
		errorMsg();
		ChooseSpot (gameboard, current_player);
	}
	String currentPlayer(String current_player) {
		if (current_player == "X")
			return "player1";
		else
			return "player2";
	}
}

