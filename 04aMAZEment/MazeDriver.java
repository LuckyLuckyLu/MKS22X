import java.io.*; //file, filenotfoundexception
public class MazeDriver{

    public static void main(String[]args){
        try{
	    Maze f;
	    f = new Maze("data1.dat");//true animates the maze.
	    
	    f.setAnimate(true);
	    f.solve();

	    System.out.println(f);
	}
	catch(FileNotFoundException e) {
	    System.out.println("You have screwed up the name. I will have your head for that!!!");
	}
    }
}
