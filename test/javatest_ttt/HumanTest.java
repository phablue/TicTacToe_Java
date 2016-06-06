package javatest_ttt;

import org.junit.*;
import java_ttt.*;

import java.util.Scanner;

public class HumanTest {
  private Human human;
  private GameBoard gameboard;

  @Before
  public void initilize() {
    human = new Human(new Reader(new Scanner(System.in)), new Writer());
    gameboard = new GameBoard();
  }
  
  @Test
  public void when_Player_Chose_Available_Spot_Should_Mark_a_Spot () {
    gameboard.spots = new String[] {"1", "X", "3",
                                    "O", "5", "6",
                                    "7", "8", "9"};
    String choiceSpot = "1";
    
    human.checkAvailable(gameboard, "X", choiceSpot);
    
    Assert.assertEquals("Marks 'X' on spot 1, when a player chose spot 1", gameboard.spots[0], "X");

    gameboard.spots = new String[] {"1", "X", "3",
                                    "4", "5", "6",
                                    "7", "O", "9"};
    choiceSpot = "3";
    
    human.checkAvailable(gameboard, "X", choiceSpot);
    
    Assert.assertEquals("Marks 'X' on spot 3, when a player chose spot 3", gameboard.spots[2], "X");

    gameboard.spots = new String[] {"X", "O", "3",
                                    "4", "X", "6",
                                    "O", "8", "O"};
    choiceSpot = "8";

    human.checkAvailable(gameboard, "X", choiceSpot);

    Assert.assertEquals("Marks 'X' on spot 8, when a player chose spot 8", gameboard.spots[7], "X");
  }
  @Test
  public void should_Get_Spot_is_User_Input() {
      Scanner userInput = new Scanner("4");
      Reader reader = new Reader(userInput);
      UI ui = new UI(reader);

      human = new Human(reader, new Writer());
      
      Assert.assertEquals("Return 4, when user input is 4", "4", ui.userInput());
  }
}
