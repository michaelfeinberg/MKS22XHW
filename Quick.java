public class Quick{
    public static int partition(int[]data,int left,int right){
	int index = left + (int)Math.random()*(right-left);
	swap(data,index,right);
	int start = left;
	int end = right - 1;
	while(start < end){
	    if(data[start] > data[right]){
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
	return quickselect(data,k,0,data..length-1);
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
	    return quickselect(data,k,left,place);
	}else{
	    return quickselect(data,k,right,place);
	}
    }
    public static void quicksort(int[]data){
	quicksort(data,0,data.length);
    }
    public static void quicksort(int[]data,int left,int right){
	if(left!=right){
	    place = partition(data,left,right);
	    quicksort(data,left,place);
	    quicksort(data,place,right);
	}
    }
    public static void swap(int[] data, int index1, int index2){
	int holder = data[index1];
	data[index1] = data[index2];
	data[index2] = holder;
    }
}