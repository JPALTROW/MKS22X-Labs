import java.util.*;

public class Calculator{
  /*Evaluate a postfix expression stored in s.
  *Assume valid postfix notation, of ints doubles and operators separated by spaces.
  *Valid operators are + - / * and % (remainder not modulo)
  *All results are doubles even if the operands are both int.
  *@throws IllegalArgumentException when there are too many or too few operands.
  *        Use the string parameter of your exception to indicate what happened.
  *        Either "too many operands" or "too few operands for operation _" replace _ with +,- etc.
  */
  public static double eval(String s){
    ArrayDeque<Double> numsStack = new ArrayDeque<Double>();
    String[] tokens = s.split(" ");
    int i = 0;
    double num1;
    double num2;
    char token;
    while(i <tokens.length){
      if(!Character.isDigit(tokens[i].charAt(0))){
        if (numsStack.size() == 1){
          throw new IllegalArgumentException("insufficient number of operands");
        }
        token = tokens[i].charAt(0);
        num2 = numsStack.pollLast();
        num1 = numsStack.pollLast();
        switch(token){
          case '+':
            numsStack.offerLast(num1+num2);
            break;
          case '*':
            numsStack.offerLast(num1*num2);
            break;
          case '-':
            numsStack.offerLast(num1-num2);
            break;
          case '/':
            numsStack.offerLast(num1/num2);
            break;
          default:
            numsStack.offerLast(num1%num2);
            break;
        }
      }else{
        numsStack.offerLast(Double.parseDouble(tokens[i]));
      }
      i++;
    }
    if (numsStack.size() > 1){
      throw new IllegalArgumentException("too many operands");
    }
    return 0;
  }
}
