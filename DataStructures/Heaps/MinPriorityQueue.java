package DataStructures.Heaps;

/**
 * 최소 우선순위 큐
 * 이것은 힙 자료구조의 한 종류이다
 * 힙은 특정한 트리 기반의 자료 구조이다.
 * 모든 트리의 노드들을 특정한 순서로 배열할 수 있다.
 * 예를 들면 자식 노드가 부모의 노드 보다 크거나 작은 것으로 배열할 수 있다.
 * 이러한 점이 최대 우선순위 큐나, 최소 우선순위 큐를 만들 수 있게 해준다.
 * <p>
 * <p>
 * Functions: insert, delete, peek, isEmpty, print, heapSort, sink
 */
public class MinPriorityQueue {
    private int[] heap;
    private int capacity;
    private int size;

    // calss the constructor and initializes the capacity 
    MinPriorityQueue(int c) {
        this.capacity = c;
        this.size = 0;
        this.heap = new int[c + 1];
    }

    // inserts the key at the end and rearranges it
    // so that the binary heap is in appropriate order
    public void insert(int key) {
        if (this.isFull())
            return;
        this.heap[this.size + 1] = key;
        int k = this.size + 1;
        while (k > 1) {
            if (this.heap[k] < this.heap[k / 2]) {
                int temp = this.heap[k];
                this.heap[k] = this.heap[k / 2];
                this.heap[k / 2] = temp;
            }
            k = k / 2;
        }
        this.size++;
    }

    // returns the highest priority value
    public int peek() {
        return this.heap[1];
    }

    // returns boolean value whether the heap is empty or not
    public boolean isEmpty() {
        if (0 == this.size)
            return true;
        return false;
    }

    // returns boolean value whether the heap is full or not
    public boolean isFull() {
        if (this.size == this.capacity)
            return true;
        return false;
    }

    // prints the heap
    public void print() {
        for (int i = 1; i <= this.capacity; i++)
            System.out.print(this.heap[i] + " ");
        System.out.println();
    }

    // heap sorting can be done by performing
    // delete function to the number of times of the size of the heap
    // it returns reverse sort because it is a min priority queue
    public void heapSort() {
        for (int i = 1; i < this.capacity; i++)
            this.delete();
    }

    // 모든 삭제 함수가 끝난 뒤 힙을 재정렬 해주는 함수
    private void sink() {
        int k = 1;
        while (2 * k <= this.size || 2 * k + 1 <= this.size) {
            int minIndex;
            if (this.heap[2 * k] >= this.heap[k]) {
                if (2 * k + 1 <= this.size && this.heap[2 * k + 1] >= this.heap[k]) {
                    break;
                } else if (2 * k + 1 > this.size) {
                    break;
                }
            }
            if (2 * k + 1 > this.size) {
                minIndex = this.heap[2 * k] < this.heap[k] ? 2 * k : k;
            } else {
                if (this.heap[k] > this.heap[2 * k] || this.heap[k] > this.heap[2 * k + 1]) {
                    minIndex = this.heap[2 * k] < this.heap[2 * k + 1] ? 2 * k : 2 * k + 1;
                } else {
                    minIndex = k;
                }
            }
            int temp = this.heap[k];
            this.heap[k] = this.heap[minIndex];
            this.heap[minIndex] = temp;
            k = minIndex;
        }
    }

    // 힙으로부터 가장 큰 우선순위 값을 삭제한다
    public int delete() {
        int min = this.heap[1];
        this.heap[1] = this.heap[this.size];
        this.heap[this.size] = min;
        this.size--;
        this.sink();
        return min;
    }

    public static void main(String[] args) {
        // 시험
        MinPriorityQueue q = new MinPriorityQueue(8);
        q.insert(5);
        q.insert(2);
        q.insert(4);
        q.insert(1);
        q.insert(7);
        q.insert(6);
        q.insert(3);
        q.insert(8);
        q.print(); // [ 1, 2, 3, 5, 7, 6, 4, 8 ]
        q.heapSort();
        q.print(); // [ 8, 7, 6, 5, 4, 3, 2, 1 ]
    }
}
