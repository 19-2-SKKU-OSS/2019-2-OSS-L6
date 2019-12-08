package Maths;

/**
 * @author https://github.com/shellhub/
 */
public class GCDRecursion {
    public static void main(String[] args) {
        System.out.println(gcd(20, 15)); /* output: 5 */
        System.out.println(gcd(10, 8));  /* output: 2 */
        System.out.println(gcd(gcd(10, 5), gcd(5, 10))); /* output: 5 */
    }

    /**
     * 최대공약수를 구합니다
     *
     * @첫 번째 숫자 a가 인자입니다
     * @두 번째 숫자 b도 인자입니다
     * @최대공약수(gcd)를 반환합니다
     */
    public static int gcd(int a, int b) {

        if (a < 0 || b < 0) {
            throw new ArithmeticException();
        }

        if (a == 0 || b == 0) {
            return Math.abs(a - b);
        }

        if (a % b == 0) { //나머지가 0이면 약수라는 의미입니다
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}
