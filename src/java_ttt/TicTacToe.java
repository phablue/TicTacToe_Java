package java_ttt;
import java.util.Scanner;

public class TicTacToe {
  public static void main(String[] args) {
    Game game = new Game(new Reader(new Scanner(System.in)), new Writer());
    game.gameStart(); }
}
