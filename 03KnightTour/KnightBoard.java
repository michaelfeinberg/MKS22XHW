
public class KnightBoard{
    public int[][] board;
    public int x;
    public KnightBoard(int n){
	board = new int[n][n];
	x = 0;
    }
    public KnightBoard(int row,int col){
	board = new int[row][col];
	x = 0;
    }
    public boolean closedSolve(){
	return ClosedSolveHelp(1,0,0);
    }
    public boolean ClosedSolveHelp(int count,int row,int col){
	//try{
	//  Thread.sleep(1000);
        //}catch(InterruptedException a){
	//}
	x++;
	//System.out.println(x);
        if(row>=board.length||row<0||col>=board[0].length||col<0){
	    return false;
	}
	for(int i = 0;i<board.length;i++){
	    for(int j = 0;j<board[0].length;j++){
		if(board[i][j]>=count){
		    board[i][j]=0;
		}
	    }
	}
	if(count == board.length*board[0].length+1){
	    if(board[row][col]== 1){
		return true;
	    }else{
		return false;
	    }
    	}else if(board[row][col]>0){
	    return false;
	}else{
	    board[row][col]=count;
	    return (ClosedSolveHelp(count+1,row+2,col+1)||
		    ClosedSolveHelp(count+1,row+2,col-1)||
		    ClosedSolveHelp(count+1,row+1,col+2)||
		    ClosedSolveHelp(count+1,row+1,col-2)||
		    ClosedSolveHelp(count+1,row-1,col+2)||
		    ClosedSolveHelp(count+1,row-1,col-2)||
		    ClosedSolveHelp(count+1,row-2,col+1)||
		    ClosedSolveHelp(count+1,row-2,col-1));
	}
    }
    public boolean solve(){
	return solveHelp(1,0,0);
    }
    public boolean solveHelp(int count,int row,int col){
	x++;
	if(row>=board.length||row<0||col>=board[0].length||col<0){
            return false;
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j]>=count){
                    board[i][j]=0;
                }
            }
        }
        if(count == board.length*board[0].length+1){
	    return true;
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
	for(int j = 0;j<board[0].length;j++){
	    if(board[n][j]<10){
		ans += board[n][j] + "  ";
	    }else{
		ans += board[n][j] + " ";
	    }
	}
	return ans;
    }
    public static void main(String[]args){
	KnightBoard K;
	if(args.length > 1){
	    K = new KnightBoard(Integer.parseInt(args[0]),
				Integer.parseInt(args[1]));
	}else{
	    K = new KnightBoard(Integer.parseInt(args[0]));
	}
	System.out.println(K.solve());
	System.out.println(K.x + " recursive calls");
	K.printSolution();
    }
}