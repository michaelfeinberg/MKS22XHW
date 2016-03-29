import java.util.*;
public class MyStack<T>{
    public MyLinkedList<T> items;
    public void push(T item){
	items.add(0,item);
    }
    public T pop(){
	if(isEmpty()){
	    throw(new NoSuchElementException());
	}else{
	    return items.remove(0);
	}
    }
    public T peek(){
	if(isEmpty()){
	                throw(new NoSuchElementException());
	}else{
	    return items.get(0);
	}
    }
    public int size(){
	return items.size();
    }
    public boolean isEmpty(){
	return items.size()==0;
    }
}
