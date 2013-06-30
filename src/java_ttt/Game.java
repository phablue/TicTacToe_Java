package java_ttt;

public class Game extends Human{
	boolean gameover;
	String player1 = "X", player2 = "O";
	void welcome_msg() {
		System.out.println("\nWelcome to TicTacToe !!\n\n");
	}
	void win_msg() {
		System.out.println("Congratulations ~ You Win!!");; 	
	}
	void game_play() {
		welcome_msg();
		show_board();
		while (true) {
			choose_spot (player1);
			show_board();
			if (game_win()) break;		
			choose_spot (player2);
			show_board();
			if (game_win()) break; }
		win_msg();
	}
}

