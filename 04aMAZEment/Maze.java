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


      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: print a meaningful error and exit the program.

    */

    public Maze(String fileName){
	String contents = "";
        cols = 0;
        rows = 0;
	try{
	    File file = new File(fileName);
	    Scanner in = new Scanner(file);	    
	    while(in.hasNextLine()){
		String line = in.nextLine();
		cols = line.length();
		rows += 1;
		contents += line;
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found: " + fileName);
	    System.exit(1);
	}
	//System.out.println(contents.length());
	int index = 0;
	maze = new char[rows][cols];
	for (int i = 0; i < rows; i++){
	    for (int j = 0; j < cols; j++){
		maze[i][j] = contents.charAt(index);
		index += 1;
	    }
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
	//find the location of the S. 
	for (int i = 0; i < rows; i++){
	    for (int j = 0; j < cols; j++){
		if (maze[i][j] == 'S'){
		    //erase the S
  		    maze[i][j] = '@';
		    //return solve(???,???);
		    return solve(i,j);
		    //and start solving at the location of the s.
		}
	    }
	}
	return 0;
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
    private int solve(int row, int col){ //you can add more parameters since this is private
        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }

        //COMPLETE SOLVE

        return -1; //so it compiles
    }


}