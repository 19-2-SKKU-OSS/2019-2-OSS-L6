package DynamicProgramming;

/**로드 절단 문제를위한 동적 프로그래밍 솔루션
 * 막대의 가장 좋은 가격을 반환합니다
 * 길이 n과 가격 []을 다른 조각의 가격으로
 */
public class RodCutting {

    private static int cutRod(int[] price, int n) {
        int val[] = new int[n + 1];
        val[0] = 0;

        for (int i = 1; i <= n; i++) {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                max_val = Math.max(max_val, price[j] + val[i - j - 1]);

            val[i] = max_val;
        }

        return val[n];
    }

    //테스트할 main 함수
    public static void main(String args[]) {
        int[] arr = new int[]{2, 5, 13, 19, 20};
        int size = arr.length;
	int result = cutRod(arr,size); 
        System.out.println("Maximum Obtainable Value is " +
                result);
    }
}
