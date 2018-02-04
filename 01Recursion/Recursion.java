public class Recursion{
  public int fact(int n){
    if (n<0){
      throw new IllegalArgumentException();
    }
    return factHelp(n,1);
  }

  public int factHelp(int current, int product){
    if (current == 0){
      return product;
    } else {
      return factHelp(current - 1, product * current);
    }
  }


  public int fib(int n){
    if (n<0){
      throw new IllegalArgumentException();
    } else {
      return fibHelper(n,0,1);
    }
  }

  public int fibHelper(int index, int two, int one){
    if (index == 0){
      return two;
    } else {
      return fibHelper(index - 1, one, two + one);
    }
  }
  // based on Newton's Square Root Approximation.
  public double sqrt(double n){
    if (n<0){
      throw new IllegalArgumentException();
    } else if (n == 0){
      return 0d;
    } else {
      return sqrtHelper(n, 1);
    }
  }

  public double sqrtHelper(double n, double guess){
    if (Math.abs((guess*guess - n)/n) < .01){
      return guess;
    } else {
      return sqrtHelper(n, (n / guess + guess) / 2);
    }
  }
}
