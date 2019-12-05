package Conversions;

import java.util.Scanner;

public class HexaDecimalToDecimal {

    // 16진수를 10진수로 변환한다.
    public static int getHexaToDec(String hex) {
        String digits = "0123456789ABCDEF";
        hex = hex.toUpperCase();
        int val = 0;
        for (int i = 0; i < hex.length(); i++) {
            int d = digits.indexOf(hex.charAt(i));
            val = 16 * val + d;
        }
        return val;
    }

    // 메인 함수는 사용자로부터 문자열 형태의 16진수를 입력받아 10진수의 정수로 변환하여 출력한다.

    public static void main(String args[]) {
        String hexa_Input;
        int dec_output;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Hexadecimal Number : ");
        hexa_Input = scan.nextLine();

        // 16진수를 10진수로 변환한다.

        dec_output = getHexaToDec(hexa_Input);
        /* 문자열 형태의 16진수를 함수의 입력값으로 전달하여 정수형태의 10진수 결과값을 반환한다.
        */
        System.out.println("Number in Decimal: " + dec_output);


    }
}
// 16진수를 10진수로 변환하는 함수이다.
