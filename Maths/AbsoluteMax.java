package Maths;

import java.util.Arrays;

/**
 * 설명: absMax([a,b,c, ...])
 * <p>
 * absMax([0, 5, 1, 11]) = 11, absMax([3 , -10, -2]) = -10
 * </p>
 */
public class AbsoluteMax {
    public static void main(String[] args) {
        int[] numbers = new int[]{3, -10, -2};
        System.out.println("absMax(" + Arrays.toString(numbers) + ") = " + absMax(numbers));
    }

    /**
     * 값을 가져와서 절댓값이 최댓값인 것을 구합니다
     *
     * @파라미터로 원소들을 포함합니다
     * @절댓값의 최댓값인 값을 반환합니다
     */
    public static int absMax(int[] numbers) {
        int absMaxValue = numbers[0];
        for (int i = 1, length = numbers.length; i < length; ++i) {
            if (Math.abs(numbers[i]) > Math.abs(absMaxValue)) {
                absMaxValue = numbers[i];
            }
        }
        return absMaxValue;
    }
}
