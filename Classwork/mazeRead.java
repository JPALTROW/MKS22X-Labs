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
}
