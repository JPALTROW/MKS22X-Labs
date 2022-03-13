import java.io.*;
import java.util.*;

public class Silver{
  public static long solve(String fileName){
    try {
      File file = new File(fileName);
      Scanner input = new Scanner(file);
      String line = input.nextLine();
      String[] data = line.split(" ");
      int N = Integer.parseInt(data[0]);
      int M = Integer.parseInt(data[1]);
      int T = Integer.parseInt(data[2]);
      long[][] field1 = new long[N][M];
      long[][] field2 = new long[N][M];
      char q;
      for (int i = 0; i < N; i++){
        line = input.nextLine();
        data = line.split("");
        for (int j = 0; j < M; j++){
          q = data[j].charAt(0);
          if (q == '*'){
            field1[i][j] = -1l;
          }else{
            field1[i][j] = 0l;
          }
        }
      }
      line = input.nextLine();
      data = line.split(" ");
      int r1 = Integer.parseInt(data[0]) - 1;
      int c1 = Integer.parseInt(data[1]) - 1;
      int r2 = Integer.parseInt(data[2]) - 1;
      int c2 = Integer.parseInt(data[3]) - 1;
      field1[r1][c1] = 1l;
      for (int t = 1; t <= T; t++){
        if (t % 2 == 1){
          move(field1, field2);
        }else{
          move(field2, field1);
        }
      }
      if (T % 2 == 1){
        return field2[r2][c2];
      }else{
        return field1[r2][c2];
      }
    }catch (FileNotFoundException ex){
      System.out.println("No such file");
      System.exit(0);
    }
    return 0l;
  }

  public static void move(long[][] field, long[][] result){
    for (int i = 0; i < field.length; i++){
      for (int j = 0; j < field[0].length; j++){
        if (field[i][j] != -1){
          if (j==0){
            result[i][j] = 0;
          }else{
            if (field[i][j-1] != -1){
              result[i][j] = field[i][j-1];
            }else{
              result[i][j] = 0;
            }
          }
        }else{
          result[i][j] = -1;
        }
      }
    }
    for (int i = 0; i < field.length; i++){
      for (int j = field[0].length-2; j >=0; j--){
        if (field[i][j] != -1 && field[i][j+1] != -1){
          result[i][j] += field[i][j+1];
        }
      }
    }
    for (int j = 0; j < field[0].length; j++){
      for (int i = field.length-2; i >=0; i--){
        if (field[i][j] != -1 && field[i+1][j] != -1){
          result[i][j] += field[i+1][j];
        }
      }
    }
    for (int j = 0; j < field[0].length; j++){
      for (int i = 1; i < field.length; i++){
        if (field[i][j] != -1 && field[i-1][j] != -1){
          result[i][j] += field[i-1][j];
        }
      }
    }
  }
  public static void printer(int[][] field){
    for (int i = 0; i <field.length; i++){
      for (int j = 0; j < field[0].length; j++){
        if (field[i][j] >= 0){
          System.out.print(" ");
        }
        System.out.print(field[i][j]);
      }
      System.out.println();
    }
  }
  public static void main(String[] args) {
  //  System.out.println(solve("tester2.txt"));
  System.out.println(solve("ctravel.2.in"));
  }
}
