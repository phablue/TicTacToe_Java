package java_ttt;
import java.util.Scanner;

public class Reader {
  Scanner scan;

  public Reader(Scanner scan) {
    this.scan = scan; }

  public String input() {
    return scan.next(); }
}
