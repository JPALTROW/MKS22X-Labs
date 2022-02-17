public class QueenBoard{
  private int[][]board;
  private boolean animated;
  private int delay;

  public QueenBoard(){
    this(8);
  }
  public QueenBoard(int size){
    board = new int[size][size];
    animated = false;
    delay = 1000;
  }

  public void setAnimate(boolean newValue){
    animated = newValue;
  }

  public void setDelay(int newValue){
    delay = newValue;
  }
  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _
  *excludes the characters up to the comment(*)
  */
  public String toString(){
    String compile = "";
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board.length; j++){
        if(board[i][j] == -1){
          compile+="Q";
        }
        else{
          compile+="_";
        }
        if(j==board.length-1){
          compile+="\n";
        }else{
          compile+=" ";
        }
      }
    }
    return compile;
  }

  /**
  *@return true when the queen added correctly, false Otherwise
  *@precondition r and c are valid indices of the board array
  *@postcondition the board is only changed when the function returns true
  * in which case the queen is added and all it's threatened positions are incremented
  */
  private boolean addQueen(int r, int c){
    int row = r;
    int col = c+1;
    if (board[r][c] > 0){
      return false;
    }
    row++;
    if(r < board.length - 1){
      while(row<board.length){
        board[row][c]++;
        row++;
      }
      row = r+1;
      if(c < board.length - 1){
        while(row<board.length && col<board.length){
          board[row][col]++;
          row++;
          col++;
        }
      }
      row = r+1;
      col = c-1;
        while(row<board.length && col>=0){
          board[row][col]++;
          row++;
          col--;
        }
    }
    board[r][c]=-1;
    return true;
  }

  /**Remove the queen that was added to r,c
  *@precondition r and c are valid indices of the board array and there is a queen at position r,c
  *@postcondition the board is modified to remove that queen and all it's
  *threatened positions are decremented
  */
  private void removeQueen(int r, int c){
    int row = r;
    int col = c+1;
    row++;
    if(r < board.length - 1){
      while(row<board.length){
        board[row][c]--;
        row++;
      }
      row = r+1;
      if(c < board.length - 1){
        while(row<board.length && col<board.length){
          board[row][col]--;
          row++;
          col++;
        }
      }
      row = r+1;
      col = c-1;
        while(row<board.length && col>=0){
          board[row][col]--;
          row++;
          col--;
        }

    }
    board[r][c]=0;
  }

  /**Find the first solution configuration possible for this size board. Start by placing
  *  the 1st queen in the top left corner, and each new queen in the next ROW. When backtracking
  *  move the previous queen to the next valid space. This means everyone will generate the same
  *  first solution.
  *@postcondition: the board remains in a solved state.
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        returns true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you solved a 2nd time.)
  */
  public boolean solve() throws IllegalStateException{
    for(int[] i:board){
      for(int j:i){
        if (j != 0){
          throw new IllegalStateException();
        }
      }
    }
    if (solve(0)){
      if (animated){
        System.out.println(toString());
      }
      return true;
    }
    return false;
  }

  private boolean solve(int row){
    if(row==board.length){
      return true;
    }else{
      for (int col = 0; col<board.length; col++){
        if(addQueen(row, col)){
          if(animated){
            System.out.println(Text.go(1,1));
            System.out.println(this);//can modify here
            Text.wait(delay);
          }
          if(solve(row+1)){
            return true;
          }
          removeQueen(row, col);
        }
      }
      return false;
    }
  }

  /**Find all possible solutions to this size board.
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you ran solve() before this method)
  */
  public int countSolutions() throws IllegalStateException{
    for(int[] i:board){
      for(int j:i){
        if (j != 0){
          throw new IllegalStateException();
        }
      }
    }
    int count = countSolutions(0);
    for (int[] i :board){
      for(int j:i){
        j=0;
      }
    }
    return count;
  }

  private int countSolutions(int row){
    int counter = 0;
    if (row == board.length){
      return 1;
    }else{
      for (int col = 0; col<board.length; col++){
        if(addQueen(row, col)){
          counter+=countSolutions(row+1);
          removeQueen(row, col);
        }
      }
    }
    return counter;
  }
}
