package Sorts;

import java.util.Arrays;
import java.util.List;

/**
 * The class contains util methods
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 **/
final class SortUtils { //확장할 수 없는 SortUtils 클래스 정의

    /**
     * Helper method for swapping places in array
     *
     * @param array The array which elements we want to swap
     * @param idx   index of the first element
     * @param idy   index of the second element
     */
    static <T> boolean swap(T[] array, int idx, int idy) { //swap하는 함수
        T swap = array[idx];
        array[idx] = array[idy];
        array[idy] = swap;
        return true;
    }


    /**
     * This method checks if first element is less then the other element
     *
     * @param v first element
     * @param w second element
     * @return true if the first element is less then the second element
     */
    static <T extends Comparable<T>> boolean less(T v, T w) { //둘의 값을 비교하여 앞의 값이 작으면 true, 그렇지 않으면 false 리턴
        return v.compareTo(w) < 0;
    }


    /**
     * Just print list
     *
     * @param toPrint - a list which should be printed
     */
    static void print(List<?> toPrint) { //리스트를 출력하는 함수
        toPrint.stream()
                .map(Object::toString)
                .map(str -> str + " ")
                .forEach(System.out::print);

        System.out.println();
    }


    /**
     * Prints an array
     *
     * @param toPrint - the array  which should be printed
     */
    static void print(Object[] toPrint) { //배열을 출력하는 함수
        System.out.println(Arrays.toString(toPrint));
    }


    /**
     * Swaps all position from {@param left} to @{@param right} for {@param array}
     *
     * @param array is an array
     * @param left  is a left flip border of the array
     * @param right is a right flip border of the array
     */
    static <T extends Comparable<T>> void flip(T[] array, int left, int right) //팬케이크 정렬에서 사용하는 일부 배열을 뒤집는 함수 
    {
        while (left <= right) { //왼쪽에서 오른쪽까지
            swap(array, left++, right--); //서로 한 칸씩 줄여나가며 뒤집음
        }
    }
}
