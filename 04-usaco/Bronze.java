import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bronze{
  public static long solve(String fileName){
    try {
      File file = new File(fileName);
      Scanner input = new Scanner(file);

    }catch (FileNotFoundException ex){
      System.out.println("No such file");
      System.exit(0);
    }
    return 0l;
  }
}
