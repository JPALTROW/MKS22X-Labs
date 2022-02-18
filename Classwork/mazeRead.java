import java.util.*;
import java.io.*;

public class mazeRead{
  public static void printMaze(String filename){
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while (input.hasNextLine()){
        System.out.println(input.nextLine());
      }
    }catch (FileNotFoundException ex){
      System.out.println("No such file");
      System.exit(0);
    }
  }

  public static char[][] readMaze(String filename){
    ArrayList<String[]> maze = new ArrayList<String[]>();
    String[] line;
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while (input.hasNextLine()){
        line = input.nextLine().split("");
        maze.add(line);
      }
    }catch (FileNotFoundException ex){
      System.out.println("No such file");
      System.exit(0);
    }
    char[][] compiled = new char[maze.size()][maze.get(1).length];
    for (int i = 0; i < maze.size(); i++){
      for (int j = 0; j < maze.get(i).length; j++){
        compiled[i][j] = maze.get(i)[j].charAt(0);
      }
    }
    return compiled;
  }

  public static void main(String[] args) {
    printMaze("Maze1.txt");
    System.out.println(Arrays.deepToString(readMaze("Maze1.txt")));
  }
}
