import java.util.LinkedList;
public class eval{
  public static Double eval(String Expression){
    LinkedList<Double> stack = new LinkedList<Double>();
    String[] data = Expression.split(" ");
    for (int i = 0; i < data.length; i++){
      if (data[i].equals("+")){
        stack.add(stack.pop() + stack.pop());
      } else if (data[i].equals("-")){
        //System.out.println(stack.pop() + "-" + stack.pop());
        stack.add(stack.pop() - stack.pop());
      } else if (data[i].equals("*")){
        stack.add(stack.pop() * stack.pop());
      } else if (data[i].equals("/")){
        stack.add(stack.pop() / stack.pop());
      } else if (data[i].equals("%")){
        stack.add(stack.pop() % stack.pop());
      } else {
        stack.add(Double.parseDouble(data[i]));
        //System.out.println(Double.parseDouble(data[i]));
      }
    }
    //return 0.0;
    return stack.pop();
  }
  public static void main(String[] args){
    System.out.println(eval("1 2 - 3 + 4 / 0.5 %"));
  }
}
