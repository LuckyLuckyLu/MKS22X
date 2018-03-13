import java.io.*; //file, filenotfoundexception
public class MazeDriver{

  public static void main(String[]args){
    try{
	    Maze f;
	    f = new Maze("data1.dat");//true animates the maze.
	    
	    f.setAnimate(true);
	    System.out.println(f.solve());

	    System.out.println(f);

	    Maze f2;
	    f2 = new Maze("data2.dat");//true animates the maze.
	    
	    f2.setAnimate(true);
	    System.out.println(f2.solve());

	    System.out.println(f2);

	    Maze f3;
	    f3 = new Maze("data3.dat");//true animates the maze.
	    
	    f3.setAnimate(true);
	    System.out.println(f3.solve());

	    System.out.println(f3);
    }
    catch(FileNotFoundException e) {
	    System.out.println("You have screwed up the name. I will have your head for that!!!");
    }
  }
}
