public class Sorts{
    public void heapify(int[] data){
	for (int i = data.length-1; i >= 0; i--){
	    correction(data[i],i);
	}
    }
    public void correction(int[] data, int value, int location){
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
    
    public void heapsort(int[] data){
	heapify(data);
    }
    public static void main(String[] args){
	int[] arry = new int[10];
	for (int i = 0; i < 10; i++){
	    arry[i] = Math.random() * 10;
	}
	System.out.println(Arrays.println(arry));
	//heapsort(arry);
	System.out.println(Arrays.println(arry));
    }
}
