public class KnightBoard{
    public int[][] board;
    public KnightBoard(int n){
	board = new int[n][n];
    }
    public boolean solve(){
	return solveHelp(1,0,0);
    }
    public boolean solveHelp(int count,int row,int col){
	if(count == board.length*board.length+1){
	    if(board[row][col]== 1){
		return true;
	    }else{
		return false;
	    }
	}else if(row>=board.length||row<0||col>=board.length||col<0){
	    return false;
	}else if(board[row][col]>0){
	    return false;
	}else{
	    board[row][col]=count;
	    return (solveHelp(count+1,row+2,col+1)||
		    solveHelp(count+1,row+2,col-1)||
		    solveHelp(count+1,row+1,col+2)||
		    solveHelp(count+1,row+1,col-2)||
		    solveHelp(count+1,row-1,col+2)||
		    solveHelp(count+1,row-1,col-2)||
		    solveHelp(count+1,row-2,col+1)||
		    solveHelp(count+1,row-2,col-1));
	}
    }
    public void printSolution(){
	String ans = "";
	for(int i = 0;i < board.length; i++){
	    ans += printRow(i) + "\n";
	}
	System.out.println(ans);
    }
    public String printRow(int n){
	String ans = "";
	for(int j = 0;j<board.length;j++){
	    if(board[n][j]<10){
		ans += board[n][j] + "  ";
	    }else{
		ans += board[n][j] + " ";
	    }
	}
	return ans;
    }
    public static void main(String[]args){
	KnightBoard K = new KnightBoard(Integer.parseInt(args[0]));
	System.out.println(K.solve());
	K.printSolution();
    }
}