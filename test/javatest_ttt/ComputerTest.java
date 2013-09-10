package javatest_ttt;

import org.junit.*;
import java_ttt.*;

public class ComputerTest {
	public Computer test;
	public GameBoard gameboard;
	@Before
	public void initilize() {
		test = new Computer();
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
	public void testComputerPlay() {
		int level = 0;
		gameboard.spots = new String[] {"X", "2", "3",
										"4", "X", "X",
										"O", "O", "9"};
		test.computerPlay(gameboard, "O", level);
		int choice = (int)test.computerPlay(gameboard, "O", level)[1];
		Assert.assertSame("choose easy win in a row", choice, 9);	
		gameboard.spots = new String[] {"O", "2", "3",
										"4", "X", "6",
										"O", "X", "X"};
		test.computerPlay(gameboard, "O", level);
		choice = (int)test.computerPlay(gameboard, "O", level)[1];
		Assert.assertSame("choose easy win in a column", choice, 4);			
		gameboard.spots = new String[] {"X", "X", "O",
										"4", "O", "6",
										"7", "8", "X"};
		choice = (int)test.computerPlay(gameboard, "O", level)[1];
		Assert.assertSame("choose easy win in a diagonal", choice, 7);
		gameboard.spots = new String[] {"X", "O", "3",
										"O", "5", "6",
										"X", "8", "X"};
		choice = (int)test.computerPlay(gameboard, "O", level)[1];
		Assert.assertSame("choose block in a row", choice, 8); }
}

