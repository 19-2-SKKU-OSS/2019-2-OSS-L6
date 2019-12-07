package Others;

/* Program to reverse a Stack using Recursion
 * 스택 뒤집기 알고리즘: 재귀함수를 이용하여 스택을 뒤집는 알고리즘.
 * */

import java.util.Stack;

public class ReverseStackUsingRecursion {

    //Stack
    private static Stack<Integer> stack = new Stack<>();

    //Main function
    public static void main(String[] args) {
        //To Create a Dummy Stack containing integers from 0-9
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println("STACK");

        //To print that dummy Stack
        for (int k = 9; k >= 0; k--) {
            System.out.println(k);
        }

        //Reverse Function called
        reverseUsingRecursion(stack);

        System.out.println("REVERSED STACK : ");
        //To print reversed  stack
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }


    }

    //Function Used to reverse Stack Using Recursion
    private static void reverseUsingRecursion(Stack<Integer> stack) { //재귀함수를 이용하여 스택을 뒤집는 함수
        if (stack.isEmpty()) // If stack is empty then return
        {
            return;
        }
        /* All items are stored in call stack until we reach the end*/

        int temptop = stack.peek();
        stack.pop();
        reverseUsingRecursion(stack); //Recursion call
        insertAtEnd(temptop); // Insert items held in call stack one by one into stack
    }

    //Function used to insert element at the end of stack
    private static void insertAtEnd(int temptop) { //원소를 스택의 끝에 삽입하는 함수
        if (stack.isEmpty()) {
            stack.push(temptop); // If stack is empty push the element
        } else {
            int temp = stack.peek(); /* All the items are stored in call stack until we reach end*/
            stack.pop();

            insertAtEnd(temptop); //Recursive call

            stack.push(temp);
        }

    }

}
