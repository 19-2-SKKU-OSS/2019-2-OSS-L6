package Others;

import java.util.Scanner;

/**
 * Fibonacci sequence, and characterized by the fact that every number
 * after the first two is the sum of the two preceding ones.
 * <p>
 * Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21,...
 * <p>
 * Source for the explanation: https://en.wikipedia.org/wiki/Fibonacci_number
 * 피보나치 수열 알고리즘: 현재의 값이 현재-1번째와 현재-2번째의 값의 합인 수열을 만드는 알고리즘
 */

public class FibToN {
    public static void main(String[] args) {
        //take input
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int first = 0, second = 1;
        scn.close();
        while (first <= N) { //N 이하까지의 피보나치 수열을 만듬

            System.out.println(first);

            int next = first + second;
            first = second; //첫번째에는 두번째를 넣는다.
            second = next; //두번째에는 전에 첫번째와 두번째를 합한 것을 넣는다.
        }
    }

}
