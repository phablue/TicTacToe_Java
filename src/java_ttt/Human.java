package java_ttt;
import java.util.Arrays;

public class Human {
  Writer writer;
  Reader reader;

  public Human(Writer writer, Reader reader) {
    this.writer = writer;
    this.reader = reader; }

  public void chooseSpot(GameBoard board, String currentPlayer) {
    writer.printOut(chooseMsg(currentPlayer));
    String input = userInput();
    checkAvailable(board, currentPlayer, input); }

  public void checkAvailable(GameBoard board, String currentPlayer, String input) {
    int choiceSpot = Integer.parseInt(input);
    try {
      if (Arrays.asList(board.spots).contains(input)) {
        board.markChoiceSpot(choiceSpot, currentPlayer); }
      else 
        unavailableSpot(board, currentPlayer); }
    catch (ArrayIndexOutOfBoundsException error) {
      writer.printLineOut(errorMsg());
      chooseSpot (board, currentPlayer); } }

  public void unavailableSpot(GameBoard board, String currentPlayer) {
    writer.printLineOut(errorMsg());
    chooseSpot(board, currentPlayer); }

  public String userInput() {
    return reader.input(); }
  
  String chooseMsg(String currentPlayer) {
    return "\nEnter a number of your choice : "; }

  String errorMsg() {
    return "\nThat is not an available number. Please choose a different number. :"; }
}
