public class MyHeap implements Comparable{
  private String[] heap;
  private int size;
  private boolean type; 
  public MyHeap(){
    heap = new String[10];
    size = 0;
    type = true;
  }
  public MyHeap(boolean min){
    heap = new String[10];
    size = 0;
    type = min;
  }
  public String peek(){
    if (size != 0){
      return heap[0];
    } else {
      return null;
    }
  }
  public void resize(){
    String[] pile = new String[heap.length * 2];
    for (int i = 0; i <= size; i++){
      pile[i] = heap[i];
    }
    heap = pile;
  }

  public void add(String s){
    size++;
    if (size < heap.length){
      heap[size] = s;
      size ++;
    } else {
      resize(); 
    }
  }
 
}
