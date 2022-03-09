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
      char[][] field = new char[N][M];
      for (int i = 0; i < N; i++){
        line = input.nextLine();
        data = line.split("");
        for (int j = 0; j < M; j++){
          field[i][j] = data[j].charAt(0);
        }
      }
      line = input.nextLine();
      data = line.split(" ");
      int r1 = Integer.parseInt(data[0]);
      int c1 = Integer.parseInt(data[1]);
      int r2 = Integer.parseInt(data[2]);
      int c2 = Integer.parseInt(data[3]);
      return count(field, r1-1, c1-1, r2-1, c2-1, T);
    }catch (FileNotFoundException ex){
      System.out.println("No such file");
      System.exit(0);
    }
    return 0l;
  }

  public static long count(char[][] field, int r1, int c1, int r2, int c2, int T){
    int[][] dirs = {{0,1}, {0, -1}, {1,0}, {-1, 0}};
    long counter = 0;
    if (r1 < 0 || c1< 0 || r1 >= field.length||c1 >= field[0].length){
      return 0l;
    }
    if (field[r1][c1] == '*'){
      return 0l;
    }
    if (Math.abs(r1-r2)+Math.abs(c1-c2) > T){
      return 0l;
    }
    if (T == 0){
      if(r1 == r2 && c1==c2){
        return 1l;
      }
      return 0l;
    }
    for (int i = 0; i < 4; i++){
      counter += count(field, r1+dirs[i][0], c1+dirs[i][1], r2, c2, T-1);
    }
    return counter;
  }

  public static void main(String[] args) {
    System.out.println(solve("tester2.txt"));
  }
}
