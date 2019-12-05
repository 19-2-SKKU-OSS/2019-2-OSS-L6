package Conversions;

import java.util.Scanner;

/**
 * 8진수를 16진수로 변환한다.
 *
 * @author Tanmay Joshi
 */
public class OctalToHexadecimal {

    /**
     * 아래의 함수는 8진수의 숫자를 10진수의 숫자로 변환하는 함수이다.
     *
     * @param s The Octal Number
     * @return The Decimal number
     */
    public static int OctToDec(String s) {
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char num = s.charAt(j);
            num -= '0';
            i *= 8;
            i += num;
        }
        return i;
    }

    /**
     * 아래의 함수는 10진수의 숫자를 16진수의 숫자로 변환하는 함수이다.
     *
     * @param d The Decimal Number
     * @return The Hexadecimal number
     */
    public static String DecimalToHex(int d) {
        String digits = "0123456789ABCDEF";
        if (d <= 0)
            return "0";
        String hex = "";
        while (d > 0) {
            int digit = d % 16;
            hex = digits.charAt(digit) + hex;
            d = d / 16;
        }
        return hex;
    }


    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Octal number: ");
        // 사용자로부터 8진수를 문자열의 형태로 입력받는다.
        String oct = input.next();

        // 문자열 형태의 8진수를 함수의 입력값으로 전달하여 정수형태의 10진수로 변환한다.
        int decimal = OctToDec(oct);

        // 정수 형태의 10진수를 함수의 입력값으로 전달하여 문자열 형태의 16진수로 변환한다.
        String hex = DecimalToHex(decimal);
        System.out.println("The Hexadecimal equivalant is: " + hex);
    }
}

// 8진수를 16진수로 변환
