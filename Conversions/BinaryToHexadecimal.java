package Conversions;

import java.util.*;

/**
 * 2진수를 16진수로 변환한다.
 *
 * @author Nishita Aggarwal
 */
public class BinaryToHexadecimal {

    /**
     * 밑의 함수들은 2진수를 16진수의 숫자로 변환하는 방법에 관한 것이다.
     *
     * @param binary The binary number
     * @return The hexadecimal number
     */
    static String binToHex(int binary) {
        //해시맵은 16진수의 코드를 2진수와 맵핑시키기 위해서 사용한다 (예시 : 0 -> 0000, 15 -> 1111)
        HashMap<Integer, String> hm = new HashMap<>();
        //16진수의 숫자를 string으로 저장
        String hex = "";
        int i;
        for (i = 0; i < 10; i++) {
            hm.put(i, String.valueOf(i));
        }
        for (i = 10; i < 16; i++) hm.put(i, String.valueOf((char) ('A' + i - 10)));
        int currbit;
        while (binary != 0) {
            int code4 = 0;    // to store decimal equivalent of number formed by 4 decimal digits
            for (i = 0; i < 4; i++) {
                currbit = binary % 10;
                binary = binary / 10;
                code4 += currbit * Math.pow(2, i);
            }
            hex = hm.get(code4) + hex;
        }
        return hex;
    }

    /**
     * Main method
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter binary number:");
        int binary = sc.nextInt();
        String hex = binToHex(binary);
        System.out.println("Hexadecimal Code:" + hex);
        sc.close();
    }
}
// 이진수를 정수의 형태로 입력받고(0 과 1만을 이용하여 입력받음), 이를 문자열 형태의 16진수로 변환하여 출력한다.
