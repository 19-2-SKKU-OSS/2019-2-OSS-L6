package DynamicProgramming;

import java.util.Scanner;

/**
 * Kadane의 알고리즘을 구현하는 프로그램
 * 배열의 최대 연속 서브 어레이 합 계산
 * 시간 복잡도 : O (n)
 *
 * @author Nishita Aggarwal
 */

public class KadaneAlgorithm {

    /**
     * 이 방법은 Kadane의 알고리즘을 구현하는 것입니다.
     *
     * @param arr 입력 어레이
     * @return 배열의 최대 연속 하위 배열 합
     */
    static int largestContiguousSum(int arr[]) {
        int i, len = arr.length, cursum = 0, maxsum = Integer.MIN_VALUE;
        if (len == 0)    //비어있는 어레이
            return 0;
        for (i = 0; i < len; i++) {
            cursum += arr[i];
            if (cursum > maxsum) {
                maxsum = cursum;
            }
            if (cursum <= 0) {
                cursum = 0;
            }
        }
        return maxsum;
    }

    /**
     * 메인 메소드
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, arr[], i;
        n = sc.nextInt();
        arr = new int[n];
        for (i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int maxContSum = largestContiguousSum(arr);
        System.out.println(maxContSum);
        sc.close();
    }

}
