import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class MazeSolver{
    private char[][] maze;
    private boolean animate;
    private int Srow, Scol, Erow, Ecol, rows, cols;
    private Frontier frontier;

    public MazeSolver(String fileName) throws FileNotFoundException{
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
		    Srow = rows;
		    Scol = cols;
                }
                if (contents.charAt(index) == 'E'){
                    eTimes += 1;
		    Erow = rows;
		    Ecol = cols;
                }
                maze[i][j] = contents.charAt(index);
                index += 1;
            }
        }
        if (eTimes != 1 || sTimes != 1){
            throw new IllegalStateException();
        }
    }
    //Default to BFS
    public boolean solve(){
	return solve(0);
    }

    //mode: required to allow for alternate solve modes.
    //0: BFS
    //1: DFS
    public boolean solve(int mode){
	if (mode == 0){
	    frontier = new FrontierQueue();
	    
	    while(frontier.hasNext()){
		
	    }
	} else if (mode == 1){

	}   
	
	//initialize your frontier
	//while there is stuff in the frontier:
	//  get the next location
	//  process the location to find the locations (use the maze to do this)
	//  check if any locations are the end, if you found the end just return true!
	//  add all the locations to the frontier
	//when there are no more values in the frontier return false
	return false;
    }

    public String toString(){
	return maze.toString();
    }
}
