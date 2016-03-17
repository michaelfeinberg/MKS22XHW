import java.util.*;
import java.io.*;
public class Quick{
    public static int partitionOld(int[]data,int left,int right){
	int index = left + (int)(Math.random()*(right-left));
	swap(data,index,right);
	int start = left;
	int end = right - 1;
	while(start < end){
	    if(data[start] >= data[right]){
		swap(data,start,end);
		end--;
	    }else{
		start++;
	    }
	}
	if(data[right]<data[start]){
	    swap(data,start,right);
	    return start;
	}else{
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
	int place = partitionOld(data,left,right);
	if(place == k){
	    return data[k];
	}
	if(k < place){
	    return quickselect(data,k,left,place-1);
	}else{
	    return quickselect(data,k,place+1,right);
	}
    }
    public static void quicksortOld(int[]data){
	quicksortOld(data,0,data.length-1);
    }
    public static void quicksortOld(int[]data,int left,int right){
	if(left!=right&&left<right){
	    int place = partitionOld(data,left,right);
	    if (place < data.length-1){
		quicksortOld(data,left,place-1);
		quicksortOld(data,place+1,right);
	    }
	}
    }

    
    public static int[] partition(int[]data,int left,int right){
	int index = left + (int)(Math.random()*(right-left));
	int[] newAry = new int[data.length];
	for(int x = 0;x<left;x++){
	    newAry[x]=data[x];
	}
	for(int y = data.length-1;y>right;y--){
	    newAry[y]=data[y];
	}
	//swap(data,index,right);
        int start = left;
        int end = right;
	for(int i = left;i<=right;i++){
	    if(data[i]>data[index]){
		newAry[end] = data[i];
		end--;
	    }else if(data[i]<data[index]){
		newAry[start]=data[i];
		start++;
	    }
	}
	if(start == end){
	    newAry[start]=data[index];
	}else{
	    for(int j = start;j<=end;j++){
		newAry[j]=data[index];
	    }
	}
	for(int n = 0;n<data.length;n++){
	    data[n] = newAry[n];
	}
	//data = newAry;
	int[] retAry = new int[2];
	
	retAry[0]=start;
	retAry[1]=end;
	return retAry;
    }
    
    public static void quicksort(int[]data){
	quicksort(data,0,data.length-1);
    }
    public static void quicksort(int[]data,int left,int right){
	if(left!=right&&left<right){
            int[] places = partition(data,left,right);
            if (places[0] < data.length-1&&places[1]<data.length-1){
                quicksort(data,left,places[0]-1);
                quicksort(data,places[1]+1,right);
            }
        }

    }
    
    public static void swap(int[] data, int index1, int index2){
	int holder = data[index1];
	data[index1] = data[index2];
	data[index2] = holder;
    }
    public static String name(){
	return "7,Feinberg,Michael";
    }
    public static void main(String[] args){
	int[] a = new int[4000000];
	int[] b = new int[4000000];
	for(int i = 0;i < a.length;i++){
	    a[i] = (int)Math.random()*4;
	}
	for(int j = 0;j<b.length;j++){
	    b[j] = Integer.MIN_VALUE + 2*(int)Math.random()*Integer.MAX_VALUE; 
	}
	//a1
	//Arrays.sort(a);
	//a2
	//quicksortOld(a);
	//a3
	//quicksort(a);
	//b1
	//Arrays.sort(b);
	//b2
	//quicksortOld(b);
	//b3
	//quicksort(b);
    }
   
}
