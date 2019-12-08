package Searches;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static java.lang.String.format;

/**
 * 삼항 검색 알고리즘은 단봉 함수의 최소 또는 최대를 찾기위한 컴퓨터 과학 기술이다
 * 알고리즘은 최소값 또는 최대 값이 도메인의 첫 번째 1/3에있을 수 없음을 결정합니다.
 * 또는 도메인의 마지막 3 분의 1에있을 수 없으며 나머지 3 분의 1에 반복됩니다.
 * <p>
 * 최악의 성능 Θ (log3 (N))
 * 최고의 성능 O (1)
 * 평균 성능 Θ (log3 (N))
 * 최악의 공간 복잡성 O (1)
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @ SearchAlgorithm 참조
 * @ IterativeBinarySearch 참조
 */

public class TernarySearch implements SearchAlgorithm {

    
/**
 *@param arr 요소를 검색 할 ** Sorted ** 배열입니다.
 *@param value 검색하려는 값입니다.
 *@return 발견 된 요소의 색인입니다.
 *그렇지 않으면 -1을 반환합니다.
 */
    @Override
    public <T extends Comparable<T>> int find(T[] arr, T value) {
        return ternarySearch(arr, value, 0, arr.length - 1);
    }

     /**
     * @param arr 요소를 검색 할 ** Sorted ** 배열입니다.
     * @param key 검색하려는 값입니다.
     * @param start 검색을 시작할 시작 색인입니다.
     * @param end 검색 할 끝 인덱스.
     * @return 발견되면 요소의 인덱스를 반환합니다.
     * 그렇지 않으면 -1을 반환합니다.
     */
    private <T extends Comparable<T>> int ternarySearch(T[] arr, T key, int start, int end) {
        if (start > end) {
            return -1;
        }
        /* 첫 번째 경계 : 길이의 1/3을 추가하여 시작 */ 
        int mid1 = start + (end - start) / 3;
        /* 두 번째 경계 : 시작 길이의 2/3 추가 */
        int mid2 = start + 2 * (end - start) / 3;

        if (key.compareTo(arr[mid1]) == 0) {
            return mid1;
        } else if (key.compareTo(arr[mid2]) == 0) {
            return mid2;
        }

        /* 배열의 첫 번째 (1/3) 부분을 검색하십시오.*/

        else if (key.compareTo(arr[mid1]) < 0) {
            return ternarySearch(arr, key, start, --mid1);
        }
        /* 배열의 3 번째 (1/3) 부분 ​​검색 */

        else if (key.compareTo(arr[mid2]) > 0) {
            return ternarySearch(arr, key, ++mid2, end);
        }
        /*배열의 중간 (1/3) 부분 ​​검색 */

        else {
            return ternarySearch(arr, key, mid1, mid2);
        }
    }

    public static void main(String[] args) {
        //사용할 데이터 생성
        Random r = new Random();
        int size = 100;
        int maxElement = 100000;
        Integer[] integers = Stream.generate(() -> r.nextInt(maxElement)).limit(size).sorted().toArray(Integer[]::new);


        //찾아야할 요소 찾기.
        Integer shouldBeFound = integers[r.nextInt(size - 1)];

        TernarySearch search = new TernarySearch();
        int atIndex = search.find(integers, shouldBeFound);

        System.out.println(format("Should be found: %d. Found %d at index %d. An array length %d"
                , shouldBeFound, integers[atIndex], atIndex, size));

        int toCheck = Arrays.binarySearch(integers, shouldBeFound);
        System.out.println(format("Found by system method at an index: %d. Is equal: %b", toCheck, toCheck == atIndex));

    }
}