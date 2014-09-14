package java_ttt;

public class Game {
  GameBoard gameboard;
  GameRules gamerules;
  Writer writer;
  Reader reader;
  Human human;
  Computer computer;

  public Game(Writer writer, Reader reader) {
    this.writer = writer;
    this.reader = reader;
    gameboard = new GameBoard();
    gamerules = new GameRules();
    human = new Human(writer, reader);
    computer = new Computer(writer); }

  public void play() {
    String currentPlayer;
    writer.printLineOut(welcomeMsg());
    gameboard.showBoard();
    while(true) {
      currentPlayer = "X";
      human.chooseSpot(gameboard, currentPlayer);
      gameboard.showBoard();
      if(gamerules.gameOver(gameboard)) break;
      currentPlayer = changeCurrentPlayer(currentPlayer);
      computer.chooseSpot(gameboard, currentPlayer);
      gameboard.showBoard();
      if(gamerules.gameOver(gameboard)) break; }
    if(gamerules.gameWin(gameboard))
      writer.printLineOut(winMessage(winner(currentPlayer)));
    else 
      writer.printLineOut(tieMsg()); }
 
  String changeCurrentPlayer(String currentPlayer) {
    return currentPlayer == "X" ? "O" : "X"; }

  String welcomeMsg() {
    return "Welcome to TicTacToe !!\n"; }

  String winner(String currentPlayer) {
    return currentPlayer == "X" ? "Player" : "Computer"; }
  
  String winMessage(String currentPlayer) {
    return "\nCongratulations," + currentPlayer + " Win!"; }

  String tieMsg() {
    return "\nGame Over. Game is Tie."; }
}
