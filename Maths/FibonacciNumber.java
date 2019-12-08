package Maths;

/**
 * Fibonacci: 0 1 1 2 3 5 8 13 21 ...
 * 피보나치수열을 구합니다
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        assert isFibonacciNumber(1);
        assert isFibonacciNumber(2);
        assert isFibonacciNumber(21);
        assert !isFibonacciNumber(9);
        assert !isFibonacciNumber(10);
    }

    /**
     * 숫자가 완전 제곱수인지 판단합니다
     *
     * @인자로 받은 수를 체크합니다
     * @받은 수가 완전 제곱수이면 true를 반환하고 아니면 false를 반환합니다
     */
    public static boolean isPerfectSquare(int number) {
        int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }

    /**
     * 숫자가 피보나치 수인지 판단합니다
     * 5n^2+4와 5n^2-4 둘 중 하나라도 완전 제곱수면 그 숫자는 피보나치 수 입니다
     *
     * @인자로 숫자 n을 받습니다
     * @숫자 n이 피보나치 수이면 true를 반환하고 아니면 false를 반환합니다
     * @링크를 참조하세요 https://en.wikipedia.org/wiki/Fibonacci_number#Identification
     */
    public static boolean isFibonacciNumber(int number) {
        return isPerfectSquare(5 * number * number + 4) || isPerfectSquare(5 * number * number - 4);
    }
}
