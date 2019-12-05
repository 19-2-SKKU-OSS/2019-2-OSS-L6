package Conversions;

import java.util.Scanner;

/**
 * 2진수를 8진수로 변환한다.
 *
 * @author Zachary Jones
 */
public class BinaryToOctal {

    /**
     * Main method
     *
     * @param args Command line arguments
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the binary number: ");
        int b = sc.nextInt();
        System.out.println("Octal equivalent: " + convertBinaryToOctal(b));
        sc.close();

    }

    /**
     * 아래의 함수는 2진수를 8진수로 변환하는 방법에 관한 것이다.
     *
     * @param binary The binary number
     * @return The octal number
     */
    public static String convertBinaryToOctal(int binary) {
        String octal = "";
        int currBit = 0, j = 1;
        while (binary != 0) {
            int code3 = 0;
            for (int i = 0; i < 3; i++) {
                currBit = binary % 10;
                binary = binary / 10;
                code3 += currBit * j;
                j *= 2;
            }
            octal = code3 + octal;
            j = 1;
        }
        return octal;
    }

}
//2진수를 8진수로 변환하는 프로그램으로 2진수는 0
