package Maths;

public class FindMin {

    //Driver
    public static void main(String[] args) {
        int[] array = {2, 4, 9, 7, 19, 94, 5};
        System.out.println("min = " + findMin(array));
    }

    /**
     * 배열의 숫자 중에서 가장 작은 숫자를 찾습니다
     *
     * @숫자를 포함하고 있는 배열을 인자로 받습니다
     * @최솟값을 반환합니다
     */
    public static int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
