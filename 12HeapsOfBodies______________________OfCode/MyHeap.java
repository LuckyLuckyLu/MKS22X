import java.util.Arrays;
public class MyHeap<T extends Comparable<T>>{
    private T[] heap;
    private int size;
    private boolean type;
  
    public MyHeap(){
	heap = (T[]) new Comparable[10];
	size = 0;
	type = true;
    }

    public MyHeap(boolean min){
	heap = (T[]) new Comparable[10];
	size = 0;
	type = min;
    }
    public T peek(){
	if (size != 0){
	    return heap[0];
	} else {
	    return null;
	}
    }
    public void resize(){
	T[] pile = (T[]) new Comparable[heap.length * 2];
	for (int i = 0; i < size; i++){
	    pile[i] = heap[i];
	}
	heap = pile;
    }

    public void swap(int a, int b){
	T temp = heap[a];
	heap[a] = heap[b];
	heap[b] = temp;
    }

    public void add(T s){
	size++;
	if (size >= heap.length){
	    resize();
	}
	heap[size-1] = s;
	if (size > 1){
	    //System.out.println("Just Checking");

	    correction(s,size-1);
	}
    }

    public void correction(T value, int location){
	int parentIndex = (location - 1) / 2;
	if (parentIndex < 0){
	    return;
	}
	if (type){
	    if (value.compareTo(heap[parentIndex]) > 0){
		swap(location, parentIndex);
		correction(value, parentIndex);
	    }
	} else {
	    if (value.compareTo(heap[parentIndex]) < 0){
		swap(location, parentIndex);
		correction(value, parentIndex);
	    }
	}
    }

    public T remove(){
	T retValue = heap[0];
	heap[0] = heap[size-1];
	heap[size-1] = null;
	size--;
	pushDown(heap[0],0);
	return retValue;
    }
    

    public void pushDown(T value, int location){
	int thing1 = 2 * location + 1;
	int thing2 = 2 * location + 2;
	if (thing1 < size + 1 && thing2 < size + 1 && heap[thing1] != null && heap[thing2] != null){
	    if (type){
		if (value.compareTo(heap[thing1]) < 0 && value.compareTo(heap[thing2]) < 0){
		    if (heap[thing1].compareTo(heap[thing2]) > 0){
			swap(location,thing1);
			pushDown(value, thing1);
		    } else {
			swap(location,thing2);
			pushDown(value, thing2);
		    }
		} else if (value.compareTo(heap[thing1]) < 0){
		    swap(location,thing1);
		    pushDown(value, thing1);
		} else if (value.compareTo(heap[thing2]) < 0){
		    swap(location,thing2);
		    pushDown(value, thing2);
		}
	    } else {
		if (value.compareTo(heap[thing1]) > 0 && value.compareTo(heap[thing2]) >  0){
		    if (heap[thing1].compareTo(heap[thing2]) < 0){
			swap(location,thing1);
			pushDown(value, thing1);
		    } else {
			swap(location,thing2);
			pushDown(value, thing2);
		    }
		} else if (value.compareTo(heap[thing1]) > 0){
		    swap(location,thing1);
		    pushDown(value, thing1);
		} else if (value.compareTo(heap[thing2]) > 0){
		    swap(location,thing2);
		    pushDown(value, thing2);
		}
	    }
	} else if (thing1 < size + 1 && heap[thing1] != null){
	    if (type){
		if (value.compareTo(heap[thing1]) < 0){
		    swap(location,thing1);
		    pushDown(value,thing1);
		}
	    } else {
		if (value.compareTo(heap[thing1]) > 0){
		    swap(location,thing1);
		    pushDown(value,thing1);
		}
	    }
	} else  if (thing2 < size + 1 && heap[thing2] != null){
	    if (type){
		if (value.compareTo(heap[thing2]) < 0){
		    swap(location,thing2);
		    pushDown(value,thing2);
		}
	    } else {
		if (value.compareTo(heap[thing2]) > 0){
		    swap(location,thing2);
		    pushDown(value,thing2);
		}
	    }
	}
    }
    public String toString(){
	String result = "";
	int line = 1;
	int x = 0;
	for (int i = 0; i < size; i++){
	    result += heap[i] + " ";
	    x++;
	    if (x == line){
		result += "\n";
		line *= 2;
		x = 0;
	    }
	}
	return result;
    }

    public void heapify(T[] data){
	heap = data;
	size = data.length;
	for (int i = data.length-1; i >= 0; i--){
	    correction(data[i],i);
	}
    }
  
    public static void main(String[] Args){
	//System.out.println("1".compareTo("2"));// in a.compareTo(b), if a < b, return -
	MyHeap<Integer> x = new MyHeap(false);
	for (int i = 65; i < 91; i++){
	    x.add((Integer) i);
	}
	System.out.println(x.peek());

	System.out.println(x);
	int i = 65;
	while (i < 91){
	    System.out.println(x.remove());
	    i++;
	}
	System.out.println(x);
	Integer[] meme = new Integer[100];
	int y = 0;
	for (int z = 99; z >= 0; z--){
	    meme[y] = z;
	    y++;
	}
	System.out.println(Arrays.toString(meme));
	x.heapify(meme);
	System.out.println(Arrays.toString(meme));
	/*
	  String a = "12";
	  String b = "2";
	  String c = "c";
	  System.out.println(a.compareTo(b));
	  System.out.println(c.compareTo(b));
	  System.out.println(b.compareTo(b));
	*/



    }
}
