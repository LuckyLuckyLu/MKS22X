import java.util.NoSuchElementException;
import java.util.ArrayList;
public class MyDeque<E>{
    private int size, start, end;
    private E[] data;
    @SuppressWarnings("unchecked")
    public MyDeque(){
	size = 0;
	data = (E[]) new Object[10];
	start = 10;
	end = -1;
    }
    @SuppressWarnings("unchecked")
    public MyDeque(int Size){
	if (Size <= 0){
	    throw new IllegalArgumentException();
	}
	size = 0;
	data = (E[])new Object[Size];
	start = Size;
	end = -1;
    }
    @SuppressWarnings("unchecked")
    public void reSize(){
	int newLength = data.length * 2;
	//int newMiddle = data.length;
	E[] newSized = (E[])new Object[newLength];
	int newStart = newLength-1;
	int newEnd = -1;
	//System.out.println(newMiddle);
    
	for (int i = end; i >= 0; i--){
	    newSized[i] = data[i];
	    newEnd++;
	}
	//System.out.println("Resize pt 1");

	//System.out.println(toString(newSized));
    
	//System.out.println(data.length);
	for (int i = data.length - 1; i >= start; i--){
	    newSized[newStart] = data[i];
	    newStart--;
	}
	//System.out.println("Resize pt 2");

	//System.out.println(newStart);
	//System.out.println(newEnd);
	//System.out.println(toString(newSized));
	data = newSized;
	newStart++;
	start = newStart;
	end = newEnd;
	//System.out.println("yo ass just got resized");

    }
    public void addFirst(E value){
	if (value == null){
	    throw new NullPointerException();
	}
	start--;
	if (start > 0 && data[start] == null){
	    data[start] = value;
	    size++;
	} else {
	    start++;
	    reSize();
	    //System.out.println("Yo ass just got resized (for adding to front)");
	    addFirst(value);
	    //data[start] = value;
	    //size++;
	}
    
    }
    public void addLast(E value){
	if (value == null){
	    throw new NullPointerException();
	}
	end++;
	if (end < data.length && data[end] == null){
	    data[end] = value;
	    size++;
	} else {
	    end--;
	    reSize();
	    //System.out.println("Yo ass just got resized (adding to last)");

	    addLast(value);
	    //data[end] = value;
	    //size++;
	}
    }
    public E removeFirst(){
	if (size == 0 || data[start] == null){
	    throw new NoSuchElementException();
	}
	E value = data[start];
	data[start] = null;
	size--;
	if (start == data.length-1){
	    start = 0;
	} else {
	    start++; 
	}
	return value;
    }
    public E removeLast(){
	if (size == 0 || data[end] == null){
	    throw new NoSuchElementException();
	}
	E value = data[end];
	data[end] = null;
	size--;
	if (end == 0){
	    end = data.length-1;
	} else {
	    end--;
	}
	return value;
    }
    public E getFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	if (start >= data.length){
	    return data[0];
	}
	return data[start];
    }
    public E getLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	if (end < 0){
	    return data[data.length-1];
	}
	return data[end];
    }
    public String toString(){
	//System.out.println(start);
	//System.out.println(end);
	String result = "";
	for (int i = 0; i < data.length; i++){
	    result += data[i] + " ";
	    //result += data[(i+start+1) % data.length]+ " ";
	}
	return result;
    }
    public String toString(E[] Array){
	String result = "";
	for (int i = 0; i < Array.length; i++){
	    result += Array[i] + " ";
	}
	return result;
    }
    public int start(){
	return start;
    }
    public int end(){
	return end;
    }

    public static void main(String[] args){
	MyDeque<Integer> a = new MyDeque<>();
	int size = 10;
	for (int i = 0; i < size; i++){
	    a.addLast(i);
	}
	System.out.println(a);
	System.out.println(a.start());
	System.out.println(a.end());
	for (int i = 0; i < size; i++){
	    if ((Integer)i != a.getFirst()){
		System.out.println("" + a.removeFirst() + " != " + i);
		System.out.println("Oww.");
	    }
	}
    }

    
    /*
      public String toString(){ //Courtesy of Crystal
      System.out.println("Start = " + start);
      System.out.println("End = " + end);
      String ans = "[";
      if(start < end){
      for (int i = start; i <= end; i++){
      ans += data[i] + " , ";
      }
      }
      else{
      for(int i = start; i < data.length; i++){
      ans += data[i] + ", ";
      }
      for(int i = 0; i <= end; i++){
      ans += data[i] + ", ";
      }
      }
      ans = ans.substring(0, ans.length() - 2) + "]";
      return ans;
      }
    */

    // public static void main(String[] args) { //Courtesy of Crystal
    //   MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
    //   ArrayList<String> b = new ArrayList<>();
    //   System.out.println("Section 1 complete");

    //   int size = Integer.parseInt(args[0]);
    
    
    //   int timeCounterMillis = 0;
    
    //   for(int i = 0; i < size; i++){
    // 	//System.out.println("Section 1." + i + " Complete");

    // 	int temp = (int)(Math.random() * 1000);
    // 	if(temp % 2 == 0){
    // 	    long startTime = System.currentTimeMillis();
    // 	    a.addFirst("" + temp);
    // 	    timeCounterMillis += System.currentTimeMillis() - startTime;
    // 	    a1.addFirst("" + temp);
    // 	    b.add(0, "" + temp);
    // 	}
    // 	else{
    // 	    long startTime = System.currentTimeMillis();	    
    // 	    a.addLast("" + temp);
    // 	    timeCounterMillis += System.currentTimeMillis() - startTime;
    // 	    a1.addLast("" + temp);
    // 	    b.add("" + temp);
    // 	}
    //   }

    //   //System.out.println(System.currentTimeMillis());

    //   //System.out.println(elapsedTime);
    //   //System.out.println(toString(b));
    //   //System.out.println(a);
    //   //System.out.println(b);
    //   System.out.println("Section 2 Complete");

    //   int index = 0;
    //   boolean hasError = false;
    //   String errorEvaluation = "Errors found at these indices: ";
    //   for (String x : b){
    // 	    if (!(x.equals(a.getFirst()))){
    //       System.out.println("" + a.getFirst() + "!= " + x);
    //       System.out.println("The getFirst() function is incorrect at index " + index);
    //       hasError = true;
    // 	    }
    // 	    if (!(x.equals(a.removeFirst()))){
    //       System.out.println("There is an error at index " + index);
    //       errorEvaluation += index + ", ";
    //       hasError = true;
    // 	    }
    // 	    index++;
    //   }


    //   if(hasError){
    // 	    errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
    // 	    System.out.println(errorEvaluation);
    // 	    System.out.println("MyDeque: " + a1);
    // 	    System.out.println("Actual Deque: " + b);
    //   }
    //   else{
    // 	    System.out.println("Your deque is bug-free!");
    //   }
    //   System.out.println("Time: " + timeCounterMillis/1000.0 +"sec ");
    //   System.out.println("Section 3 Complete");

    // }
  
}
//80s Synth Music
//Tongue tied

