import java.util.LinkedList;
public class FrontierQueue implements Frontier{
  private LinkedList<Location> list; 
  public FrontierQueue(){
    list = new LinkedList<>();
  }
  public Location next(){
    return null;
  }
  public void add(Location Thingy){
    list.add(Thingy);
  }
    
}
