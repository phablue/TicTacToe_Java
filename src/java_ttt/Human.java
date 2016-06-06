package java_ttt;
import java.util.Arrays;

public class Human {
  private Writer writer;
  private UI ui;

  public Human(Reader reader, Writer writer) {
    ui = new UI(reader);
    this.writer = writer; }

  public void chooseSpot(GameBoard board, String currentPlayer) {
    writer.printOut(ui.choiceSpotMessage(currentPlayer));
    String input = ui.userInput();
    checkAvailable(board, currentPlayer, input); }

  public void checkAvailable(GameBoard board, String currentPlayer, String input) {
    int choiceSpot = Integer.parseInt(input);
    try {
      if (Arrays.asList(board.spots).contains(input)) {
        board.markChoiceSpot(choiceSpot, currentPlayer); }
      else 
        unavailableSpot(board, currentPlayer); }
    catch (ArrayIndexOutOfBoundsException error) {
      writer.printLineOut(ui.choiceSpoterrorMessage());
      chooseSpot (board, currentPlayer); } }

  public void unavailableSpot(GameBoard board, String currentPlayer) {
    writer.printLineOut(ui.choiceSpoterrorMessage());
    chooseSpot(board, currentPlayer); }
}
