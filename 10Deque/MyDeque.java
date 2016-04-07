import java.util.*;
import java.io.*;
public class MyDeque<T>{
    private T[] data;
    public int start;
    public int end;
    private int size;
    @SuppressWarnings("unchecked") public MyDeque(){
	data = (T[]) new Object[10];
    }
    @SuppressWarnings("unchecked") private void grow(){
	T[] newData = (T[]) new Object[data.length * 2];
	
	for(int x = start;x<data.length;x++){
	    newData[x] = data[x];
	}
	for(int j = 0; j<start;j++){
	    newData[data.length + j]=data[j];
	}
	end = start + size-1;
	data = newData;
    }
    public void addFirst(T value){
	if(end + 1 == start || (start == 0 && end == data.length-1)){
	    grow();
	    addFirst(value);
        }else{
	    if(size == 0){
		data[start] = value;
	    }else if(start == 0){
		data[data.length-1]=value;
		start = data.length-1;
	    }else{
		data[start-1]=value;
		start--;
	    }
	    size++;
	}
    }
    public void addLast(T value){
	if(end + 1 == start || (start == 0 && end == data.length-1)){
	    grow();
	    addLast(value);
        }else{
	    if(size == 0){
		data[end]=value;
	    }else if(end == data.length-1){
		data[0]=value;
		end=0;
	    }else{
		data[end+1] = value;
		end++;
	    }
	    size++;
	}
    }
    public T removeFirst(){
	if(start == end&&data[start]==null){
	    throw(new NoSuchElementException());
	}else{
	    T ans = data[start];
	    data[start]=null;
	    if(start == data.length-1){
		start = 0;
	    }else{
		start++;
	    }
	    size--;
	    return ans;
	}
    }
    public T removeLast(){
	if(start==end&&data[start]==null){
	    throw(new NoSuchElementException());
	}else{
	    T ans = data[end];
	    data[end]=null;
	    if(end==0){
		end = data.length-1;
	    }else{
		end--;
	    }
	    size--;
	    return ans;
	}
    }
    public T getFirst(){
	if(start==end&&data[start]==null){
            throw(new NoSuchElementException());
	}else{
	    return data[start];
	}
    }
    public T getLast(){
	if(start==end&&data[start]==null){
            throw(new NoSuchElementException());
	}else{
	    return data[end];
	}
    }
    public String toString(){
	String ans = "[";
	for(int i = 0;i<data.length;i++){
	    ans += data[i] + ", ";
	}
	return ans.substring(0,ans.length()-2)+"]";
    }
    public int size(){
	return size;
    }
    public static void main(String[]args){
        MyDeque<Integer> d = new MyDeque<Integer>();
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
 
        // Limit the number of times addFirst and addLast is done
 
        int limit = 0;
 
        if (args.length > 0) {
            limit = Integer.parseInt(args[0]);
        }
 
        // Add to the head and to the tail
 
        for (int i = 0; i < limit; i++) {
            Integer r1 = (int) (Math.random() * 10);
	  
            // Add to either the beginning or end
	    if (Math.random()*2 < 1) {
		d.addFirst(r1);
		ad.addFirst(r1);
		//System.out.println(d.size);
		//System.out.println(d);
		//System.out.println("First");
	    }
	    else {
		d.addLast(r1);
		ad.addLast(r1);
		//System.out.println(d.size);
		//System.out.println(d);
		//System.out.println("Last");
	    }
        }
       
	//System.out.println(d);
	//System.out.println(ad);
        // Test if adding worked by removing elements
 
        for (int i = 0; i < limit/2; i++) {
	   
            if (!d.getFirst().equals(ad.getFirst())) {
                System.out.println(d.getFirst() + " " + ad.getFirst());
		System.out.println("Test #0 (addFirst) failed at: " + i + "!");
                System.exit(0);
            }
 
            if (!d.getLast().equals(ad.getLast())) {
                System.out.println("Test #1 (addLast) failed at: " + i + "!");
                System.exit(0);
            }
       
            if (!d.removeFirst().equals(ad.removeFirst())) {
                System.out.println("Test #2 (removeFirst) failed at: " + i + "!");
                System.exit(0);
            }
 
            if (!d.removeLast().equals(ad.removeLast())) {
                System.out.println("Test #3 (removeLast) failed at: " + i + "!");
                System.exit(0);
            }
        }
 
        // Sizes should be equal
 
        if (d.size() != ad.size()) {
            System.out.println("Not equal sizes. Error!");
            System.exit(0);
        }
 
        System.out.println("Success!");
	
	
	/*MyDeque<Integer> a = new MyDeque<Integer>();
	ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
	a.addLast(4);
	for(int i = 0;i<8;i++){
	    System.out.println(a.start + " " + a.end+ " " + a.size());
	    System.out.println(a);
	    if(Math.random()*2>=1){
		a.addFirst(i);
	    }else{
		a.addLast(i);
	    }
	}
	System.out.println(a);
	*/
	//System.out.println(a.size());
	//for(int i = 0;i<5;i++){
	//    System.out.println(a.start +" " + a.end);
	//    System.out.println(a.removeFirst());
	//}
	
	
    }
}