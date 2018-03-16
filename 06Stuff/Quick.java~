public class QuickSelect{
    private int[] Array;
    public QuickSelect(int[] newArray){
        Array= newArray;
    }
    public void Swap(int x, int y){
	int ValueHolder  = Array[x];
	Array[x] = Array[y];
	Array[y] = ValueHolder;
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
