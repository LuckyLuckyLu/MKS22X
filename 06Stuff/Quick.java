import java.util.Random;
public class Quick{
    //private int[] Array;    
    public static void Swap(int[] box, int x, int y){
	int ValueHolder  = box[x];
	box[x] = box[y];
	box[y] = ValueHolder;
    }
    /*Choose a random pivot element, and modify the array such that:
     *1. Only the indices from start to end inclusive are considered in range
     *2. A random index from start to end inclusive is chosen, the corresponding 
     *   element is designated the pivot element. 
     *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
     *4. all elements in range that are larger than the pivot element are placed after the pivot element.
     *@return the index of the final position of the pivot element.
     */

    public static int partition(int[] data, int start, int end){
	Random index = new Random();
	int v = index.nextInt(end) + start;
	System.out.println(v);
	Swap(data,v,start);
	int front = start + 1;
	int ending = end;
	//System.out.println(toString(data));
	//System.out.println(Array.length);
	while(front <= ending){
	    if (data[front] > data[ending]){
		Swap(data,front,ending);
		ending --;
	    } else{
		front ++;
	    }
	}
	Swap(data,ending,start);
	//System.out.println(toString(data));

	int i = 0;
	for (int x = 0; x < data.length; x++){
	    if (data[x] == v){
		return i;
	    }
	    i++;
	}
	return i;
    }
    public static void quicksort(int[]ary){
	
    }
    public static boolean sorted(int[] ary, int start, int end){
	for (int x = start; x < end - 1; x++){
	    if (ary[x] > ary[x+1]){
		return false;
	    }
	}
	return true;
    }
    public static String toString(int[] arr){
	String result = "";
	for (int x = 0; x < arr.length; x++){
	    result += arr[x];
	}
	return result;
    }
    // public void Partition(int index){
    // 	int front = 0;
    // 	Swap(front,index);
    // 	int first = front;
    // 	front++;
    // 	System.out.println(Array.length);
    // 	int end = Array.length - 1;
    // 	System.out.println(end);
    // 	while(front <= end){
    // 	    if (Array[front] > Array[]){
    // 		Swap(front,end);
    // 		end --;
    // 	    } else{
    // 		front ++;
    // 	    }
    // 	}
    // }
    // public int[] getArray(){
    // 	return Array;
    // }
    // public String toString(){
    // 	String result = "";
    // 	for (int x = 0; x < this.getArray().length; x++){
    // 	    result += this.getArray()[x] + " ";
    // 	}
    // 	return result;
    // }
    public static void main(String[] Arg){
	int[] x = {1,4,6,7,9,3,2};
	Quick bob = new Quick();
	while(!sorted(x)){
	    bob.partition(x,0,6);
	    //System.out.println(bob.partition(x,0,6));//tArray());//.toString());
	    System.out.println(toString(x));
	}
	System.out.println(toString(x));
	
    }
}
