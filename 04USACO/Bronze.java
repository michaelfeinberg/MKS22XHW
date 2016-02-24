import java.util.*;
import java.io.*;
public class Bronze{
    private int[][] elevations;
    private int finalE;
    private int[][] instructions; 
    public Bronze(String filename){
	try{
	    Scanner s = new Scanner(new File(filename));
	    int R = s.nextInt();
	    //System.out.println(R);
	    int C = s.nextInt();
	    //System.out.println(C);
	    finalE = s.nextInt();
	    int N = s.nextInt();
	    elevations = new int[R][C];
	    s.nextLine();
	    for(int line = 0;line<R;line++){
		Scanner Line = new Scanner(s.nextLine());
		int Col = 0;
		while(Line.hasNext()){
		    elevations[line][Col]=Line.nextInt();
		    Col++;
		}
	    }
	    instructions = new int[N][3];
	    for(int count = 0;count<N;count++){
		Scanner L = new Scanner(s.nextLine());
		instructions[count][0] = L.nextInt();
		instructions[count][1] = L.nextInt();
		instructions[count][2] = L.nextInt();
	    }
	}catch(FileNotFoundException f){
	    System.out.println("File does not exist");    
	}
    }
    public int calculate(){
	for(int r = 0;r < instructions.length;r++){
	    stomp(instructions[r][0],instructions[r][1],instructions[r][2]);
	}
	findDepths();
	int sum;
	sum = totalDepth();
	return sum * 72 * 72;
    }
    public void findDepths(){
	for(int r = 0;r<elevations.length;r++){
	    for(int c = 0;c<elevations[r].length;c++){
		if(elevations[r][c]>=finalE){
		    elevations[r][c]=0;
		}else{
		    elevations[r][c]= finalE - elevations[r][c];
		}
	    }
	}
    }
    public int totalDepth(){
	int sum = 0;
	for(int r = 0;r<elevations.length;r++){
	    for(int c = 0;c<elevations[r].length;c++){
		sum += elevations[r][c];
	    }
	}
	return sum;
    }
    public void stomp(int row,int col, int depth){
	//System.out.println("" + row+ " "+ col+" "+depth);
	int greatest = elevations[row][col];
	for(int r = row-1;r<row+2;r++){
	    for(int c = col-1;c<col+2;c++){
		if(elevations[r][c]>greatest){
		    greatest = elevations[r][c];
		}
	    }
	}
	for(int r = row-1;r<row+2;r++){
	    for(int c = col-1;c<col+2;c++){
		if(elevations[r][c] > greatest - depth){
		    elevations[r][c] = greatest - depth;
		}
	    }
	}
    }
    public static void main(String[]args){
	String file = args[0];
	Bronze farm = new Bronze(file);
	System.out.println(farm.calculate() +",7,Feinberg,Michael");
    }
}
