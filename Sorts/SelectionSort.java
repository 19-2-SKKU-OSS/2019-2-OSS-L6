package Sorts;

/**
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see SortAlgorithm
 * 선택 정렬: 배열을 비교한 뒤 최솟값을 선택해서 비교한 배열의 가장 앞에 그 최솟값을 넣고 그 뒤의 배열을 비교하는 작업을 반복하며 정렬.
 * 시간복잡도: O(n^2), 최악의 경우: O(n^2), 최선의 경우:O(n^2)
 */

public class SelectionSort implements SortAlgorithm { //SelectionSort 클래스 정의

    /**
     * This method implements the Generic Selection Sort
     *
     * @param arr The array to be sorted
     *            Sorts the array in increasing order
     **/
    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) { //정렬하는 함수
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Initial index of min
            int min = i; //min 인덱스는 일단 비교하는 배열의 가장 앞

            for (int j = i + 1; j < n; j++) { //뒤의 배열중에서
                if (SortUtils.less(arr[j], arr[min])) { //min인덱스의 값보다 작은 값의 인덱스가 있다면
                    min = j; //min을 그것으로 교체
                }
            }

            // Swapping if index of min is changed
            if (min != i) { //min이 교체되었다면 
                SortUtils.swap(arr, i, min); //i 자리에 교체된 min 값을 넣어줌
            }
        }

        return arr; //정렬된 배열 리턴
    }

    // Driver Program
    public static void main(String[] args) {

        Integer[] arr = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        SelectionSort selectionSort = new SelectionSort();

        Integer[] sorted = selectionSort.sort(arr);

        // Output => 1	  4	 6	9	12	23	54	78	231
        SortUtils.print(sorted);

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};
        String[] sortedStrings = selectionSort.sort(strings);

        //Output => a	b	 c  d	e
        SortUtils.print(sortedStrings);
    }
}
