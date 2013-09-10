package java_ttt;

public class Game {
	String current_player, player1 = "X", player2 = "O";
	GameBoard gameboard = new GameBoard();
	Computer computer = new Computer();
	Human human = new Human();
	GameRules gamerules = new GameRules();

	String currentPlayer(String current_player) {
		if (current_player == "X")
			return "player1";
		else
			return "Computer";
	}
	void welcomeMsg() {
		System.out.println("\nWelcome to TicTacToe !!");
	}
	void winMsg(String current_player) {
		if (currentPlayer(current_player)=="player1")
			System.out.println("Congratulations ~ Player Win!!"); 	
		else
			System.out.println("Sorry~ Computer Win.."); 	
	}
	void tieMsg() {
		System.out.println("Game Over. Game is Tie."); 
	}
	public void gamePlay(GameBoard gameboard) {
		welcomeMsg();
		gameboard.showBoard();	
		while (true) {
			current_player = player1;
			human.chooseSpot(gameboard, current_player);
			gameboard.showBoard();
			if (gamerules.gameOver(gameboard)) break;
			current_player = player2;
			computer.chooseSpot(gameboard, current_player);
			gameboard.showBoard();
			if (gamerules.gameOver(gameboard)) break; }
		if(gamerules.gameWin(gameboard)) 
			winMsg(current_player); 
		else 
			tieMsg(); 
	}
}

