public class QueenBoard{
    private int[][] board;
    public QueenBoard(int size){
	board = new int[size][size];
	for (int i = 0; i < size; i++){
	    for (int j = 0; j < size; j++){
		board[i][j] = 0;
	    }
	}
    }
    
    private boolean addQueen(int r, int c){
	if (board[r][c] != 0){
	    return false;
	} else {
	    board[r][c] = -1;
	    UpDiaLazer(r,c);
	    DownDiaLazer(r,c);
	    StraightLazer(r,c);
	    return true;
	}
    }
    private void UpDiaLazer(int r, int c){
	int col = c+1;
	for (int row = r-1; row >= 0; row--){
	    if (col < board.length){
		board[row][col] += 1;
		col += 1;
	    }
	}
    }
    private void DownDiaLazer(int r, int c){
	int col = c+1;
	for (int row = r+1; row < board.length; row++){
	    if (col < board.length){
		board[row][col] += 1;
		col += 1;
	    }
	}
    }
    private void StraightLazer(int r, int c){
	for (int col = c+1; col < board.length; col++){
	    board[r][col] += 1;
	}
    }
    private boolean rmQueen(int r, int c){
	if (board[r][c] != -1){
	    return false;
	} else {
	    board[r][c] = 0;
	    AntiUpDiaLazer(r,c);
	    AntiDownDiaLazer(r,c);
	    AntiStraightLazer(r,c);
	    return true;
	}
    }
    private void AntiUpDiaLazer(int r, int c){
	int col  = c+1;
	for (int row = r-1; row >= 0; row--){
	    if (col < board.length){
		board[row][col] -= 1;
		col += 1;
	    }
	}
    }
    private void AntiDownDiaLazer(int r, int c){
	int col = c+1;
	for (int row = r+1; row < board.length; row++){
	    if (col < board.length){
		board[row][col] -= 1;
		col += 1;
	    }
	}
    }
    private void AntiStraightLazer(int r, int c){
	for (int col = c+1; col < board.length; col++){
	    board[r][col] -= 1;
	}
    }
    /**
     *@return The output string formatted as follows:
     *All numbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     *There are spaces between each symbol:  
     *Q _ _ _
     *_ _ Q _
     * etc.
     */
    public String toString(){
	String result = "";
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board.length; j++){
		//result += board[i][j];
		if (board[i][j] == -1){
		    result += "Q ";
		} else {
		    result += "_ ";
		}
	    }
	    result += "\n";
	}
	return result;
    }
  
    /**
     *@return false when the board is not solveable and leaves the board filled with zeros; 
     *true when the board is solveable, and leaves the board in a solved state
     *@throws IllegalStateException when the board starts with any non-zero value

     */
    public boolean solve(){
	boolean nonZeroPresent = false;
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board.length; j++){
		if (board[i][j] != 0){
		    nonZeroPresent = true;
		}
	    }
	}
	if (nonZeroPresent){
	    throw new IllegalStateException();
	} else {
	    return solHelper(0);
	}
    }

    private boolean solHelper(int col){
	if (col == board.length){
	    return true;
	} else {
	    for (int x = 0; x < board.length; x++){
		if (addQueen(x,col)){
		    if (solHelper(col+1)){
			return true;
		    } else {
			rmQueen(x,col);
		    }
		}
	    }
	}
	return false;
    }
  
    /**
     *@return the number of solutions found, and leaves the board filled with only 0's
     *@throws IllegalStateException when the board starts with any non-zero value
     */
    public int countSolutions(){
	boolean nonZeroPresent = false;
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board.length; j++){
		if (board[i][j] != 0){
		    nonZeroPresent = true;
		}
	    }
	}
	if (nonZeroPresent){
	    throw new IllegalStateException();
	} else {
	    return CountHelper(0);
	}
    }

    private int CountHelper(int col){
	int solutions = 0;
	if (col ==  board.length){
	    return 1;
	}
	for (int x = 0; x < board.length; x++){
	    if (addQueen(x,col)){
		solutions += CountHelper(col+1);
		rmQueen(x,col);
	    }
	}
	return solutions;
    }
    public static void main(String[] args){
	QueenBoard x = new QueenBoard(4);
	//x.addQueen(5,8);
	System.out.println(x);
	//x.rmQueen(1,1);
	//System.out.println(x.addQueen(9,8));
	//System.out.println(x);
	System.out.println(x.countSolutions());
	System.out.println(x);
	x.solve();
	System.out.println(x);

    
	QueenBoard b = new QueenBoard(4);

	System.out.println(b.solve()); //prints true
	System.out.println(b); //prints a valid solution

	try{
	    b.solve();
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"

	try{
	    b.countSolutions();
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"

	for (int i = 0; i < 12; i++){
	    QueenBoard a = new QueenBoard(i);
	    System.out.println("# of Solutions for " + i + ": " + a.countSolutions());
	    /*          Expected Values
			i --> # of Solutions   i --> # of Solutions
			0 --> 1                      6 --> 4
			1 --> 1                      7 --> 40
			2 --> 0                      8 --> 92
			3 --> 0                      9 --> 352
			4 --> 2                    10 --> 724
			5 --> 10                  11 --> 2680
	    */
	    System.out.println(a); //prints out an empty i by i grid of underscores
	}
    }
}
// TODO: change the recursion through addition of parameters.
// TODO: remove redundant code.
