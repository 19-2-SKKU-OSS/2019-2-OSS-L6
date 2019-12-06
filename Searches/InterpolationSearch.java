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
 * 평균 성능	O(log(log(n))) 요소들이 균등하게 분포할때, 균등하게 분포되지 않았다면  O(n)
 * 최악의 공간복잡도	O(1)
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 */
class InterpolationSearch {


    /**
     * @param array 는 정렬된 array이다.
     * @param key   는 어레이 내에서 찾게 될 값이다.
     * @return an index if the array contains the key unless -1
     */
    public int find(int array[], int key) {
        // Find indexes of two corners
        int start = 0, end = (array.length - 1);

        // Since array is sorted, an element present
        // in array must be in range defined by corner
        while (start <= end && key >= array[start] && key <= array[end]) {
            // Probing the position with keeping
            // uniform distribution in mind.
            int pos = start + (((end - start) / (array[end] - array[start])) * (key - array[start]));

            // Condition of target found
            if (array[pos] == key)
                return pos;

            // If key is larger, key is in upper part
            if (array[pos] < key)
                start = pos + 1;

                // If key is smaller, x is in lower part
            else
                end = pos - 1;
        }
        return -1;
    }

    // Driver method
    public static void main(String[] args) {
        Random r = new Random();
        int size = 100;
        int maxElement = 100000;
        int[] integers = IntStream.generate(() -> r.nextInt(maxElement)).limit(size).sorted().toArray();


        //the element that should be found
        Integer shouldBeFound = integers[r.nextInt(size - 1)];

        InterpolationSearch search = new InterpolationSearch();
        int atIndex = search.find(integers, shouldBeFound);

        System.out.println(String.format("Should be found: %d. Found %d at index %d. An array length %d"
                , shouldBeFound, integers[atIndex], atIndex, size));


        int toCheck = Arrays.binarySearch(integers, shouldBeFound);
        System.out.println(format("Found by system method at an index: %d. Is equal: %b", toCheck, toCheck == atIndex));
    }
}

