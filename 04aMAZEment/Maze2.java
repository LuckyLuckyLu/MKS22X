import java.util.*;
import java.io.*;
public class Maze2{


  private char[][]maze;
  private boolean animate;
  private int rows, cols; 

  public Maze2(String fileName) throws FileNotFoundException{
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
	    }
    }
    solve(startRow,startCol,0);
    return AtCounter();
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
  private int solve(int row, int col, int count){ 
    //System.out.println(row);
    //System.out.println(col);
    if(animate){
	    clearTerminal();
	    System.out.println(this);
	    //System.out.println(counter);
	    wait(20);
    }
    int[][] moveSet = {{0,1},{1,0},{0,-1},{-1,0}};
    for (int dir = 0; dir < 4; dir++){
	    int newRow = row + moveSet[dir][0];
	    int newCol = col + moveSet[dir][1];
	    if (maze[newRow][newCol] == 'E'){
        return count;
	    }
	    if (maze[newRow][newCol] == ' '){
        maze[newRow][newCol] = '.';
        if (solve(newRow,newCol,(count+1)) > 0){
        }
        else {
          maze[newRow][newCol] = '.';
        }
      }
    }
    return -1;
  }
  private int AtCounter(){
    int Counter = 0;
    for (int i = 0; i < rows; i++){
	    for (int j = 0; j < cols; j++){
        if (maze[i][j] == '@'){
          Counter += 1;
        }
	    }
    }
    Counter -= 1;
    if (Counter == 0){
      return -1;
    }
    return Counter;
  }
}




// if (maze[row][col] != ' ' || maze[row][col] == 'E'){
// 	    if (maze[row][col] == 'E'){
// 		System.out.println("wHOOT!");
// 		return counter;
// 	    }
// 	    int[][] moveSet = {{0,1},{1,0},{0,-1},{-1,0}};
// 	    for (int i = 0; i < moveSet.length; i++){
// 		int newRow = row + moveSet[i][0];
// 		int newCol = col + moveSet[i][1];
// 		if (newRow >= maze.length || newCol >= maze[0].length){
// 		    return -1;
// 		}
// 		if (maze[newRow][newCol] == ' '){
// 		    maze[newRow][newCol] = '@';
// 		    counter += 1;
// 		}
// 		if (solve(newRow,newCol,endRow,endCol,counter) != -1){
// 		    return counter;
// 		}
// 		maze[newRow][newCol] = '.';
// 		counter -= 1;
// 	    }
// 	    return counter;
// 	} else {
// 	    return -1;
// 	}
