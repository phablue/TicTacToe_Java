package java_ttt;

public class Game {
  String winner;
  UI ui;
  GameBoard gameboard;
  GameRules gamerules;
  Writer writer;
  Reader reader;
  Human human;
  Computer computer;

  public Game(Reader reader, Writer writer) {
    this.writer = writer;
    this.reader = reader;
    ui = new UI(reader);
    gameboard = new GameBoard();
    gamerules = new GameRules();
    human = new Human(reader, writer);
    computer = new Computer(writer); }

  public void gameStart() {
    writer.printLineOut(ui.welcomeMsg());
    chooseGameMode();
    if(gamerules.gameWin(gameboard))
      writer.printLineOut(ui.winMessage(winner));
    else 
      writer.printLineOut(ui.tieMsg()); }
  
  public void chooseGameMode() {
    writer.printOut(ui.gameModeChoiceMessage());
    String choiceGameMode = ui.userInput();
    checkAvailable(choiceGameMode); }

  public void checkAvailable(String choiceGameMode) {
    if(chosenSpotIsValid(choiceGameMode))
      winner = gamePlay(choiceGameMode); 
    else {
      writer.printLineOut(ui.gameModeChoiceErrorMessage()); 
      chooseGameMode(); } }

  public String gamePlay(String choiceGameMode) {
    gameboard.showBoard();
    if(choiceGameMode.equals("1"))
      return singleModePlay();
    else
      return multiModePlay(); }

  public String singleModePlay() {
    while(true) {
      String currentPlayer = "X";
      human.chooseSpot(gameboard, currentPlayer);
      gameboard.showBoard();
      if(gamerules.gameOver(gameboard))
        return "Player";
      currentPlayer = changeCurrentPlayer(currentPlayer);
      computer.chooseSpot(gameboard, currentPlayer);
      gameboard.showBoard();
      if(gamerules.gameOver(gameboard))
        return "Computer"; } }

  public String multiModePlay() {
    String currentPlayer = "X";
    while(true) {
      human.chooseSpot(gameboard, currentPlayer);
      gameboard.showBoard();
      if(gamerules.gameOver(gameboard))
        return "Player('" + currentPlayer + "')";
      currentPlayer = changeCurrentPlayer(currentPlayer); } }

  boolean chosenSpotIsValid(String chosenGameMode) {
    return chosenGameMode.equals("1") || chosenGameMode.equals("2"); }

  String changeCurrentPlayer(String currentPlayer) {
    return currentPlayer == "X" ? "O" : "X"; }
}
