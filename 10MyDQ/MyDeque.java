public class MyDeque{
  private int size, start, end;
  private Integer[] data;
  public MyDeque(){
    size = 10;
    data = new Integer[10];
    start = 5;
    end = 0;
  }
  public MyDeque(int Size){
    if (Size <= 0){
      throw new IllegalArgumentException();
    }
    size = Size;
    data = new Integer[Size];
    start = Size / 2;
    end = 0;
  }
  public void reSize(int multiple){
    int newSize = size * multiple;
    Integer[] newSized = new Integer[size];
    for (int i = 0; i < size; i++){
      newSized[i] = data[(i+start)%size];
    }
    size = newSize;
    data = newSized;
  }
  public void addFirst(Integer value){
    if (value == null){
      throw new NullPointerException();
    }
    if (data[start-1] == null){
      data[start-1] = value;
      start -= 1;
      size+=
    } else {
      reSize(2);
      addFirst(value);
    }
    
  }
  public void addLast(Integer value){
    if (value == null){
      throw new NullPointerException();
    }
    if (data[end+1] == null){
      data[end-1] = value;
      end += 1;
    } else {
      reSize(2);
      addLast(value);
    }
  }
  public Integer removeFirst(){
    if (size)
  }
  
}
