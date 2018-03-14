import java.util.*;
import java.io.*;
public class USACO{
    private int[][] map = {{28,25,20,32,34,36},
			   {27,25,20,20,30,34},
			   {24,20,20,20,20,30},
			   {20,20,14,14,20,20}};
    public USACO(){
       
    }
    public static int bronze(int[][] map){//String filename){
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
		if (map[row][col] / 10 >= 1){
		    result += " " + map[row][col];
		} else if (map[row][col] == 0){
		    result += " __";
		} else {
		    result += " _" + map[row][col];
		}	    }
	    result += "\n";
	}
	return result;
    }

    public void reduce3by3(int row, int col, int increment){
	int[][] blocks = {{-1,-1},
			  {1,1},
			  {1,-1},
			  {-1,1},
			  {0,-1},
			  {-1,0},
			  {1,0},
			  {0,1},
			  {0,0}};
	// for (int i = 0; i < blocks.length; i++){
	//     int newRow = row+blocks[i][0];
	//     int newCol = col+blocks[i][1];
	//     if (newRow < map.length &&
	// 	newCol < map[0].length &&
	// 	newRow >= 0 &&
	// 	newCol >= 0){
	// 	map[newRow][newCol] = 0;
	//     }
	// }
	
	int maxValue = map[row][col];
	for (int i = 0; i < blocks.length; i++){
	    int newRow = row+blocks[i][0];
	    int newCol = col+blocks[i][1];
	    if (newRow < map.length &&
		newCol < map[0].length &&
		newRow >= 0 &&
		newCol >= 0){
		int block = map[newRow][newCol];
		if (maxValue < block){
		    maxValue = block;
		}
	    }
	}
	int change = maxValue - increment;
	for (int i = 0; i < blocks.length; i++){
	    int newRow = row+blocks[i][0];
	    int newCol = col+blocks[i][1];
	    if (newRow < map.length &&
		newCol < map[0].length &&
		newRow >= 0 &&
		newCol >= 0){
		int block = map[newRow][newCol];
		if (change < block){
		    map[newRow][newCol] = change;
		}
	    }
	}
    }
  
    public static String fileReader(String filename){
	try{
	    File file = new File(filename);
	    Scanner in = new Scanner(file);
	    while(in.hasNextLine()){
		String newLine = in.nextLine();
	
	    }
	}
  
	catch(FileNotFoundException e){
	    System.out.println("File Not Found Sucker!");
	}
	return " ";
    }
    public static void main(String[] Args){
	USACO thing = new USACO();
	System.out.println(thing);
	thing.reduce3by3(2,2,6);
	System.out.println(thing);
    }
}

