package Others;

import java.util.Scanner;

/**
 * A utility to check if a given number is armstrong or not. Armstrong number is
 * a number that is equal to the sum of cubes of its digits for example 0, 1,
 * 153, 370, 371, 407 etc. For example 153 = 1^3 + 5^3 +3^3
 *
 * @author mani manasa mylavarapu
 * 암스트롱의 수 알고리즘: 세 자리의 정수 중에서 각 자리의 수를 세 제곱한 수의 합과 자신이 같은지 아닌지 구하는 알고리즘
 */
public class Armstrong {
    static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        int n = inputInt("please enter the number");
        boolean isArmstrong = checkIfANumberIsAmstrongOrNot(n);
        if (isArmstrong) {
            System.out.println("the number is armstrong");
        } else {
            System.out.println("the number is not armstrong");
        }
    }

    /**
     * Checks whether a given number is an armstrong number or not. Armstrong
     * number is a number that is equal to the sum of cubes of its digits for
     * example 0, 1, 153, 370, 371, 407 etc.
     *
     * @param number
     * @return boolean
     */
    public static boolean checkIfANumberIsAmstrongOrNot(int number) {
        int remainder, sum = 0, temp = 0;
        temp = number; //본래의 세 자리수 저장
        while (number > 0) {
            remainder = number % 10; //각 자리수마다
            sum = sum + (remainder * remainder * remainder); //세 제곱을 한 것을 저장
            number = number / 10; //다음 자리수를 위해 10으로 나눔
        }
        return sum == temp; //본래의 수와 위의 작업을 한 수가 같다면 true, 아니면 false 리턴
    }

    private static int inputInt(String string) {
        System.out.print(string);
        return Integer.parseInt(scan.nextLine());
    }
}
