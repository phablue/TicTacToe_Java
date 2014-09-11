package javatest_ttt;

import org.junit.*;
import java_ttt.*;

public class ComputerTest {
  public Computer test;
  public GameBoard gameboard;
  
  @Before
  public void initilize() {
    test = new Computer(new Writer());
    gameboard = new GameBoard();
  }
  @Test
  public void testChagePlayer() {
    String current_player = "O";
    Assert.assertSame("Return X if current player is O ", test.changePlayer(current_player), "X");
    current_player = "X";
    Assert.assertSame("Return O if current player is X ", test.changePlayer(current_player), "O");
  }
  @Test
  public void testGetPoint() {
    int level = 5;
    double point;
    
    gameboard.spots = new String[] {"X", "2", "3",
                                    "4", "X", "X",
                                    "O", "O", "O"};
    point = test.getPoint(gameboard, level);
    Assert.assertEquals("Return any value if any player win",point, 1.0 / -level, 0.0);

    gameboard.spots = new String[] {"X", "2", "3",
                                    "4", "X", "6",
                                    "O", "O", "X"};
    point = test.getPoint(gameboard, level);
    Assert.assertEquals("Return any value if any player win",point, 1.0 / -level, 0.0);
    
    gameboard.spots = new String[] {"X", "2", "3",
                                    "4", "X", "X",
                                    "O", "O", "9"};
    point = test.getPoint(gameboard, level);
    Assert.assertEquals("Return 0 if nobody win",point, 0.0, 0.0);
  }
  @Test
  public void testComputerPlay() {
    int level = 0;
    int choice;
    
    gameboard.spots = new String[] {"X", "2", "3",
                                    "4", "X", "X",
                                    "O", "O", "9"};
    test.computerPlay(gameboard, "O", level);
    choice = (int)test.computerPlay(gameboard, "O", level)[1];
    Assert.assertSame("chooses easy win in a row", choice, 9);
    
    gameboard.spots = new String[] {"O", "2", "3",
                                    "4", "X", "6",
                                    "O", "X", "X"};
    test.computerPlay(gameboard, "O", level);
    choice = (int)test.computerPlay(gameboard, "O", level)[1];
    Assert.assertSame("chooses easy win in a column", choice, 4);
    
    gameboard.spots = new String[] {"X", "X", "O",
                                    "4", "O", "6",
                                    "7", "8", "X"};
    choice = (int)test.computerPlay(gameboard, "O", level)[1];
    Assert.assertSame("chooses easy win in a diagonal", choice, 7);
    
    gameboard.spots = new String[] {"X", "O", "3",
                                    "O", "5", "6",
                                    "X", "8", "X"};
    choice = (int)test.computerPlay(gameboard, "O", level)[1];
    Assert.assertSame("chooses block in a row", choice, 8);
    
    gameboard.spots = new String[] {"X", "O", "3",
                                    "4", "5", "6",
                                    "X", "8", "9"};
    choice = (int)test.computerPlay(gameboard, "O", level)[1];
    Assert.assertSame("chooses block in a column", choice, 4);
    
    gameboard.spots = new String[] {"X", "O", "X",
                                    "O", "5", "6",
                                    "X", "8", "9"};
    choice = (int)test.computerPlay(gameboard, "O", level)[1];
    Assert.assertSame("chooses block in a diagonal", choice, 5);
  }
  public void testChooseSpot() {
    gameboard.spots = new String[] {"X", "O", "X",
                                    "O", "5", "6",
                                    "X", "8", "9"};
    test.chooseSpot(gameboard, "X");
    Assert.assertSame("chooses spot '5' and marks 'O' in the gameboard", "O" , gameboard.spots[4]);
    
    gameboard.spots = new String[] {"X", "2", "3",
                                    "4", "X", "X",
                                    "O", "O", "9"};
    test.chooseSpot(gameboard, "X");
    Assert.assertSame("chooses spot '9' and marks 'O' in the gameboard", "O" , gameboard.spots[8]);
  } 
}
