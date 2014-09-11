package javatest_ttt;

import org.junit.*;
import java_ttt.*;

public class HumanTest {
  public Human test;
  public GameBoard gameboard;
  
  @Before
  public void initilize() {
    test = new Human(new Writer(), new Reader());
    gameboard = new GameBoard();
  }
  @Test
  public void testCurrentPlayer() {
    String player;
    
    player = test.currentPlayer("X");
    Assert.assertSame("Returns player1 if current player X", player, "player1");

    player = test.currentPlayer("O");
    Assert.assertSame("Returns player2 if current player O", player, "player2");
  }
}
