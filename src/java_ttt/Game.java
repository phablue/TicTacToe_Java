package java_ttt;

public class Game {
  String currentPlayer, player1 = "X", player2 = "O";
  GameBoard gameboard = new GameBoard();
  GameRules gamerules = new GameRules();
  Writer writer = new Writer();
  Reader reader = new Reader();
  Human human = new Human(writer, reader);
  Computer computer = new Computer(writer);

  String currentPlayer(String currentPlayer) {
    return currentPlayer == "X" ? "player" : "Computer"; }

  String welcomeMsg() {
    return "\nWelcome to TicTacToe !!\n"; }

  String winMessage(String currentPlayer) {
    return "\nCongratulations," + currentPlayer + " Win!"; }

  String tieMsg() {
    return "\nGame Over. Game is Tie."; }

  public void gamePlay(GameBoard gameboard) {
    writer.printLineOut(welcomeMsg());
    gameboard.showBoard();
    while(true) {
      currentPlayer = player1;
      human.chooseSpot(gameboard, currentPlayer);
      gameboard.showBoard();
      if(gamerules.gameOver(gameboard)) break;
      currentPlayer = player2;
      computer.chooseSpot(gameboard, currentPlayer);
      gameboard.showBoard();
      if(gamerules.gameOver(gameboard)) break; }
    if(gamerules.gameWin(gameboard))
      writer.printLineOut(winMessage(currentPlayer(currentPlayer)));
    else 
      writer.printLineOut(tieMsg()); }
}
