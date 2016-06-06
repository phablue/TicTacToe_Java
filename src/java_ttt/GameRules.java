package java_ttt;
import java.util.Arrays;

public class GameRules {
  public boolean gameOver(GameBoard board) {
    return gameWin(board) || gameTie(board); }

  public boolean gameWin(GameBoard board) {
    return winRequirementForRow(board) || winRequirementForColumn(board) || winRequirementForDiagonal(board); }

  public boolean gameTie(GameBoard board) {
    if(board.availableSpots().size() == 0)
      return true;
    else 
      return false; }

  public boolean winRequirementForRow(GameBoard board) {
    for(int i = 0; i < 9; i += 3)
      if(checkForWin(Arrays.copyOfRange(board.spots, i, i +3 )))
        return true;
    return false; }

  public boolean winRequirementForColumn(GameBoard board) {
    for(int i = 0; i < 3; i++) {
      String[] columnSpots = {board.spots[i], board.spots[i + 3], board.spots[i + 6]};
      if(checkForWin(columnSpots))
        return true; }
    return false; }
  
  public boolean winRequirementForDiagonal(GameBoard board) {
    String[][] diagonalSpots = {{board.spots[0], board.spots[4], board.spots[8]},
                                {board.spots[2], board.spots[4], board.spots[6]}};
    
    if(checkForWin(diagonalSpots[0]))
      return true;
    else if(checkForWin(diagonalSpots[1]))
      return true;
    else
      return false; }

  private boolean checkForWin(String[] spots) {
    return Arrays.toString(spots).equals("[X, X, X]") || Arrays.toString(spots).equals("[O, O, O]"); }
}
