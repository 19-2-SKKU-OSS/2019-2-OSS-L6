package Conversions;

import java.util.Scanner;

/**
 * 10진수의 숫자를 8진수의 숫자로 변환하는 클래스
 *
 * @author Unknown
 */
public class DecimalToOctal {
    /**
     * Main Method
     *
     * @param args Command line Arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k, d, s = 0, c = 0;
        System.out.print("Decimal number: ");
        n = sc.nextInt();
        k = n;
        while (k != 0) {
            d = k % 8;
            s += d * (int) Math.pow(10, c++);
            k /= 8;
        }

        System.out.println("Octal equivalent:" + s);
        sc.close();
    }
}
// 10진수의 숫자를 8진수의 숫자로 변환하는 클래스이다.
