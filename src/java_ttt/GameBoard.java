package java_ttt;

public class GameBoard {
	String board[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
	int available_spots;
	int spot;
	
	void show_board() {
		System.out.printf("\n------------------\n");
		System.out.printf("|%3s  |%3s  |%3s  |\n", board[0], board[1], board[2]);
		System.out.printf("------------------\n");
		System.out.printf("|%3s  |%3s  |%3s  |\n", board[3], board[4], board[5]);
		System.out.printf("------------------\n");
		System.out.printf("|%3s  |%3s  |%3s  |\n", board[6], board[7], board[8]);
		System.out.printf("------------------\n\n");		
	}	
	int available_spots() {
		available_spots = 0;
		for(spot=0; spot<9; spot++) {
			try {
				if (Integer.parseInt(board[spot]) > 0)
				available_spots += 1; }
			catch(Exception string) { 
				available_spots += 0; } }
		return available_spots;
	}
}
