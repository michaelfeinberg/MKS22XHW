import java.util.*;
import java.io.*;
public class MyLinkedList<T>{
    private class LNode{
	private T value;
	private LNode next;
	public LNode(T val){
	    value = val;
	}
	public void setValue(T Value){
	    value = Value;
	}
	public void setNext(LNode Next){
	    next = Next;
	}
	public T getValue(){
	    return value;
	}
	public LNode getNext(){
	    return next;
	}
    }
    public LNode head;
    public LNode tail;
    public int size;
    public boolean add(T value){
	if(head==null){
	    head = new LNode(value);
	    tail = head;
	}else{
	    LNode next = new LNode(value);
	    tail.setNext(next);
	    tail = next;
	}
	size++;
	return true;
    }
    public T get(int index){
	if(index<0||index>=size){
	    throw(new IndexOutOfBoundsException());
	}else{
	    LNode place = head;
	    int x = index;
	    while(x>0){
		place = place.getNext();
		x--;
	    }
	    return place.getValue();
	}
	
    }
    public T set(int index,T newValue){
	if(index<0||index>=size){
	    throw(new IndexOutOfBoundsException());
	}else{
	    LNode place = head;
	    int x = index;
	    while(x>0){
		place = place.getNext();
		x--;
	    }
	    T ans = place.getValue();
	    place.setValue(newValue);
	    return ans;
	}
    }
    public boolean add(int index,T value){
	if(index<0||index>size){
	    throw(new IndexOutOfBoundsException());
	}else if(index == size){
	    add(value);
	    return true;
	}else if(index == 0){
	    LNode newHead = new LNode(value);
	    newHead.setNext(head);
	    head = newHead;
	    size++;
	    return true;
	}else{
	    LNode place = head;
	    int x = index;
	    while(x>1){
		place = place.getNext();
		x--;
	    }
	    LNode restOfList = place.getNext();
	    LNode newIndex = new LNode(value);
	    newIndex.setNext(restOfList);
	    place.setNext(newIndex);
	    size++;
	    return true;
	}
    }
    public T remove(int index){
	if(index<0||index>=size){
	    throw(new IndexOutOfBoundsException());
	}else if(index == 0){
	    T ans = head.getValue();
	    head = head.getNext();
	    size--;
	    return ans;	    
 	}else{
	    LNode place = head;
	    int x = index;
	    while(x>1){
		place=place.getNext();
		x--;
	    }
	    T ans = place.getNext().getValue();
	    if(index == size - 1){
		place.setNext(null);
		size--;
		tail = place;
	    }else{
		place.setNext(place.getNext().getNext());
		size--;
	    }
	    return ans;
	}
    }
    public String toString(){
	String ans = "[";
	LNode p = head;
	while(p!=null){
	    ans+=p.getValue();
	    if(p.getNext()!=null){
		ans+=", ";
	    }
	    p=p.getNext();
	}
	return ans + "]";
    }
    public int size(){
	return size;
    }
    public static void main(String[] args){
	MyLinkedList<String> m = new MyLinkedList<String>();
	for(int i = 0;i<10;i++){
	    m.add(i+"");
	}
	m.add("End");
	System.out.println(m);
	System.out.println(m.size);
	System.out.println(m.get(3));
	try{
	    System.out.println(m.get(11));
	}catch(IndexOutOfBoundsException a){
	    System.out.println("Error Handled");
	    System.out.println(m.get(10));
	}
	System.out.println(m.size());
	System.out.println(m.set(0,"Start"));
	System.out.println(m);
	try{
	    m.set(-4,"Hello");
	}catch(IndexOutOfBoundsException b){
	    System.out.println("Error Handled");
	}
	System.out.println(m.size());
	m.add(0,"Start1");
	System.out.println(m.size());
	m.add(0,"Hello its me");
	System.out.println(m.size());
	m.add(m.size(),"PlZ wOrK");
	System.out.println(m.size());
	System.out.println(m);
	m.remove(0);
	m.remove(7);
	m.remove(m.size()-1);
	System.out.println(m);
    }
}