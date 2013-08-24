package javatest_ttt;

import org.junit.*;
import java_ttt.*;

public class GameRulesTest {
	public GameRules test;
	public GameBoard gameboard;
	
	@Before 
	public void initialize() {
		test = new GameRules();
		gameboard = new GameBoard();
	}
	@Test
	public void testCheckRows() {
		gameboard.spots = new String[] {"X", "X", "X", "4", "5", "6", "7", "8", "9"};
		Assert.assertTrue("Return true if same value in rows form a gameboard.", test.checkRows(gameboard));
		gameboard.spots = new String[] {"O", "O", "O", "4", "5", "6", "7", "8", "9"};
		Assert.assertTrue("Return true if same value in rows form a gameboard.", test.checkRows(gameboard));
		gameboard.spots = new String[] {"1", "2", "3", "X", "X", "X", "7", "8", "9"};
		Assert.assertTrue("Return true if same value in rows form a gameboard.", test.checkRows(gameboard));
		gameboard.spots = new String[] {"1", "2", "3", "O", "O", "O", "7", "8", "9"};
		Assert.assertTrue("Return true if same value in rows form a gameboard.", test.checkRows(gameboard));
		gameboard.spots = new String[] {"1", "2", "3", "4", "5", "6", "X", "X", "X"};
		Assert.assertTrue("Return true if same value in rows form a gameboard.", test.checkRows(gameboard));
		gameboard.spots = new String[] {"1", "2", "3", "4", "5", "6", "O", "O", "O"};
		Assert.assertTrue("Return true if same value in rows form a gameboard.", test.checkRows(gameboard));		
		gameboard.spots = new String[] {"X", "O", "X", "4", "5", "6", "7", "8", "9"};
		Assert.assertFalse("Return false if differnt value in rows form a gameboard.", test.checkRows(gameboard));
		gameboard.spots = new String[] {"1", "2", "3", "O", "X", "O", "7", "8", "9"};
		Assert.assertFalse("Return false if differnt value in rows form a gameboard.", test.checkRows(gameboard));
		gameboard.spots = new String[] {"1", "2", "3", "4", "5", "6", "X", "O", "X"};
		Assert.assertFalse("Return false if differnt value in rows form a gameboard.", test.checkRows(gameboard));	
	}
	@Test
	public void testCheckColumns() {
		gameboard.spots = new String[] {"X", "2", "3", "X", "5", "6", "X", "8", "9"};
		Assert.assertTrue("Return true if same value in columns form a gameboard.", test.checkColumns(gameboard));
		gameboard.spots = new String[] {"O", "2", "3", "O", "5", "6", "O", "8", "9"};
		Assert.assertTrue("Return true if same value in columns form a gameboard.", test.checkColumns(gameboard));
		gameboard.spots = new String[] {"1", "X", "3", "4", "X", "6", "7", "X", "9"};
		Assert.assertTrue("Return true if same value in columns form a gameboard.", test.checkColumns(gameboard));
		gameboard.spots = new String[] {"1", "O", "3", "4", "O", "6", "7", "O", "9"};
		Assert.assertTrue("Return true if same value in columns form a gameboard.", test.checkColumns(gameboard));
		gameboard.spots = new String[] {"1", "2", "X", "4", "5", "X", "7", "8", "X"};
		Assert.assertTrue("Return true if same value in columns form a gameboard.", test.checkColumns(gameboard));
		gameboard.spots = new String[] {"1", "2", "O", "4", "5", "O", "7", "8", "O"};
		Assert.assertTrue("Return true if same value in columns form a gameboard.", test.checkColumns(gameboard));
		gameboard.spots = new String[] {"X", "2", "3", "O", "5", "6", "X", "8", "9"};
		Assert.assertFalse("Return false if differnt value in columns form a gameboard.", test.checkRows(gameboard));
		gameboard.spots = new String[] {"1", "X", "3", "4", "O", "6", "7", "X", "9"};
		Assert.assertFalse("Return false if differnt value in columns form a gameboard.", test.checkRows(gameboard));
		gameboard.spots = new String[] {"1", "2", "X", "4", "5", "O", "7", "8", "X"};
		Assert.assertFalse("Return false if differnt value in columns form a gameboard.", test.checkRows(gameboard));
	}
	@Test
	public void testCheckDiagonals() {
		gameboard.spots = new String[] {"X", "2", "3", "4", "X", "6", "7", "8", "X"};
		Assert.assertTrue("Return true if same value in diagonals form a gameboard.", test.checkDiagonals(gameboard));
		gameboard.spots = new String[] {"O", "2", "3", "4", "O", "6", "7", "8", "O"};
		Assert.assertTrue("Return true if same value in diagonals form a gameboard.", test.checkDiagonals(gameboard));
		gameboard.spots = new String[] {"1", "2", "X", "4", "X", "6", "X", "8", "9"};
		Assert.assertTrue("Return true if same value in diagonals form a gameboard.", test.checkDiagonals(gameboard));
		gameboard.spots = new String[] {"1", "2", "O", "4", "O", "6", "O", "8", "9"};
		Assert.assertTrue("Return true if same value in diagonals form a gameboard.", test.checkDiagonals(gameboard));
		gameboard.spots = new String[] {"O", "2", "3", "4", "X", "6", "7", "8", "O"};
		Assert.assertFalse("Return false if differnt value in diagonals form a gameboard.", test.checkDiagonals(gameboard));
		gameboard.spots = new String[] {"1", "2", "X", "4", "O", "6", "X", "8", "9"};
		Assert.assertFalse("Return false if differnt value in diagonals form a gameboard.", test.checkDiagonals(gameboard));
	}
	@Test
	public void testGameWin() {
		gameboard.spots = new String[] {"X", "X", "X", "4", "5", "6", "7", "8", "9"};
		Assert.assertTrue("Return true if game win", test.gameWin(gameboard));
		gameboard.spots = new String[] {"O", "O", "O", "4", "5", "6", "7", "8", "9"};
		Assert.assertTrue("Return true if game win", test.gameWin(gameboard));
		gameboard.spots = new String[] {"X", "2", "3", "X", "5", "6", "X", "8", "9"};
		Assert.assertTrue("Return true if game win", test.gameWin(gameboard));
		gameboard.spots = new String[] {"O", "2", "3", "O", "5", "6", "O", "8", "9"};
		Assert.assertTrue("Return true if game win", test.gameWin(gameboard));
		gameboard.spots = new String[] {"X", "2", "3", "4", "X", "6", "7", "8", "X"};
		Assert.assertTrue("Return true if game win", test.gameWin(gameboard));
		gameboard.spots = new String[] {"O", "2", "3", "4", "O", "6", "7", "8", "O"};
		Assert.assertTrue("Return true if game win", test.gameWin(gameboard));
	}
	@Test
	public void testGameTie() {
		gameboard.spots = new String[] {"X", "O", "O", "X", "O", "O", "O", "X", "X"};
		Assert.assertTrue("Return true if game is tie", test.gameTie(gameboard));	
		gameboard.spots = new String[] {"O", "2", "3", "4", "O", "6", "7", "8", "O"};
		Assert.assertFalse("Return false if gmae is not tie", test.gameTie(gameboard)); 
	}
	@Test
	public void testGameOver() {
		gameboard.spots = new String[] {"X", "O", "O", "X", "O", "O", "O", "X", "X"};
		Assert.assertTrue("Return true if game is tie", test.gameOver(gameboard));	
		gameboard.spots = new String[] {"O", "2", "3", "4", "O", "6", "7", "8", "O"};
		Assert.assertTrue("Return true if gmae win", test.gameOver(gameboard)); 		
	}
}

