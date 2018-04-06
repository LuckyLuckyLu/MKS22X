public class Merge{
  public static void main(String[] args){
    int[] data = {3,5,9,2,4,8,1,6};
    int[] temp = new int[data.length];
    //int[] Final = new int[data.length+temp.length];

    mergesort(data,temp,0,data.length-1);
    System.out.println(toString(data));
  }
  public static void mergeSort(int[] data){
    int[] temp = new int[data.length];
    mergesort(data,temp,0,data.length-1);
  }
  public static void mergesort(int[] data, int[] temp, int lo, int hi){
    if(data.length <= 0){
      return;
    }
    int flo=lo;
    int fhi=lo/2+hi/2;
    int slo=lo/2+hi/2+1; //hi-fhi;
    int shi=hi;
    if (flo != fhi){
      mergesort(data, temp, flo, fhi);
    }
    if (slo != shi){
      mergesort(data, temp, slo, shi);
    }
    merge(data,temp,flo,fhi,slo,shi);
    for (int i=flo;i<=shi;i++){
      data[i]=temp[i];
    }
  }

  public static void merge(int[] data, int[] temp, int firstlo, int firsthi, int secondlo, int secondhi){
    //int[] total = new int[data.length+temp.length];
    int di = firstlo;
    int ti = secondlo;
    int index = firstlo;
    while (di <= firsthi || ti <= secondhi){
      if (di <= firsthi && ti <= secondhi){
        if (data[di] <= data[ti]){
          temp[index] = data[di];
          di++;
        } else {
          temp[index] = data[ti];
          ti++;
        }
      } else if (di <= firsthi){
        temp[index] = data[di];
        di++;
      } else if (ti <= secondhi){
        temp[index] = data[ti];
        ti++;
      }
      index++;
    }
  }

  public static int[]  mergeV1(int[] data, int[] temp){//, int lo, int mi, int hi){
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
    return total;
  }
  public static String toString(int[] Arg){
    String result = "";
    for (int i = 0; i < Arg.length; i++){
      result += Arg[i];
    }
    return result;
  }
}
