package Sorts;

import java.util.Arrays;
import java.util.List;

/**
 * The common interface of most sorting algorithms
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 **/
public interface SortAlgorithm { //SortAlgorithm 인터페이스 정의

    /**
     * Main method arrays sorting algorithms
     *
     * @param unsorted - an array should be sorted
     * @return a sorted array
     */
    <T extends Comparable<T>> T[] sort(T[] unsorted); //정렬하는 함수

    /**
     * Auxiliary method for algorithms what wanted to work with lists from JCF
     *
     * @param unsorted - a list should be sorted //정렬해야할 함수를 가져야함
     * @return a sorted list //정렬된 함수를 리턴해야함
     */
    @SuppressWarnings("unchecked")
    default <T extends Comparable<T>> List<T> sort(List<T> unsorted) {
        return Arrays.asList(sort(unsorted.toArray((T[]) new Comparable[unsorted.size()])));
    }

}
