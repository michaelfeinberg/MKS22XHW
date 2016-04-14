import java.util.*;

public class MyQueue<T>{
    public MyLinkedList<T> items;
    public MyQueue(){
	items = new MyLinkedList<T>();
    }
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
	return  size()==0;
    }
    public static void main(String[]args){
	MyQueue<String> q = new MyQueue<String>();
	System.out.println(q.isEmpty() + " " + q.size());
	q.enqueue("FUCK");
	System.out.println(q.isEmpty() + " " + q.size());
	q.dequeue();
	System.out.println(q.isEmpty() + " " + q.size());
    }
}

