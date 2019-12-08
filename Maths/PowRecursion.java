package Maths;

public class PowRecursion {
    public static void main(String[] args) {
        assert pow(2, 0) == Math.pow(2, 0);
        assert pow(0, 2) == Math.pow(0, 2);
        assert pow(2, 10) == Math.pow(2, 10);
        assert pow(10, 2) == Math.pow(10, 2);
    }

    /**
     * 첫 번째 수를 밑으로 하고 두 번째 수를 지수로 합니다
     *다
     * @인자 a는 밑으로 받습니다
     * @인자 b는 지수로 받습니다
     * @a^b를 반환합니다
     */
    public static long pow(int a, int b) {
        if (b == 0) {
            return 1;
        } else {
            return a * pow(a, b - 1);
        }
    }
}
