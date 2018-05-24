import java.util.*;
import java.io.*;
public class USACO{
    //public int[][] map = {{28,25,20,32,34,36},
    //                      {27,25,20,20,30,34},
    //                     {24,20,20,20,20,30},
    //                      {20,20,14,14,20,20}};
    public static int bronze(String filename){
	try{
	    int[][] map;
	    int row,col,llevel,numInstruc, sum;
	    File file = new File(filename);
	    Scanner in = new Scanner(file);
	    //Adding values from beginning of file
	    String[] valueStr = in.nextLine().split(" ");
	    row = Integer.parseInt(valueStr[0]);
	    col = Integer.parseInt(valueStr[1]);
	    llevel = Integer.parseInt(valueStr[2]);
	    numInstruc = Integer.parseInt(valueStr[3]);
	    sum = 0;
	    map = new int[row][col];
	    for(int r = 0; r < row; r++){
		String newLine = in.nextLine();
		String[] values = newLine.split(" ");
		for (int c = 0; c < col; c++){
		    map[r][c] = Integer.parseInt(values[c]); 
		}
	    }
	    String newLine;
	    String[] instructions;
	    for (int i = 0; i < numInstruc; i++){
		newLine = in.nextLine();
		// Testing purposes: System.out.println(newLine);
		instructions= newLine.split(" ");
		reduce3by3(map,
			   Integer.parseInt(instructions[0]),
			   Integer.parseInt(instructions[1]),
			   Integer.parseInt(instructions[2]));
	    }
	    for (int rows = 0; rows < row; rows++){
		for (int cols = 0; cols < col; cols++) {
		    map[rows][cols] -= llevel;
		}
	    }
	    for (int rows = 0; rows < row; rows++){
		for (int cols = 0; cols < col; cols++) {
		    if (map[rows][cols] < 0){
			sum += Math.abs(map[rows][cols]);
		    }
		}
	    }
	    return sum * 72 * 72;
	}
	catch(FileNotFoundException e){
	    return 0;    
	}
    }
    public void print(int[][] map){
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
	System.out.println(result);
    }

    private static void reduce3by3(int[][] map,int row, int col, int increment){
	int[][] blocks = {{-1,-1},
			  {1,1},
			  {1,-1},
			  {-1,1},
			  {0,-1},
			  {-1,0},
			  {1,0},
			  {0,1},
			  {0,0}};
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
    public static int silver(String filename){
	int[][] pasture;
	int row, col, time, initialRow, initialCol, finalRow, finalCol;
	try{
	    File file = new File(filename);
	    Scanner in = new Scanner(file);
	    //Adding values from beginning of file
	    String[] DiamondAndPearl = in.nextLine().split(" ");
	    row = Integer.parseInt(DiamondAndPearl[0]);
	    col = Integer.parseInt(DiamondAndPearl[1]);
	    time = Integer.parseInt(DiamondAndPearl[2]);
	    pasture = new int[row][col];
	    for(int r = 0; r < row; r++){
		String newLine = in.nextLine();
		System.out.println(newLine);
		String[] values = newLine.split("");
		for (int c = 0; c < col; c++){
		    if(values[c].equals(".")){
			pasture[r][c] = 0;
		    } else {
			pasture[r][c] = -1;
		    }
		}
		//System.out.println(newLine);
	    }
	    String newLine;
	    String[] instructions;
	    newLine = in.nextLine();
	    // Testing purposes: System.out.println(newLine);
	    instructions= newLine.split(" ");
	    initialRow = Integer.parseInt(instructions[0])-1;
	    initialCol = Integer.parseInt(instructions[1])-1;
	    finalRow = Integer.parseInt(instructions[2])-1;
	    finalCol = Integer.parseInt(instructions[3])-1;
	    pasture[initialRow][initialCol] = 1;
	    String result = "";
	    for (int i = 0; i < pasture.length; i++){
		for (int j = 0; j < pasture[0].length; j++){
		    result += pasture[i][j];
		}
		result += "\n";
	    }
	    System.out.println(result);
	    for (int timer = 0; timer < time; timer++){
		pasture = pastureConverter(pasture,row,col);
		result = "";
		for (int i = 0; i < pasture.length; i++){
		    for (int j = 0; j < pasture[0].length; j++){
			result += pasture[i][j];
		    }
		    result += "\n";
	    }
	    System.out.println(result);

	    }
	    result = "";
	    for (int i = 0; i < pasture.length; i++){
		for (int j = 0; j < pasture[0].length; j++){
		    result += pasture[i][j];
		}
		result += "\n";
	    }
	    System.out.println(result);
	    return pasture[finalRow][finalCol];
	}
	catch(FileNotFoundException e){
	    return 0;    
	}
    }

    public static int[][] pastureConverter2(int[][] pasture, int row, int col){
	return pasture;
    }
    
    public static int[][] pastureConverter(int[][] pasture, int row, int col){
	int[][] Convent = new int[row][col];
	int[][] MoveSet = {{0,1},
			   {0,-1},
			   {1,0},
			   {-1,0}};
	int newRow, newCol;
	for (int r = 0; r < row; r++){
	    for (int c = 0; c < col; c++){
		for (int i = 0; i < 4; i++){
		    newRow = r+MoveSet[i][0];
		    newCol = c+MoveSet[i][1];
		    if (newRow >= 0 && newRow < row &&
			newCol >= 0 && newCol < col){
			if (pasture[newRow][newCol] != -1){
			    Convent[newRow][newCol] += 1;
			} else {
			    Convent[newRow][newCol] = -1;
			}
		    }
		}
		Convent[r][c] = 0;
	    }
	}
	return Convent;
    }
    public String toString(int[][] Array){
	String result = "";
	for (int i = 0; i < Array.length; i++){
	    for (int j = 0; j < Array[0].length; j++){
		result += Array[i][j];
	    }
	    result += "\n";
	}
	return result;
    }
    public static void main(String[] Args){
	//Bronze Driver
	//System.out.println(bronze("bronzeTest1.in"));
	System.out.println(silver("silverTest1.in"));
    }
}
//virtual insanity
