import java.util.*;
import java.io.*;
public class USACO2{
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
		//System.out.println(newLine);
		String[] values = newLine.split("");
		for (int c = 0; c < col; c++){
		    if(values[c].equals(".")){
			pasture[r][c] = 0;
		    } else {
			pasture[r][c] = -1;
		    }
		}
		System.out.println(newLine);
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
	    for (int k = 0; k < row; k++){
		System.out.println(Arrays.toString(pasture[k]));
	    }
	    for(int t = 0; t < time; t++){
		int[][] duplicate = new int[row][col];
		for (int k = 0; k < row; k++){
		    for (int j = 0; j < col; j++){
			if (pasture[k][j] >= 0){
			    //System.out.println(getNeighborSum(pasture,k,j));
			    duplicate[k][j] = getNeighborSum(pasture,k,j);
			} else {
			    duplicate[k][j] = pasture[k][j];
			}
		    }
		}
		pasture = duplicate;
		String result = "";
		for (int i = 0; i < pasture.length; i++){
		    for (int j = 0; j < pasture[0].length; j++){
			result += pasture[i][j] + "   ";
		    }
		    result += "\n";
		}
		System.out.println(result);
	    }
	    return pasture[finalRow][finalCol];
	}
	catch(FileNotFoundException e){
	    return 0;
	}
    }
    public static int getNeighborSum(int[][] array, int row, int col){
	int[][] neighbors = {{-1,0},
			     {1,0},
			     {0,-1},
			     {0,1}};
	int sum = 0;
	for (int i = 0; i < 4; i++){
	    int rInc = neighbors[i][0];
	    int cInc = neighbors[i][1];
	    if (row+rInc < array.length && col+cInc < array[0].length &&
		row+rInc >= 0 && col+cInc >= 0){
		if (array[row+rInc][col+cInc] > 0){
		    sum += array[row+rInc][col+cInc];
		}
	    }
	}
	return sum;
    }
    
    public static void main(String[] Args){
	//Bronze Driver
	//System.out.println(bronze("bronzeTest1.in"));
	System.out.println(silver("silverTest1.in"));
	/*int[][] test = new int[10][10];
	  test[5][5] = 1;
	  int[][] duplicate = new int[10][10];
	  for (int i = 0; i < test.length; i++){
	  for (int j = 0; j < test[0].length; j++){
	  if (duplicate[i][j] == 0){
	  duplicate[i][j] = getNeighborSum(test,i,j);
	  } else {
	  duplicate[i][j] = 0;
	  }
	  }
	  }
	
	  for (int i = 0; i < 10; i++){
	  System.out.println(Arrays.toString(test[i]));
	  }
	  for (int i = 0; i < 10; i++){
	  System.out.println(Arrays.toString(duplicate[i]));
	  }
	*/		       
    }
}
			  
//PAndemonium
