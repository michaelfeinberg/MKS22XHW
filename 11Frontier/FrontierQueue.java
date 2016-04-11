import java.util.*;
import java.io.*;
public class FrontierQueue<T> extends MyQueue<T> implements Frontier<T>{`
    public void add(T element){
	enqueue(element);
    }
    public T next(){
	if(isEmpty()){
	    throw(new NoSuchElementException());
	}else{
	    return dequeue();
	}
    }
    public boolean hasNext(){
	return isEmpty();
    }
}