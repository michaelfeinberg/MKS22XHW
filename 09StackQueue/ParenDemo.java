public class ParenDemo{
    public static boolean isMatching(String s){
	MyStack<String> L = new MyStack<String>();
	for(int i = 0;i<s.length();i++){
	    String a = s.substring(i,i+1);
	    //System.out.println(a);
	    if(a.equals("[") || a.equals("{") || a.equals("(") || a.equals("<")){
		L.push(a);
	    }else if(a.equals("]") || a.equals("}") || a.equals(")") || a.equals(">")){
		if(L.isEmpty()){
		    return false;
		}
		//System.out.println(a + " " + L.peek());
		String b = L.pop();
		if(!matchingParens(b,a)){
		    return false;
		}
	    }else{

	    }
	}
	return L.isEmpty();
    }
    public static boolean matchingParens(String a, String b){
	return ((a.equals("(")&&b.equals(")"))||
		(a.equals("{")&&b.equals("}"))||
		(a.equals("[")&&b.equals("]"))||
		(a.equals("<")&&b.equals(">")));
    }
    public static void main(String[]args){
	System.out.println(isMatching("[ ( { } ) ]"));
	System.out.println(isMatching("[FISHIES]"));
	System.out.println(isMatching("[FISH(I)ES]"));
	System.out.println(isMatching("[FISHIES][][][]"));
	System.out.println(isMatching(")[ ( { } ) ]"));
	System.out.println(isMatching("()"));
	System.out.println(isMatching("[({})}"));


    }
}