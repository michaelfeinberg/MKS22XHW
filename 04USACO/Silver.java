import java.io.*;
import java.util.*;
public class Silver{
    int[][] moves;
    int R1,C1,R2,C2,T;
    public Silver(String filename){
	try{
	    Scanner in = new Scanner(new File(filename));
	    int L = 1;
	    int N = 0;
	    int M = 0;
	    T = 0;
	    while(in.hasNext()){
		String str = in.nextLine();
		Scanner line = new Scanner(str);
		if(L == 1){
		    N = line.nextInt();
		    M = line.nextInt();
		    T = line.nextInt();
		    moves=new int[N][M];
		}else if(L<=N+1){
		    for(int i = 0;i<M;i++){
			if(str.charAt(i)=='.'){
			    moves[L-2][i]=0;
			}else if(str.charAt(i)=='*'){
			    moves[L-2][i]=-1;
			}
		    }
		}else{
		    R1 = line.nextInt();
		    C1 = line.nextInt();
		    R2 = line.nextInt();
		    C2 = line.nextInt();
		}
		L++;
	    }
	}catch(FileNotFoundException a){
	    System.out.println("File Does Not Exist");
	}
    }
    public int solve(){
	moves[R1-1][C1-1]=1;
	for(int t = 1; t<=T;t++){
	    calculate();
	}
	return moves[R2-1][C2-1];
    }
    public void calculate(){
	int[][] data = new int[moves.length][moves[0].length];
	int sum = 0;
	for(int i = 0;i<moves.length;i++){
	    for(int j = 0;j<moves[0].length;j++){
		sum = 0;
		if(i<moves.length-1){
		    if(moves[i+1][j]>0){
			sum+=moves[i+1][j];
		    }
		}
		if(i>0){
		    if(moves[i-1][j]>0){
			sum+=moves[i-1][j];
		    }
		}
		if(j>0){
		    if(moves[i][j-1]>0){
			sum+=moves[i][j-1];
		    }
		}
		if(j<moves[0].length-1){
		    if(moves[i][j+1]>0){
			sum+=moves[i][j+1];
		    }
		}
		if(moves[i][j]>=0){
		    data[i][j]=sum;
		}else{
		    data[i][j]=-1;
		}
	    }
	}
	moves = data;
	//System.out.println(toString());
    }
    public String toString(){
	String ans="";
	for(int i = 0;i<moves.length;i++){
	    for(int j = 0;j<moves[0].length;j++){
		ans+=moves[i][j]+ " ";
	    }
	    ans +="\n";
	}
	return ans;
    }
    public static void main(String[]args){
	Silver s1 = new Silver("pasture.in");
	int n = s1.solve();
	System.out.println(n + ",7,Feinberg,Michael");
    }
}