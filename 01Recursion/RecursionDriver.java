public class RecursionDriver{
  public static void main(String[] Args){
    Recursion ref = new Recursion();
    //for (int n = 0; n < 10; n++){
    //  System.out.println(ref.fact(n));
    //}
    //for (int n = 0; n < 100; n++){
    //  System.out.println(ref.fib(n));
    //}
    for (int n = 0; n <= 100; n ++){
      System.out.println(ref.sqrt(n));
    }
    for (int n = 0; n < 10; n ++){
      System.out.println(ref.isPossibleSum(n,5));
    }
  }
}
