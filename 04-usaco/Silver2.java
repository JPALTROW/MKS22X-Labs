import java.io.*;
import java.util.*;

public class Silver2{
  public static long solve(String fileName){
    try {
      File file = new File(fileName);
      Scanner input = new Scanner(file);
      String line = input.nextLine();
      String[] data = line.split(" ");
      int N = Integer.parseInt(data[0]);
      int M = Integer.parseInt(data[1]);
      int T = Integer.parseInt(data[2]);
      char[][] field = new char[N][M];
      int[][] field1 = new int[N][M];
      int[][] field2 = new int[N][M];
      char q;
      for (int i = 0; i < N; i++){
        line = input.nextLine();
        data = line.split("");
        for (int j = 0; j < M; j++){
          q = data[j].charAt(0);
          field[i][j] = q;
          if (q == '*'){
            field1[i][j] = -1;
          }else{
            field1[i][j] = 0;
          }
        }
      }
      line = input.nextLine();
      data = line.split(" ");
      int r1 = Integer.parseInt(data[0]);
      int c1 = Integer.parseInt(data[1]);
      int r2 = Integer.parseInt(data[2]);
      int c2 = Integer.parseInt(data[3]);
      field1[r1][c1] = 1;
      for (int t = 1; t <= T; t++){
        for (int i = 0; i < N; i++){
          for (int j = 0; j < M; j++){

          }
        }
      }
    }catch (FileNotFoundException ex){
      System.out.println("No such file");
      System.exit(0);
    }
    return 0l;
  }

  
}
