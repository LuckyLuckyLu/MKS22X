import java.util.Random;
public class Quick{
  //private int[] Array;    
  public static void Swap(int[] box, int x, int y){
    int ValueHolder  = box[x];
    box[x] = box[y];
    box[y] = ValueHolder;
  }
  /*Choose a random pivot element, and modify the array such that:
   *1. Only the indices from start to end inclusive are considered in range
   *2. A random index from start to end inclusive is chosen, the corresponding 
   *   element is designated the pivot element. 
   *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
   *4. all elements in range that are larger than the pivot element are placed after the pivot element.
   *@return the index of the final position of the pivot element.
   */

  public static int partition(int[] data, int start, int end){
    if (data.length < 2){
      return start;
    }
    Random index = new Random();
    int v = index.nextInt(end) + start;;
    int Vvalue = data[v];
    Swap(data,v,start);
    int front = start + 1;
    int ending = end;
    while(front <= ending){
      if (data[front] > Vvalue){
        Swap(data,front,ending);
        ending --;
      } else{
        front ++;
      }
    }
    Swap(data,ending,start);
    for (int x = 0; x < data.length; x++){
      if (data[x] == Vvalue){
        return x;
      }
    }
    return 0;
  }
  public static int quickSelect(int[]ary, int index){
    return quickSelectHelper(ary,index,0,ary.length-1);
      }
  private static int quickSelectHelper(int[] Array, int index, int start, int end){
    int initial = partition(Array, start, end);
    if (initial == index){
      return Array[initial]; 
    } else if (initial >= index){
      return quickSelectHelper(Array, index, start, initial);
    } else {
      return quickSelectHelper(Array, index, initial+1, end);
    }
  }

  public static String toString(int[] arr){
    String result = "";
    for (int x = 0; x < arr.length; x++){
      result += arr[x];
    }
    return result;
  }
}
