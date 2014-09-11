package javatest_ttt;

import org.junit.*;
import java.util.*;
import java_ttt.*;

public class GameBoardTest {
  public GameBoard test;
  @Before
  public void initilize() {
    test = new GameBoard();
  }
  @Test
  public void testAvailableSpots () {
    test.spots = new String[] {"1", "X", "3",
                               "O", "5", "6",
                               "7", "8", "9"};
    LinkedList<String> availableSpots = new LinkedList<String>(Arrays.asList("1", "3", "5", "6", "7", "8", "9"));
    Assert.assertEquals("Shows only numbers from gameboard.", availableSpots, test.availableSpots());

    test.spots = new String[] {"1", "X", "3",
					           "4", "5", "6",
					           "7", "8", "9"};
	availableSpots = new LinkedList<String>(Arrays.asList("1", "3", "4", "5", "6", "7", "8", "9"));
	Assert.assertEquals("Shows only numbers from gameboard.", availableSpots, test.availableSpots());

    test.spots = new String[] {"X", "O", "3",
					           "4", "X", "6",
					           "O", "8", "O"};
	availableSpots = new LinkedList<String>(Arrays.asList("3", "4", "6", "8"));
	Assert.assertEquals("Shows only numbers from gameboard.", availableSpots, test.availableSpots());
  }
  @Test
  public void testMarkChoiceSpot() {
    test.spots = new String[] {"1", "2", "3",
                               "4", "5", "6",
                               "7", "8", "9"};
    test.markChoiceSpot(2, "X");
    Assert.assertSame("The choice number '2' replaces 'X' in the gameboard","X",test.spots[1]);

    test.markChoiceSpot(5, "X");
    Assert.assertSame("The choice number '5' replaces 'X' in the gameboard","X",test.spots[4]);

    test.markChoiceSpot(3, "O");
    Assert.assertSame("The choice number '3' replaces 'O' in the gameboard","O",test.spots[2]);

    test.markChoiceSpot(8, "O");
    Assert.assertSame("The choice number '8' replaces 'O' in the gameboard","O",test.spots[7]);
  }
}
