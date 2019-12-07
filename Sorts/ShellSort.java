package Sorts;

import static Sorts.SortUtils.*;


/**
 * @author dpunosevac
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see SortAlgorithm
 * 셸 정렬: 삽입 정렬을 임의의 간격을 벌려서 시행하며 정렬.
 * 시간복잡도: 약 O(n^1.5), 최악의 경우:O(n^2), 최선의 경우: O(n)
 */
public class ShellSort implements SortAlgorithm { //ShellSort 클래스 정의

    /**
     * This method implements Generic Shell Sort.
     *
     * @param array The array to be sorted
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) { //정렬하는 함수
        int N = array.length;
        int h = 1; //간격은 우선 1

        while (h < N / 3) { //간격이 전체 길이의 3분의 1보다 작을만큼만
            h = 3 * h + 1; //간격을 늘림
        }

        while (h >= 1) { //간격이 1보다 크거나 같을 때까지만
            for (int i = h; i < N; i++) { //h가 줄면서 계속 늘어나지만 점점 정렬되어 있어서 스왑할 것이 적어짐
                for (int j = i; j >= h && less(array[j], array[j - h]); j -= h) //j와 h만큼 앞에 떨어진 값을 비교하여 j가 작으면
	       	{
                    swap(array, j, j - h); //스왑 -> 삽입정렬과 같음
                }
            }

            h /= 3; //간격을 3으로 나누어서 줄임
        }

        return array; //정렬된 배열 리턴
    }

    public static void main(String[] args) {
        Integer[] toSort = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        ShellSort sort = new ShellSort();
        Integer[] sorted = sort.sort(toSort);

        print(sorted);

    }
}
