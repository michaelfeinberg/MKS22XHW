import java.io.*;
import java.util.*;
public class BetterMaze{
    private char[][] maze;
    private int[] solution;
    private int startRow,startCol;
    private Frontier<Node> placesToGo;
    private boolean animate;

    /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
     **/
    public BetterMaze(String filename){
	animate = false;
	startRow = -1;
	startCol = -1;
	try{
	    Scanner in = new Scanner(new File(filename));
	    ArrayList<String> lines = new ArrayList<String>();
	    while(in.hasNextLine()){
		lines.add(in.nextLine());
	    }
	    maze = new char[lines.size()][lines.get(0).length()];
	    for(int i = 0;i<lines.size();i++){
		String L = lines.get(i);
		for(int j = 0;j<L.length();j++){
		    maze[j][i]=L.charAt(j);
		    if(L.charAt(j)=='S'){
			startCol = i;
			startRow = j;
		    }
		}
	    }
	}catch(FileNotFoundException E){
	    System.out.println("The file does not exist");
	}
	
    }
    private class Node{
	private int[] coor;
	private Node prev;
	public Node(int x, int y){
	    coor = new int[2];
	    coor[0] = x;
	    coor[1] = y;
	}
	public Node(int x, int y, Node p){
	    coor = new int[2];
	    coor[0] = x;
	    coor[1] = y;
	    prev = p;
	}
	public int getX(){
	    return coor[0];
	}
	public int getY(){
	    return coor[1];
	}
	public Node getPrev(){
	    return prev;
	}
    }
    public int[] solutionCoordinates(){
        return new int[0];      
    }    

    /**initialize the frontier as a queue and call solve
     **/
    public boolean solveBFS(){  
        placesToGo = new FrontierQueue<Node>();
	return solve();
    }   

   /**initialize the frontier as a stack and call solve
    **/ 
    public boolean solveDFS(){  
        placesToGo = new FrontierStack<Node>();
	return solve();
	
    }    

   /**Search for the end of the maze using the frontier. 
      Keep going until you find a solution or run out of 
      elements on the frontier.
    When animate is true, print the maze each time you 
    process a new node.
    **/
    private boolean solve(){
	System.out.println(this);
	Node x = new Node(startRow,startCol);
	System.out.println(x.getX()+ " " + x.getY());
	placesToGo.add( new Node(startCol,startRow));
	placesToGo.add(x);
	//if(placesToGo.next()==null){
	//return true;
	//}
	
	//placesToGo.add(start);
	System.out.println(placesToGo.hasNext());
	
	while(placesToGo.hasNext()){
	    if(process(placesToGo.next())){
		return true;
	    }
	}
	//If while loop finishes, there is no solution
	return false;
    }
    public boolean process(Node current){
	System.out.println(current.getX() + " " + current.getY());
	//Add neighbors to Stack or Queue                                                                                                                    
	for(Node n : getNeighbors(current)){
	    placesToGo.add(n);
	}
	//Check for end Node
	if(maze[current.getY()][current.getX()]=='E'){
	    return true;
	}else{
	    maze[current.getY()][current.getX()]='.';
	    if(animate==true){
		System.out.println(this);
		wait(100);
	    }
	    return false;
	}
    }
     
   /**mutator for the animate variable  **/
    public void setAnimate(boolean b){
	animate = b;
    }
    public ArrayList<Node> getNeighbors(Node n){
	ArrayList<Node> ans = new ArrayList<Node>();
	int x = n.getX();
	int y = n.getY();
	if(y < maze.length-1 && maze[y+1][x]==' '){
	    ans.add(new Node(x,y+1,n));
	}
	if(y > 0 && maze[y-1][x]==' '){
	    ans.add(new Node(x,y-1,n));
	}
	if(x < maze[0].length-1 && maze[y][x+1]==' '){
	    ans.add(new Node(x+1,y,n));
	}
	if(x > 0 && maze[y][x-1]==' '){
	    ans.add(new Node(x-1,y,n));
	}
	return ans;
    }
    public String toString(){
        int maxx = maze.length;
        int maxy = maze[0].length;
        String ans = "";
        if(animate){
            ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
        }
        for(int i = 0; i < maxx * maxy; i++){
            if(i % maxx == 0 && i != 0){
                ans += "\n";
            }
            char c =  maze[i % maxx][i / maxx];
            if(c == '#'){
                ans += color(38,47)+c;
            }else{
		ans += color(32,40)+c;
            }
        }
        return HIDE_CURSOR + go(0,0) + ans + "\n" + SHOW_CURSOR + color(37,40);
    }
    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    //terminal specific character to move the cursor                                                                                   
    private String go(int x,int y){
        return ("\033[" + x + ";" + y + "H");
    }
    
    private String color(int foreground,int background){
        return ("\033[0;" + foreground + ";" + background + "m");
    }
    
    private void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }
    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }
    
}