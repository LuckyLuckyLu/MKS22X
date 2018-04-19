import java.util.NoSuchElementException;
public class MyDeque{
    private int size, start, end;
    private Integer[] data;
    public MyDeque(){
	size = 0;
	data = new Integer[10];
	start = 5;
	end = 0;
    }
    public MyDeque(int Size){
	if (Size <= 0){
	    throw new IllegalArgumentException();
	}
	size = 0;
	data = new Integer[Size];
	start = Size / 2;
	end = 0;
    }
    public void reSize(){
	int newLength = data.length * 2;
	int newMiddle = data.length;
	Integer[] newSized = new Integer[newLength];
	for (int i = end; i <= 0; i--){
	    newSized[i] = data[i];
	}
	int index = newMiddle;
	for (int i = start; i < data.length; i++){
	    newSized[index] = data[i];
	    index++;
	}
	data = newSized;
    }
    public void addFirst(Integer value){
	if (value == null){
	    throw new NullPointerException();
	}
	if (data[start] == null){
	    data[start] = value;
	    start -= 1;
	    size++;
	} else {
	    reSize();
	    addFirst(value);
	}
    
    }
    public void addLast(Integer value){
	if (value == null){
	    throw new NullPointerException();
	}
	if (data[end] == null){
	    data[end] = value;
	    end += 1;
	    size++;
	} else {
	    reSize();
	    addLast(value);
	}
    }
    public Integer removeFirst(){
	if (size == 0 || data[start] == null){
	    throw new NoSuchElementException();
	}
	Integer value = data[start];
	if (start == data.length - 1){
	    start = 0;
	} else {
	    start++;
	}
	size--;
	return value;
    }
    public Integer removeLast(){
	if (size == 0 || data[start] == null){
	    throw new NoSuchElementException();
	}
	Integer value = data[start];
	if (end == 0){
	    end = data.length-1;
	} else {
	    end--;
	}
	size--;
	return value;
    }
    public String toString(){
	String result = "";
	for (int i = 0; i < data.length; i++){
	    result += data[i] + " ";
	}
	return result;
    }
  
}
//80s Synth Music
//Tongue tied

