package java_ttt;

public class Game extends Human{
	boolean gameover;
	String player1 = "X", player2 = "O";
	void welcome_msg() {
		System.out.println("\nWelcome to TicTacToe !!");
	}
	void win_msg() {
		System.out.println("Congratulations ~ You Win!!"); 	
	}
	void tie_msg() {
		System.out.println("Game Over. Game is Tie."); 
	}
	void game_play() {
		welcome_msg();
		show_board();
		while (true) {
			choose_spot (player1);
			show_board();
			if (game_over()) break;
			choose_spot (player2);
			show_board();
			if (game_over()) break; }
		if(game_win()) 
			win_msg(); 
		else 
			tie_msg(); 
	}
}

