public class QueenBoard{
    public int[][] board;

    public QueenBoard(int n){
	board = new int[n][n];
    }
    public void printSolution(){
	String ans = "";
	for(int i = 0;i<board.length;i++){
	    ans+=printRow(i);
	}
	System.out.println(ans);
    }
    public String printRow(int row){
	String ans = "";
	for(int j = 0;j<board.length;j++){
	    if(board[row][j]==1){
		ans += "Q ";
	    }else{
		ans += "_ ";
	    }
	}
	return ans + "\n";
    }
    public void clear(){
	board = new int[board.length][board.length];
    }
    public boolean solve(){
	return solveHelp(0);
    }
    public boolean solveHelp(int col){
	if(col==board.length-1){
	    if(isSpace(col)){
		for(int x = 0;x<board.length;x++){
		    if(board[x][col]==0){
			board[x][col]=1;
		    }
		}
		return true;
	    }
	    return false;
	}else if(!isSpace(col)){
	    return false;
	    
	}else{
	    for(int j = 0;j<board.length;j++){
		if(board[j][col]==0){
		    addQueen(j,col);
		    if(solveHelp(col+1)){
			return true;
		    }else{
			remQueen(j,col);
		    }
		}
	    }
	    return false;
	}
    }
    public boolean isSpace(int col){
	for(int x = 0;x<board.length;x++){
	    if(board[x][col]==0){
		return true;
	    }
	}
	return false;
    }
    public void addQueen(int row,int col){
	board[row][col] = 1;
	int r = row + 1;
	for(int c = col+1;c<board.length;c++){
	    if(r<board.length){
		board[r][c]-=1;
		r++;
	    }
	}
	r = row-1;
	for(int c = col+1;c<board.length;c++){
	    if(r>=0){
		board[r][c]-=1;
		r--;
	    }    
	}
	for(int c = col+1;c<board.length;c++){
	    board[row][c]-=1;
	}
	
    }
    public void remQueen(int row,int col){
	if(board[row][col]==1){
	    board[row][col] = 0;
	    int r = row + 1;
	    for(int c = col+1;c<board.length;c++){
		if(r<board.length){
		    board[r][c]+=1;
		    r++;
		}
	    }
	    r = row -1;
	    for(int c = col+1;c<board.length;c++){
		if(r>=0){
		    board[r][c]+=1;
		    r--;
		}
	    }
	    for(int c = col+1;c<board.length;c++){
		board[row][c]+=1;
	    }
	    
	}
    }
    public static void main(String[]args){
	QueenBoard b = new QueenBoard(Integer.parseInt(args[0]));
	b.solve();
	b.printSolution();
    }
}