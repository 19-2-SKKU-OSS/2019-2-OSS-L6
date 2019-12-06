package Sorts;

import static Sorts.SortUtils.less;
import static Sorts.SortUtils.print;

/**
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * 삽입 정렬: 현재 위치에서 그 이하의 배열들을 비교하여 자신이 들어갈 위치를 찾아 그 위치에 삽입하는 정렬
 * 시간복잡도: O(n^2), 최악의 경우: O(n^2), 최선의 경우: O(n)
 */

class InsertionSort implements SortAlgorithm { //InsertionSort 클래스 정의

    /**
     * This method implements the Generic Insertion Sort
     * Sorts the array in increasing order
     *
     * @param array The array to be sorted
     **/

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) { //정렬하는 함수
        for (int j = 1; j < array.length; j++) { //배열 크기만큼

            // Picking up the key(Card)
            T key = array[j]; //두번째 인덱스 값부터 차례대로  key에 넣는다.
            int i = j - 1; //i는 j보다 하나 작은 인덱스

            while (i >= 0 && less(key, array[i])) { //i가 0보다 크고 뒤의 값이 앞의 값보다 작으면
                array[i + 1] = array[i]; // 뒤의 인덱스에 앞의 값을 넣고
                i--; //i를 줄여준다. -> 더 앞의 값과 비교하기 위해
            }
            // Placing the key (Card) at its correct position in the sorted subarray
            array[i + 1] = key; //위의 과정이 끝나고 나서 자신보다 작은 것 바로 뒤에 key 값을 저장, 작은 것이 없다면 인덱스는 0
        }
        return array; //정렬된 배열 리턴
    }

    // Driver Program
    public static void main(String[] args) {
        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        InsertionSort sort = new InsertionSort();

        sort.sort(integers);

        // Output => 1 4 6 9 12 23 54 78 231
        print(integers);

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};

        sort.sort(strings);

        //Output => a	b	c	d	e
        print(strings);
    }
}
