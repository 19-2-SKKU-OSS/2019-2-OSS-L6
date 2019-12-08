package Maths;

public class MinValue {

    /**
     * 가장 작은 값을 반환합니다
     * 인자가 같다면 같은 결과가 나옵니다
     *
     * @a를 인자로 받습니다
     * @b도 인자로 받습니다
     * @가장 작은 값을 반환합니다
     */
    public static int min(int a, int b) {
        return a <= b ? a : b;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        System.out.format("min:%d between %d and %d", min(a, b), a, b);
    }
}
