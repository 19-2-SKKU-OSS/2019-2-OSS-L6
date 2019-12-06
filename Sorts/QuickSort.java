package Sorts;

import static Sorts.SortUtils.*;

/**
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see SortAlgorithm
 * 퀵 정렬: 임의의 피벗을 기준으로 작은 것은 왼쪽, 큰 것은 오른쪽으로 이동시키면서 재귀적으로 정렬.
 * 시간복잡도: O(nlogn), 최악의 경우: O(n^2), 최선의 경우: O(nlogn)
 */
class QuickSort implements SortAlgorithm { //QuickSort 클래스 정의

    /**
     * This method implements the Generic Quick Sort
     *
     * @param array The array to be sorted
     *              Sorts the array in increasing order
     **/

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) { //정렬하는 함수
        doSort(array, 0, array.length - 1);
        return array;
    }


    /**
     * The sorting process
     *
     * @param left  The first index of an array
     * @param right The last index of an array
     * @param array The array to be sorted
     **/

    private static <T extends Comparable<T>> void doSort(T[] array, int left, int right) { //재귀를 이용하여 정렬하는 함수
        if (left < right) { //왼쪽보다 오른쪽이 클 때
            int pivot = randomPartition(array, left, right); //피벗을 설정
            doSort(array, left, pivot - 1); //왼쪽과 피벗 사이 재귀
            doSort(array, pivot, right); //피벗과 오른쪽 사이 재귀
        }
    }

    /**
     * Ramdomize the array to avoid the basically ordered sequences
     * 
     * @param array The array to be sorted
     * @param left  The first index of an array
     * @param right The last index of an array
     * @return the partition index of the array
     */

    private static <T extends Comparable<T>> int randomPartition(T[] array, int left, int right) { //피벗을 구하는 함수
        int randomIndex = left + (int)(Math.random()*(right - left + 1)); //랜덤한 인덱스 저장
        swap(array, randomIndex, right); //오른쪽 값과 랜덤 인덱스 값 스왑
        return partition(array, left, right); //피벗을 구하는 함수 선언
    }

    /**
     * This method finds the partition index for an array
     *
     * @param array The array to be sorted
     * @param left  The first index of an array
     * @param right The last index of an array
     *              Finds the partition index of an array
     **/

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right) { //피벗보다 작은 것은 왼쪽으로 큰 것은 오른쪽으로 옮기고 피벗을 정하는 함수
        int mid = (left + right) / 2; //중간 인덱스 저장
        T pivot = array[mid]; //피벗은 중간에 있는 값

        while (left <= right) { //왼쪽이 오른쪽보다 작으면
            while (less(array[left], pivot)) { //왼쪽 값이 피벗보다 작으면
                ++left; //왼쪽 끝을 증가
            }
            while (less(pivot, array[right])) { //피벗이 오른쪽 값보다 작으면
                --right; //오른쪽 끝을 감소
            }
            if (left <= right) { //왼쪽이 오른쪽보다 작거나 같고 위의 작업을 한후에
                swap(array, left, right); //왼쪽과 오른쪽 값 스왑
                ++left; //왼쪽 끝 증가
                --right; //오른쪽 끝 감소
            }
        }
        return left; //다음 피벗인 왼쪽 끝 인덱스 리턴
    }

    // Driver Program
    public static void main(String[] args) {

        // For integer input
        Integer[] array = {3, 4, 1, 32, 0, 1, 5, 12, 2, 5, 7, 8, 9, 2, 44, 111, 5};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);

        //Output => 0 1 1 2 2 3 4 5 5 5 7 8 9 12 32 44 111
        print(array);

        String[] stringArray = {"c", "a", "e", "b", "d"};
        quickSort.sort(stringArray);

        //Output => a	b	c	d	e
        print(stringArray);
    }
}

