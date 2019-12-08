package Conversions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 특정 진법에서 또다른 특정 진법으로 수를 변환하는데 사용할 수 있는 클래스이다. 여기서 '특정 진법'이란 2에서 36까지를 말한다.
 * 특정 진법 b1에서 특정 진법 b2로 변환된다. 주어진 입력 숫자가 주어진 진법에 대해 유효한지 판단하는 보조 방법을 포함한다.
 *
 * @author Michael Rolland
 * @version 2017.10.10
 */
 
public class AnyBaseToAnyBase {

    /**
     * 사용자가 허용할 최소 진법(MIN)과 최대 진법(MAX)
     */
    static final int MINIMUM_BASE = 2;
    static final int MAXIMUM_BASE = 36;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n;
        int b1, b2;
        while (true) {
            try {
                System.out.print("Enter number: "); //사용자로부터 진법을 변환할 숫자를 입력받음
                n = in.next();
                System.out.print("Enter beginning base (between " + MINIMUM_BASE + " and " + MAXIMUM_BASE + "): "); //초기 진법 결정
                b1 = in.nextInt();
                if (b1 > MAXIMUM_BASE || b1 < MINIMUM_BASE) {
                    System.out.println("Invalid base!");
                    continue;
                }
                if (!validForBase(n, b1)) { //입력받은 숫자가 시작 진법으로 표현이 가능한 수인지 판별
                    System.out.println("The number is invalid for this base!");
                    continue;
                }
                System.out.print("Enter end base (between " + MINIMUM_BASE + " and " + MAXIMUM_BASE + "): "); //변환될 진법 결정
                b2 = in.nextInt();
                if (b2 > MAXIMUM_BASE || b2 < MINIMUM_BASE) { 
                    System.out.println("Invalid base!");
                    continue;
                }
                break;
            } catch (InputMismatchException e) { //nextInt에 입력받은 값이 정수가 아닐 경우의 예외처리
                System.out.println("Invalid input.");
                in.next();
            }
        }
        System.out.println(base2base(n, b1, b2)); //최종적으로 변환된 숫자를 출력
    }

    /**
     * 문자열로 입력받은 숫자가 주어진 진법으로 표현이 가능한 숫자인지를 판별한다.
     */
    public static boolean validForBase(String n, int base) {
        char[] validDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
                'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                'W', 'X', 'Y', 'Z'};
        // digitsForBase는 진법에 사용할 수 있는 모든 유효한 숫자와 문자를 포함한다.
        char[] digitsForBase = Arrays.copyOfRange(validDigits, 0, base);

        // 문자 배열을 contains() 함수의 편의를 위해 해시 셋으로 변환한다.
        HashSet<Character> digitsList = new HashSet<>();
        for (int i = 0; i < digitsForBase.length; i++)
            digitsList.add(digitsForBase[i]);

        // n의 모든 문자가 주어진 진법에 대해 유효한 자릿수인지를 체크한다.
        for (char c : n.toCharArray())
            if (!digitsList.contains(c))
                return false;

        return true;
    }

    /**
     * 아래의 함수는 b1의 진법으로 나타낸 수를 b2의 진법으로 변환하는 함수이다. 먼저 b1의 진법으로 나타낸 수를 10진수로 변환한 후, 
     * 이를 b2의 진법으로 변환한다.
     *
     * @param n  변환될 정수
     * @param b1 시작 진법
     * @param b2 최종 진법
     * @n을 진법 b2의 수로 반환한다.
     */
    public static String base2base(String n, int b1, int b2) {
        // 변수선언 : n의 10진수 값, 진법 b1를 나타내는 문자, 
        // 진법 b2를 나타내는 문자, 변환되어 반환될 문자열
        int decimalValue = 0, charB2;
        char charB1;
        String output = "";
        // n의 모든 자리의 문자에 대해서
        for (int i = 0; i < n.length(); i++) {
            // charB1에 각 자리 문자를 저장한다.
            charB1 = n.charAt(i);
            // 만약에 문자가 숫자가 아니라면(A-Z), 이를 9보다 큰 10진수로 변환하여 charB2에 저장한다.
            if (charB1 >= 'A' && charB1 <= 'Z')
                charB2 = 10 + (charB1 - 'A');
                // 그렇지 않을 경우, charB2에 정수 값을 저장한다.
            else
                charB2 = charB1 - '0';
            // 각 숫자 문자를 10진수의 정수 형태로 변환하고 이를 n의 decimalValue에 저장한다.
            decimalValue = decimalValue * b1 + charB2;
        }

        // 10진수 의 값을 진법 b2의 수로 변환한다.
        // 연속적으로 몫이 0이 되기전까지 몫을 새로운 진법의 수로 나누고, 나눌때마다 나머지를 저장하는 것을 통해서
        // 숫자는 10진수에서 다른 진법의 숫자로 변환된다.
        // 새로운 진법의 수는 나머지에 해당하고, 마지막 나머지가 새로운 숫자의 가장 왼편에 위치한다.

        // 몫이 0이 아닐 동안 
        while (decimalValue != 0) {
            // 만약 나머지가 10보다 작은 수라면 간단히 새로운 숫자의 가장 왼편에 추가한다.
            if (decimalValue % b2 < 10)
                output = Integer.toString(decimalValue % b2) + output;
                // 만약 나머지가 10보다 큰 수라면 숫자에 알맞는 문자를 새로운 숫자의 가장 왼편에 추가한다.
                // (A = 10, B = 11, C = 12, ...)
            else
                output = (char) ((decimalValue % b2) + 55) + output;
            // 새로운 진법의 수로 다시 나눈다.
            decimalValue /= b2;
        }
        return output;
    }
}
//사용자가 직접 두 개의 시작 진법과 최종 진법을 선택하여 시작 진법으로 나타낸 숫자를 최종 진법의 수로 변환하는 알고리즘이다.
//동일한 목적을 가진 또다른 구현이 존재하므로, 여러개의 같은 목적을 가진 알고리즘을 비교하면서 이해하는 것을 추천한다.
