package Others;

import java.util.Scanner;
/*
 * 루트 소수점 표현 알고리즘: 수를 루트로 변환하고 제시한 소수점까지 표현하는 알고리즘.
 */
public class RootPrecision {

    public static void main(String[] args) {
        // take input
        Scanner scn = new Scanner(System.in);

        // N is the input number
        int N = scn.nextInt();

        // P is precision value for eg - P is 3 in 2.564 and 5 in 3.80870.
        int P = scn.nextInt();
        System.out.println(squareRoot(N, P));
    }

    public static double squareRoot(int N, int P) {
        // rv means return value
        double rv;

        double root = Math.pow(N, 0.5); //N의 루트
        // calculate precision to power of 10 and then multiply it with root value.
        int precision = (int) Math.pow(10, P); //10의 P승
        root = root * precision; //N의 루트를 10의 P승으로 곱함
	    /*typecast it into integer then divide by precision and again typecast into double
	   so as to have decimal points upto P precision */

        rv = (int) root; //루트를 정수로 변환
        return rv / precision; //그 정수를 10의 P승으로 다시 나눔
    }
}
