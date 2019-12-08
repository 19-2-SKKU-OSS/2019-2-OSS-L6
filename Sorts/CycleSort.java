package Sorts;

import static Sorts.SortUtils.less;
import static Sorts.SortUtils.print;

/**
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * 사이클 정렬: 자료들 중 cycle 관계에 있는 그룹을 찾아내어 정렬 기준에 맞게 자료들을 회전시켜서 정렬.
 * 시간복잡도: O(n^2)
 */
class CycleSort implements SortAlgorithm { //CycleSort 클래스 정의

    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) { //정렬하는 함수
        int n = arr.length; 

        // traverse array elements
        for (int j = 0; j <= n - 2; j++) {
            // initialize item as starting point
            T item = arr[j]; //아이템을 시작점으로 초기화

            // Find position where we put the item.
            int pos = j; //아이템을 넣을 곳을 pos에 넣어줌
            for (int i = j + 1; i < n; i++)
                if (less(arr[i], item)) pos++;

            // If item is already in correct position
            if (pos == j) continue; //아이템이 이미 알맞은 위치에 있으면 정렬하지 않음

            // ignore all duplicate elements
            while (item.compareTo(arr[pos]) == 0) //똑같은 원소는 무시
                pos += 1;

            // put the item to its right position
            if (pos != j) {
                item = replace(arr, pos, item); //알맞은 위치에 아이템 넣기
            }

            // Rotate rest of the cycle
            while (pos != j) { //나머지 사이클 반복
                pos = j;

                // Find position where we put the element
                for (int i = j + 1; i < n; i++) //원소를 넣을 곳 찾기
                    if (less(arr[i], item)) {
                        pos += 1;
                    }


                // ignore all duplicate elements
                while (item.compareTo(arr[pos]) == 0) //똑같은 원소는 무시
                    pos += 1;

                // put the item to its right position
                if (item != arr[pos]) {
                    item = replace(arr, pos, item); //알맞은 위치에 아이템 넣기
                }
            }
        }

        return arr; //정렬된 배열 리턴
    }

    private <T extends Comparable<T>> T replace(T[] arr, int pos, T item) { //스왑 함수
        T temp = item;
        item = arr[pos];
        arr[pos] = temp;
        return item;
    }


    public static void main(String[] args) {
        Integer arr[] = {4, 23, 6, 78, 1, 26, 11, 23, 0, -6, 3, 54, 231, 9, 12};
        CycleSort cycleSort = new CycleSort();
        cycleSort.sort(arr);

        System.out.println("After sort : ");
        print(arr);
    }

}
