import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
        data = line.split(" ");
        for (int j = 0; j < M; j++){
          field[i][j] = data[j].charAt(0);
        }
      }
    }catch (FileNotFoundException ex){
      System.out.println("No such file");
      System.exit(0);
    }
    return 0l;
  }

  public static long count(char[][] field, int r1, int c1, int r2, int c2, int T, long count){
    int[][] dirs = {{0,1}, {0, -1}, {1,0}, {-1, 0}};
    int counter = 0;
    if (field[r1][c1] == '*'){
      return 0;
    }
    if (r1 < 0 || c1< 0 || r1 >= field.length||c1 >= field[0].length){
      return 0;
    }
    if (Math.abs(r1-r2)+Math.abs(c1-c2) > T){
      return 0;
    }
    if (T == 0){
      if(r1 == r2 && c1==c2){
        return 1;
      }
      return 0;
    }
    for (int i = 0; i < 4; i++){
      counter += count(field, r1+dirs[i][0], c1+dirs[i][1], r2, c2, T-1, count);
    }
    return counter;
  }
}
