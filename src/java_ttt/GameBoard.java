package java_ttt;

public class GameBoard {
	String board[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
	
	void show_board() {
		System.out.printf("------------------\n");
		System.out.printf("|%3s  |%3s  |%3s  |\n", board[0], board[1], board[2]);
		System.out.printf("------------------\n");
		System.out.printf("|%3s  |%3s  |%3s  |\n", board[3], board[4], board[5]);
		System.out.printf("------------------\n");
		System.out.printf("|%3s  |%3s  |%3s  |\n", board[6], board[7], board[8]);
		System.out.printf("------------------\n");		
	}
}
