package DataStructures.Lists;

public class CircleLinkedList<E> {
    private static class Node<E> {
        Node<E> next;
        E value;

        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    // 더 나은 0.0디자인 을 위해 이것은 더 나은 블랙 박스 디자인을 위해 private으로 허용해야 한다.
    private int size;
    // 이것은 더미 노드로 포인팅 할 것이다.
    private Node<E> head;

    // 클래스를 위한 구조체.. 여기에 원형 연결 리스트를 위한 더미 노드를 만들 것이다.
    // 리스트가 비어있을 경우는 없기 때문에 에러를 잡는 것을 줄인 구현이다.
    public CircleLinkedList() {
        //더미 노드 제작
        head = new Node<E>(null, head);
        size = 0;
    }

    // size가 private여서 필요하다
    public int getSize() {
        return size;
    }

    // 단순화를 위해 이 클래스는 append 함수만 포함할 것이다.
    // 다른 추가 함수를 구현할 수 있지만. 이것이 그 모든 것의 기본이다.
    public void append(E value) {
        if (value == null) {
            // 리스트에 null을 추가하지 않는다.
            throw new NullPointerException("Cannot add null element to the list");
        }
        //head.next는 마지막 요소를 가리키고 있다;
        head.next = new Node<E>(value, head);
        size++;
    }

    public E remove(int pos) {
        if (pos > size || pos < 0) {
            //에러
            throw new IndexOutOfBoundsException("position cannot be greater than size or negative");
        }
        //요소를 제거하기 전에 요소를 추적할 필요가 있다
        Node<E> before = head;
        for (int i = 1; i <= pos; i++) {
            before = before.next;
        }
        Node<E> destroy = before.next;
        E saved = destroy.value;
        // 제거할 요소에 이어 다음 요소에 대한 참조를 할당한다.
        //마지막 요소는 head에 할당 될 것이다.
        before.next = before.next.next;
        // 청소
        destroy = null;
        size--;
        return saved;

    }

}
