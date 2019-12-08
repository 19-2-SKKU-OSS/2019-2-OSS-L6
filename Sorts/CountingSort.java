package Sorts;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static Sorts.SortUtils.print;

/**
 * @author Youssef Ali (https://github.com/youssefAli11997)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * 계수 정렬: 원소간 비교하지 않고 각 원소가 몇 개 등장하는지 개수를 세어 정렬. 원소의 크기가 시간 복잡도에 영향을 미친다.
 * 시간 복잡도: O(n+k) (k는 원소 중 최댓값)
 */
class CountingSort implements SortAlgorithm { //CountingSort 클래스 정의

    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) { //정렬하는 함수
        return sort(Arrays.asList(unsorted)).toArray(unsorted);
    }

    /**
     * This method implements the Generic Counting Sort
     *
     * @param list The list to be sorted
     *             <p>
     *             Sorts the list in increasing order
     *             The method uses list elements as keys in the frequency map
     **/
    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> list) { //정렬하는 함수
        Map<T, Integer> frequency = new TreeMap<>();
        // The final output array
        List<T> sortedArray = new ArrayList<>(list.size()); //새로운 리스트 생성

        // Counting the frequency of @param array elements
        list.forEach(v -> frequency.put(v, frequency.getOrDefault(v, 0) + 1));// 배열의 각각의 빈도를 센다.

        // Filling the sortedArray
        for (Map.Entry<T, Integer> element : frequency.entrySet()) {
            for (int j = 0; j < element.getValue(); j++) {
                sortedArray.add(element.getKey()); //원소의 크기 순서대로 각각의 빈도만큼 값들을 배열에 집어넣는다. ->오름차순 정렬
            }
        }

        return sortedArray; //정렬된 배열 리턴
    }


    /**
     * Stream Counting Sort
     * The same as method {@link CountingSort#sort(List)} } but this method uses stream API
     *
     * @param list The list to be sorted
     **/
    private static <T extends Comparable<T>> List<T> streamSort(List<T> list) {
        return list.stream()
                .collect(toMap(k -> k, v -> 1, (v1, v2) -> v1 + v2, TreeMap::new))
                .entrySet()
                .stream()
                .flatMap(entry -> IntStream.rangeClosed(1, entry.getValue()).mapToObj(t -> entry.getKey()))
                .collect(toList());
    }

    // Driver Program
    public static void main(String[] args) {
        // Integer Input
        List<Integer> unsortedInts = Stream.of(4, 23, 6, 78, 1, 54, 23, 1, 9, 231, 9, 12).collect(toList());
        CountingSort countingSort = new CountingSort();

        System.out.println("Before Sorting:");
        print(unsortedInts);

        // Output => 1 1 4 6 9 9 12 23 23 54 78 231
        System.out.println("After Sorting:");
        print(countingSort.sort(unsortedInts));
        System.out.println("After Sorting By Streams:");
        print(streamSort(unsortedInts));

        System.out.println("\n------------------------------\n");

        // String Input
        List<String> unsortedStrings = Stream.of("c", "a", "e", "b", "d", "a", "f", "g", "c").collect(toList());

        System.out.println("Before Sorting:");
        print(unsortedStrings);

        //Output => a a b c c d e f g
        System.out.println("After Sorting:");
        print(countingSort.sort(unsortedStrings));

        System.out.println("After Sorting By Streams:");
        print(streamSort(unsortedStrings));

    }
}
