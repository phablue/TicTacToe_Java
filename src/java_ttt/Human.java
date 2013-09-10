package java_ttt;
import java.util.*;

public class Human {
	public void chooseSpot (GameBoard gameboard, String current_player) {
		chooseMsg(current_player);
		String input = input();
		int choice_spot = Integer.parseInt(input);		
		try {
			if (Arrays.asList(gameboard.spots).contains(input)) {
				gameboard.markChoiceSpot(choice_spot, current_player); }
			else 
				unavailableSpot(gameboard, current_player); }
		catch (ArrayIndexOutOfBoundsException error) {
			System.out.println("Your answer is out of bounds. Please Enter a number in bounds");
			chooseSpot (gameboard, current_player); }
	}
	public void chooseMsg(String current_player) {
		System.out.printf("[ %s ] Enter a number of your choice : ", currentPlayer(current_player));
	}
	public void errorMsg() {
		System.out.println("\nThat is not an available number. Please choose a different number. :");
	}
	public String input() {
		Scanner scan = new Scanner(System.in);
		return scan.next(); 
	}
	public void unavailableSpot(GameBoard gameboard, String current_player) {
		errorMsg();
		chooseSpot (gameboard, current_player);
	}
	public String currentPlayer(String current_player) {
		if (current_player == "X")
			return "player1";
		else
			return "player2";
	}
}

