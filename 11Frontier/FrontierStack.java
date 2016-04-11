import java.util.*;
import java.io.*;
public class FrontierStack<T> extends MyStack<T> implements Frontier<T>{
    public void add(T element){
	push(element);
    }
    public T next(){
	if(isEmpty()){
	    throw(new NoSuchElementException());
	}else{
	    return pop();
	}
    }
    public boolean hasNext(){
	return isEmpty();
    }
    
}