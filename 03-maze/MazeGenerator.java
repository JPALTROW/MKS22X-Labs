import java.util.*;

public class MazeGenerator{
  public static void generate(char[][]maze,int startrow,int startcol){
    boolean stop = false;
    maze[startrow][startcol] = 'S';
    generateM(maze, startrow, startcol);
    for (char[] i : maze){
      for (char j : i){
        if(j!='#' && !stop){
          j='E';
          stop = true;
        }
      }
    }
    /*if (startRow > maze.length/2){
      if (startCol > maze[0].length/2){
        for (int i = 2; i < maze.length+maze[0].length; i++){
          for (int j = 1; j < i && !stop; j++){
            if (maze[j][i-j] == ' '){
              maze[j][i-j]='E';
            }
          }
        }
      }else{
        for (int i = 2; i < maze.length+maze[0].length; i++){
          for (int j = 1; j < i && !stop; j++){
            if (maze[j][i-j] == ' '){
              maze[j][i-j]='E';
            }
          }
        }
      }
    }*/
  }

  public static void generateM(char[][]maze,int startrow,int startcol){
    int counter = 0;
    int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    ArrayList<Integer> nums = new ArrayList<Integer>();
    if(maze[startrow][startcol] == '#' && startrow != 0 && startrow != maze.length && startcol != 0 && startcol != maze[0].length){
      for (int[] dir:dirs){
        if (maze[startrow + dir[0]][startcol + dir[1]] == ' '){
          counter++;
        }
      }
      if (counter < 2){
        maze[startrow][startcol] = ' ';
      }

    }
  }
}
