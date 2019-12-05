package Conversions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Varun Upadhyay (https://github.com/varunu28)
 *
 */


public class DecimalToAnyBase {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the decimal input below: ");
        int decInput = Integer.parseInt(br.readLine());
        System.out.println();

        System.out.println("Enter the base below: ");
        int base =  Integer.parseInt(br.readLine());
        System.out.println();

        System.out.println("Decimal Input" + " is: " + decInput);
        System.out.println("Value of " + decInput + " in base " + base + " is: " + convertToAnyBase(decInput, base));

        br.close();
    }

    /**
     * 아래의 함수는 10진수의 정수를 입력받아 원하는 진법의 수로 변환하여 문자열의 형태로 생성한다.
     * @param inp Decimal of which we need the value in base in String format
     * @return string format of the converted value in the given base
     */

    public static String convertToAnyBase(int inp, int base) {
        ArrayList<Character> charArr = new ArrayList<>();

        while (inp > 0) {
            charArr.add(reVal(inp%base));
            inp /= base;
        }

        StringBuilder str = new StringBuilder(charArr.size());

        for(Character ch: charArr)
        {
            str.append(ch);
        }

        return str.reverse().toString();
    }

    /**
     * 아래의 함수는 정수형태의 입력값을 문자열 형태로 나타내기 위해 (0-9) 와 (A-Z)로 변환하여 반환한다.
     * @param num integer of which we need the character value of
     * @return character value of input integer
     */

    public static char reVal(int num) {
        if (num >= 0 && num <= 9)
            return (char)(num + '0');
        else
            return (char)(num - 10 + 'A');
    }
}
// 10진수를 원하는 진수의 형태로 변환한다. 0-9 와 A-Z로 나타낼 수 있는 
