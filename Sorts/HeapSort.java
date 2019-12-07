package Sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Sorts.SortUtils.*;

/**
 * Heap Sort Algorithm
 * Implements MinHeap
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * 힙 정렬: 완전 이진 트리를 기반으로 한 최대 힙 트리나 최소 힙 트리를 구성해 정렬.
 * 시간복잡도: O(nlogn), 최악의 경우: O(nlogn), 최선의 경우: O(nlogn)
 */
public class HeapSort implements SortAlgorithm {


    private static class Heap<T extends Comparable<T>> { //Heap 클래스 정의
        /**
         * Array to store heap
         */
        private T[] heap;

        /**
         * Constructor
         *
         * @param heap array of unordered integers
         */
        public Heap(T[] heap) {
            this.heap = heap;
        }

        /**
         * Heapifies subtree from top as root to last as last child
         *
         * @param rootIndex index of root
         * @param lastChild index of last child
         */
        private void heapSubtree(int rootIndex, int lastChild) { //힙 서브트리 생성하는 함수
            int leftIndex = rootIndex * 2 + 1; //왼쪽 인덱스 초기화
            int rightIndex = rootIndex * 2 + 2; //오른쪽 인덱스 초기화
            T root = heap[rootIndex]; //루트 인덱스 값 넣기
            if (rightIndex <= lastChild) { // 왼쪽 자식과 오른쪽 자식을 갖고 있다면
                T left = heap[leftIndex];
                T right = heap[rightIndex];
                if (less(left, right) && less(left, root)) { //왼쪽과 오른쪽 비교, 왼쪽과 루트 비교
                    swap(heap, leftIndex, rootIndex); //왼쪽 인덱스와 루트 인덱스 스왑
                    heapSubtree(leftIndex, lastChild); //왼쪽 인덱스와 마지막 자식의 힙 서브트리 생성 
                } else if (less(right, root)) { //오른쪽과 루트 비교
                    swap(heap, rightIndex, rootIndex); //오른쪽 인덱스와 루트 인덱스 스왑
                    heapSubtree(rightIndex, lastChild); //오른쪽 인덱스와 마지막 자식의 힙 서브트리 생성
                }
            } else if (leftIndex <= lastChild) { // 오른쪽 자식은 없고 왼쪽 자식만 있다면
                T left = heap[leftIndex];
                if (less(left, root)) { //왼쪽과 루트 비교
                    swap(heap, leftIndex, rootIndex); //왼쪽 인덱스와 루트 인덱스 스왑
                    heapSubtree(leftIndex, lastChild); //왼쪽 인덱스와 마지막 자식의 힙 서브트리 생성
                }
            }
        }


        /**
         * Makes heap with root as root
         *
         * @param root index of root of heap
         */
        private void makeMinHeap(int root) { //최소 힙을 만드는 함수
            int leftIndex = root * 2 + 1;
            int rightIndex = root * 2 + 2;
            boolean hasLeftChild = leftIndex < heap.length;
            boolean hasRightChild = rightIndex < heap.length;
            if (hasRightChild) { //왼쪽을 가지고 있다면
                makeMinHeap(leftIndex); //왼쪽 인덱스의 최소 힙 생성
                makeMinHeap(rightIndex);// 오른쪽 인덱스의 최소 힙 생성
                heapSubtree(root, heap.length - 1); //루트와 힙 크기의 힙 서브트리 생성
            } else if (hasLeftChild) { //오른쪽도
                heapSubtree(root, heap.length - 1); //루트와 힙 크기의 힙 서브트리 생성
            }
        }

        /**
         * Gets the root of heap
         *
         * @return root of heap
         */
        private T getRoot(int size) { //루트 값을 가져오는 함수
            swap(heap, 0, size);
            heapSubtree(0, size - 1);
            return heap[size]; // return old root
        }


    }

    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        return sort(Arrays.asList(unsorted)).toArray(unsorted);
    }

    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> unsorted) { //정렬하는 함수
        int size = unsorted.size();

        @SuppressWarnings("unchecked")
        Heap<T> heap = new Heap<>(unsorted.toArray((T[]) new Comparable[unsorted.size()]));

        heap.makeMinHeap(0); // make min heap using index 0 as root.
        List<T> sorted = new ArrayList<>(size); //새로운 리스트 생성
        while (size > 0) { //사이즈만큼
            T min = heap.getRoot(--size); //최소 힙으로부터 작은 값부터 가져옴 ->오름차순 정렬
            sorted.add(min); //sorted 배열에 하나씩 넣어서 정렬
        }

        return sorted;//정렬된 배열 리턴
    }

    /**
     * Main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[] heap = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        HeapSort heapSort = new HeapSort();
        print(heapSort.sort(heap));
    }

}
