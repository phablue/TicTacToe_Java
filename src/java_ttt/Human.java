package java_ttt;
import java.util.Arrays;

public class Human {
  Writer writer;
  Reader reader;

  public Human(Writer writer, Reader reader) {
    this.writer = writer;
    this.reader = reader; }

  public void chooseSpot (GameBoard board, String currentPlayer) {
    writer.printOut(chooseMsg(currentPlayer));
    String input = reader.input();
    int choiceSpot = Integer.parseInt(input);
    try {
      if (Arrays.asList(board.spots).contains(input)) {
        board.markChoiceSpot(choiceSpot, currentPlayer); }
      else 
        unavailableSpot(board, currentPlayer); }
    catch (ArrayIndexOutOfBoundsException error) {
      writer.printLineOut(errorMsg());
      chooseSpot (board, currentPlayer); } }

  public String chooseMsg(String currentPlayer) {
    return "\n" + currentPlayer(currentPlayer) + " Enter a number of your choice : "; }

  public String errorMsg() {
    return "\nThat is not an available number. Please choose a different number. :"; }

  public void unavailableSpot(GameBoard board, String currentPlayer) {
    writer.printLineOut(errorMsg());
    chooseSpot (board, currentPlayer); }

  public String currentPlayer(String currentPlayer) {
    return currentPlayer == "X" ? "player1" : "player2"; }
}
