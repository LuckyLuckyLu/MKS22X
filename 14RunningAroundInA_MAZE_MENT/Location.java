public class Location implements Comparable<Location>{
  private int x,y,distance;
  private Location previous;

  public Location(int _x, int _y, Location prev){
    x = _x;
    y = _y;
    previous = prev;
  }
  public Location(int _x, int _y, Location prev, int dist){
    x = _x;
    y = _y;
    previous = prev;
    distance = dist;
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
  public int getDistance(){
    return distance;
  }
  public int compareTo(Location other){
    if(getDistance() < other.getDistance()){
      return -1;
    } else {
      return 1;
    }
  }
  public String toString(){
    return "X value: " + getX() + " |Y value: " + getY() + " |DistanceToE: " + getDistance();
  }
}
