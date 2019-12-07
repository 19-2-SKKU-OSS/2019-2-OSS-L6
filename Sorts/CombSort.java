package Sorts;

import static Sorts.SortUtils.*;


/**
 * Comb Sort algorithm implementation
 * <p>
 * Best-case performance O(n * log(n))
 * Worst-case performance O(n ^ 2)
 * Worst-case space complexity O(1)
 * <p>
 * Comb sort improves on bubble sort.
 *
 * @author Sandeep Roy (https://github.com/sandeeproy99)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see BubbleSort
 * @see SortAlgorithm
 * 빗질 정렬: 버블정렬에서 인덱스의 비교를 일정 칸 띄워서 하는 정렬.gap을 계속 줄이면서 비교횟수를 줄이고 시간을 절약한다.
 * 시간복잡도: O(n^2/2^p) (여기서 p는 증가 수), 최악의 경우: O(n^2), 최선의 경우: O(n*logn)
 */
class CombSort implements SortAlgorithm {

    // To find gap between elements
    private int nextGap(int gap) { //gap을 줄이면서 다음 gap을 찾는 함수
        // Shrink gap by Shrink factor
        gap = (gap * 10) / 13; //gap에 10을 곱하고 13으로 나누면서 줄임
        return (gap < 1) ? 1 : gap; // gap이 1보다 작으면 1 리턴 크면 gap리턴
    }

    /**
     * Function to sort arr[] using Comb
     *
     * @param arr - an array should be sorted
     * @return sorted array
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T arr[]) {
        int size = arr.length;

        // initialize gap
        int gap = size; //gap을 처음에는 배열의 크기로 설정

        // Initialize swapped as true to make sure that loop runs
        boolean swapped = true; //첫 while문을 돌기 위해서 true로 설정

        // Keep running while gap is more than 1 and last iteration caused a swap
        while (gap != 1 || swapped) { //gap이 1까지 줄기 전까지, 스왑이 되는 동안만
            // Find next gap
            gap = nextGap(gap); //gap을 줄이면서 다음 gap을 찾음

            // Initialize swapped as false so that we can check if swap happened or not
            swapped = false; //스왑이 안된 것이 default값

            // Compare all elements with current gap
            for (int i = 0; i < size - gap; i++) { //size-gap 만큼 실행하여서 점점 비교 횟수가 줄어듬
                if (less(arr[i + gap], arr[i])) { //gap만큼 떨어진 두 인덱스 값을 비교해서 i+gap 인덱스의 값이 i 인덱스의 값보다 작으면 -> 오름차순 정렬
                    // Swap arr[i] and arr[i+gap]
                    swapped = swap(arr, i, i + gap); //스왑한다.
                }
            }
        }
        return arr; //정렬된 배열 리턴
    }

    // Driver method
    public static void main(String args[]) {
        CombSort ob = new CombSort();
        Integer arr[] = {8, 4, 1, 56, 3, -44, -1, 0, 36, 34, 8, 12, -66, -78, 23, -6, 28, 0};
        ob.sort(arr);

        System.out.println("sorted array");
        print(arr);
    }
}
