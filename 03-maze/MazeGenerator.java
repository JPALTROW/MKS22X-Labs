import java.util.*;

public class MazeGenerator{
  public static void generate(char[][]maze,int startrow,int startcol){
    boolean stop = false;
    generateM(maze, startrow, startcol);
    maze[startrow][startcol] = 'S';
    for (int i = 0; i < maze.length && !stop; i++){
      for (int j = 0; j < maze[0].length && !stop; j++){
        if (maze[i][j] == ' '){
          maze[i][j] = 'E';
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

public static void clearTerminal(){
  //erase terminal
  System.out.println("\033[2J");
}
public static void gotoTop(){
  //go to top left of screen
  System.out.println("\033[1;1H");
}

public static void printer(char[][] maze){
  clearTerminal();
  gotoTop();
  String compile = "";
  for (int i=0; i<maze.length; i++){
    for (int j=0; j<maze[i].length; j++){
      compile+=maze[i][j];
    }
    compile+="\n";
  }
  System.out.println(compile);
}

public static void wait(int millis){
  try {
    Thread.sleep(millis);
  }
  catch (InterruptedException e) {
  }
}

public static int generateM(char[][]maze,int startrow,int startcol){
  int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
  ArrayList<Integer> nums = new ArrayList<Integer>();
  nums.add(0);
  nums.add(1);
  nums.add(2);
  nums.add(3);
  if(maze[startrow][startcol] == '#' && startrow > 0 && startrow < maze.length - 1 && startcol > 0 && startcol < maze[0].length - 1){
    int counter = 0;
    for (int[] dir:dirs){
      if (maze[startrow + dir[0]][startcol + dir[1]] == ' '){
        counter++;
      }
    }
    if (counter < 2){
      maze[startrow][startcol] = ' ';

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
  }
  return -1;
}
}
