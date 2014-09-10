package java_ttt;
import java.util.*;

public class GameBoard {
  public String spots[] = {"1", "2", "3",
                           "4", "5", "6",
                           "7", "8", "9"};
  public String[][] newSpots = new String[3][3];
  
  public void showBoard() {
    for(int i = 0; i < spots.length; i += 3) {
      System.out.printf("%3s  |%3s  |%3s\n", spots[i], spots[i+1], spots[i+2]);
      if(i < 6)
        System.out.println(" ---------------"); } }
  
  public List <String> availableSpots() {
    LinkedList <String> accessible_spots = new LinkedList <String>();
    for(int spot=0; spot<9; spot++) {
      if(spots[spot].equals("O") || spots[spot].equals("X"));
      else 
        accessible_spots.add(spots[spot]); }
    return accessible_spots; }
  
  public void markChoiceSpot(int choice_spot, String current_player) {
    spots[choice_spot-1] = current_player; }
}
