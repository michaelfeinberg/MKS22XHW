public class Sorts{
    public static String name(){
	return "7,Feinberg,Michael";
    }
    public static void printArray(int[] ary){
	String retString = "{";
	for(int x = 0;x<ary.length-1;x++){
	    retString += ary[x] + ",";
	   
	}
	System.out.println(retString + ary[ary.length-1]+"}");
    }
    public static void insertionSort(int[] data){
	int temp;
	for(int x = 0;x<data.length;x++){
	    temp = data[x];
	    int replacer;
	    for(replacer = x;replacer>0 && temp<data[replacer-1];replacer--){
		data[replacer] = data[replacer-1];
	    }
	    data[replacer] = temp;
	}
    }
    public static int[] selectionSort(int[] data){
	int placeholder;
	int index;
	for(int x = 0;x<data.length;x++){
	    placeholder = data[x];
	    index = x;
	    for(int y = x;y<data.length;y++){
		if (placeholder > data[y]){
		    placeholder = data[y];
		    index = y;
		}
	    }
	    data[index] = data[x];
	    data[x] = placeholder;
	}
	return data;
    }
    
    public static int[] bubbleSort(int[] data){
	
	int holder;
	int x = 0;
	do{
	    for(int j = 0;j<data.length-x-1;j++){
		
		if(data[j]>data[j+1]){
		    holder = data[j];
		    data[j] = data[j+1];
		    data[j+1]=holder;
		    
		}
	    }
	    x++;
	}while(x<data.length-1);
	return data;
    }
    public static int[] mergesort(int[] data){
	if(data.length == 1){
	    return data;
	}else{
	    int a = data.length/2;
	    int[] data1 = new int[a];
	    for(int x = 0;x<a;x++){
		data1[x]=data[x];
	    }
	    int[] data2;
	    if(data.length % 2 == 1){
		data2 = new int[a+1];
	    }else{
		data2 = new int[a];
	    }
	    for(int i = a;i<data.length;i++){
		data2[i-a]=data[i];
	    }
	    return merge(mergeSort(data1),mergeSort(data2));
	}
    }
    public static int[] merge(int[] data1,int[] data2){
	int next1 = 0;
	int next2 = 0;
	int[] data = new int[data1.length+data2.length];
	//Sorts.printArray(data1);
	//Sorts.printArray(data2);
	while(next1+next2<data.length){
	    if(data1.length<=next1){
		data[next1+next2]=data2[next2];
		next2++;
	    }else if(data2.length<=next2){
		data[next1+next2]=data1[next1];
		next1++;
	    }else{
		if(data1[next1]>data2[next2]){
		    data[next1+next2]=data2[next2];
		    next2++;
		}else{
		    data[next1+next2]=data1[next1];
		    next1++;
		}
	    }
	}
	return data;
    }
    public static void main(String[]args){
	int[] a = {8,4,0,0,0,6,6,7,234,-1,3,4,8,123,1,2,444};
	int[] b = {8,-2,-1};
	/*Sorts.printArray(a);
	Sorts.insertionSort(a);
	Sorts.printArray(a);
	Sorts.insertionSort(b);
	Sorts.printArray(b);
	*/
	Sorts.printArray(b);
	int[] c = {3,5,6};
	int[] d = {1,2,7,8};
	//Sorts.printArray(a);
	//Sorts.printArray(mergeSort(a));
	Sorts.printArray(mergeSort(b));
	
    }
}