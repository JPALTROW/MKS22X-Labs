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

  public static int generateM(char[][]maze,int startrow,int startcol){
    int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    ArrayList<Integer> nums = new ArrayList<Integer>();
    nums.add(0);
    nums.add(1);
    nums.add(2);
    nums.add(3);
    if(maze[startrow][startcol] == '#' && startrow != 0 && startrow != maze.length && startcol != 0 && startcol != maze[0].length){
      int counter = 0;
      for (int[] dir:dirs){
        if (maze[startrow + dir[0]][startcol + dir[1]] == ' '){
          counter++;
        }
      }
      if (counter < 2){
        maze[startrow][startcol] = ' ';
      }
      int randNum = nums.remove((int)(Math.random()*4));
      int[] randDir = dirs[randNum];
      int j = generateM(maze, startrow + randDir[0], startcol+randDir[1]);
      if (j > -1){
        return 0;
      }
      randNum = nums.remove((int)(Math.random()*3));
      randDir = dirs[randNum];
      j = generateM(maze, startrow + randDir[0], startcol+randDir[1]);
      if (j > -1){
        return 0;
      }
      randNum = nums.remove((int)(Math.random()*2));
      randDir = dirs[randNum];
      j = generateM(maze, startrow + randDir[0], startcol+randDir[1]);
      if (j > -1){
        return 0;
      }
      randNum = nums.remove((int)(Math.random()*1));
      randDir = dirs[randNum];
      j = generateM(maze, startrow + randDir[0], startcol+randDir[1]);
      if (j > -1){
        return 0;
      }
    }
    return -1;
  }
}
