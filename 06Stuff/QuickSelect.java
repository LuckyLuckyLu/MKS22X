public class QuickSelect{
    private int[] Array;
    public QuickSelect(int[] Array){
        this.Array= Array;
    }
    public void Swap(int x, int y){
	int ValueHolder  = Array[x];
	Array[x] = Array[y];
	Array[y] = ValueHolder;
    }
    public void Partition(){
	int front = 0;
	int end = this.getArray().length - 1;
	int middle = this.getArray().length / 2;
	for (int x = 0; x < Array.length; x++){
	    if (Array[front] > Array[middle]){
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
