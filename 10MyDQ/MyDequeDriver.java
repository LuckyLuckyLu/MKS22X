public class MyDequeDriver{
    public static void main(String[] args){
	MyDeque x = new MyDeque();
	x.addFirst(5);
	x.addLast(6);
	x.addFirst(4);
	x.addLast(7);
	x.addFirst(3);
	x.addLast(8);
	x.addFirst(2);
	x.addLast(9);
	x.addFirst(1);
	x.addLast(10);
	System.out.println(x);
	MyDeque y = new MyDeque(100);
	
    }
}
