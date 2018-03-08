//import java.util.Arrays;
public class KnightBoard{
  private int[][] board;
  public KnightBoard(int row, int col){
    if (row <= 0 || col <= 0){
	    throw new IllegalArgumentException();
    }
    board = new int[row][col];
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
    if (row >= board[0].length ||
        row < 0 ||
        col >= board.length ||
        col < 0 ||
        board[row][col] != 0){
	    return false;
    } else {
	    board[row][col] = number;
	    return true;
    }
  }
  private void rmKnight(int row, int col){
    if (row >= board[0].length ||
        row < 0 ||
        col >= board.length ||
        col < 0 ||
        board[row][col] != 0){
    } else {
	    board[row][col] = 0;
    }
  }    

  public boolean solve(int row, int col){
    if (row < 0 || col < 0 || row > board.length || col > board[0].length){
	    throw new IllegalArgumentException();
    }
    for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[0].length; j++){
        if (board[i][j] != 0){
          throw new IllegalStateException();
        }
	    }
    }
    return solveH(row,col,1);
  }

  private boolean solveH(int row, int col, int level){
    int[][] moveSet = {{-1,-2},
                       {-2,-1},
                       {-1,2},
                       {2,-1},
                       {1,-2},
                       {-2,1},
                       {1,2},
                       {2,1}};
	
    if (board[row][col] != 0){
	    return false;
    }
    if (level == board.length * board[0].length){
	    board[row][col] = level;
	    return true;
    }
    for (int x = 0; x < moveSet.length; x++){
	    int newRow = row+ moveSet[x][0];
	    int newCol = col+ moveSet[x][1];
	    if (newRow >= board.length ||
          newRow < 0 ||
          newCol >= board[0].length ||
          newCol < 0){

	    } else {
        board[row][col] = level;
        if (solveH(newRow,newCol,level+1)){
          return true;
        }
        board[row][col] = 0;
	    }
    }
    return false;
  }

  public int countSolutions(int row, int col){
    if (row < 0 || col < 0 || row > board.length || col > board[0].length){
	    throw new IllegalArgumentException();
    }
    for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[0].length; j++){
        if (board[i][j] != 0){
          throw new IllegalStateException();
        }
	    }
    }
    return countHelp(row,col,1);
  }

  private int countHelp(int row, int col, int level){
    int solutions = 0;
    int[][] moveSet = {{-1,-2},
                       {-2,-1},
                       {-1,2},
                       {2,-1},
                       {1,-2},
                       {-2,1},
                       {1,2},
                       {2,1}};
	
    if (board[row][col] != 0){
	    //System.out.println(board[row][col]);
	    return 0;
    }
    if (level == board.length * board[0].length){
	    //board[row][col] = level;
	    return 1;
    }
    for (int x = 0; x < moveSet.length; x++){
	    //System.out.println("HI");
	    int newRow = row+ moveSet[x][0];
	    int newCol = col+ moveSet[x][1];
	    if (newRow >= board.length ||
          newRow < 0 ||
          newCol >= board[0].length ||
          newCol < 0){
	    } else {
       board[row][col] = level;
        solutions += countHelp(newRow,newCol,level+1);
        board[row][col] = 0;
	    }
    }
    return solutions;
  }

  public static void main(String[] Args){
    //KnightBoard y = new KnightBoard(0,0);
    KnightBoard z = new KnightBoard(4,5);
    System.out.println(z);
    System.out.println(z.solve(0,0));
    System.out.println(z);
    KnightBoard x = new KnightBoard(4,5);
    System.out.println(x);
    System.out.println(x.countSolutions(0,0));
    System.out.println(x);
			   
  }
}
// if (moveKnight(row+moveSet[x][0],col+moveSet[x][1],level)){
// 	//System.out.println(toString());
// 	if (solveH(row+moveSet[x][0],col+moveSet[x][1],level+1)){
// 	    return true;
// 	}
// 	board[row+moveSet[x][0]][col+moveSet[x][1]] = 0;	    
		
// }
// board[row+moveSet[x][0]][col+moveSet[x][1]] = 0;	    
// //System.out.println(toString());
