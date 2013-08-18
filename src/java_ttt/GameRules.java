package java_ttt;

public class GameRules  {
	boolean win = false;
	int spot;
	
	boolean checkRows(GameBoard gameboard) {
		spot = 0;
		while (spot<7) {
			if (gameboard.spots[spot] == gameboard.spots[spot+1] && gameboard.spots[spot] == gameboard.spots[spot+2])
				win = true;
			spot = spot+3; }
		return win;
		} 
	boolean checkColumns(GameBoard gameboard) {
		for (spot=0; spot<3; spot++) {
			if (gameboard.spots[spot] == gameboard.spots[spot+3] && gameboard.spots[spot] == gameboard.spots[spot+6])
				win = true; } 
		return win;
		}
	boolean checkDiagonals(GameBoard gameboard) {
		if (gameboard.spots[0] == gameboard.spots[4] && gameboard.spots[4] == gameboard.spots[8])
			return true;
		else if (gameboard.spots[2] == gameboard.spots[4] && gameboard.spots[4] == gameboard.spots[6])
			return true;
		else 
			return false;
	}
	boolean gameWin(GameBoard gameboard) {
		return  checkRows(gameboard) || checkColumns(gameboard) || checkDiagonals(gameboard);
	}
	boolean gameTie(GameBoard gameboard) {
		if (gameboard.availableSpots().size()==0)
			return true;
		else 
			return false;
	}
	boolean gameOver(GameBoard gameboard) {
		return gameWin(gameboard) || gameTie(gameboard);
	}
}

