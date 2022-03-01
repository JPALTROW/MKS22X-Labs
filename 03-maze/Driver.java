import java.io.*;

public class Driver{
  public static void main(String[]args) throws FileNotFoundException{
    Maze test1 = new Maze("Maze1.txt");
    Maze test2 = new Maze("Maze2.txt");
    Maze test3 = new Maze("Maze3.txt");
    Maze test4 = new Maze("Maze4.txt");
    Maze test5 = new Maze("Maze5.txt");
    System.out.println(test1.solve());
    System.out.println(test2.solve());
    System.out.println(test3.solve());
    System.out.println(test4.solve());
    System.out.println(test5.solve());
  }
}
