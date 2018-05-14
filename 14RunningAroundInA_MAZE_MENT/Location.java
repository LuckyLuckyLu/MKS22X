public class Location{
  private int x,y,priority;
  private Location previous;

  public Location(int _x, int _y, Location prev){
    x = _x;
    y = _y;
    previous = prev;
  }
  public Location(int _x, int _y, Location prev, int distance){
    x = _x;
    y = _y;
    previous = prev;
    priority = distance;
  }

  public Location getPrevious(){
    return previous;
  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  public int getPriority(){
    return priority;
  }
}
