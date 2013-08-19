package java_ttt;

public class Game {
	String player1 = "X", player2 = "O";
	GameBoard gameboard = new GameBoard();
	Computer computer = new Computer();
	Human human = new Human();
	GameRules gamerules = new GameRules();

	void welcomeMsg() {
		System.out.println("\nWelcome to TicTacToe !!");
	}
	void winMsg() {
		System.out.println("Congratulations ~ Win!!"); 	
	}
	void tieMsg() {
		System.out.println("Game Over. Game is Tie."); 
	}
	public void gamePlay(GameBoard gameboard) {
		welcomeMsg();
		gameboard.showBoard();	
		while (true) {
			human.ChooseSpot(gameboard, player1);
			gameboard.showBoard();
			if (gamerules.gameOver(gameboard)) break;
			computer.ChooseSpot(gameboard, player2);
			gameboard.showBoard();
			if (gamerules.gameOver(gameboard)) break; }
		if(gamerules.gameWin(gameboard)) 
			winMsg(); 
		else 
			tieMsg(); 
	}
}

