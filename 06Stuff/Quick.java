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
    //if (end-start<=0){
    //  return start;
    //}
    int v = (int)(Math.random() * ((end-start) + 1) + start);//counter.nextInt(end) + start;;
    //System.out.println("pivot = "+ v);
    int Vvalue = data[v];
    Swap(data,v,start);
    // System.out.println("Swap to start, v= "+ v + " get "+ toString(data));
    int front = start+1;
    int counter = 0;
    int back = end;
    int m = 0;
    while(front <= back){
      if (data[front] == Vvalue){
        counter++;
        m = start + counter;
        Swap(data,front,m);
        front++;
      } else if (data[front] > Vvalue){
        //if (front < back){
        Swap(data,front,back);
        // System.out.println(">value Swap to back- = "+ back + " get "+ toString(data));
        back--;
        //}
      } else if (data[front] < Vvalue){
        //  System.out.println("<value front++ ="+ front);
        front++;
      }
      // System.out.println("         New:" + toString(data));
    }
    if (front > back){
      //  front = back;
    }
      //  front = back;
    if (front > data.length){
      front = end;
    }
    if (back == -1){
      back = start;
    }
    for (int i = 0; i <= counter; i++){
      // System.out.println("swap to middle, start ="+ start);
      // System.out.println("swap to middle, back ="+ back);
      Swap(data,start+i,back-i);
      // System.out.println("after swap to middle, i= "+ i + " get "+ toString(data));
    }
    //Swap(data,back,start);
    /*for (int x = 0; x < data.length; x++){
      if (data[x] == Vvalue){
      return x;
      }
      }
    */
    //v = end;
    for (int i = start; i <= end; i++){
      if (data[i] == Vvalue){
        v = i;
      }
    }
    //System.out.println("Before return V, Vvalue = "+ Vvalue + " get "+ toString(data));
    //System.out.println("finally return V = "+ v  + " get "+ toString(data));
    return v;
  }
  
  
  public static int quickSelect(int[]ary, int index){
    return quickSelectHelper(ary,index,index,ary.length-1);
  }
  private static int quickSelectHelper(int[] Array, int index, int start, int end){
    //System.out.println(toString(Array));
    if (end - start < 10){
      insertionSort(Array,start,end);
    }
    int initial = partition(Array, start, end);
    //System.out.println("initial = " + initial);
    if (initial == index){
      return Array[index];
    } else if (initial > index){
      //if (initial >= 1){
      // while (Array[initial] == Array[initial-1]){
      //   initial --;
      //   if (initial == index){
      //     return Array[initial];
      //   }
      // }
      return quickSelectHelper(Array, index, start, initial-1);
      //}
    } else {
      return quickSelectHelper(Array, index, initial+1, end);
    }
  }
  public static void quicksort(int[] arr){
    //int x = 0;
    for (int i = 0; i < arr.length; i++){
      quickSelect(arr, i);
      //Swap(arr,x,i);
      //x++;
    }
  }

  public static String toString(int[] arr){
    String result = "";
    for (int x = 0; x < arr.length; x++){
      result += arr[x] + " ";
    }
    return result;
  }
  public static void insertionSort(int[] data, int lo, int hi){
    for (int i = lo+1; i < hi; i++){
      int j = i;
      while (j > lo && data[j] < data[j-1]){
        Swap(data,j,j-1);
        j -= 1;
      }
    }
  }
}
