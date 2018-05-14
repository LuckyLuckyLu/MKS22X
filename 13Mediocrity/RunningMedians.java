public class RunningMedians{
  private MyHeap<Double> min, max;
  private Double median;
  public RunningMedians(){
    min = new MyHeap<>(false);
    max = new MyHeap<>();
    median = 0.0;
  }
  public int size(){
    return min.size() + max.size();
  }
  public void add(Double x){
    if (size() == 0){
      median = x;
      max.add(x);
    } else {
      if (x < median){
        max.add(x);
      } else {
        min.add(x);
      }
    }
    if (min.size() - max.size() < -1){
      Double y = max.remove();
      min.add(y);
    } else if (max.size() - min.size() < -1){
      Double y = min.remove();
      max.add(y);
    }
    if (min.size() > max.size()){
      median = min.peek();
    } else if (min.size() < max.size()){
      median = max.peek();
    } else {
      median = (min.peek() + max.peek()) / 2;
    }

  }

  public double getMedian(){
    return median;
  }
  public static void main(String[] Args){
    RunningMedians x = new RunningMedians();
    for (Double i = -10.0; i < 11.0; i++){
      x.add(i);
      System.out.println("median =" + x.getMedian());
    }
  }
}
