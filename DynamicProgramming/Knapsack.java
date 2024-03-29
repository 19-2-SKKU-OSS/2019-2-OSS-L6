package DynamicProgramming;

/**
 * Dynamic progeaming을 기반으로한 0-1 Knapsack problem 솔루션
 */

public class Knapsack {

    private static int knapSack(int W, int wt[], int val[], int n) throws IllegalArgumentException {
        if(wt == null || val == null)
            throw new IllegalArgumentException();
        int i, w;
        int rv[][] = new int[n + 1][W + 1];    //rv 는 retrun 값을 의마한다

        // 상향식으로 테이블 rv [] [] 빌드한다
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    rv[i][w] = 0;
                else if (wt[i - 1] <= w)
                    rv[i][w] = Math.max(val[i - 1] + rv[i - 1][w - wt[i - 1]], rv[i - 1][w]);
                else
                    rv[i][w] = rv[i - 1][w];
            }
        }

        return rv[n][W];
    }


    // 위의 기능을 테스트하는 드라이버 프로그램
    public static void main(String args[]) {
        int val[] = new int[]{50, 100, 130};
        int wt[] = new int[]{10, 20, 40};
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}
