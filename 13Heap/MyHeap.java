 import java.util.*;
@SuppressWarnings("unchecked") public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] data;
    boolean isMax;

    public MyHeap(){
	size = 0;
	T[] data = (T[])(new Comparable[3]);
    }

    public MyHeap(T[] array){
	data = (T[])(new Comparable[array.length+1]);
	size = array.length;
	//data[0] = size;
	for(int i = 1;i<data.length;i++){
	    data[i] = array[i-1];
	}
	heapify();
    }
    private boolean checkIndex(int index){
	return (index < data.length && index > 1);
    }
    private void pushDown(int k){
	if(isMax){
	    while(checkIndex(2*k+1)){
		if(data[2*k].compareTo(data[k])>0 || data[2*k+1].compareTo(data[k])>0){
		    if(data[2*k].compareTo(data[2*k+1])>0){
			T temp = data[2*k];
			data[2*k] = data[k];
			data[2*k] = temp;
			k *= 2;
		    }else{
			T temp = data[2*k+1];
			data[2*k+1] = data[k];
			data[2*k+1] = temp;
			k = k*2 + 1;

		    }
		}
	    }
	}else{
	    while(checkIndex(2*k+1)){
		if(data[2*k].compareTo(data[k])>0 || data[2*k+1].compareTo(data[k])<0){
		    if(data[2*k].compareTo(data[2*k+1])<0){
			T temp = data[2*k];
                        data[2*k] = data[k];
			data[2*k] = temp;
			k *= 2;
		    }else{
                        T temp = data[2*k+1];
                        data[2*k+1] = data[k];
                        data[2*k+1] = temp;
                        k = k*2 + 1;
		    }
		}
	    }
	}
    }
    private void pushUp(int k){
	if(isMax){
	    while(checkIndex(k/2)){
		if(data[k].compareTo(data[k/2])>0){
		    T temp = data[k];
		    data[k] = data[k/2];
		    data[k/2] = temp;
		    k /= 2;
		}
	    }
	}else{
	    while(checkIndex(k/2)){
		if(data[k].compareTo(data[k/2])<0){
		    T temp = data[k];
		    data[k] = data[k/2];
		    data[k/2] =temp;
		    k /= 2;
		}
	    }
	}
    }
    
    private void heapify(){
	for(int j = size/2; j > 0;j--){
	    pushDown(j);
	}
    }
    public void doubleSize(){
	T[] newAry = (T[])(new Comparable[size*2]);
	for(int i = 0;i<data.length;i++){
	    newAry[i]=data[i];
	}
	data = newAry;
    }
    public T delete(){
	T temp = data[1];
	data[1] = data[size];
	data[size] = null;
	size--;
	pushDown(1);
	return temp;
    }
    public void add(T x){
	if(size+1>=data.length){
	    doubleSize();
	    add(x);
	}else{
	    data[size+1]=x;
	    pushUp(size+1);
	    size++;
	}
    }
    public String toString(){
	String ans = "[";
	for(int index = 1;index<data.length;index++){
	    ans += data[index] + ", ";
	}
	return ans.substring(0,data.length-2) + "]";
    }
    
    //do this last
    public MyHeap(boolean isMax){
	data = (T[])(new Comparable[3]);
	this.isMax = isMax;
	size = 0;
    }
    public MyHeap(T[] array, boolean isMax){
	data = (T[])(new Comparable[array.length+1]);
	this.isMax = isMax;
	size = array.length;
	//data[0] = size;
	for(int i = 1;i<data.length;i++){
	    data[i]=array[size-1];
	}
	heapify();
    }
    }