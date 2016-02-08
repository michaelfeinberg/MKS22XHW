
public class Recursion implements hw01{
    public String name(){
	return "Feinberg,Michael";
    }
    public double sqrt(double n){
	if(n>=0){
	    return sqrtHelp(n,n/2);
	}else{
	    IllegalArgumentException a = new IllegalArgumentException();
	    throw a;  
	}
    }
    private double sqrtHelp(double n, double guess){
        if(Math.abs(Math.pow(guess,2) - n) <= 0.000000000000001){
	    return guess;
	}else{
	    return sqrtHelp(n,(n/guess + guess)/2);
	}
    }
}