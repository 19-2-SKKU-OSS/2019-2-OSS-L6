package Maths;

/**
 * 정수론에서 완전수는 자신을 제외한 양수 약수들의 합과 같은 정수입니다.
 * 예를 들어 6은 자기 자신을 제회한 나머지 양의 약수 1, 2, 3을 갖습니다.
 * 그리고 그 합은 1 + 2 + 3 = 6으로 자기 자신이 됩니다.
 * <p>
 * 참조:https://en.wikipedia.org/wiki/Perfect_number
 * </p>
 */
public class PerfectNumber {
    public static void main(String[] args) {
        assert isPerfectNumber(6); /* 1 + 2 + 3 == 6 */
        assert !isPerfectNumber(8); /* 1 + 2 + 4 != 8 */
        assert isPerfectNumber(28); /* 1 + 2 + 4 + 7 + 14 == 28 */
    }

    /**
     * 완전수인지 아닌지 판단합니다
     *
     * @number를 인자로 받습니다
     * @완전수이면 true, 아니면 false를 반환합니다
     */
    public static boolean isPerfectNumber(int number) {
        int sum = 0;  /* 양수 약수들의 합 */
        for (int i = 1; i < number; ++i) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }
}
