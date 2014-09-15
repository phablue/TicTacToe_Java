package java_ttt;

public class UI {
  Reader reader;

  public UI(Reader reader) {
    this.reader = reader; }

  public String userInput() {
    return reader.input(); }
  
  String choiceSpotMessage(String currentPlayer) {
    return "\n Player('" + currentPlayer + "') Enter a number of your choice : "; }

  String choiceSpoterrorMessage() {
    return "\nThat is not an available spot. Please choose a different spot. :"; }

  String welcomeMsg() {
    return "Welcome to TicTacToe !!\n"; }
  
  String gameModeChoiceMessage() {
    return "Please, Choose game mode ; [Option: 1(Single Player), 2(Two Players) :"; }

  String gameModeChoiceErrorMessage() {
    return "\nThat is not an available option. Please choose in options."; }

  String winMessage(String winner) {
    return "\nCongratulations, " + winner + " Win!"; }

  String tieMsg() {
    return "\nGame Over. Game is Tie."; }
}
