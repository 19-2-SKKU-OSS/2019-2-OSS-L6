package Searches;

import java.util.Random;
import java.util.stream.Stream;

/**
 * 선형 검색은 가장 쉬운 검색 알고리즘입니다
 * 정렬 및 정렬되지 않은 배열에서 작동합니다 (이진 검색은 정렬 된 배열에서만 작동합니다)
 *이 알고리즘은 배열의 모든 요소를 ​​비교하여 값을 찾습니다.
 * <p>
 * 최악의 성능 O (n)
 * 최고의 성능 O (1)
 * 평균 성능 O (n)
 * 최악의 공간 복잡성
 *
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see BinarySearch
 * @see SearchAlgorithm
 */

public class LinearSearch implements SearchAlgorithm {

    /**
     * 일반 선형 검색 방법
     *
     * @param array List to be searched
     * @param value Key being searched for
     * @return Location of the key
     */
    @Override
    public <T extends Comparable<T>> int find(T[] array, T value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(value) == 0) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        // 데이터를 생성하기
        Random r = new Random();
        int size = 200;
        int maxElement = 100;
        Integer[] integers = Stream.generate(() -> r.nextInt(maxElement)).limit(size).toArray(Integer[]::new);


        //찾아야 할 요소 
        Integer shouldBeFound = integers[r.nextInt(size - 1)];

        LinearSearch search = new LinearSearch();
        int atIndex = search.find(integers, shouldBeFound);

        System.out.println(String.format("Should be found: %d. Found %d at index %d. An array length %d"
                , shouldBeFound, integers[atIndex], atIndex, size));
    }

}
