package DataStructures.Lists;

import java.util.Objects;

public class CursorLinkedList<T> {

    private static class Node<T> {

        T element;
        int next;

        Node(T element, int next) {
            this.element = element;
            this.next = next;
        }

        boolean isEmpty() {
            return element == null;
        }
    }


    private final int os;
    private int head;
    private final Node<T>[] cursorSpace;
    private int count;
    private final static int CURSOR_SPACE_SIZE = 100;


    {
        // 로딩시에 init
        cursorSpace = new Node[CURSOR_SPACE_SIZE];
        for (int i = 0; i < CURSOR_SPACE_SIZE; i++) {
            cursorSpace[i] = new Node<>(null, i + 1);
        }
        cursorSpace[CURSOR_SPACE_SIZE - 1].next = 0;
    }


    public CursorLinkedList() {
        os = 0;
        count = 0;
        head = -1;
    }

    public void printList() {

        if (head != -1) {


            int start = head;
            while (start != -1) {

                T element = cursorSpace[start].element;
                System.out.println(element.toString());
                start = cursorSpace[start].next;
            }
        }

    }


    /**
     * @return 실제 [cursorSpace] 배열의 인덱스가 아닌 리스트에 들어있는 요소의 타당한 인덱스
     */
    public int indexOf(T element) {


        Objects.requireNonNull(element);
        Node<T> iterator = cursorSpace[head];
        for (int i = 0; i < count; i++) {
            if (iterator.element.equals(element)) {
                return i;
            }
            iterator = cursorSpace[iterator.next];
        }


        return -1;
    }


    /**
     * @param position , 실제 [cursorSpace] 배열의 인덱스가 아닌 리스트에 들어있는 요소의 타당한 인덱스
     *                 이 메소드는 indexof()메소드로 부터 밭은 인덱스를 사용해야 한다.
     * @return
     */

    public T get(int position) {

        if (position >= 0 && position < count) {

            int start = head;
            int counter = 0;
            while (start != -1) {

                T element = cursorSpace[start].element;
                if (counter == position) {
                    return element;
                }

                start = cursorSpace[start].next;
                counter++;
            }

        }

        return null;
    }


    public void removeByIndex(int index) {

        if (index >= 0 && index < count) {

            T element = get(index);
            remove(element);
        }

    }

    public void remove(T element) {


        Objects.requireNonNull(element);

        // case 요소는 head에 있다.
        T temp_element = cursorSpace[head].element;
        int temp_next = cursorSpace[head].next;
        if (temp_element.equals(element)) {
            free(head);
            head = temp_next;
        } else { // 다른 

            int prev_index = head;
            int current_index = cursorSpace[prev_index].next;

            while (current_index != -1) {

                T current_element = cursorSpace[current_index].element;
                if (current_element.equals(element)) {
                    cursorSpace[prev_index].next = cursorSpace[current_index].next;
                    free(current_index);
                    break;
                }

                prev_index = current_index;
                current_index = cursorSpace[prev_index].next;
            }

        }


        count--;

    }

    private void free(int index) {

        Node os_node = cursorSpace[os];
        int os_next = os_node.next;
        cursorSpace[os].next = index;
        cursorSpace[index].element = null;
        cursorSpace[index].next = os_next;

    }


    public void append(T element) {

        Objects.requireNonNull(element);
        int availableIndex = alloc();
        cursorSpace[availableIndex].element = element;

        if (head == -1) {
            head = availableIndex;
        }

        int iterator = head;
        while (cursorSpace[iterator].next != -1) {
            iterator = cursorSpace[iterator].next;
        }

        cursorSpace[iterator].next = availableIndex;
        cursorSpace[availableIndex].next = -1;


        count++;
    }

    /**
     * @return 다음으로 사용가능한 노드의 인덱스
     */
    private int alloc() {


        //1- os가 가리키는 인덱스를 받는다
        int availableNodeIndex = cursorSpace[os].next;

        if (availableNodeIndex == 0) {
            throw new OutOfMemoryError();
        }

        //2- os가 @var{availableNodeIndex}의 다음을 가리키도록 만든다
        int availableNext = cursorSpace[availableNodeIndex].next;
        cursorSpace[os].next = availableNext;

        // this to indicate an end of the list , helpful at testing since any err
        // 이것은 리스트에 마지막을 가리킨다, 에러가 생기면 outOfBoundException을 던질 것이다.
        // 테스트시 유용하다.
        cursorSpace[availableNodeIndex].next = -1;

        return availableNodeIndex;

    }


}
