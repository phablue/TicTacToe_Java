package java_ttt;
import java.util.*;

public class Human {
  public void chooseSpot (GameBoard board, String currentPlayer) {
    chooseMsg(currentPlayer);
    String input = input();
    int choiceSpot = Integer.parseInt(input);
    try {
      if (Arrays.asList(board.spots).contains(input)) {
        board.markChoiceSpot(choiceSpot, currentPlayer); }
      else 
        unavailableSpot(board, currentPlayer); }
    catch (ArrayIndexOutOfBoundsException error) {
      System.out.println("Your answer is out of bounds. Please Enter a number in bounds");
      chooseSpot (board, currentPlayer); } }

  public void chooseMsg(String currentPlayer) {
    System.out.printf("\n[ %s ] Enter a number of your choice : ", currentPlayer(currentPlayer)); }

  public void errorMsg() {
    System.out.println("\nThat is not an available number. Please choose a different number. :"); }

  public String input() {
    Scanner scan = new Scanner(System.in);
    return scan.next(); }

  public void unavailableSpot(GameBoard board, String currentPlayer) {
    errorMsg();
    chooseSpot (board, currentPlayer); }

  public String currentPlayer(String currentPlayer) {
    return currentPlayer == "X" ? "player1" : "player2"; }
}
