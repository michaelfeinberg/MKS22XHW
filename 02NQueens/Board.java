public class Board{
    public int[][] board;

    public Board(int n){
	board = new int[n][n];
    }
    public String toString(){
	String ans = "";
	for(int i = 0;i<board.length;i++){
	    ans+=printRow(i);
	}
	return ans;
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
	Board b = new Board(Integer.parseInt(args[0]));
	Board b2 = new Board(2);
	Board b3 = new Board(3);
	Board b8 = new Board(8);

	//System.out.println(b2.solve());
	//System.out.println(b3.solve());
	//System.out.println(b8.solve());
	//System.out.println(b2);
	//System.out.println(b8);
	System.out.println(b.solve());
	System.out.println(b);
    }
}