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
	board[r][c] = -1;
	UpDiaLazer(r,c);
	DownDiaLazer(r,c);
	StraightLazer(r,c);
	return true;
    }
    private void UpDiaLazer(int r, int c){
	for (int i = r; i < board.length; i++){
	    for (int j = c; j < board.length; j++){
		board[i][j] -= 1;
	    }
	}
    }
    private void DownDiaLazer(int r, int c){
	for (int i = r; i < board.length; i--){
	    for (int j = c; j < board.length; j++){
		board[i][j] -= 1;
	    }
	}
    }
    private void StraightLazer(int r, int c){
	for (int i = r; i < board.length; i++){
	    board[i][c] -= 1;
	}
    }
    private boolean rmQueen(int r, int c){
	return true;
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

     *        true when the board is solveable, and leaves the board in a solved state

     *@throws IllegalStateException when the board starts with any non-zero value

     */
    public boolean solve(){return false}
  
    /**
     *@return the number of solutions found, and leaves the board filled with only 0's
     *@throws IllegalStateException when the board starts with any non-zero value
     */
    public int countSolutions(){return 0}
    
    public static void main(String[] args){
	System.out.println();
    }
}
