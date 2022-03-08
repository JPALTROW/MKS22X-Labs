import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bronze{
  public static long solve(String fileName){
    try {
      File file = new File(fileName);
      Scanner input = new Scanner(file);
      String line1 = input.nextLine();
      String[] nums = line1.split(" ");
      int R = Integer.parseInt(nums[0]);
      int C = Integer.parseInt(nums[1]);
      int E = Integer.parseInt(nums[2]);
      int N = Integer.parseInt(nums[3]);
      int[][] lake = new int[R][C];
      String line;
      String[] data;
      for (int i = 0; i < R; i++){
        line = input.nextLine();
        data = line.split(" ");
        for (int j = 0; j < C; j++){
          lake[i][j] = Integer.parseInt(data[j]);
        }
      }
      int stompR;
      int stompC;
      int stompDepth;
      int sqMax = 0;
      for(int q = 0; q < N; q++){
        line = input.nextLine();
        data = line.split(" ");
        stompR = Integer.parseInt(data[0]);
        stompC = Integer.parseInt(data[1]);
        stompDepth = Integer.parseInt(data[2]);
        for (int i = 0; i < 3; i++){
          for (int j = 0; j < 3; j++){
            if (lake[i][j] > sqMax){
              sqMax = lake[i][j];
            }
          }
        }
        for (int i = 0; i < 3; i++){
          for (int j = 0; j < 3; j++){
            lake[i][j]=Math.min(sqMax - stompDepth, lake[i][j]);
          }
        }
      }
      long counter = 0;
      for (int i = 0; i < R; i++){
        for (int j = 0; j < C; j++){
          counter += (long)(Math.max(0, E - lake[i][j]));
        }
      }
      return counter * 72l * 72l;
    }catch (FileNotFoundException ex){
      System.out.println("No such file");
      System.exit(0);
    }
    return 0l;
  }
}
