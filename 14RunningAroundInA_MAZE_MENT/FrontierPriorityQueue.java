public class FrontierPriorityQueue implements Frontier{
  private MyHeap<Location> minHeap;
  public FrontierPriorityQueue(){
    minHeap = new MyHeap<>(false);
  }
  public Location next(){
    return minHeap.remove();
  }
  public void add(Location Thingy){
    minHeap.add(Thingy);
  }
  public boolean hasNext(){
    return null != minHeap.peek();
  }
}
