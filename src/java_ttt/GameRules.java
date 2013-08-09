package java_ttt;

public class GameRules extends GameBoard {
	boolean win = false;
	
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
			return true;
		else if (board[2] == board[4] && board[4] == board[6])
			return true;
		else 
			return false;
	}
	boolean game_win() {
		return  check_win_rows() || check_win_columns() || check_win_diagonals();
	}
	boolean game_tie() {
		if (available_spots() == 0)
			return true;
		else 
			return false;
	}
	boolean game_over() {
		return game_win() || game_tie();
	}
}

