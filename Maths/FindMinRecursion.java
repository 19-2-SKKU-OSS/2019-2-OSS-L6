package Maths;

public class FindMinRecursion {
    public static void main(String[] args) {
        int[] array = {2, 4, 9, 7, 19, 94, 5};
        int low = 0;
        int high = array.length - 1;

        System.out.println("min value is " + min(array, low, high));
    }

    /**
     * 배열의 원소 중에서 최솟값을 찾습니다
     *
     * @인자는 숫자를 포함하고 있는 배열을 받습니다
     * @low 인자는 배열의 가장 낮은 색인입니다
     * @high 인자는 배열의 가장 높은 색인입니다
     * @배열에서 가장 작은 값을 반환합니다
     */
    public static int min(int[] array, int low, int high) {
        if (low == high) {
            return array[low]; //혹은 array[high]를 반환합니다
        }

        int mid = (low + high) >>> 1;

        int leftMin = min(array, low, mid); //low와 mid중에서 더 작은 값을 고릅니다
        int rightMin = min(array, mid + 1, high); //mid+1과 high중에서 더 작은 값을 고릅니다

        return leftMin <= rightMin ? leftMin : rightMin;
    }
}
