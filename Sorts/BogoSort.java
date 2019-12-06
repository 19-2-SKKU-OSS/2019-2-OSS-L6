package Sorts;

import java.util.Random;


/**
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see SortAlgorithm
 * 보고 정렬: 이름 그대로 멍청한 정렬. 랜덤으로 데이터들을 재배열한 후, 정렬되었는지 검사한다. 정렬이 되지 않았으면 다시 랜덤으로 정렬될 때까지 재배열한다.
 * 평균 시간복잡도: O(n*n!), 최악의 경우: O(∞)
 */
public class BogoSort implements SortAlgorithm { //BogoSort Class 생성

    private static final Random random = new Random(); //랜덤 변수 생성


    private static <T extends Comparable<T>> boolean isSorted(T array[]) { //정렬이 되었는지 확인하는 함수
        for (int i = 0; i < array.length - 1; i++) {
            if (SortUtils.less(array[i + 1], array[i])) return false; //정렬이 안되었으면 false 리턴
        }
        return true; //정렬이 되었으면 true 리턴
    }

    // Randomly shuffles the array
    private static <T> void nextPermutation(T array[]) { //랜덤으로 재배열하는 함수
        int length = array.length;

        for (int i = 0; i < array.length; i++) {
            int randomIndex = i + random.nextInt(length - i); //randomIndex에 랜덤한 값 저장
            SortUtils.swap(array, randomIndex, i);//스왑하면서 랜덤으로 배열 재배치
        }
    }

    public <T extends Comparable<T>> T[] sort(T array[]) { //정렬될 때까지 실행되는 함수
        while (!isSorted(array)) { //배열이 정렬이 되지 않았으면
            nextPermutation(array); //또다시 랜덤으로 재배열
        }
        return array; //정렬된 함수 리턴
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
