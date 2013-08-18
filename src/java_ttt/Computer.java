package java_ttt;

public class Computer extends GameRules  {
	void ChooseSpot(GameBoard gameboard, String current_player) {	
		int startlevel = 0;
		System.out.println ("Please wait to computer play..");
		int choice = (int)computerPlay(gameboard, current_player, startlevel)[1];
		gameboard.markChoiceSpot(choice, current_player);
	}
	double[] computerPlay(GameBoard gameboard, String current_player, int level) {
		double minimax[] = new double[2];
		double point = -1, best_point = -1;
		String best_spot = "";
		level = level;
		if (gameOver(gameboard)) {
			minimax[0] = getPoint(gameboard, current_player, level);
			return minimax; }
		for (String spot : gameboard.availableSpots()) {
			int choice_spot = Integer.parseInt(spot);
			gameboard.markChoiceSpot(choice_spot, current_player);
			level++;
			point = -(computerPlay(gameboard, changePlayer(current_player), level)[0]);
			gameboard.markChoiceSpot(choice_spot, spot);
			if (point > best_point) {
				best_point = point;
				minimax[0] = best_point;
				best_spot = spot; 
				double best_choice = Double.parseDouble(best_spot);
				minimax[1] = best_choice;} }
		return minimax;				
	}
	double getPoint(GameBoard gameboard, String current_player, int level) {
		if (gameWin(gameboard)) 
			return 1.0 / -level;
		else 
			return 0.0;	
	}
	String changePlayer(String current_player) {
		return (current_player == "X") ? "O" : "X";
	}
}
