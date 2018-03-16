import java.util.Random;
public class Quick{
    private int[] Array;    
    public void Swap(int[] box, int x, int y){
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

    public static int partition (int[] data, int start, int end){
	Random index = new Random();
	int v = index.nextInt(end) + start;
	int i = start;
	Swap(v,i);
	i++;
	//System.out.println(Array.length);
	int j = end;
	while(front <= end){
	    if (Array[front] > Array[]){
		Swap(front,end);
		end --;
	    } else{
		front ++;
	    }
	}

    }
    public static void quicksort(int[]ary){
	
    }

    public void Partition(int index){
	int front = 0;
	Swap(front,index);
	int first = front;
	front++;
	System.out.println(Array.length);
	int end = Array.length - 1;
	System.out.println(end);
	while(front <= end){
	    if (Array[front] > Array[]){
		Swap(front,end);
		end --;
	    } else{
		front ++;
	    }
	}
    }
    public int[] getArray(){
	return Array;
    }
    public String toString(){
	String result = "";
	for (int x = 0; x < this.getArray().length; x++){
	    result += this.getArray()[x] + " ";
	}
	return result;
    }
    public static void main(String[] Arg){
	int[] x = {1,4,6,7,9,3,2};
	QuickSelect bob = new QuickSelect(x);
	bob.Partition();
	System.out.println(bob);//tArray());//.toString());
    }
}
