public class Driver{
    public static void main(String[]args){
	int input = 1;
	if(args.length>0){
	    input = Integer.parseInt(args[0]);
	}
	String fileName = "data" + input + ".dat";
	//Loads from file
	BetterMaze m = new BetterMaze(fileName);
	//Sets animate
	m.setAnimate(true);
	m.clearTerminal();
	//Runs
	System.out.println(m.solveBFS());
    }
}