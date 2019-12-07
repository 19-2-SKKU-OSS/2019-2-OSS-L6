package Others;

import java.util.Scanner;

/**
 * A utility to check if a given number is power of two or not.
 * For example 8,16 etc.
 * 2의 거듭제곱 판별 알고리즘: 수가 2의 거듭제곱인지 아닌지 비트 연산자를 사용하여 찾는 알고리즘
 */

public class PowerOfTwoOrNot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int num = sc.nextInt();
        boolean isPowerOfTwo = checkIfPowerOfTwoOrNot(num);
        if (isPowerOfTwo) {
            System.out.println("Number is a power of two");
        } else {
            System.out.println("Number is not a power of two");
        }
    }


    /**
     * Checks whether given number is power of two or not.
     *
     * @param number
     * @return boolean
     */
    public static boolean checkIfPowerOfTwoOrNot(int number) {
        return number != 0 && ((number & (number - 1)) == 0); //0이 아니고, 수에서 하나 뺀 값과의 & 연산을 사용했을 때 0이 아니라면 true 리턴, 아니면 false 리턴
    }

}
