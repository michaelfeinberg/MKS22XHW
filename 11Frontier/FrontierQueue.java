import java.util.*;
import java.io.*;

public class FrontierQueue<T> extends MyQueue<T> implements Frontier<T>{
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
    public static void main(String[]args){
	FrontierQueue<Integer> b = new FrontierQueue<Integer>();
	b.add(1);
	b.add(234);
	System.out.println(b.next() + " " + b.next());
    }
}