package java_ttt;
import java.util.Scanner;

public class TicTacToe {
  public static void main(String[] args) {
    Game game = new Game(new Writer(), new Reader(new Scanner(System.in)));
    game.play(); }
}
