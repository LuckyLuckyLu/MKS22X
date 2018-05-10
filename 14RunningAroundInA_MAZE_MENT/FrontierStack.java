import java.util.LinkedList;
public class FrontierStack implements Frontier{
    private LinkedList<Location> list; 
    public FrontierStack(){
	list = new LinkedList<>();
    }
    public Location next(){
	return null;
    }
    public void add(Location Thingy){
	list.addLast(Thingy);
    }
    public Location remove(){
	return list.removeLast();
    }
    public boolean hasNext(){
	return null != list.peekLast();
    }
}
