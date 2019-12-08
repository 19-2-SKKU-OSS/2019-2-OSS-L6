package DynamicProgramming;

import java.util.Scanner;

/**
 * @author Afrizal Fikri (https://github.com/icalF)
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ar[] = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }

        System.out.println(LIS(ar));
    }

    private static int upperBound(int[] ar, int l, int r, int key) {
        while (l < r - 1) {
            int m = (l + r) / 2;
            if (ar[m] >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    private static int LIS(int[] array) {
        int N = array.length;
        if (N == 0)
            return 0;

        int[] tail = new int[N];

        // 항상 꼬리에 빈 슬롯을 가리킴
        int length = 1;

        tail[0] = array[0];
        for (int i = 1; i < N; i++) {

            // 새로운 가장 작은 값
            if (array[i] < tail[0])
                tail[0] = array[i];

                // array [i]는 가장 큰 하위 시퀀스를 확장합니다
            else if (array[i] > tail[length - 1])
                tail[length++] = array[i];

                // array [i]는 기존 하위 시퀀스의 최종 후보가되거나
                // 배열보다 다가오는 강판 요소를위한 공간을 만들기 위해 모든 LIS에서 더 큰 요소를 버립니다.
                // (그리고 array [i]는 이미 LIS 중 하나에 나타 났을 것입니다. 위치를 식별하고 교체하십시오)
            else
                tail[upperBound(tail, -1, length - 1, array[i])] = array[i];
        }

        return length;
    }
}