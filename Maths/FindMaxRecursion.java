package Maths;

public class FindMaxRecursion {
    public static void main(String[] args) {
        int[] array = {2, 4, 9, 7, 19, 94, 5};
        int low = 0;
        int high = array.length - 1;

        System.out.println("max value is " + max(array, low, high));
    }

    /**
     * 분할 정복으로 배열에서 최댓값을 찾습니다 
     *
     * @인자로 숫자를 포함한 배열을 받습니다
     * @인자 low는 가장 낮은 색인을 갖는 원소입니다
     * @인자 high는 가장 높은 색인을 갖는 원소입니다
     * @배열에서 가장 큰 원소를 반환합니다
     */
    public static int max(int[] array, int low, int high) {
        if (low == high) {
            return array[low]; //혹은 array[high]를 반환해도 됩니다
        }

        int mid = (low + high) >>> 1;

        int leftMax = max(array, low, mid); //[low, mid]중 더 큰 값을 가져옵니다
        int rightMax = max(array, mid + 1, high); //[mid+1, high]에서 가장 큰 값을 가져옵니다

        return leftMax >= rightMax ? leftMax : rightMax;
    }
}
