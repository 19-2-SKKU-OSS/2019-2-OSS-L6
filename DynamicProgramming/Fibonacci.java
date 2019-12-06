package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Varun Upadhyay (https://github.com/varunu28)
 */

public class Fibonacci {

    private static Map<Integer, Integer> map = new HashMap<>();


    public static void main(String[] args) {

        // n = [0, 1, 2, 3, 4, 5, ...]에 대해 모두 [0, 1, 1, 2, 3, 5, ...]를 반환하는 메소드        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.println(fibMemo(n));
        System.out.println(fibBotUp(n));
        System.out.println(fibOptimized(n));
    }

    /**
     * 이 방법은 메모 기술을 사용하여 n 번째 피보나치 수를 찾습니다.
     *
     * @param n 피보나치 수를 결정해야하는 입력 n 하고
     *           n 번째 피보나치 수를 출력합니다
     **/
    public static int fibMemo(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int f;

        if (n <= 1) {
            f = n;
        } else {
            f = fibMemo(n - 1) + fibMemo(n - 2);
            map.put(n, f);
        }
        return f;
    }

    /**
     * 이 방법은 상향식을 사용하여 n 번째 피보나치 수를 찾습니다.
     *
     *  @param n 피보나치 수를 결정해야하는 입력 n 하고
     *         n 번째 피보나치 수를 출력합니다
     **/
    public static int fibBotUp(int n) {

        Map<Integer, Integer> fib = new HashMap<>();

        for (int i = 0; i <= n; i++) {
            int f;
            if (i <= 1) {
                f = i;
            } else {
                f = fib.get(i - 1) + fib.get(i - 2);
            }
            fib.put(i, f);
        }

        return fib.get(n);
    }


    /**
     * 이 방법은 상향식을 사용하여 n 번째 피보나치 수를 찾습니다.
     *
     * @ @param n 피보나치 수를 결정해야하는 입력 n 하고
     *         n 번째 피보나치 수를 출력합니다
     * 
     * 이것은 피보나치 프로그램의 최적화 된 버전입니다. 해시 맵과 재귀를 사용하지 않습니다.
     * 메모리와 시간을 모두 절약합니다.
     * 공간 복잡도는 O (1)입니다.
     * 시간 복잡도는 O (n)입니다.
     * <p>
     * 위의 함수는 O (n) 공간을 차지합니다.
     * @author Shoaib Rayeen (https://github.com/shoaibrayeen)
     **/
    public static int fibOptimized(int n) {
        if (n == 0) {
            return 0;
        }
        int prev = 0, res = 1, next;
        for (int i = 2; i <= n; i++) {
            next = prev + res;
            prev = res;
            res = next;
        }
        return res;
    }
}
