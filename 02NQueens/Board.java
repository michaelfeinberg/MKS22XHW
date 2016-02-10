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
	    ans += board[row][j]+"";
	}
	return ans + "\n";
    }
    public void clear(){
	board = new int[board.length][board.length];
    }
    public boolean solve(){
	return solveHelp(0,0);
    }
    public boolean solveHelp(int startCol,int startRow){
        if(startCol==board.length-1){
	    return(findFirstSpace(startCol,startRow)>0);
	    
	}else if(findFirstSpace(startCol,startRow)==-1){
	    return false;
	}else{ 
	    addQueen(startCol,findFirstSpace(startCol,startRow));
	    if( solveHelp(startCol+1,0) ){
		return true;
	    }else{
		remQueen(startCol,findFirstSpace(startCol,startRow));
		return solveHelp(startCol,findFirstSpace(startCol,findFirstSpace(startCol,startRow)));
	    }
	}
    }
    public int findFirstSpace(int col,int startRow){
	for(int x = startRow+1;x<board.length;x++){
	    if(board[col][x]==0){
		return x;
	    }
	}
	return -1;
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
	    if(r>0){
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
		if(r>0){
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
	Board b = new Board(4);
	b.addQueen(0,0);
	System.out.println(b);
	b.remQueen(0,0);
	System.out.println(b);
	System.out.println(b.solve());
	Board b2 = new Board(2);
	Board b3 = new Board(3);
	Board b8 = new Board(8);
	System.out.println(b2.solve());
	System.out.println(b3.solve());
	System.out.println(b8.solve());
	System.out.println(b2);
	System.out.println(b3);
    }
}