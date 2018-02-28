import java.util.*;
import java.io.*;
public class Maze{


    private char[][]maze;
    private boolean animate;//false by default
    private int rows, cols; 
    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      
      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: 
      throw a FileNotFoundException or IllegalStateException
    */

    public Maze(String fileName) throws FileNotFoundException(){
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
	    //System.out.println(contents.length());
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
		if (maze[i][j] = 'E'){
		    endRow = i;
		    endCol = j;
		}
	    }
	}
	return solve(startRow,startCol,endRow,endCol);
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
    private int solve(int row, int col, int endRow, int endCol){ //you can add more parameters since this is private
	//automatic animation! You are welcome.
	if(animate){
	    clearTerminal();
	    System.out.println(this);
	    wait(20);
	}

	//COMPLETE SOLVE
	if (row == endRow && col == endCol){	    
	    int counter = 0;
	    for (int i = 0; i < rows; i++){
		for (int j = 0; j < cols; j++){
		    if (maze[i][j] == '@'){
			counter ++;
		    }
		}
	    }
	    return counter;
	}
	int[][] moveSet = {{0,1},{1,0},{0,-1},{-1,0}};
	for (int i = 0; i < moveSet.length(); i++){
	    int newRow = row + moveSet[x][0];
	    int newCol = col + moveSet[x][1];
	    if (maze[newRow][newCol] == ' '){
		maze[newRow][newCol] = '@';
		return solve(newRow,newCol,endRow,endCol);
	    }
	}
	
	return -1; //so it compiles
    }

    
}

