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
    int v = (int)(Math.random() * ((end-start) + 1) + start);//index.nextInt(end) + start;;
    int Vvalue = data[v];
    Swap(data,v,start);
    int front = start + 1;
    int back = end;
    while(front <= back){
      if (data[front] > Vvalue){
        Swap(data,front,back);
        back --;
      } else{
        front ++;
      }
    }
    Swap(data,back,start);
    for (int x = 0; x < data.length; x++){
      if (data[x] == Vvalue){
        return x;
      }
    }
    return 0;
  }
  public static int partitionV2(int[] data, int start, int end){
    if (data.length < 2){
      return start;
    }
    int v = (int)(Math.random() * ((end-start) + 1) + start);//counter.nextInt(end) + start;;
    int Vvalue = data[v];
    Swap(data,v,start);
    int front = start+1;
    int counter = start;
    int back = end;
    while(front <= back){
      if (data[front] == Vvalue){
        counter++;
        Swap(data,front,counter);
      } else if (data[front] > Vvalue){
        Swap(data,front,back);
        back--;
      } else if (data[front] < Vvalue){
        front++;
      }
      /*
        if (data[counter] > Vvalue){
        Swap(data,counter,back);
        back --;
        } else if (data[counter] < Vvalue){
        Swap(data,counter,front);
        front++;
        counter++;
        } else{
        counter ++;
        }
      */
    }
    for (int i = start; i <= counter; i++){
      Swap(data,i,front-i);
    }
    //Swap(data,back,start);
    /*for (int x = 0; x < data.length; x++){
      if (data[x] == Vvalue){
      return x;
      }
      }
    */
    for (int i = start; i <= end; i++){
      if (data[i] == Vvalue){
        return i;
      }
    }
    return v;
  }
  public static int partitionV3(int[] data, int start, int end){
    if (data.length < 2){
      return start;
    }
    //if (end-start<=0){
    //  return start;
    //}
    int v = (int)(Math.random() * ((end-start) + 1) + start);//counter.nextInt(end) + start;;
    System.out.println("pivot = "+ v);
    int Vvalue = data[v];
    Swap(data,v,start);
    int front = start+1;
    int counter = start;
    int back = end;
    while(front <= back){
      if (data[front] == Vvalue){
        counter++;
        Swap(data,front,counter);
        front++;
      } else if (data[front] > Vvalue){
        Swap(data,front,back);
        back--;
      } else if (data[front] < Vvalue){
          front++;
      }
      /*
        if (data[counter] > Vvalue){
        Swap(data,counter,back);
        back --;
        } else if (data[counter] < Vvalue){
        Swap(data,counter,front);
        front++;
        counter++;
        } else{
        counter ++;
        }
      */
    }
    if (front > back){
      front = back;
    }
    if (front > data.length){
      front = data.length;
    }
    if (back == -1){
      back = 0;
    }
    for (int i = start; i <= counter; i++){
      Swap(data,i,back-i);
    }
    //Swap(data,back,start);
    /*for (int x = 0; x < data.length; x++){
      if (data[x] == Vvalue){
      return x;
      }
      }
    */
    for (int i = start; i < end; i++){
      if (data[i] == Vvalue){
        v = i;
      }
    }

    return v;
  }
  
  
  public static int quickSelect(int[]ary, int index){
    return quickSelectHelper(ary,index,index,ary.length-1);
  }
  private static int quickSelectHelper(int[] Array, int index, int start, int end){
    System.out.println(toString(Array));
    int initial = partitionV3(Array, start, end);
    System.out.println("initial = " + initial);
    if (initial == index){
      return Array[initial];
    } else if (initial > index){
      //if (initial >= 1){
      // while (Array[initial] == Array[initial-1]){
      //   initial --;
      //   if (initial == index){
      //     return Array[initial];
      //   }
      // }
      return quickSelectHelper(Array, index, start, initial);
      //}
    } else {
      return quickSelectHelper(Array, index, initial, end);
    }
  }

  public static String toString(int[] arr){
    String result = "                              ";
    for (int x = 0; x < arr.length; x++){
      result += arr[x] + " ";
    }
    return result;
  }
}
