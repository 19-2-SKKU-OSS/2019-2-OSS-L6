package Sorts;

import static Sorts.SortUtils.*;

/**
 * Implementation of gnome sort
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @since 2018-04-10
 * 팬케이크 정렬: 배열을 팬케이크가 쌓여있다고 생각하고 가장 큰 값의 지점에 주걱을 넣어 뒤집으면서 정렬.
 * 시간복잡도: O(n^2)
 **/
public class PancakeSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int size = array.length;

        for (int i = 0; i < size; i++) {
            T max = array[0]; //첫번째 인덱스 값을 max에 저장
            int index = 0;
            for (int j = 0; j < size - i; j++) { //처음부터 size-i까지 돌면서
                if (less(max, array[j])) { //max와 배열의 값들을 비교하여
                    max = array[j]; //max값을 찾고
                    index = j; //그 인덱스를 저장
                }
            }
            flip(array, index, array.length - 1 - i); //그 인덱스 값을 기준으로 뒤집음
        }
        return array; //정렬된 배열 리턴
    }


    public static void main(String[] args) {

        Integer[] arr = {10, 9, 8, 7, 6, 15, 14, 7, 4, 3, 8, 6, 3, 1, 2, -2, -5, -8, -3, -1, 13, 12, 11, 5, 4, 3, 2, 1};
        PancakeSort pancakeSort = new PancakeSort();
        System.out.println("After sorting:");
        pancakeSort.sort(arr);
        print(arr);
    }


}
