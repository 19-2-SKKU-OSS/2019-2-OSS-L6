package DataStructures.Heaps;

/**
 * 힙 데이터와 공통된 인터페이스<br>
 * <p>힙은 트리와 비슷한 데이터 구조로서, 요소를 특정한 방법으로 저장할 수 있다.
 * 각 노드는 한 요소에 해당하며(루트를 제외하면) 하나의 부모 노드와 최대 두 개의 자식 노드를 가지고 있다.
 * 모든 요소에는 키가 들어 있고, 그 키들은 트리를 어떻게 만들어야하는 지를 나타낸다.
 * 예를 들어, 최소 힙의 경우, 노드의 키는 부모 노드의 키보다 크거나 같아야 하고 자식 노드의 키보다 작거나 같아야 한다.
 * 최대 힙에는 반대의 규칙이 적용된다.</p>
 * <p>모든 힙 관련 작업(요소 삽입 또는 삭제, 최소 또는 최대 추출)은 O(log n)의 시간 복잡도를 가진다.</p>
 *
 * @author Nicolas Renard
 */
public interface Heap {

    /**
     * @return the top element in the heap, the one with lowest key for min-heap or with
     * the highest key for max-heap
     * @throws EmptyHeapException if heap is empty
     */
    HeapElement getElement() throws EmptyHeapException;

    /**
     * Inserts an element in the heap. Adds it to then end and toggle it until it finds its
     * right position.
     *
     * @param element an instance of the HeapElement class.
     */
    void insertElement(HeapElement element);

    /**
     * Delete an element in the heap.
     *
     * @param elementIndex int containing the position in the heap of the element to be deleted.
     */
    void deleteElement(int elementIndex);

}
