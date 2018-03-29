public class MyLinkedList{
    private  Node start,end;
    private int size;
    
    //This method will help you write other
    //methods, it is private to protect your list
    //private Node getNode(int index);


    //public MyLinkedList();
    //public String toString();
    //public void clear();
    //public int size();  
    //public Integer get(int index);//exceptions!
    //public Integer set(int index, Integer value);//exceptions!

    //public int indexOf(Integer value);

    //public boolean add(Integer newData);
    //public void add(int index, Integer value);//exceptions!

    //The remove methods can cause a problem, this is why we shouldn't 
    //use an int as the data, we need objects to distinguish between index and data
    //public boolean remove(Integer value);
    //public boolean remove(int index);//exceptions!

    private class Nodes{
	private Node next,prev;
	private int data;

	public Nodes(int Next, int Prev, int Data){
	    next = Next;
	    prev = Prev;
	    data = Data;
	}

	public Node getNext(){
	    return next;
	}
	public Node getPrev(){
	    return prev;
	}
	public int getValue(){
	    return data;
	}
	public String toString(){
	    return "" + data;
	}
	public void setDat(int Data){
	    data = Data;
	}
	public void setPre(int Prev){
	    prev = Prev;
	}
	public void setNex(int Next){
	    next = Next;
	}
	
	
	/* Node next,prev
		int data

		Node Methods:
		Node getNext()
		Node getPrev()
		int getValue()
		String toString
		(also all the set methods to go with them)
	*/
	
    }
}
