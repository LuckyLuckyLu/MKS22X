import java.util.*;
import java.io.*;
public class Maze{


  private char[][]maze;
  private boolean animate;
  private int rows, cols; 

  public Maze(String fileName) throws FileNotFoundException{
    String contents = "";
    cols = 0;
    rows = 0;

	
    File file = new File(fileName);
    Scanner in = new Scanner(file);	    
    while(in.hasNextLine()){
	    String line = in.nextLine();
	    cols = line.length();
	    rows += 1;
	    contents += line;
    }
    int index = 0;
    int sTimes = 0;
    int eTimes = 0;
    maze = new char[rows][cols];
    for (int i = 0; i < rows; i++){
	    for (int j = 0; j < cols; j++){
        if (contents.charAt(index) == 'S'){
          sTimes += 1;
        }
        if (contents.charAt(index) == 'E'){
          eTimes += 1;
        }
        maze[i][j] = contents.charAt(index);
        index += 1;
	    }
    }
    if (eTimes != 1 || sTimes != 1){
	    throw new IllegalStateException();
    }
  }
    
    
  public String toString(){
    String result = "";
    for (int i = 0; i < rows; i++){
	    for (int j = 0; j < cols; j++){
        result += maze[i][j];
	    }
	    result += "\n";
    }
    return result;
  }
    
    
    

  private void wait(int millis){
    try {
	    Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }


  public void setAnimate(boolean b){

    animate = b;

  }


  public void clearTerminal(){

    //erase terminal, go to top left of screen.

    System.out.println("\033[2J\033[1;1H");

  }



  /*Wrapper Solve Function returns the helper function

    Note the helper function has the same name, but different parameters.
    Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

  */
  public int solve(){
    int startRow = 0;
    int startCol = 0;
    int endRow = 0;
    int endCol = 0;
    //find the location of the S.
    for (int i = 0; i < rows; i++){
	    for (int j = 0; j < cols; j++){
        if (maze[i][j] == 'S'){
          //erase the S
          maze[i][j] = '@';
          startRow = i;
          startCol = j;
          //and start solving at the location of the s.
        }
        if (maze[i][j] == 'E'){
          endRow = i;
          endCol = j;
        }
	    }
    }
    return solve(startRow,startCol,endRow,endCol,0);
  }

  /*
    Recursive Solve function:

    A solved maze has a path marked with '@' from S to E.

    Returns the number of @ symbols from S to E when the maze is solved,
    Returns -1 when the maze has no solution.


    Postcondition:

    The S is replaced with '@' but the 'E' is not.

    All visited spots that were not part of the solution are changed to '.'

    Note: This is not required based on the algorithm, it is just nice visually to see.
    All visited spots that are part of the solution are changed to '@'
  */
  private int solve(int row, int col, int endRow, int endCol, int counter){ 
    System.out.println(row);
    System.out.println(col);
    System.out.println(endRow);
    System.out.println(endCol);
    if(animate){
	    clearTerminal();
	    System.out.println(this);
      //System.out.println(counter);
	    wait(100);
    }
    if (row == endRow && col == endCol){
      System.out.println("Oh yeah baby!");
      return counter;
    }
    int[][] moveSet = {{0,1},{1,0},{0,-1},{-1,0}};
    for (int i = 0; i < moveSet.length; i++){
	    int newRow = row + moveSet[i][0];
	    int newCol = col + moveSet[i][1];
      if (maze[newRow][newCol] == ' ' || maze[newRow][newCol] == 'E'){
        if (maze[newRow][newCol] == ' '){
         maze[newRow][newCol] = '@';
         counter += 1;
        }
        if (solve(newRow,newCol,endRow,endCol,counter) != -1){
          return solve(newRow,newCol,endRow,endCol,counter);
        }
        maze[newRow][newCol] = '.';
        counter -= 1;
      }
    }
    return -1;
  }
}
