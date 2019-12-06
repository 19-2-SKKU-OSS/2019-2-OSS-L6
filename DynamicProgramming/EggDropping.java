package DynamicProgramming;

/**
 * Egg Dropping Puzzle을위한 DynamicProgramming 솔루션
 */
public class EggDropping {

    // n 개의 계란과 m 개의 층으로 시험

    private static int minTrials(int n, int m) {

        int[][] eggFloor = new int[n + 1][m + 1];
        int result, x;

        for (int i = 1; i <= n; i++) {
            eggFloor[i][0] = 0;   // 0층의 0번째시도
            eggFloor[i][1] = 1;   // 한 층당 1번의 시도 
        }

        // 계란 1개에 대해서 j회 시도

        for (int j = 1; j <= m; j++)
            eggFloor[1][j] = j;

        // DP에서 상향식 접근법 사용

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++) {
                    result = 1 + Math.max(eggFloor[i - 1][x - 1], eggFloor[i][j - x]);

                    // choose min of all values for particular x
                    if (result < eggFloor[i][j])
                        eggFloor[i][j] = result;
                }
            }
        }

        return eggFloor[n][m];
    }

    public static void main(String args[]) {
        int n = 2, m = 4;
        // result outputs min no. of trials in worst case for n eggs and m floors
        int result = minTrials(n, m);
        System.out.println(result);
    }
}
