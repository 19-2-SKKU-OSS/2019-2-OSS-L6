package Sorts;

import static Sorts.SortUtils.*;

/**
 * Implementation of gnome sort
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @since 2018-04-10
 * 난쟁이 정렬: 두 값을 비교하여 교환이 필요하면 교환하고 index를 하나 낮추고, 필요하지 않다면 index를 하나 증가하는 것을 반복하며 정렬.
 * 시간복잡도: O(n^2), 최악의 경우: O(n^2), 최선의 경우: O(n)
 * */
public class GnomeSort implements SortAlgorithm { //GnomeSort 클래스 정의

    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        int i = 1;
        int j = 2;
        while (i < arr.length) { //배열의 크기만큼
            if (less(arr[i - 1], arr[i])) i = j++; //i-1 인덱스의 값과 i의 값을 비교하여 앞의 값이 작으면 인덱스를 하나 증가시킴
            else { //앞의 값이 크면 -> 오름차순 정렬
                swap(arr, i - 1, i); //스왑을 해주고
                if (--i == 0) { //인덱스를 하나 낮춰줌. 그리고 그것이 만약 0이면
                    i = j++; //다음 작업을 위해 j의 값을 넣어주고 j 증가
                }
            }
        }

        return null; //배열은 리턴하지 않음
    }

    public static void main(String[] args) {
        Integer[] integers = {4, 23, 6, 78, 1, 26, 11, 23, 0, -6, 3, 54, 231, 9, 12};
        String[] strings = {"c", "a", "e", "b", "d", "dd", "da", "zz", "AA", "aa", "aB", "Hb", "Z"};
        GnomeSort gnomeSort = new GnomeSort();

        gnomeSort.sort(integers);
        gnomeSort.sort(strings);

        System.out.println("After sort : ");
        print(integers);
        print(strings);


    }

}
