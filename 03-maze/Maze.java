public class Maze{
  private char[][] maze;

  public static String toString(){
    for (int i = 0; i < maze.length; i++){
      for (int j = 0; j < maze[i].length; j++){
        if (maze[i][j]=='#'){
          System.out.print("#");
        }else if(maze[i][j]=='X'){
          System.out.print(Text.colorize("+", Text.GREEN));
        }else{
          System.out.print(" ");
        }
      }
    }
  }
  public static boolean solve(){
    for (int i = 0; i < maze.length; i++){
      for (int j = 0; j < maze[i].length(); j++){
        if (maze[i][j] == 'S'){
          return solve(maze, 0, 0, i, j);
        }
      }
    }
  }

  public static boolean solve(int row, int col){
    if(maze[row][col] == '#' || maze[row][col] == 'X'){
      return false;
    }
    else{
      maze[row][col] = 'X';
      return solve(maze, row+1, col)||solve(maze, row, col+1)||solve(maze, row-1, col)||solve(maze, row, col-1);

    }
  }
}
