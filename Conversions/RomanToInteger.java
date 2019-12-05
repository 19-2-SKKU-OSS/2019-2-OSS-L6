package Conversions;

import java.util.*;

public class RomanToInteger {

    private static Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    /**
     * 이 함수는 로마숫자를 정수형태의 숫자로 변환한다.
     *
     * @param A Roman number string
     * @return integer
     */
    public static int romanToInt(String A) {

        char prev = ' ';

        int sum = 0;

        int newPrev = 0;
        for (int i = A.length() - 1; i >= 0; i--) {
            char c = A.charAt(i);

            if (prev != ' ') {
                // 현재의 숫자가 이전의 숫자보다 큰지 크지 않은지를 체크한다.
                newPrev = map.get(prev) > newPrev ? map.get(prev) : newPrev;
            }

            int currentNum = map.get(c);

            // 만약 현재 숫자가 이전의 최대 숫자보다 크다면 더한다.
            if (currentNum >= newPrev) {
                sum += currentNum;
            } else {
                // 새로 들어오는 숫자가 이전 최대 숫자보다 크지 않다면 뺀다.
                sum -= currentNum;
            }

            prev = c;
        }

        return sum;
    }

    public static void main(String[] args) {
        int sum = romanToInt("MDCCCIV");
        System.out.println(sum);
    }
} 
// 로마
