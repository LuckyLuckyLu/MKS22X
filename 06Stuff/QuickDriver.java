import java.util.Arrays;

public class QuickDriver{



  //Sort testing code
  private static final int INCREASE = 0;
  private static final int DECREASE = 1;
  private static final int STANDARD = 2;
  private static final int SMALL_RANGE = 3;
  private static final int EMPTY = 4;

  private static String name(int i){
    if(i==0)return "Increassing";
    if(i==1)return "Decreassing";
    if(i==2)return "Normal Random";
    if(i==3)return "Random with Few Values";
    if(i==4)return "size 0 array";
    return "Error stat array";

  }

  private static int create(int min, int max){
    return min + (int)(Math.random()*(max-min));
  }

  private static int[]makeArray(int size,int type){
    int[]ans =new int[size];
    if(type == STANDARD){
      for(int i = 0; i < size; i++){
        ans[i]= create(-1000000,1000000);
      }
    }
    if(type == INCREASE){
      int current = -5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current += 10;
      }
    }
    if(type == DECREASE){
      int current = 5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current -= 10;
      }
    }
    if(type == SMALL_RANGE){
      for(int i = 0; i < size; i++){
        ans[i]= create(-5,5);
      }
    }
    if(type == EMPTY){
      ans = new int[0];
    }
    return ans;
  }

  public static void main(String[]args){
    if(args.length < 2)return;

    int size =  Integer.parseInt(args[0]);
    int type =   Integer.parseInt(args[1]);

    int [] start = makeArray(size,type);
    int [] result = Arrays.copyOf(start,start.length);
    Arrays.sort(result);

    long startTime = System.currentTimeMillis();
    /*
     * Test your sort here!
     */
    Quick.quicksort(start);
    long elapsedTime = System.currentTimeMillis() - startTime;
    if(Arrays.equals(start,result)){
      System.out.println("PASS Case "+name(type)+" array, size:"+size+" "+elapsedTime/1000.0+"sec ");
    }else{
      System.out.println("FAIL ! ERROR ! "+name(type)+" array, size:"+size+"  ERROR!");
    }
  }
  /*
    public static void main(String[] args){


    //MOST IMPORTANT TEST........PARTITION!!!
    //(This could be more extensive ..... and better .... and A LOT MORE!)
    //(My Quick.partition returns the index num of PIVOT, and is inclusive of the last num)
    /*
    System.out.println("TESTING PARTITION");

    int[] tests = {0,0,2,0,1,2,1,1,1,2,0,2,2};//{0,1,0,1,0,1,2,0,1,2,1,2,2};//{1000, 999,999,999,4,1,0,3,2,999,999,100,100,-10000, 10212, -19212, 23, 12};

    toString(tests);

    int ans = Quick.partitionV3(tests, 0, tests.length - 1);
    System.out.println("Pivot: " + tests[ans] + " Index: " + ans);
    System.out.println("Pivot correct? " + checkPivot(tests, ans));
    toString(tests);


    int[] testt = {};
    ans = Quick.partition(testt, 0, 0);
    toString(testt);

    int[] testu = {1};
    ans = Quick.partition(testu, 0, 1);
    System.out.println("Pivot: " + testu[ans] + " Index: " + ans);
    toString(testu);


    int[] testv = {1,1};
    ans = Quick.partition(testv, 0, 1);
    System.out.println("Pivot: " + testv[ans] + " Index: " + ans);
    toString(testv);

    int[] testw = {2,1};
    ans = Quick.partition(testw, 0, 1);
    System.out.println("Pivot: " + testw[ans] + " Index: " + ans);
    toString(testw);

    int[] testx = {1,2};
    ans = Quick.partition(testx, 0, 1);
    System.out.println("Pivot: " + testx[ans] + " Index: " + ans);
    toString(testx);
    System.out.println("DONE!\n");


    //int[] test = {6,5,4,3,2,1};//{0,1,0,1,0,1,2,0,1,2,1,2,2};//{2,1,4,6,8,0,-1,-2,7,9};//
    int[] test = {1000, 999,999,999,4,1,0,3,2,999,999,100,100,-10000, 10212, -19212, 23, 12};
    toString(test);
    ////SHOULD PRINT THE ARRAY IN ORDER FROM LEAST TO GREATEST
    System.out.println("\nPRINTING LEAST TO GREATEST");
    for (int i = 0; i < test.length; i++){
    System.out.println(Quick.quickSelect(test, i));;
    }
    System.out.println("DONE!\n");


    //Testing QuickSort
    System.out.println("TESTING QUICKSORT!");
    //General Case

    long start,end;
    start = System.currentTimeMillis();

    System.out.print("Before: ");
    int[] testy = {1000, 999,999,999,4,1,0,3,2,999,999,100,100,-10000, 10212, -19212, 23, 12};
    toString(testy);
    Quick.quicksort(testy);
    end = System.currentTimeMillis();

    System.out.print("aAfter: ");
    toString(testy);
    System.out.println("Time: " + (end-start) + "ms");

    //Edge Cases

    System.out.print("\nTESTING EDGY CASES!\n");

    int[] testz = {};
    System.out.print("Before: ");
    toString(testz);
    System.out.print("aAfter: ");
    Quick.quicksort(testz);
    toString(testz);
    System.out.println();

    int[] testa = {1};
    System.out.print("Before: ");
    toString(testa);
    System.out.print("aAfter: ");
    Quick.quicksort(testa);
    toString(testa);
    System.out.println();

    int[] testb = {1,1};
    System.out.print("Before: ");
    toString(testb);
    System.out.print("aAfter: ");
    Quick.quicksort(testb);
    toString(testb);
    System.out.println();

    int[] testc = {2,1};
    System.out.print("Before: ");
    toString(testc);
    System.out.print("aAfter: ");
    Quick.quicksort(testc);
    toString(testc);
    System.out.println();

    int[] testd = {1,2};
    System.out.print("Before: ");
    toString(testd);
    System.out.print("aAfter: ");
    Quick.quicksort(testd);
    toString(testd);
    System.out.println();


    }

    //Checks to see if pivot is correct
    //Given: ary, pivot
    private static boolean checkPivot(int[] ary, int pivot){
    for (int i = 0; i < pivot; i++){
    if (ary[i] > ary[pivot]){
    return false;
    }
    }
    for (int j = pivot + 1; j < ary.length; j++){
    if (ary[j] < ary[pivot]){
    return false;
    }
    }
    return true;
    }


    private static void toString(int[] parti){
    for (int k = 0; k < parti.length; k++){
    System.out.print(parti[k] + ", ");
    }
    System.out.println();
    }
  */
}
