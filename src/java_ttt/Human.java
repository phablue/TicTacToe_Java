package java_ttt;
import java.util.Scanner;

public class Human extends GameRules{
	void choose_spot (String current_player) {
		choose_msg(current_player);
		
		Scanner scan = new Scanner(System.in);
		String input = scan.next(); 
		int choice_spot = Integer.parseInt(input);
			
		try {
			if (input.equals(board[choice_spot-1])) {
				board[choice_spot-1] = current_player; }
			else {
				error_msg();
				choose_spot (current_player); } }
		catch (ArrayIndexOutOfBoundsException except) {
			System.out.printf("Your answer is out of bounds. Please Enter a number in bounds : "); } 
	}
	void choose_msg(String current_player) {
		System.out.printf("[ %s ] Enter a number of your choice : ", current_player(current_player));
	}
	void error_msg() {
		System.out.println("\nThat is not an available number. Please choose a different number.");
	}
	String current_player(String current_player) {
		if (current_player == "X")
			return "player1";
		else
			return "player2";
	}
}

