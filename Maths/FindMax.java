package Maths;

public class FindMax {

    //Driver
    public static void main(String[] args) {
        int[] array = {2, 4, 9, 7, 19, 94, 5};
        System.out.println("max = " + findMax(array));
    }

    /**
     * 배열의 최댓값을 구합니다
     *
     * @인자로 최댓값을 찾을 숫자를 저장한 배열을 갖습니다
     * @최댓값을 반환합니다
     */
    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
