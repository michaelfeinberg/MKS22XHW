import java.util.*;
public class MyQueue<T>{
    public MyLinkedList<T> items;
    /*public MyQueue(T item){
	items = new MyLinkedList<T>(item);
	}*/
    public void enqueue(T item){
	items.add(item);
    }
    public T dequeue(){
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

