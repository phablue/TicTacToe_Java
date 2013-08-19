package java_ttt;

public class GameRules {
	boolean win;
	int spot;
	
	boolean checkRows(GameBoard gameboard) {
		for (spot=0; spot<7; spot+=3) {
			if (gameboard.spots[spot].equals(gameboard.spots[spot+1]) && gameboard.spots[spot].equals(gameboard.spots[spot+2])) { 
				win = true; 
				break;}
			else
				win = false;}
		return win;
	} 
	boolean checkColumns(GameBoard gameboard) {
		for (spot=0; spot<3; spot++) {
			if (gameboard.spots[spot].equals(gameboard.spots[spot+3]) && gameboard.spots[spot].equals(gameboard.spots[spot+6])) {
				win = true;
				break;}
			else 
				win = false;}
		return win;
	}
	boolean checkDiagonals(GameBoard gameboard) {
		if (gameboard.spots[0].equals(gameboard.spots[4]) && gameboard.spots[0].equals(gameboard.spots[8]))
			return true;
		else if (gameboard.spots[2].equals(gameboard.spots[4]) && gameboard.spots[2].equals(gameboard.spots[6]))
			return true;
		else 
			return false;
	}
	boolean gameWin(GameBoard gameboard) {
		return checkRows(gameboard) || checkColumns(gameboard) || checkDiagonals(gameboard);
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

