package Maths;

public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(n + "! = " + factorial(n));
    }

    /**
     * 팩토리얼을 계산합니다
     *
     * @인자로 숫자 n을 받습니다
     * @n의 팩토리얼을 반환합니다
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new ArithmeticException("n < 0");
        }
        long fac = 1;
        for (int i = 1; i <= n; ++i) {
            fac *= i;
        }
        return fac;
    }
}
