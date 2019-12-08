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
     * Check if a number is fibonacci number
     * This is true if and only if at least one of 5x^2+4 or 5x^2-4 is a perfect square
     *
     * @param number the number
     * @return <tt>true</tt> if {@code number} is fibonacci number, otherwise <tt>false</tt>
     * @link https://en.wikipedia.org/wiki/Fibonacci_number#Identification
     */
    public static boolean isFibonacciNumber(int number) {
        return isPerfectSquare(5 * number * number + 4) || isPerfectSquare(5 * number * number - 4);
    }
}
