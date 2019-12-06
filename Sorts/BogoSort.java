package Sorts;

import java.util.Random;


/**
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see SortAlgorithm
 * 보고 정렬: 이름 그대로 멍청한 정렬. 랜덤으로 데이터들을 재배열한 후, 정렬되었는지 검사한다. 정렬이 되지 않았으면 다시 랜덤으로 정렬될 때까지 재배열한다.
 * 평균 시간복잡도: O(n*n!), 최악의 경우: O(∞)
 */
public class BogoSort implements SortAlgorithm {

    private static final Random random = new Random();


    private static <T extends Comparable<T>> boolean isSorted(T array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            if (SortUtils.less(array[i + 1], array[i])) return false;
        }
        return true;
    }

    // Randomly shuffles the array
    private static <T> void nextPermutation(T array[]) {
        int length = array.length;

        for (int i = 0; i < array.length; i++) {
            int randomIndex = i + random.nextInt(length - i);
            SortUtils.swap(array, randomIndex, i);
        }
    }

    public <T extends Comparable<T>> T[] sort(T array[]) {
        while (!isSorted(array)) {
            nextPermutation(array);
        }
        return array;
    }

    // Driver Program
    public static void main(String[] args) {
        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        BogoSort bogoSort = new BogoSort();

        // print a sorted array
        SortUtils.print(bogoSort.sort(integers));

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};

        SortUtils.print(bogoSort.sort(strings));
    }
}
