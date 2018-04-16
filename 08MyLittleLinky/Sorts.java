public class Sorts{
  public static void radixsort(MyLinkedListImproved<Integer> AllDATA){
    if (AllDATA == null || AllDATA.size() == 0){
      return;
    }
    MyLinkedListImproved<Integer> positive = new MyLinkedListImproved();
    MyLinkedListImproved<Integer> negative = new MyLinkedListImproved();
    boolean Negativity = false;
    boolean Positivity = false;
    for (Integer x: AllDATA){
      if (x < 0){
        Negativity = true;
        negative.add(x);
      } else {
        Positivity = true;
        positive.add(x);
      }
    }
    AllDATA.clear();
    if (Positivity && Negativity){
      radixNegative(negative);
      radixPositive(positive);
      negative.extend(positive);
      AllDATA.extend(negative);
    } else if (Negativity){
      radixNegative(negative);
      AllDATA.extend(negative);
    } else if (Positivity){
      radixPositive(positive);
      AllDATA.extend(positive);
    }
    //System.out.println(AllDATA);
  }
  public static void radixNegative(MyLinkedListImproved<Integer> data){
    @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];
    //int max = info.get(data.max());
    //System.out.println(data);
    int minValue = data.get(data.min());
    int numDigits = RunTimes(minValue);//+1;
    //System.out.println("MIN: "+ minValue);
    //System.out.println(numDigits);

    for (int i = 0; i < 10; i++){
      buckets[i] = new MyLinkedListImproved<Integer>();
      //System.out.println(buckets[i]);
    }
    for (Integer x : data){
      buckets[0].add(x);
    }
    data.clear();
    //System.out.println(buckets[0]);
    
    //System.out.println(maxValue);
    /*
      for(MyLinkedListImproved<Integer> x: info){
      x = new MyLinkedListImproved();
      System.out.println(x);
      }
    */
    
    
    for(int i = 1; i <= numDigits; i++){
      @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] info = new MyLinkedListImproved[10];

      for (int bukNum = 0; bukNum < 10; bukNum++){
        if (buckets[bukNum] != null){
          for (Integer n : buckets[bukNum]){
            int Location = getDigit(n,i)+9;
            //System.out.println("Number " + n + " Location: "+ Location);

            if (info[Location] == null){
              info[Location] = new MyLinkedListImproved<Integer>();
              info[Location].add(n);
            } else {
              info[Location].add(n);
            }
          }
        }
      }
      buckets = info;
    }
    for (MyLinkedListImproved<Integer> List : buckets){
      if (List != null){
        data.extend(List);
      }
    }
    //data.reverse();
    //for (Integer x: data){
    //  x *= -1;
    //}
    //System.out.println(data);
  }



  
  public static void radixPositive(MyLinkedListImproved<Integer> data){
    @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];
    //int max = info.get(data.max());
    //System.out.println(data.max());
    int maxValue = data.get(data.max());
    int numDigits = RunTimes(maxValue);//+1;
    //System.out.println(maxValue);
    //System.out.println(numDigits);

    for (int i = 0; i < 10; i++){
      buckets[i] = new MyLinkedListImproved<Integer>();
      //System.out.println(buckets[i]);
    }
    for (Integer x : data){
      buckets[0].add(x);
    }
    data.clear();
    //System.out.println(buckets[0]);
    
    //System.out.println(maxValue);
    /*
      for(MyLinkedListImproved<Integer> x: info){
      x = new MyLinkedListImproved();
      System.out.println(x);
      }
    */
    
    
    for(int i = 1; i <= numDigits; i++){
      @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] info = new MyLinkedListImproved[10];

      for (int bukNum = 0; bukNum < 10; bukNum++){
        if (buckets[bukNum] != null){
          for (Integer n : buckets[bukNum]){
            int Location = getDigit(n,i);
            //System.out.println("Number " + n + " Location: "+ Location);

            if (info[Location] == null){
              info[Location] = new MyLinkedListImproved<Integer>();
              info[Location].add(n);
            } else {
              info[Location].add(n);
            }
          }
        }
      }
      buckets = info;
    }
    for (MyLinkedListImproved<Integer> List : buckets){
      if (List != null){
        data.extend(List);
      }
    }
    //System.out.println(data);
  }



  
  public static void printOut(MyLinkedListImproved<Integer>[] x){
    for (MyLinkedListImproved<Integer> z: x){
      System.out.println(z + ", ");
    }
  }


  
  public static int RunTimes(int x){
    int n = 0;
    while (Math.abs(x) > 0){
      n++;
      x/= 10;
    }
    return n;
  }


  
  public static int getDigit(int original, int powerOF10){
    for (int i = 1; i < powerOF10; i++){
      original = original / 10;
    }
    return original % 10;
  }
  
  public static void main(String[] args){
    MyLinkedListImproved<Integer> x = new MyLinkedListImproved<>();
    x.add(10);
    x.add(3);
    x.add(2);
    x.add(10);    //for (int z : x){
    //  System.out.println(z);
    //}
    radixsort(x);
    System.out.println(x);
  }
}
