import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadMaze {
  public static void printMaze(String filename){
    char[][] maze;
    String line;
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while (input.hasNextLine()){
        line = input.nextLine();
        System.out.println(line);

      }
    }catch (FileNotFoundException ex){
      System.out.println("No such file");
    }
  }
  public static void main(String[] args) {
    printMaze("Maze1.txt");
  }
}
