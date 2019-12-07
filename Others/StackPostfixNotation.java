package Others;

import java.util.*;
// 스택 후위 표기법 알고리즘: 스택을 이용하여 식을 후위 표기식을 계산하는 알고리즘.
public class StackPostfixNotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String post = scanner.nextLine();   // Takes input with spaces in between eg. "1 21 +"
        System.out.println(postfixEvaluate(post));
    }

    // Evaluates the given postfix expression string and returns the result.
    public static int postfixEvaluate(String exp) {
        Stack<Integer> s = new Stack<Integer>();
        Scanner tokens = new Scanner(exp);

        while (tokens.hasNext()) {
            if (tokens.hasNextInt()) {
                s.push(tokens.nextInt()); //숫자는 계속 푸시한다.
            } else { 
                int num2 = s.pop(); //연산자가 들어오면 pop하면서 저장.
                int num1 = s.pop();
                String op = tokens.next();

                if (op.equals("+")) {
                    s.push(num1 + num2);
                } else if (op.equals("-")) {
                    s.push(num1 - num2);
                } else if (op.equals("*")) {
                    s.push(num1 * num2);
                } else {
                    s.push(num1 / num2);
                }//저장한 두 값을 연산자에 따라 계산한다.

                //  "+", "-", "*", "/"
            }
        }
        return s.pop();
    }
}
