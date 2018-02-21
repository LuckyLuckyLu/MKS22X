//import java.util.Arrays;
public class KnightBoard{
  private int[][] board;
  public KnightBoard(int row, int col){
    board = new int[row][col];
    /*
    //int x = 0;
    for (int i = 0; i < row; i++){
    for (int j = 0; j < col; j++){
    board[i][j] = x;
    //	x += 1;
    }
    }
    */
  }

  public String toString(){
    String result = "";
    for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[0].length; j++){
        if (board[i][j] / 10 >= 1){
          result += " " + board[i][j];
        } else if (board[i][j] == 0){
          result += " __";
        } else {
          result += " _" + board[i][j];
        }
	    }
	    result += "\n";
    }
    return result;
  }
  private boolean moveKnight(int row, int col, int number){
    if (row > board[0].length ||
        row < 0 ||
        col > board.length ||
        col < 0 ||
        board[row][col] != 0){
	    return false;
    } else {
	    board[row][col] = number;
	    return true;
    }
  }
  private boolean rmKnight(int row, int col){
    if (row > board[0].length ||
        row < 0 ||
        col > board.length ||
        col < 0 ||
        board[row][col] == 0){
	    return false;
    } else {
	    board[row][col] = 0;
	    return true;
    }
  }    

  public boolean solve(int row, int col){
    board[row][col] = 1;
    return solveH(row,col,2);
  }

  private boolean solveH(int row, int col, int level){
    int[][] moveSet = {{-1,-2},{-2,-1},{-1,2},{2,-1},{1,-2},{2,-1},{1,2},{2,1}};
    for (int x = 0; x < moveSet.length; x++){
	    if (moveKnight(row+moveSet[x][0],col+moveSet[x][1],level)){
        //System.out.println(toString());
        return solveH(row+moveSet[x][0],col+moveSet[x][1],level+1); 
	    } else {
        rmKnight(row+moveSet[x][0],col+moveSet[x][1]);	    
	    }
	    //System.out.println(toString());
    }
    return false;
  }

  public int countSolutions(){
    return 0;
  }

  private int countHelp(int counter){
    return 0;
  }

  public static void main(String[] Args){
    KnightBoard y = new KnightBoard(5,5);
    /*System.out.println(y);
      System.out.println(y.moveKnight(5,5,1));
      System.out.println(y);
      System.out.println(y.moveKnight(9,5,1));
      System.out.println(y);
      System.out.println(y.moveKnight(5,9,1));
      System.out.println(y);
      System.out.println(y.moveKnight(20,5,1));
      System.out.println(y);
      System.out.println(y.moveKnight(5,20,1));
      System.out.println(y);*/

    KnightBoard z = new KnightBoard(5,5);
    System.out.println(z);
    z.solve(0,0);
    System.out.println(z);
  }
}
