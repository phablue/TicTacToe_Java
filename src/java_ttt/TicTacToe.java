package java_ttt;

public class TicTacToe {
	public static void main(String[] args) {	
		Game game = new Game();
		GameBoard gameboard = new GameBoard();
		game.gamePlay(gameboard);
	}
}
