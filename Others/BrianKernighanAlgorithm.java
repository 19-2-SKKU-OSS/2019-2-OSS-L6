package Others;

import java.util.Scanner;

/**
 * @author Nishita Aggarwal
 * <p>
 * Brian Kernighan’s Algorithm
 * <p>
 * algorithm to count the number of set bits in a given number
 * <p>
 * Subtraction of 1 from a number toggles all the bits (from right to left) till the rightmost set bit(including the
 * rightmost set bit).
 * So if we subtract a number by 1 and do bitwise & with itself i.e. (n & (n-1)), we unset the rightmost set bit.
 * <p>
 * If we do n & (n-1) in a loop and count the no of times loop executes we get the set bit count.
 * <p>
 * <p>
 * Time Complexity: O(logn)
 * 브라이언 캐니핸 알고리즘: 이진수에서 1의 개수를 세기 위해 비트 연산자를 사용한 알고리즘.
 * 시간복잡도: O(logn)
 */


public class BrianKernighanAlgorithm {

    /**
     * @param num: number in which we count the set bits
     * @return int: Number of set bits
     */
    static int countSetBits(int num) {
        int cnt = 0;
        while (num != 0) { //num이 0이 되기 전까지
            num = num & (num - 1); //1씩 줄여나가며 & 연산을 하면 가장 오른쪽의 1이 계속해서 사라질 것임
            cnt++; //그 사라지는 1의 개수를  셈
        }
        return cnt; //1의 개수 리턴
    }


    /**
     * @param args : command line arguments
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int setBitCount = countSetBits(num);
        System.out.println(setBitCount);
        sc.close();
    }
}
