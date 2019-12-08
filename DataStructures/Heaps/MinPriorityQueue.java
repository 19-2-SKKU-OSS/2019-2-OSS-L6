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

    // capacity를 초기화 해주는 생성자
    MinPriorityQueue(int c) {
        this.capacity = c;
        this.size = 0;
        this.heap = new int[c + 1];
    }

    // 키를 삽입하고 끝에 그것을 재정렬 한다.
    // 이진 힙이 적절한 순서로 되기 위해서
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

    // returns 가장 큰 우선순위 값
    public int peek() {
        return this.heap[1];
    }

    // returns  힙이 비어있으면 참, 아니면 거짓
    public boolean isEmpty() {
        if (0 == this.size)
            return true;
        return false;
    }

    // returns 힙이 가득 차면 참, 아니면 거짓
    public boolean isFull() {
        if (this.size == this.capacity)
            return true;
        return false;
    }

    // 힙 출력
    public void print() {
        for (int i = 1; i <= this.capacity; i++)
            System.out.print(this.heap[i] + " ");
        System.out.println();
    }

    // 힙 정렬은 delete 함수를 힙의 사이즈 번 수행하는 것으로 수행 될 수 있다.
    // 최소 힙이기 때문에 역 정렬을 반환한다.
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
