public class MyLinkedList{
  private Node start,end;
  private int size;
    
  //This method will help you write other
  //methods, it is private to protect your list
  private Node getNode(int index){
    if (index < 0 || index > size){
      throw new IndexOutOfBoundsException();
    }
    if (index == 0){
      return start;
    }
    if (index == size){
      return end;
    }
    Node found = start;
    for (int i = 0; i < index; i++){
      found = found.getNext();
    }
    return found;
  }


  public MyLinkedList(){
    size = 0;
    start = null;
    end = null;
  }
  public String toString(){
    String result = "";
    for (int i = 0; i < size; i++){
      result += getNode(i) + " ";
    }
    return result;
  }
  public void clear(){
    start = null;
    end = null;
    size = 0;
  }
  public int size(){
    return size;
  }
  
  public Integer get(int index){//exceptions!
    if (index < 0 || index > size){
      throw new IndexOutOfBoundsException();
    }
    return getNode(index).getValue();
  }
  
  public Integer set(int index, Integer value){//exceptions!
    if (index < 0 || index > size){
      throw new IndexOutOfBoundsException();
    }
    getNode(index).setDat(value);
    return value;
  }

  public int indexOf(Integer value){
    Node found = start;
    for (int i = 0; i < size; i++){
      if ((found.getValue()) == (value)){
        return i;
      }
      found = found.getNext();
    }
    return -1;
  }

  public boolean add(Integer newData){
    add(size,newData);
    return true;
  }
  public void add(int index, Integer value){//exceptions!
    if (index < 0 || index > size){
      throw new IndexOutOfBoundsException();
    }
    Node NEW = new Node(null,null,value);
    if (size == 0){
      start = NEW;
      end = NEW;
    } else if (index == 0){
      start.setPre(NEW);
      NEW.setNex(start);
      start = NEW;
    } else if (index == size) {
      end.setNex(NEW);
      NEW.setPre(end);
      end = NEW;
    } else {
      Node After = getNode(index);
      Node Before = After.getPrev();
      Before.setNex(NEW);
      After.setPre(NEW);
      NEW.setPre(Before);
      NEW.setNex(After);
    }
    size ++;
  }

  //The remove methods can cause a problem, this is why we shouldn't 
  //use an int as the data, we need objects to distinguish between index and data
  //public boolean remove(Integer value);
  //public boolean remove(int index);//exceptions!

   class Node{
    private Node next,prev;
    private int data;

     public Node(Node Prev, Node Next, int Data){
	    prev = Prev;
	    next = Next;
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
    public void setPre(Node Prev){
	    prev = Prev;
    }
    public void setNex(Node Next){
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
