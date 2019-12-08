package Maths;

public class FactorialRecursion {

    /* Driver Code */
    public static void main(String[] args) {
        assert factorial(0) == 1;
        assert factorial(1) == 1;
        assert factorial(2) == 2;
        assert factorial(3) == 6;
        assert factorial(5) == 120;
    }

    /**
     * 재귀형 팩토리얼입니다
     *
     * @인자로 숫자 n을 받습니다
     * @n의 팩토리얼을 반환합니다
     * n 팩토리얼은 1*2*3*...*(n-1)*n 입니다
     * Factorial.java는 iterative, FactorialRecurion.java는 recursive 합니다
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("number is negative");
        }
        return n == 0 || n == 1 ? 1 : n * factorial(n - 1);
    }
}
