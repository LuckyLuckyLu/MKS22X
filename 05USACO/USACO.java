import java.util.*;
import java.io.*;
public class USACO{
    public static int bronze(String filename){
	fileReader(filename);
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

    public static String fileReader(String filename){
	try{
	    File file = new File(filename);
	    Scanner in = new Scanner(file);
	    while(in.hasNextLine()){
		String newLine = in.nextLine;
		
	    }
	}
	    
	catch(FileNotFoundException e){
	    throw FileNotFoundException;
	}

	}
    }
}
