public QuickSelect{
    private int[] Array;
    public QuickSelect(int[] Array){
        This.Array= Array;
    }
    public void Swap(int x, int y){
	int ValueHolder  = Array[x];
	Array[x] = Array[y];
	Array[y] = ValueHolder;
    }
    public static void Partition(){
	int front = 0;
	int end = Array.length - 1;
	int middle = Array.length / 2;
	for (int x = 0; x < Array.length; x++){
	    if (Array[front] > Array[middle]){
		Swap(front,end);
		end --;
	    } else if (Array[end] < Array[middle]){
		Swap(end,front);
		front ++;
	    }
	}
    }
    public static 
    public static void main(String[] Arg){
	QuickSelect bob = new QuickSelect({1,2,3,4,5,6});
	bob.Partition();
	System.out.println(Array);
    }
}
