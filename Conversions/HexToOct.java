package Conversions;

import java.util.Scanner;

/**
 * 16진수의 숫자를 8진수의 숫자로 변환한다.
 *
 * @author Tanmay Joshi
 */
public class HexToOct {
    /**
     * 아래의 함수는 16진수의 숫자를 8진수의 숫자로 변환한다.
     *
     * @param s The Hexadecimal Number
     * @return The Decimal number
     */
    public static int hex2decimal(String s) {
        String str = "0123456789ABCDEF";
        s = s.toUpperCase();
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            int n = str.indexOf(a);
            val = 16 * val + n;
        }
        return val;
    }

    /**
     * 아래의 함수는 10진수의 숫자를 8진수의 숫자로 변환한다.
     *
     * @param q The Decimal Number
     * @return The Octal number
     */
    public static int decimal2octal(int q) {
        int now;
        int i = 1;
        int octnum = 0;
        while (q > 0) {
            now = q % 8;
            octnum = (now * (int) (Math.pow(10, i))) + octnum;
            q /= 8;
            i++;
        }
        octnum /= 10;
        return octnum;
    }

    /**
     * 메인 함수는 16진수를 입력값으로 받아 8진수로 변환한다.
     * @param args arguments
     */
    public static void main(String args[]) {
        String hexadecnum;
        int decnum, octalnum;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Hexadecimal Number : ");
        hexadecnum = scan.nextLine();

        // 먼저 16진수를 10진수로 변환한다.
        decnum = hex2decimal(hexadecnum);   //16진수는 문자열의 형태로 입력되고 결과값으로 정수 형태의 10진수를 얻는다.

        // 10진수를 8진수로 변환한다.
        octalnum = decimal2octal(decnum);
        System.out.println("Number in octal: " + octalnum);


    }
}
// 16진수를 8진수로 변환하는 함수이다. 16진수를 10진수로 먼저 변환한 후, 10진수를 8진수로 변환한다.
