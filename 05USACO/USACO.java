import java.util.*;
import java.io.*;
public class USACO{
    public static int bronze(String filename){
	//fileReader(filename);
	int[][] map = {{1,2,3,4,5,6},
		       {28,25,20,32,34,36},
		       {27,25,20,20,30,34},
		       {24,20,20,20,20,30},
		       {20,20,14,14,20,20}};
	return 0;
    }
    
    public static int silver(String filename){
	try (
	     File file = new File(filename);
	     Scanner in = new Scanner(file);
	     while(in.hasNextLine()){
	     }
	     )
	    catch(FileNotFoundException e){
		throw FileNotFoundException;
	    }
	return 0;
		
    }
    public String toString(){
	
    }

    // public static String fileReader(String filename){
    //   try{
    // 	File file = new File(filename);
    // 	Scanner in = new Scanner(file);
    // 	while(in.hasNextLine()){
    //       String newLine = in.nextLine;
		
    // 	    }
    //   }
	    
    //   catch(FileNotFoundException e){
    // 	    throw FileNotFoundException;
    //   }

    // }
}

