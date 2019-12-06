package Sorts;

import static Sorts.SortUtils.print;

/**
 * This method implements the Generic Merge Sort
 *
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see SortAlgorithm
 * 병합 정렬: 원소 개수가 1또는 0이 될 때까지 두 부분으로 쪼갠 뒤, 역순으로 크기를 비교하며 재조합하면서 정렬. 쪼개는 작업과 역순 병합 작업은 재귀함수를 이용.
 * 시간복잡도: O(nlogn), 최악의 경우: O(nlogn), 최선의 경우: O(nlogn)
 * /

class MergeSort implements SortAlgorithm { //MergeSort 클래스 정의

    /**
     * This method implements the Generic Merge Sort
     *
     * @param unsorted the array which should be sorted
     * @param <T>      Comparable class
     * @return sorted array
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T extends Comparable<T>> T[] sort(T[] unsorted) { //정렬하는 함수
        T[] tmp = (T[]) new Comparable[unsorted.length];
        doSort(unsorted, tmp, 0, unsorted.length - 1);
        return unsorted;
    }

    /**
     * @param arr   The array to be sorted
     * @param temp  The copy of the actual array
     * @param left  The first index of the array
     * @param right The last index of the array
     *              Recursively sorts the array in increasing order
     **/
    private static <T extends Comparable<T>> void doSort(T[] arr, T[] temp, int left, int right) { //재귀를 이용해 정렬하는 함수
        if (left < right) { //오른쪽이 왼쪽보다 클 때
            int mid = left + (right - left) / 2; //중간값 찾기
            doSort(arr, temp, left, mid); //왼쪽부터 중간값까지 쪼개기
            doSort(arr, temp, mid + 1, right); //중간값부터 오른쪽까지 쪼개기
            merge(arr, temp, left, mid, right); //병합
        }

    }

    /**
     * This method implements the merge step of the merge sort
     *
     * @param arr   The array to be sorted
     * @param temp  The copy of the actual array
     * @param left  The first index of the array
     * @param mid   The middle index of the array
     * @param right The last index of the array
     *              merges two parts of an array in increasing order
     **/

    private static <T extends Comparable<T>> void merge(T[] arr, T[] temp, int left, int mid, int right) { //병합하는 함수
        System.arraycopy(arr, left, temp, left, right - left + 1); 


        int i = left; //i는 왼쪽 블록
        int j = mid + 1; //j는 오른쪽 블록
        int k = left;

        while (i <= mid && j <= right) { 
            if (temp[i].compareTo(temp[j]) <= 0) { //인덱스 i의 값과 j의 값 중 i가 작으면
                arr[k++] = temp[i++]; //인덱스 i 값을 앞에 넣기
            } else {
                arr[k++] = temp[j++]; //인덱스 j가 작으면 인덱스 j 값을 앞에 넣기
            }
        }

        while (i <= mid) { //j 값을 다 썼으면 i만 다 넣기
            arr[k++] = temp[i++];
        }

        while (j <= right) { //i 값을 다 썼으면 j만 넣기
            arr[k++] = temp[j++];
        }
    }

    // Driver program
    public static void main(String[] args) {

        // Integer Input
        Integer[] arr = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);

        // Output => 1	   4  	 6	9	12	23	54	78	231
        print(arr);

        // String Inpu
        String[] stringArray = {"c", "a", "e", "b", "d"};
        mergeSort.sort(stringArray);
        //Output => a	b	c	d	e
        print(stringArray);
    }
}
