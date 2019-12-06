package Sorts;

import static Sorts.SortUtils.*;

/**
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see SortAlgorithm
 * 버블 정렬: 서로 인접한 두 원소를 검사하여 크기가 순서대로 되어있지 않다면 서로 교환하는 정렬.
 * 시간복잡도: O(n^2), 최악의 경우: O(n^2), 최선의 경우: O(n^2)
 */

class BubbleSort implements SortAlgorithm { //BubbleSort 클래스 정의
    /**
     * This method implements the Generic Bubble Sort
     *
     * @param array The array to be sorted
     *              Sorts the array in increasing order
     **/

    @Override
    public <T extends Comparable<T>> T[] sort(T array[]) {//정렬하는 함수 
        for (int i = 0, size = array.length; i < size - 1; ++i) {//처음부터 사이즈만큼
            boolean swapped = false;
            for (int j = 0; j < size - 1 - i; ++j) {//처음부터 사이즈-i만큼
                swapped = less(array[j], array[j + 1]) && swap(array, j, j + 1);//j와 j+1 인덱스의 배열 값을 비교하고, j가 작으면 스왑->내림차순 정렬
            }
            if (!swapped) { //한번도 스왑되지 않았으면 
                break;//for문을 그만둠->정렬이 완료되었을 때 시간 절약
            }
        }
        return array;//정렬된 배열 리턴
    }

    // Driver Program
    public static void main(String[] args) {

        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(integers);

        // Output => 231, 78, 54, 23, 12, 9, 6, 4, 1
        print(integers);

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};
        //Output => e, d, c, b, a
        print(bubbleSort.sort(strings));

    }
}
