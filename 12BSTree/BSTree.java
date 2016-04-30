public class BSTree<T extends comparable<T>>{
    private class Node{
	T data;
	Node left;
	Node right;
	public T getData(){
	    return data;
	}
	public Node getLeft(){
	    return left;
	}
	public Node getRight(){
	    return right;
	}
	public void setData(T value){
	    data = value;
	}
	public void setLeft(Node newNode){
	    left = newNode;
	}
	public void setRight(Node newNode){
	    right = newNode;
	}
	public int height(){
	    int leftHeight = 1;
	    int rightHeight = 1;
	    if(left != null){
		leftHeight += left.height();
	    }
	    if(right != null){
		rightHeight += right.height();
	    }
	    if(rightHeight>leftHeight){
		return rightHeight;
	    }else{
		return leftHeight;
	    }
	}
	public void add(T value){
	    if(value < data){
		if(left == null){
		    left = new Node(value);
		}else{
		    left.add(value);
		}
	    }else{
		if(right == null){
		    right = new Node(value);
		}else{
		    right.add(value);
		}
	    }
	}
	public String toString(){
	    String ans = "";
	    ans += data;
	    if(left != null){
		ans += left.toString();
	    }
	    if(right != null){
		ans += right.toString();
	    }
	    return ans;
	}
	public boolean contains(T value){
	    if(data.compareTo(value)){
		return true;
	    }else{
		
	    }
	}
	private Node root;
    }
}