public class MyLinkedList{
    private class LNode{
	private int value;
	private LNode next;
	public LNode(int val){
	    value = val;
	}
	public void setValue(int Value){
	    value = Value;
	}
	public void setNext(LNode Next){
	    next = Next;
	}
	public int getValue(){
	    return value;
	}
	public LNode getNext(){
	    return next;
	} 
    }
    public LNode head;
    public LNode tail;
    public int size;
    public boolean add(int value){
	if(head==null){
	    head = new LNode(value);
	    tail = head;
	}else{
	    /* LNode place = head;
	       while(place.getNext()!=null){
	       place = place.getNext();
	       }
	       place.setNext(new LNode(value));
	       }
	       return true;
	    */
	    LNode Next = new LNode(value);
	    tail.setNext(Next);
	    tail = Next;
	    
	}
	size++;
	return true;
    }
    public int set(int index,int newValue){
	LNode place = head;
	int x = index;
	while(x>0){
	    place = place.getNext();
	    x--;
	}
	int ans = place.getValue();
	place.setValue(newValue);
	return ans;
    }
    public int get(int index){
	LNode place = head;
	int x = index;
	while(x>0){
	    place = place.getNext();
	    x--;
	}
	return place.getValue();
    }
    public boolean add(int index,int value){
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
    public int remove(int index){
	LNode place = head;
	int x = index;
	while(x>1){
	    place = place.getNext();
	    x--;
	}
	LNode ToBeRemoved = place.getNext();
	place.setNext(ToBeRemoved.getNext());
	size--;
	return ToBeRemoved.getValue();
    }
    public int indexOf(int value){
	LNode place = head;
	int index = 0;
	while(place.getNext()!=null){
	    if(place.getValue() == value){
		return index;
	    }else{
		place = place.getNext();
		index++;
	    }
	}
	if(place.getValue() == value){
	    return index;
	}else{
	    return -1;
	}
    }
    public String toString(){
	String ans = "[";
	LNode p = head;
	while(p!=null){
	    ans+=p.getValue();
	    if(p.getNext()!=null){
		ans += ", ";
	    }
	    p=p.getNext();
	}
	return ans + "]";
    }
    public int size(){
	return size;
    }
    public static void main(String[] args){
	MyLinkedList m = new MyLinkedList();
	m.add(3);
	m.add(2);
	m.add(1,7);
	System.out.println(m.get(1));
	System.out.println(m);
	System.out.println(m.get(1));
	System.out.println(m.indexOf(2));
    }
   
}