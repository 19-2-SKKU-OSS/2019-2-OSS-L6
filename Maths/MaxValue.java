package Maths;

public class MaxValue {

    /**
     * 가장 큰 값을 반환합니다
     * 인자가 같으면 결과도 같습니다
     *
     * @a를 인자로 받습니다
     * @b도 인자로 받습니다
     * @a와 b 중 더 큰 값을 반환합니다
     */
    public static int max(int a, int b) {
        return a >= b ? a : b;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        System.out.format("max:%d between %d and %d", max(a, b), a, b);
    }
}
