package Maths;

import java.util.Arrays;

/**
 * description:
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
     * get the value, it's absolute value is min
     *
     * @param numbers contains elements
     * @return the absolute min value
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
