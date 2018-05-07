public class MazeSolver{
    private char[][]maze;
    private boolean animate;
    private int rows, cols; 

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
                }
                if (contents.charAt(index) == 'E'){
                    eTimes += 1;
                }
                maze[i][j] = contents.charAt(index);
                index += 1;
            }
        }
        if (eTimes != 1 || sTimes != 1){
            throw new IllegalStateException();
        }
    }

    
    
}
