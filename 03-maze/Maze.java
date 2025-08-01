import java.util.*;
import java.io.*;
public class Maze{
  private char[][]maze;
  private boolean animate;//false by default
  private int startRow,startCol;

  /*Constructor loads a maze text file, and sets animate to false by default.
  When the file is not found then:
  throw a FileNotFoundException

  You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
  '#' - Walls - locations that cannot be moved onto
  ' ' - Empty Space - locations that can be moved onto
  'E' - the location of the goal if any (0 or more per file)
  'S' - the location of the start(exactly 1 per file)

  You may also assume the maze has a border of '#' around the edges.
  So you don't have to check for out of bounds!
  Some text editors always include a newline at the end of a file, but that is not always present.
  Make sure your file reading is able to handle this.
  */
  public Maze(String filename) throws FileNotFoundException{
    //COMPLETE CONSTRUCTOR
    ArrayList<String[]> compile = new ArrayList<String[]>();
    String[] line;
    String data;
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while (input.hasNextLine()){
        data = input.nextLine();
        if (!data.equals("\n")){
          line = data.split("");
          compile.add(line);
        }
      }
    }catch (FileNotFoundException ex){
      System.out.println("No such file");
      System.exit(0);
    }
    maze = new char[compile.size()][compile.get(1).length];
    for (int i = 0; i < compile.size(); i++){
      for (int j = 0; j < compile.get(i).length; j++){
        char entry = compile.get(i)[j].charAt(0);
        maze[i][j] = entry;
        if (entry == 'S'){
          startRow = i;
          startCol = j;
        }
      }
    }
    animate = false;
  }

  public void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }

  public void setAnimate(boolean b){
    animate = b;
  }

  public static void clearTerminal(){
    //erase terminal
    System.out.println("\033[2J");
  }
  public static void gotoTop(){
    //go to top left of screen
    System.out.println("\033[1;1H");
  }

  /*Return the string that represents the maze.
  It should look like the text file with some characters replaced.
  */
  public String toString(){
    clearTerminal();
    gotoTop();
    String compile = "";
    for (int i=0; i<maze.length; i++){
      for (int j=0; j<maze[i].length; j++){
        compile+=maze[i][j];
      }
      compile+="\n";
    }
    return compile;
  }

  /*Wrapper Solve Function returns the helper function
  Note the helper function has the same name, but different parameters.
  Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
  */
  public int solve(){
    //only clear the terminal if you are running animation
    if(animate){
      clearTerminal();
    }
    //start solving at the location of the s.
    return solve(startRow,startCol);

  }

  /*
  Recursive Solve function:

  A solved maze has a path marked with '@' from S to E.

  Returns the number of @ symbols from S to E when the maze is solved,
  Returns -1 when the maze has no solution.

  Postcondition:
  The 'S' is replaced with '@'
  The 'E' remain the same
  All visited spots that were not part of the solution are changed to '.'
  All visited spots that are part of the solution are changed to '@'
  */
  private int solve(int row, int col){ //you can add more parameters since this is private
    //automatic animation! You are welcome.
    if(animate){
      gotoTop();
      System.out.println(this);
      wait(10);
    }

    if (maze[row][col]=='E'){
      return 0;
    }
    if (maze[row][col] == '#'||maze[row][col] == '.'||maze[row][col] == '@'){
      return -1;
    }
    maze[row][col] = '@';
    int j = solve(row, col+1);
    if(j>=0){
      return j+1;
    }else{
      int k = solve(row, col-1);
      if(k>=0){
        return k+1;
      }else{
        int l = solve(row+1, col);
        if(l>=0){
          return l+1;
        }else{
          int m = solve(row-1, col);
          if(m>=0){
            return m+1;
          }
        }
      }
    }
    maze[row][col] = '.';
    return -1;
  }
}
