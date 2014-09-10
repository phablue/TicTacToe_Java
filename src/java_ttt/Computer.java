package java_ttt;

public class Computer extends GameRules {
  public void chooseSpot(GameBoard board, String currentPlayer) {
    int startlevel = 0;
    System.out.println ("\nPlease wait to computer play..\n");
    int choice = (int)computerPlay(board, currentPlayer, startlevel)[1];
    board.markChoiceSpot(choice, currentPlayer); }

  public double[] computerPlay(GameBoard board, String currentPlayer, int level) {
    double minimax[] = new double[2];
    double point = -1, bestPoint = -1;
    String bestSpot = "";
    if (gameOver(board)) {
      minimax[0] = getPoint(board, level);
      return minimax; }
    else {
      for (String spot : board.availableSpots()) {
        int choiceSpot = Integer.parseInt(spot);
        board.markChoiceSpot(choiceSpot, currentPlayer);
        level++;
        point = -(computerPlay(board, changePlayer(currentPlayer), level)[0]);
        board.markChoiceSpot(choiceSpot, spot);
        if (point > bestPoint) {
          bestPoint = point;
          minimax[0] = bestPoint;
          bestSpot = spot;
          double best_choice = Double.parseDouble(bestSpot);
          minimax[1] = best_choice; } } }
    return minimax; }

  public double getPoint(GameBoard board, int level) {
    return gameWin(board) ? 1.0 / -level : 0.0; }

  public String changePlayer(String currentPlayer) {
    return (currentPlayer == "X") ? "O" : "X"; }
}
