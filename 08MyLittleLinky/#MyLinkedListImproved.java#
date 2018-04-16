import java.util.*;
public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
  // class MyLinkedListImproved<T extends Comparable<T>>{
  private Node start,end;
  private int size;
    
  //This method will help you write other
  //methods, it is private to protect your list
  private Node getNode(int index){
    if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
    }
    if (index == 0){
	    return start;
    }
    if (index == size - 1){
	    return end;
    }
    Node found = start;
    for (int i = 0; i < index; i++){
	    found = found.getNext();
    }
    return found;
  }


  public MyLinkedListImproved(){
    size = 0;
    start = null;
    end = null;
  }
  // public void reverse(){
  //   if (start != null){
  //     for (int x = 1; x < size; x++){
  //       Node here = this.getNode(x);
  //       Node newPre = here.getNext();
  //       here.setNex(here.getPrev());
  //       here.setPre(newPre);
  //     }
  //     Node newStart = end;
  //     end = start;
  //     start = newStart;
  //   }
  // }
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
  
  public T get(int index){//exceptions!
    if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
    }
    return getNode(index).getValue();
  }
  
  public T set(int index, T value){//exceptions!
    if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
    }
    getNode(index).setDat(value);
    return value;
  }

  public int indexOf(T value){
    Node found = start;
    for (int i = 0; i < size; i++){
	    if ((found.getValue()).equals(value)){
        return i;
	    }
	    found = found.getNext();
    }
    return -1;
  }

  public boolean add(T newData){
    add(size,newData);
    return true;
  }
  public void add(int index, T value){//exceptions!
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
  public boolean remove(T value){
    int index = indexOf(value);
    if (index == -1){
	    return false;
    }
    Node current = getNode(index);
    if (index == 0){
	    Node next = current.getNext();
	    next.setPre(null);
	    start = next;
    } else if (index == size-1){
	    Node previous = current.getPrev();
	    previous.setNex(null);
	    end = previous;
    } else {
	    Node previous = current.getPrev();
	    Node next = current.getNext();
	    previous.setNex(next);
	    next.setPre(previous);
    }
    size--;
    return true;
  }
  public boolean remove(int index){//exceptions!
    if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
    }
    Node current = getNode(index);
    if (index == 0){
	    Node next = current.getNext();
	    next.setPre(null);
	    start = next;
    } else if (index == size-1){
	    Node previous = current.getPrev();
	    previous.setNex(null);
	    end = previous;
    } else {
	    Node previous = current.getPrev();
	    Node next = current.getNext();
	    previous.setNex(next);
	    next.setPre(previous);
    }
    size--;
    return true;
  }

  class Node{
    private Node next,prev;
    private T data;

    public Node(Node Prev, Node Next, T Data){
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
    public T getValue(){
	    return data;
    }
    public String toString(){
	    return "" + data;
    }
    public void setDat(T Data){
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
  public Iterator<T> iterator(){
    return new ImprovIterator();
  }
  private class ImprovIterator implements Iterator<T>{
    public Node current;
	
    public ImprovIterator(){
	    current = start;
    }
    public boolean hasNext(){
      return current != null;
	    
    }
    public T next(){
	    T value = current.getValue();
	    current = current.getNext();
	    return value;
    }
  }

  public int min(){
    T minTy = null;
    int index = 0;
    if (start.getValue() != null){
	    minTy = start.getValue();
    } else {
	    return -1;
    }
    for (T x : this ){
	    if (minTy.compareTo(x) > 0){
        minTy = x;
	    }
      index++;
    }
    return this.indexOf(minTy);
  }
  public int max(){
    T maxTy = null;
    int index = 0;
    if (start.getValue() != null){
	    maxTy = start.getValue();
    } else {
	    return -1;
    }
    for (T x : this ){
	    if (maxTy.compareTo(x) < 0){
        maxTy = x;
	    }
      index++;
    }
    return this.indexOf(maxTy);
  }
  public void extend(MyLinkedListImproved<T> data){
    if (data == null || data.size == 0){
	    return;
    } else if (this == null || this.size == 0){
      this.size = data.size;
      this.start = data.start;
      this.end = data.end;
    } else {
      this.end.setNex(data.start);
      this.end = data.end;
      this.size += data.size();
      data.clear();
    }
  }
}
