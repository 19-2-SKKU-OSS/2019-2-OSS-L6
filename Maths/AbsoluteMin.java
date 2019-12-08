package Maths;

import java.util.Arrays;

/**
 * 설명: absMin([a, b, c ...])
 * <p>
 * absMin([0, 5, 1, 11]) = 0, absMin([3 , -10, -2]) = -2
 * </p>
 */
public class AbsoluteMin {
    public static void main(String[] args) {
        int[] numbers = new int[]{3, -10, -2};
        System.out.println("absMin(" + Arrays.toString(numbers) + ") = " + absMin(numbers));
    }

    /**
     * 값을 가져와서 절댓값의 최솟값을 구합니다
     *
     * @인자로 숫자들을 가져옵니다
     * @절댓값의 최솟값을 반환합니다
     */
    public static int absMin(int[] numbers) {
        int absMinValue = numbers[0];
        for (int i = 1, length = numbers.length; i < length; ++i) {
            if (Math.abs(numbers[i]) < Math.abs(absMinValue)) {
                absMinValue = numbers[i];
            }
        }
        return absMinValue;
    }
}
