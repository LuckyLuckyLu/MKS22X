public class QueenBoard{
  private int[][] board;
  public QueenBoard(int size){
    board = new int[size][size];
    for (int i = 0; i < size; i++){
	    for (int j = 0; j < size; j++){
        board[i][j] = 0;
	    }
    }
  }
    
  private boolean addQueen(int r, int c){
    if (board[r][c] != 0){
      return false;
    } else {
      board[r][c] = -1;
      UpDiaLazer(r,c);
      DownDiaLazer(r,c);
      StraightLazer(r,c);
      return true;
    }
  }
  private void UpDiaLazer(int r, int c){
    int col = c+1;
    for (int row = r-1; row >= 0; row--){
      if (col < board.length){
        board[row][col] += 1;
        col += 1;
      }
    }
  }
  private void DownDiaLazer(int r, int c){
    int col = c+1;
    for (int row = r+1; row < board.length; row++){
      if (col < board.length){
        board[row][col] += 1;
        col += 1;
      }
    }
  }
  private void StraightLazer(int r, int c){
    for (int col = c+1; col < board.length; col++){
	    board[r][col] += 1;
    }
  }
  private boolean rmQueen(int r, int c){
    if (board[r][c] != -1){
      return false;
    } else {
      board[r][c] = 0;
      AntiUpDiaLazer(r,c);
      AntiDownDiaLazer(r,c);
      AntiStraightLazer(r,c);
      return true;
    }
  }
  private void AntiUpDiaLazer(int r, int c){
    int col  = c+1;
    for (int row = r-1; row >= 0; row--){
      if (col < board.length){
        board[row][col] -= 1;
        col += 1;
      }
    }
  }
  private void AntiDownDiaLazer(int r, int c){
    int col = c+1;
    for (int row = r+1; row < board.length; row++){
	    if (col < board.length){
        board[row][col] -= 1;
        col += 1;
      }
    }
  }
  private void AntiStraightLazer(int r, int c){
    for (int col = c+1; col < board.length; col++){
	    board[r][col] -= 1;
    }
  }
  /**
   *@return The output string formatted as follows:
   *All numbers that represent queens are replaced with 'Q' 
   *all others are displayed as underscores '_'
   *There are spaces between each symbol:  
   *Q _ _ _
   *_ _ Q _
   * etc.
   */
  public String toString(){
    String result = "";
    for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board.length; j++){
        //result += board[i][j];
        if (board[i][j] == -1){
          result += "Q ";
        } else {
          result += "_ ";
        }
	    }
	    result += "\n";
    }
    return result;
  }
  
  /**
   *@return false when the board is not solveable and leaves the board filled with zeros; 

   *        true when the board is solveable, and leaves the board in a solved state

   *@throws IllegalStateException when the board starts with any non-zero value

   */
  public boolean solve(){
    boolean nonZeroPresence = false;
    for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board.length; j++){
        if (board[i][j] != 0){
          nonZeroPresence = true;
        }
	    }
    }
    if (nonZeroPresence){
      throw new IllegalStateException();
    } else {
      return solHelper(0,0);
    }
  }

  private boolean solHelper(int col, int qPlaced){
    if (col == board.length){
      return qPlaced == board.length;
    } else {
      for (int x = 0; x < board.length; x++){
        if (addQueen(x,col) == true){
          if (solHelper(col+1, qPlaced+1) == true){
            return true;
          } else {
            rmQueen(x,col);
          }
        }
      }
    }
    return false;
  }
  
  /**
   *@return the number of solutions found, and leaves the board filled with only 0's
   *@throws IllegalStateException when the board starts with any non-zero value
   */
  public int countSolutions(){return 0;}
    
  public static void main(String[] args){
    QueenBoard x = new QueenBoard(10);
    //x.addQueen(5,8);
    System.out.println(x);
    //x.rmQueen(1,1);
    //System.out.println(x.addQueen(9,8));
    //System.out.println(x);
    x.solve();
    System.out.println(x);
  }
}
