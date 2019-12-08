package Searches;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.String.format;

/**
 * Interpolation search algorithm implementation
 * <p>
 * 최악의 시간복잡도  O(n)
 * 최고상황의 시간복잡도	O(1)
 * 평균 성능 O(log(log(n))) 요소들이 균등하게 분포할때, 균등하게 분포되지 않았다면  O(n)이다.
 * 최악의 공간복잡도	O(1)
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 */
class InterpolationSearch {


    /**
     * @param array 는 정렬된 array이다.
     * @param key   는 어레이 내에서 찾게 될 값이다.
     * @return 배열에 키가 포함되어있는 경우는 -1을 반환한다.
     */
    public int find(int array[], int key) {
        // 두 코너의 인덱스 찾기
        int start = 0, end = (array.length - 1);

        // 배열이 정렬되므로 요소가 존재합니다
        // 배열에서 모서리로 정의 된 범위에 있어야합니다
        while (start <= end && key >= array[start] && key <= array[end]) {
            // 유지하면서 위치 조사
            // 균일 한 분포를 염두에 두십시오
            int pos = start + (((end - start) / (array[end] - array[start])) * (key - array[start]));

            // Condition of target found
            if (array[pos] == key)
                return pos;

            // 키가 크면 키가 위쪽에 있습니다.
            if (array[pos] < key)
                start = pos + 1;

              
            // 키가 작 으면 x는 아래쪽에 있습니다.
            else
                end = pos - 1;
        }
        return -1;
    }

    // 드라이버
    public static void main(String[] args) {
        Random r = new Random();
        int size = 100;
        int maxElement = 100000;
        int[] integers = IntStream.generate(() -> r.nextInt(maxElement)).limit(size).sorted().toArray();


        // 찾아야할 값.
        Integer shouldBeFound = integers[r.nextInt(size - 1)];

        InterpolationSearch search = new InterpolationSearch();
        int atIndex = search.find(integers, shouldBeFound);

        System.out.println(String.format("Should be found: %d. Found %d at index %d. An array length %d"
                , shouldBeFound, integers[atIndex], atIndex, size));


        int toCheck = Arrays.binarySearch(integers, shouldBeFound);
        System.out.println(format("Found by system method at an index: %d. Is equal: %b", toCheck, toCheck == atIndex));
    }
}

