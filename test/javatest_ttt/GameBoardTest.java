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
		test.spots = new String[] {"1", "X", "3", "O", "5", "6", "7", "8", "9"};
		ArrayList<String> availableSpots = new ArrayList<String>(Arrays.asList("1", "3", "5", "6", "7", "8", "9"));
		Assert.assertEquals("Shows only numbers from gameboard.", availableSpots, test.availableSpots());
	}
	@Test
	public void testMarkChoiceSpot() {
		test.spots = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
		test.markChoiceSpot(2, "X");
		Assert.assertSame("The choice number '2' replaces 'X' in the gameboard","X",test.spots[1]);
	}
}

