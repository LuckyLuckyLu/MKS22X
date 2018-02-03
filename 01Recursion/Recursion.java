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


//   public int fib(int n){
//     if (n<0){
//       throw new IllegalArgumentException();
//     }

//   }
//   public double sqrt(double n){
//     if (n<0){
//       throw new IllegalArgumentException();
//     }
//     // based on Newton's Square Root Approximation.

//   }
}
