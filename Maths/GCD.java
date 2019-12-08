package Maths;

/**
 * 최대공약수를 찾는 유클리드 알고리즘 입니다
 * 함수 gcd(최대공약수)는 overide를 사용하였습니다 
 *
 * @author Oskar Enmalm 3/10/17
 */
public class GCD {

    /**
     * 최대공약수를 구합시다
     *
     * @인자 num1은 첫 번째 숫자입니다
     * @인자 num2는 두 번째 숫자입니다
     * @gcd를 반환합니다
     */
    public static int gcd(int num1, int num2) {
        if (num1 < 0 || num2 < 0) {
            throw new ArithmeticException();
        }

        if (num1 == 0 || num2 == 0) {
            return Math.abs(num1 - num2);
        }

        while (num1 % num2 != 0) {
            int remainder = num1 % num2;
            num1 = num2;
            num2 = remainder;
        }
        return num2;
    }

    /**
     * 배열에서 최대공약수를 찾읍시다
     *
     * @인자로 배열에 저장된 숫자들을 받습니다
     * @gcd를 반환합니다
     */
    public static int gcd(int[] number) {
        int result = number[0];
        for (int i = 1; i < number.length; i++)
            // call gcd function (input two value)
            result = gcd(result, number[i]);

        return result;
    }

    public static void main(String[] args) {
        int[] myIntArray = {4, 16, 32};

        // gcd 함수를 호출합시다 (배열을 넣고)
        System.out.println(gcd(myIntArray)); // => 4
        System.out.printf("gcd(40,24)=%d gcd(24,40)=%d\n", gcd(40, 24), gcd(24, 40)); // => 8
    }
}
