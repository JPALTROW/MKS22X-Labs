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

  }
}
