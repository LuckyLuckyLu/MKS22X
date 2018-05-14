import java.util.LinkedList;
public class FrontierStack implements Frontier{
  private LinkedList<Location> list; 
  public FrontierStack(){
    list = new LinkedList<>();
  }
  public Location next(){
    return list.removeLast();
  }
  public void add(Location Thingy){
    list.add(Thingy);
  }
  public boolean hasNext(){
    return null != list.peekLast();
  }
}
