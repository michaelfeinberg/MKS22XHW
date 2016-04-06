import java.util.*;
import java.io.*;
public class MyDeque<T>{
    private T[] data;
    private int start;
    private int end;
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
	data = newData;
    }
    public void addFirst(T value){
	if(end + 1 == start || (start == 0 && end == data.length)){
	    grow();
	    addFirst(value);
        }else{
	    if(start == 0){
		data[data.length-1]=value;
		start = data.length-1;
	    }else{
		data[start-1]=value;
		start--;
	    }
	}
    }
    public void addLast(T value){
	if(end + 1 == start || (start == 0 && end == data.length)){
	    grow();
	    addLast(value);
        }else{
	    if(end == data.length-1){
		data[0]=value;
		end=0;
	    }else{
		data[end + 1] = value;
		end++;
	    }
	}
    }
    public T removeFirst(){
	if(start == end){
	    throw(new NoSuchElementException());
	}else{
	    T ans = data[start];
	    data[start]=null;
	    if(start == data.length){
		start = 0;
	    }else{
		start++;
	    }
	    return ans;
	}
    }
    public T removeLast(){
	if(start==end){
	    throw(new NoSuchElementException());
	}else{
	    T ans = data[end];
	    data[end]=null;
	    if(end==0){
		end = data.length;
	    }else{
		end--;
	    }
	    return ans;
	}
    }
    public T getFirst(){
	if(start==end){
            throw(new NoSuchElementException());
	}else{
	    return data[start];
	}
    }
    public T getLast(){
	if(start==end){
            throw(new NoSuchElementException());
	}else{
	    return data[end];
	}
    }
    public static void main(String[]args){

    }
}