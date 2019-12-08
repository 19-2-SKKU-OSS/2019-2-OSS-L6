package Searches;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static java.lang.String.format;

/**
 * 이진 검색은 가장 인기있는 알고리즘 중 하나입니다
 *이 클래스는 반복 버전 {@link BinarySearch}을 나타냅니다.
 * 반복 이진 검색은 호출 스택 조작의 오버 헤드를 포함하지 않기 때문에 상수가 더 낮을 수 있습니다.
 * 그러나 자바에서는 재귀 버전을 컴파일러 가이 버전으로 최적화 할 수 있습니다.
 * <p>
 * 최악의 성능 O (log n)
 * 최고의 성능 O (1)
 * 평균 성능 O (log n)
 * 최악의 공간 복잡성 O (1)
 *
 * @author Gabriele La Greca : https://github.com/thegabriele97
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see SearchAlgorithm
 * @see BinarySearch
 */

public final class IterativeBinarySearch implements SearchAlgorithm {

    /**
     * 이 방법은 반복적 인 버전의 이진 검색 알고리즘을 구현합니다.
     *
     * @param array 정렬 된 배열
     * @param key 배열에서 검색 할 키
     * @ 배열의 ​​키 인덱스를 반환하거나 찾지 못하면 -1을 반환
     */
    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        int l, r, k, cmp;

        l = 0;
        r = array.length - 1;

        while (l <= r) {
            k = (l + r) / 2;
            cmp = key.compareTo(array[k]);

            if (cmp == 0) {
                return k;
            } else if (cmp < 0) {
                r = --k;
            } else {
                l = ++k;
            }
        }

        return -1;
    }

    //Only a main method for test purpose
    public static void main(String[] args) {
        Random r = new Random();
        int size = 100;
        int maxElement = 100000;
        Integer[] integers = Stream.generate(() -> r.nextInt(maxElement)).limit(size).sorted().toArray(Integer[]::new);


        //the element that should be found
        Integer shouldBeFound = integers[r.nextInt(size - 1)];

        IterativeBinarySearch search = new IterativeBinarySearch();
        int atIndex = search.find(integers, shouldBeFound);

        System.out.println(String.format("Should be found: %d. Found %d at index %d. An array length %d"
                , shouldBeFound, integers[atIndex], atIndex, size));


        int toCheck = Arrays.binarySearch(integers, shouldBeFound);
        System.out.println(format("Found by system method at an index: %d. Is equal: %b", toCheck, toCheck == atIndex));
    }
}
