package Maths;

/**
 * @author PatOnTheBack
 */

public class AbsoluteValue {

    public static void main(String[] args) {
        int value = -34;
        System.out.println("The absolute value of " + value + " is " + absVal(value));
    }

    /**
     * 값이 0보다 작으면, 0보다 크게 만듭니다
     *
     * @인자로 숫자를 받습니다
     * @절댓값을 반환합니다
     */
    public static int absVal(int value) {
        return value < 0 ? -value : value;
    }

}
