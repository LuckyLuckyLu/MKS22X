import java.util.*;
import java.io.*;
public class USACO{
  private int[][] map;
  public USACO(){
    int[][] map = {
      {1,2,3,4,5,6},
      {28,25,20,32,34,36},
      {27,25,20,20,30,34},
      {24,20,20,20,20,30},
      {20,20,14,14,20,20}};
  }
  public static int bronze(String filename){
      //fileReader(filename);
      return 0;
  }
  
  public static int silver(String filename){
    try {
         File file = new File(filename);
         Scanner in = new Scanner(file);
         while(in.hasNextLine()){
         }
    }
    catch(FileNotFoundException e){
      System.out.println("You suck.");
      System.exit(1);
    }
    return 0;
		
  }
  public String toString(){
    String result = "";
    for (int row = 0; row < map.length; row++){
      for (int col = 0; col < map[0].length; col++){
        result += map[row][col];
      }
      result += "\n";
    }
    return result;
  }
  
  public static String fileReader(String filename){
    try{
  	File file = new File(filename);
  	Scanner in = new Scanner(file);
  	while(in.hasNextLine()){
          String newLine = in.nextLine;
	
    	    }
      }
  
      catch(FileNotFoundException e){
        throw new FileNotFoundException(;
      }
  
    }
  public static void main(String[] Args){
    USACO thing = new USACO();
    System.out.println(thing);
  }
}

