package java_ttt;

public class GameRules extends GameBoard {
	boolean win;
	int spot;
	
	boolean check_win_rows() {
		spot = 0;
		while (spot<7) {
			if (board[spot] == board[spot+1] && board[spot] == board[spot+2])
				win = true;
			spot = spot+3; }
		return win;
		} 
	boolean check_win_columns() {
		for (spot=0; spot<3; spot++) {
			if (board[spot] == board[spot+3] && board[spot] == board[spot+6])
				win = true; } 
		return win;
		}
	boolean check_win_diagonals() {
		if (board[0] == board[4] && board[4] == board[8])
			win = true;
		if (board[2] == board[4] && board[4] == board[6])
			win = true;
		return win;
	}
	boolean game_win() {
		if (check_win_rows() || check_win_columns() || check_win_diagonals())
			win = true;
		return win;
	}
}

