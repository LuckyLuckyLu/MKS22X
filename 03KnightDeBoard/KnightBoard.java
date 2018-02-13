public class KnightBoard{
    private int[][] board;
    public KnightBoard(int row, int col){
	board = new int[row][col];
	/*
	//int x = 0;
	for (int i = 0; i < row; i++){
	    for (int j = 0; j < col; j++){
		board[i][j] = x;
		//	x += 1;
	    }
	}
	*/
    }

    public String toString(){
	String result = "";
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[0].length; j++){
		if (board[i][j] / 10 >= 1){
		    result += " " + board[i][j];
		} else {
		    result += " _" + board[i][j];
		}
	    }
	    result += "\n";
	}
	return result;
    }
	    

    public boolean solve(int row, int col){
	return true;
    }

    private boolean solveH(int row, int col, int level){
	return true;
    }

    public int countSolutions(){
	return 0;
    }

    private int countHelp(int counter){
	return 0;
    }

    public static void main(String[] Args){
	KnightBoard y = new KnightBoard(5,10);
	System.out.println(y);
    }
}
