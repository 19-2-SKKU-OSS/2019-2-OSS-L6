package DataStructures.Heaps;

import java.util.ArrayList;
import java.util.List;

/**
 * 노드의 키가 상위 키보다 작거나 같고 하위 키보다 나 같은 힙 트리
 *
 * @author Nicolas Renard
 */
public class MinHeap implements Heap {

    private final List<HeapElement> minHeap;

    public MinHeap(List<HeapElement> listElements) {
        minHeap = new ArrayList<>();
        for (HeapElement heapElement : listElements) {
            if (heapElement != null) insertElement(heapElement);
            else System.out.println("Null element. Not added to heap");
        }
        if (minHeap.size() == 0) System.out.println("No element has been added, empty heap.");
    }

    // 주어진 인덱스에 있는 요소를 얻는다. 리스트의 키는 인덱스 값-1과 동일하다
    public HeapElement getElement(int elementIndex) {
        if ((elementIndex <= 0) || (elementIndex > minHeap.size()))
            throw new IndexOutOfBoundsException("Index out of heap range");
        return minHeap.get(elementIndex - 1);
    }

    // 주어진 인덱스에 있는 요소를 얻는다
    private double getElementKey(int elementIndex) {
        return minHeap.get(elementIndex - 1).getKey();
    }

    // 힙에 있는 두 요소를 바꾼다
    private void swap(int index1, int index2) {
        HeapElement temporaryElement = minHeap.get(index1 - 1);
        minHeap.set(index1 - 1, minHeap.get(index2 - 1));
        minHeap.set(index2 - 1, temporaryElement);
    }

    // 키가 부모의 키보다 높은 한, 원소를 그것의 윗 자리로 전환한다.
    private void toggleUp(int elementIndex) {
        double key = minHeap.get(elementIndex - 1).getKey();
        while (getElementKey((int) Math.floor(elementIndex / 2)) > key) {
            swap(elementIndex, (int) Math.floor(elementIndex / 2));
            elementIndex = (int) Math.floor(elementIndex / 2);
        }
    }

    // 키가 자식의 키보다 낮은 한, 원소를 그것의 아래 자리로 전환한다.
    private void toggleDown(int elementIndex) {
        double key = minHeap.get(elementIndex - 1).getKey();
        boolean wrongOrder = (key > getElementKey(elementIndex * 2)) || (key > getElementKey(Math.min(elementIndex * 2, minHeap.size())));
        while ((2 * elementIndex <= minHeap.size()) && wrongOrder) {
            // 왼쪽 자식와 교환할지 오른쪽 자식과 교환할지 검사한다.
            if ((2 * elementIndex < minHeap.size()) && (getElementKey(elementIndex * 2 + 1) < getElementKey(elementIndex * 2))) {
                swap(elementIndex, 2 * elementIndex + 1);
                elementIndex = 2 * elementIndex + 1;
            } else {
                swap(elementIndex, 2 * elementIndex);
                elementIndex = 2 * elementIndex;
            }
            wrongOrder = (key > getElementKey(elementIndex * 2)) || (key > getElementKey(Math.min(elementIndex * 2, minHeap.size())));

        }
    }

    private HeapElement extractMin() {
        HeapElement result = minHeap.get(0);
        deleteElement(0);
        return result;
    }

    @Override
    public void insertElement(HeapElement element) {
        minHeap.add(element);
        toggleUp(minHeap.size());

    }

    @Override
    public void deleteElement(int elementIndex) {
        if (minHeap.isEmpty())
            try {
                throw new EmptyHeapException("Attempt to delete an element from an empty heap");
            } catch (EmptyHeapException e) {
                e.printStackTrace();
            }
        if ((elementIndex > minHeap.size()) || (elementIndex <= 0))
            throw new IndexOutOfBoundsException("Index out of heap range");
        // 힙의 마지막 요소를 삭제할 요소로 대체한다.
        minHeap.set(elementIndex - 1, getElement(minHeap.size()));
        minHeap.remove(minHeap.size());
        // 새로운 요소를 위로 이동시킬지
        if (getElementKey(elementIndex) < getElementKey((int) Math.floor(elementIndex / 2))) toggleUp(elementIndex);
            // 아래로 이동시킬지
        else if (((2 * elementIndex <= minHeap.size()) && (getElementKey(elementIndex) > getElementKey(elementIndex * 2))) ||
                ((2 * elementIndex < minHeap.size()) && (getElementKey(elementIndex) > getElementKey(elementIndex * 2))))
            toggleDown(elementIndex);
    }

    @Override
    public HeapElement getElement() throws EmptyHeapException {
        try {
            return extractMin();
        } catch (Exception e) {
            throw new EmptyHeapException("Heap is empty. Error retrieving element");
        }
    }
}
