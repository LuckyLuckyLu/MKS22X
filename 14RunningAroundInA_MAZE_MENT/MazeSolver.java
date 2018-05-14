import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class MazeSolver{
  private Maze maze;
  private Frontier frontier;

  public MazeSolver(String fileName){
    maze = new Maze(fileName);
    //System.out.println(maze);

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
    
    } else if (mode == 1){
      frontier = new FrontierStack();
    } else {
      frontier = new FrontierPriorityQueue();
    }

    frontier.add(maze.getStart());
    Location end = maze.getEnd();

    while (frontier.hasNext()){
      Location Spot = frontier.next();
      Location[] battleFrontier = maze.getNeighbors(Spot);
      for (int i = 0; i < 4; i++){
        Location nextSpot = battleFrontier[i];
        if (nextSpot != null){
          int nextX = nextSpot.getX();
          int nextY = nextSpot.getY();
          char nextValue = maze.get(nextX,nextY);
          if (nextValue == ' '){
            frontier.add(nextSpot);
          }
          if (nextValue == 'E'){
            maze.set(Spot.getX(),Spot.getY(),'.');
            maze.end = new Location(nextX,nextY,Spot);
            end = maze.getEnd();
            while (end.getPrevious() != null && !(end.getPrevious().equals(maze.getStart()))){
              end = end.getPrevious();
              maze.set(end.getX(),end.getY(),'@');
            }
            //System.out.println(maze.toStringColor());
            return true;
          }
        }
      }
      //System.out.println(maze.toStringColor());
      if (maze.get(Spot.getX(),Spot.getY()) != 'S'){
        maze.set(Spot.getX(),Spot.getY(),'.');
      }

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

  public static void main(String[] args){
    MazeSolver x = new MazeSolver("data3.dat");
    System.out.println(x.solve(2));
    System.out.println(x);


  }
}
