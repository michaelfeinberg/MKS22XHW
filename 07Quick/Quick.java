import java.util.*;
import java.io.*;
public class Quick{
    public static int partition(int[]data,int left,int right){
	int index = left + (int)(Math.random()*(right-left));
	//System.out.println(index);
	swap(data,index,right);
	int start = left;
	int end = right - 1;
	while(start < end){
	    //System.out.println(start + " " + end);
	    if(data[start] >= data[right]){
		swap(data,start,end);
		end--;
	    }else{
		start++;
	    }
	}
	//System.out.println(right+ " " + start+" " +end);
	if(data[right]<data[start]){
	    //System.out.println(start);
	    swap(data,start,right);
	    return start;
	}else{
	    //System.out.println(start);
	    swap(data,start+1,right);
	    return start + 1;
	}
    }
    public static int quickselect(int[]data,int k){
	return quickselect(data,k,0,data.length-1);
    }
    public static int quickselect(int[]data,int k,int left,int right){
	if(left == right){
	    return data[k];
	}
	int place = partition(data,left,right);
	if(place == k){
	    return data[k];
	}
	if(k < place){
	    return quickselect(data,k,left,place-1);
	}else{
	    return quickselect(data,k,place+1,right);
	}
    }
    public static void quicksort(int[]data){
	quicksort(data,0,data.length-1);
    }
    public static void quicksort(int[]data,int left,int right){
	if(left!=right&&left<right){
	    int place = partition(data,left,right);
	    if (place < data.length-1){
		quicksort(data,left,place-1);
		quicksort(data,place+1,right);
	    }
	}
    }
    public static void swap(int[] data, int index1, int index2){
	int holder = data[index1];
	data[index1] = data[index2];
	data[index2] = holder;
    }
    public static void main(String[] args){
	
	int[] ary = new int[30];
	for(int i = 0;i<ary.length;i++){
	    ary[i] = (int)(Math.random()*100);
	}
	
    }
}