package java_ttt;

public class Computer extends GameRules  {
	public void ChooseSpot(GameBoard gameboard, String current_player) {	
		int startlevel = 0;
		System.out.println ("Please wait to computer play..");
		int choice = (int)computerPlay(gameboard, current_player, startlevel)[1];
		gameboard.markChoiceSpot(choice, current_player);
	}
	public double[] computerPlay(GameBoard gameboard, String current_player, int level) {
		double minimax[] = new double[2];
		double point = -1, best_point = -1;
		String best_spot = "";
		if (gameOver(gameboard)) {
			minimax[0] = getPoint(gameboard, level);
			return minimax; }
		else {
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
					minimax[1] = best_choice; } } }
		return minimax;		
	}
	public double getPoint(GameBoard gameboard, int level) {
		if (gameWin(gameboard)) 
			return 1.0 / -level;
		else 
			return 0.0;	
	}
	public String changePlayer(String current_player) {
		return (current_player == "X") ? "O" : "X";
	}
}
