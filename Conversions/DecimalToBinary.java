package Conversions;

import java.util.Scanner;

/**
 * 10진수를 2진수로 변환하는 클래스
 *
 * @author Unknown
 */
class DecimalToBinary {

    /**
     * Main Method
     *
     * @param args Command Line Arguments
     */
    public static void main(String args[]) {
        conventionalConversion();
        bitwiseConversion();
    }

    /**
     * 아래의 함수는 전통적인 알고리즘으로, 10진수를 2진수로 변환시키는 함수이다.
     *
     */
    public static void conventionalConversion() {
        int n, b = 0, c = 0, d;
        Scanner input = new Scanner(System.in);
        System.out.printf("Conventional conversion.\n\tEnter the decimal number: ");
        n = input.nextInt();
        while (n != 0) {
            d = n % 2;
            b = b + d * (int) Math.pow(10, c++);
            n /= 2;
        } //converting decimal to binary
        System.out.println("\tBinary number: " + b);
    }

    /**
     * 아래의 함수는 비트단위의 연산을 사용하는 알고리즘을 통해 10진수를 2진수로 변환하는 함수이다.
     *
     */
    public static void bitwiseConversion() {
        int n, b = 0, c = 0, d;
        Scanner input = new Scanner(System.in);
        System.out.printf("Bitwise conversion.\n\tEnter the decimal number: ");
        n = input.nextInt();
        while (n != 0) {
            d = (n & 1);
            b += d * (int) Math.pow(10, c++);
            n >>= 1;
        }
        System.out.println("\tBinary number: " + b);
    }

}
// 10진수를 2진수로 변환하는 아주 전통적인 변환 알고리즘이다. 코드 중 변환하는 과정을 천천히 완벽하게 이해하는 것이 좋다.  
