
public class Merge{
  public static void swap(int[] arry, int x, int y){
    int temp = arry[x];
    arry[x] = arry[y];
    arry[y] = temp;
  }
  public static void mergesort(int[]data){ // -  sort the array from least to greatest value. This is a wrapper function that calls msort()
    int[] temp = new int[data.length];
    msort(data,temp,0,data.length);
  }

  // public int[] mergesort(int[] data, int[] temp, int lo, int hi){
  //  int mid=0;
  //  //int[] STA, STB, final;
  //  if (lo!=hi){
  //    mid=(lo+hi)/2;
  //    mergesort(temp, data, lo, mid);
  //    mergesort(temp, data, mid+1,hi);
  //  }
  //    final = merge(STA,STB);
  //    return final;
  //    }
  
  
  public static void msort(int[]data, int[]temp, int lo, int hi){
    System.out.println(toString(data));
    System.out.println(toString(temp));
    if (hi - lo < 15){
      insertionSort(data,lo,hi);
      return;
    }
    if (lo < hi){
      for (int i = lo; i <= hi; i++){
        temp[i] = data[i];
      }
      int mid = (hi+lo)/2;
      msort(temp,data,lo,mid);
      //System.out.println("First msort data = " + toString(data));
      //System.out.println("temp" + toString(temp));
      msort(temp,data,mid,hi);
      mergeV2(data,temp,lo,mid,hi);
    }
  }
    

  public static int[]  merge(int[] data, int[] temp){//, int lo, int mi, int hi){
    int[] total = new int[data.length+temp.length];
    int di = 0;
    int ti = 0;
    int index = 0;
    while (di < data.length || ti < temp.length){
      if (di < data.length && ti < temp.length){
        if (data[di] <= temp[ti]){
          total[index] = data[di];
          di++;
        } else {
          total[index] = temp[ti];
          ti++;
        }
      } else if (di < data.length){
        total[index] = data[di];
        di++;
      } else if (ti < temp.length){
        total[index] = temp[ti];
        ti++;
      }
      index++;
    }
    data = new int[total.length];
    // System.out.println("create new array, total.length =" + total.length + "Now data string is " + toString(data));
    int i = 0;
    while (i < total.length){
      data[i] = total[i];
      // System.out.println("copy from total to data, i =" + i + "Now data string is " + toString(data));
      i++;
    }
    return data;
  }

  public static int[]  mergeV2(int[] data, int[] temp, int lo, int mi, int hi){
    //int[] total = new int[data.length+temp.length];
    int di = lo;
    int ti = mi;
    int index = 0;
    while (di < mi || ti <= hi){
      if (di < mi && ti < hi){
        if (data[di] <= data[ti]){
          temp[index] = data[di];
          di++;
        } else {
          temp[index] = data[ti];
          ti++;
        }
      } else if (di < mi){
        temp[index] = data[di];
        di++;
      } else if (ti <= hi){
        temp[index] = data[ti];
        ti++;
      }
      index++;
    }
    //data = new int[total.length];
    // System.out.println("create new array, total.length =" + total.length + "Now data string is " + toString(data));
    //int i = 0;
    //while (i < total.length){
    //  data[i] = total[i];
    // System.out.println("copy from total to data, i =" + i + "Now data string is " + toString(data));
    //  i++;
    //}
    return temp;
  }
  public static void insertionSort(int[] data, int lo, int hi){
    for (int i = lo+1; i < hi; i++){
	    int j = i;
	    while (j > lo && data[j] < data[j-1]){
        swap(data,j,j-1);
        j -= 1;
	    }
    }
}

 
  public static String toString(int[] outst){
    String result = "";
    int index = 0;
    // System.out.println("output string length = "+ outst.length);
    while (index < outst.length){
      result += outst[index] + " ";
      index++;
    }
    return result;
  }
  



    
  public static void main(String[] Arg){
    int[] data = {1,2,3,4,5,6,7};
    int[] test = {2,6,7,9,19};
    merge(data,test);
    System.out.println(toString(data));
    data = merge(data,test);
    System.out.println(toString(data));
  }
}
